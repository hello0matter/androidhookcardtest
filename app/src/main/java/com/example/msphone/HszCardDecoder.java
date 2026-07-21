package com.example.msphone;

/**
 * Sichuan Mahjong card decoder — QP framework encoding:
 *   0x01-0x09 = Man (1-9W)
 *   0x11-0x19 = Sou/Bamboo (1-9T)
 *   0x21-0x29 = Pin/Circles (1-9C)
 *   0x00 / 0xFF = invalid/empty slot
 */
public final class HszCardDecoder {
    public static final int PLAYER_COUNT     = 4;
    public static final int CARDS_PER_PLAYER = 13;
    public static final int MAX_COUNT        = 14; // QP SDK allots 14 slots per player

    private HszCardDecoder() {}

    public static String decodeCard(int b) {
        if (b == 0 || b == 0xFF) return "--";
        int suit = (b >> 4) & 0xF;
        int val  = b & 0xF;
        if (val < 1 || val > 9) return String.format("%02X", b);
        switch (suit) {
            case 0: return val + "万";  // 万字牌 (W = Wan)
            case 1: return val + "条";  // 条子牌/索子 (T = Tiao)
            case 2: return val + "筒";  // 筒子牌 (C = Circle)
            case 3:
                switch (val) {
                    case 1: return "东";
                    case 2: return "南";
                    case 3: return "西";
                    case 4: return "北";
                    case 5: return "中";
                    case 6: return "发";
                    case 7: return "白";
                    default: return val + "?";
                }
            default: return String.format("%02X", b);
        }
    }

    public static String decodeHand(int[] cards) {
        if (cards == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int c : cards) {
            if (c != 0 && c != 0xFF) {
                if (sb.length() > 0) sb.append(' ');
                sb.append(decodeCard(c));
            }
        }
        return sb.toString();
    }

    /**
     * Game start packet body (QP: MainCmdID=200 SubCmdID=100 SUB_S_GAME_START).
     * Body layout (data after TNet strips TCP_Head):
     *   [0-3]  int    lSiceCount   (dice)
     *   [4-5]  word   wBankerUser
     *   [6-7]  word   wCurrentUser
     *   [8]    byte   cbUserAction
     *   [9..8+MAX_COUNT*4] byte[56]  cbCardData  — 4 players × 14 slots
     *
     * Returns int[4][13]: each player's starting 13 tiles.
     */
    public static int[][] parseGameStart(byte[] body) {
        if (body == null) return null;
        int dataOffset = 9; // skip 4+2+2+1
        if (body.length < dataOffset + MAX_COUNT * PLAYER_COUNT) return null;
        int[][] cards = new int[PLAYER_COUNT][CARDS_PER_PLAYER];
        for (int p = 0; p < PLAYER_COUNT; p++) {
            int base = dataOffset + p * MAX_COUNT;
            int k = 0;
            for (int i = 0; i < MAX_COUNT && k < CARDS_PER_PLAYER; i++) {
                int b = body[base + i] & 0xFF;
                if (b != 0 && b != 0xFF) {
                    cards[p][k++] = b;
                }
            }
        }
        return cards;
    }

    public static String formatAll(int[][] cards, int selfChairId) {
        if (cards == null) return "waiting...";
        StringBuilder sb = new StringBuilder();
        for (int p = 0; p < PLAYER_COUNT; p++) {
            sb.append(p == selfChairId ? "[ME] " : "P" + p + ": ");
            sb.append(decodeHand(cards[p]));
            if (p < PLAYER_COUNT - 1) sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * Parse gamerecord.dat format.
     * Tile sequences found at:
     *   0x130: Player 0 (13 tiles)
     *   0x13E: Player 1 (13 tiles)
     *   Need to find Player 2 & 3 positions
     *
     * Returns int[4][13]: each player's tiles, or null on error.
     */
    public static int[][] parseGameRecord(byte[] data) {
        if (data == null || data.length < 0x150) return null;

        int[][] cards = new int[PLAYER_COUNT][];

        // Player 0 at offset 0x130
        cards[0] = readTileSequence(data, 0x130, 13);

        // Player 1 at offset 0x13E
        cards[1] = readTileSequence(data, 0x13E, 13);

        // Search for Player 2 & 3 in range 0x200-0x400
        int foundPlayers = 2;
        for (int offset = 0x200; offset < Math.min(data.length - 13, 0x400) && foundPlayers < 4; offset++) {
            int[] hand = readTileSequence(data, offset, 13);
            if (hand != null && countValidTiles(hand) >= 10) {
                cards[foundPlayers++] = hand;
                offset += 12; // Skip ahead
            }
        }

        // Fill missing players with empty hands
        for (int i = 0; i < PLAYER_COUNT; i++) {
            if (cards[i] == null) {
                cards[i] = new int[CARDS_PER_PLAYER];
            }
        }

        return cards;
    }

    private static int[] readTileSequence(byte[] data, int offset, int count) {
        if (offset + count > data.length) return null;

        int[] tiles = new int[count];
        int validCount = 0;

        for (int i = 0; i < count; i++) {
            int b = data[offset + i] & 0xFF;
            if (isValidTile(b)) {
                tiles[validCount++] = b;
            } else if (b == 0x00) {
                break;  // End marker
            }
        }

        if (validCount < 10) return null;  // Not enough valid tiles
        return tiles;
    }

    private static boolean isValidTile(int b) {
        // QP encoding: 0x01-0x09 (W), 0x11-0x19 (T), 0x21-0x29 (C)
        // Also accept 0x31-0x39 (unknown suit seen in data)
        return (b >= 0x01 && b <= 0x09) ||
               (b >= 0x11 && b <= 0x19) ||
               (b >= 0x21 && b <= 0x29) ||
               (b >= 0x31 && b <= 0x37);
    }

    private static int countValidTiles(int[] tiles) {
        if (tiles == null) return 0;
        int count = 0;
        for (int t : tiles) {
            if (t != 0 && t != 0xFF) count++;
        }
        return count;
    }
}
