package com.example.msphone;

/** 牌值解码器。card字节 = (花色<<4)|点值，花色0=♦1=♣2=♥3=♠，点值1-10 */
public final class HszCardDecoder {
    public static final int PLAYER_COUNT     = 6;
    public static final int CARDS_PER_PLAYER = 2;
    private static final String[] SUIT  = {"♦","♣","♥","♠"};
    private static final String[] VALUE = {"","A","2","3","4","5","6","7","8","9","10"};
    private HszCardDecoder() {}

    public static String decodeCard(int b) {
        if (b == 0) return "?";
        int s = (b >> 4) & 0xF, v = b & 0xF;
        if (s >= SUIT.length || v < 1 || v > 10) return String.format("0x%02X", b);
        return SUIT[s] + VALUE[v];
    }

    /** 发牌包 body（SubID=101，13字节），[0..11]=6人*2张，[12]=牌数 */
    public static int[][] parseDealPacket(byte[] body) {
        if (body == null || body.length < 13) return null;
        int[][] c = new int[PLAYER_COUNT][CARDS_PER_PLAYER];
        int pos = 0;
        for (int p = 0; p < PLAYER_COUNT; p++)
            for (int i = 0; i < CARDS_PER_PLAYER; i++)
                c[p][i] = body[pos++] & 0xFF;
        return c;
    }

    /** 断线重连包 body（268字节），偏移0x6B起12字节=全场手牌 */
    public static int[][] parseStatusPlayCards(byte[] body) {
        if (body == null || body.length < 0x6B + 12) return null;
        int[][] c = new int[PLAYER_COUNT][CARDS_PER_PLAYER];
        int pos = 0x6B;
        for (int p = 0; p < PLAYER_COUNT; p++)
            for (int i = 0; i < CARDS_PER_PLAYER; i++)
                c[p][i] = body[pos++] & 0xFF;
        return c;
    }

    public static String formatAll(int[][] cards, int selfChairId) {
        if (cards == null) return "等待发牌...";
        StringBuilder sb = new StringBuilder();
        for (int p = 0; p < PLAYER_COUNT; p++) {
            sb.append(p == selfChairId ? "【我】" : "P" + p + "  ");
            sb.append(decodeCard(cards[p][0])).append(" ").append(decodeCard(cards[p][1]));
            if (p < PLAYER_COUNT - 1) sb.append("\n");
        }
        return sb.toString();
    }
}