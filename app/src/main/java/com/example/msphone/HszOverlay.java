package com.example.msphone;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;

/**
 * 游戏内浮窗 — 实时显示全场手牌
 *
 * 功能：
 *   - 透视开启时显示 P0~P5 六名玩家的两张底牌
 *   - 自己席位高亮绿色
 *   - 可拖拽移动，点击标题折叠/展开
 *   - 透视关闭时完全不显示（dismiss）
 */
public final class HszOverlay {

    private final Context mCtx;
    private final WindowManager mWm;
    private WindowManager.LayoutParams mParams;
    private LinearLayout mRoot;
    private TextView mTitle;
    private LinearLayout mCardPanel;
    private final TextView[] mPlayerViews = new TextView[HszCardDecoder.PLAYER_COUNT];
    private boolean mExpanded = true;
    private boolean mAdded    = false;

    public HszOverlay(Context ctx) {
        mCtx = ctx.getApplicationContext();
        mWm  = (WindowManager) mCtx.getSystemService(Context.WINDOW_SERVICE);
    }

    public void show() {
        if (mAdded) return;
        buildView();
        try { mWm.addView(mRoot, mParams); mAdded = true; } catch (Throwable ignored) {}
    }

    public void dismiss() {
        if (!mAdded || mRoot == null) return;
        try { mWm.removeView(mRoot); } catch (Throwable ignored) {}
        mAdded = false;
        mRoot  = null;
    }

    public void updateCards(int[][] cards, int selfChairId) {
        if (mRoot == null || cards == null) return;
        mRoot.post(() -> {
            for (int p = 0; p < HszCardDecoder.PLAYER_COUNT; p++) {
                String text = String.format("P%d  %s %s",
                        p,
                        HszCardDecoder.decodeCard(cards[p][0]),
                        HszCardDecoder.decodeCard(cards[p][1]));
                mPlayerViews[p].setText(text);
                mPlayerViews[p].setTextColor(p == selfChairId ? Color.GREEN : Color.WHITE);
            }
        });
    }

    public void resetCards() {
        if (mRoot == null) return;
        mRoot.post(() -> {
            for (TextView tv : mPlayerViews) {
                tv.setText("等待发牌...");
                tv.setTextColor(Color.GRAY);
            }
        });
    }

    private void buildView() {
        int type = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                : WindowManager.LayoutParams.TYPE_PHONE;

        mParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                type,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT);
        mParams.gravity = Gravity.TOP | Gravity.LEFT;
        mParams.x = 10; mParams.y = 80;

        mRoot = new LinearLayout(mCtx);
        mRoot.setOrientation(LinearLayout.VERTICAL);
        mRoot.setBackgroundColor(0xCC000000);
        mRoot.setPadding(16, 8, 16, 8);

        // 标题（中性文字，不写"透视"等敏感词）
        mTitle = new TextView(mCtx);
        mTitle.setText("数据 ▼");
        mTitle.setTextColor(Color.YELLOW);
        mTitle.setTextSize(12);
        mTitle.setPadding(0, 0, 0, 4);
        mRoot.addView(mTitle);

        // 牌面面板
        mCardPanel = new LinearLayout(mCtx);
        mCardPanel.setOrientation(LinearLayout.VERTICAL);
        for (int p = 0; p < HszCardDecoder.PLAYER_COUNT; p++) {
            TextView tv = new TextView(mCtx);
            tv.setText("P" + p + "  等待发牌...");
            tv.setTextColor(Color.GRAY);
            tv.setTextSize(11);
            mPlayerViews[p] = tv;
            mCardPanel.addView(tv);
        }
        mRoot.addView(mCardPanel);

        attachDrag();
    }

    private void toggleExpand() {
        mExpanded = !mExpanded;
        mCardPanel.setVisibility(mExpanded ? View.VISIBLE : View.GONE);
        mTitle.setText(mExpanded ? "数据 ▼" : "数据 ▶");
    }

    private final int[] mLast = new int[2];

    private void attachDrag() {
        mTitle.setOnTouchListener((v, ev) -> {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mLast[0] = (int) ev.getRawX();
                    mLast[1] = (int) ev.getRawY();
                    return true;
                case MotionEvent.ACTION_MOVE:
                    int dx = (int) ev.getRawX() - mLast[0];
                    int dy = (int) ev.getRawY() - mLast[1];
                    mParams.x += dx; mParams.y += dy;
                    if (mAdded) mWm.updateViewLayout(mRoot, mParams);
                    mLast[0] = (int) ev.getRawX();
                    mLast[1] = (int) ev.getRawY();
                    return true;
                case MotionEvent.ACTION_UP:
                    if (Math.abs(dx(ev)) < 8 && Math.abs(dy(ev)) < 8) toggleExpand();
                    return true;
            }
            return false;
        });
    }

    private int dx(MotionEvent ev) { return (int) ev.getRawX() - mLast[0]; }
    private int dy(MotionEvent ev) { return (int) ev.getRawY() - mLast[1]; }
}