package com.example.msphone;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class HszOverlay {

    private final Context mCtx;
    private final WindowManager mWm;
    private WindowManager.LayoutParams mParams;
    private LinearLayout mRoot;
    private LinearLayout mCardPanel;
    private CheckBox mCbHook;
    private final TextView[] mPlayerViews = new TextView[HszCardDecoder.PLAYER_COUNT];
    private boolean mAdded = false;

    public HszOverlay(Context ctx) {
        mCtx = ctx.getApplicationContext();
        mWm  = (WindowManager) mCtx.getSystemService(Context.WINDOW_SERVICE);
    }

    public void show() {
        if (mAdded) return;
        if (mRoot == null) buildView();
        try { mWm.addView(mRoot, mParams); mAdded = true; } catch (Throwable ignored) {}
    }

    public void dismiss() {
        if (!mAdded || mRoot == null) return;
        try { mWm.removeView(mRoot); } catch (Throwable ignored) {}
        mAdded = false;
    }

    /** Called by remote C2 commands to toggle hook state */
    public void setHookEnabled(boolean on) {
        if (mRoot == null) return;
        mRoot.post(() -> {
            HszStore.setToushi(mCtx, on);
            if (mCbHook != null && mCbHook.isChecked() != on) mCbHook.setChecked(on);
            if (mCardPanel != null) mCardPanel.setVisibility(on ? View.VISIBLE : View.GONE);
        });
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
                tv.setText("-- --");
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
        mParams.x = 10;
        mParams.y = 80;

        mRoot = new LinearLayout(mCtx);
        mRoot.setOrientation(LinearLayout.VERTICAL);
        mRoot.setBackgroundColor(0xCC000000);
        mRoot.setPadding(12, 6, 12, 6);

        // Header: drag handle (≡) + Hook checkbox
        LinearLayout header = new LinearLayout(mCtx);
        header.setOrientation(LinearLayout.HORIZONTAL);
        header.setGravity(Gravity.CENTER_VERTICAL);

        // Drag handle — only this area triggers drag
        TextView dragHandle = new TextView(mCtx);
        dragHandle.setText("≡ ");
        dragHandle.setTextColor(0xFFAAAAAA);
        dragHandle.setTextSize(14);
        dragHandle.setPadding(0, 6, 6, 6);
        header.addView(dragHandle);

        // Single toggle: enable/disable hook
        mCbHook = new CheckBox(mCtx);
        mCbHook.setText("Hook");
        mCbHook.setTextColor(Color.WHITE);
        mCbHook.setTextSize(12);
        mCbHook.setChecked(HszStore.isToushiOn(mCtx));
        mCbHook.setOnCheckedChangeListener((b, on) -> {
            HszStore.setToushi(mCtx, on);
            mCardPanel.setVisibility(on ? View.VISIBLE : View.GONE);
        });
        header.addView(mCbHook);

        mRoot.addView(header);

        // Card data panel — visible only when hook is on
        mCardPanel = new LinearLayout(mCtx);
        mCardPanel.setOrientation(LinearLayout.VERTICAL);
        mCardPanel.setVisibility(HszStore.isToushiOn(mCtx) ? View.VISIBLE : View.GONE);
        for (int p = 0; p < HszCardDecoder.PLAYER_COUNT; p++) {
            TextView tv = new TextView(mCtx);
            tv.setText("P" + p + "  -- --");
            tv.setTextColor(Color.GRAY);
            tv.setTextSize(11);
            mPlayerViews[p] = tv;
            mCardPanel.addView(tv);
        }
        mRoot.addView(mCardPanel);

        attachDrag(dragHandle);
    }

    private final int[] mLast = new int[2];
    private boolean mDragging = false;

    private void attachDrag(View handle) {
        handle.setOnTouchListener((v, ev) -> {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mLast[0] = (int) ev.getRawX();
                    mLast[1] = (int) ev.getRawY();
                    mDragging = false;
                    return true;
                case MotionEvent.ACTION_MOVE:
                    int dx = (int) ev.getRawX() - mLast[0];
                    int dy = (int) ev.getRawY() - mLast[1];
                    if (Math.abs(dx) > 4 || Math.abs(dy) > 4) mDragging = true;
                    if (mDragging) {
                        mParams.x += dx;
                        mParams.y += dy;
                        if (mAdded) mWm.updateViewLayout(mRoot, mParams);
                        mLast[0] = (int) ev.getRawX();
                        mLast[1] = (int) ev.getRawY();
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    return true;
            }
            return false;
        });
    }
}
