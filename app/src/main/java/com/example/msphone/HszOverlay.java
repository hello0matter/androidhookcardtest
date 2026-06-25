package com.example.msphone;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Attaches directly to the game Activity's DecorView — no SYSTEM_ALERT_WINDOW needed.
 * The game (com.yunjian.yygame) doesn't declare that permission in its manifest so
 * WindowManager TYPE_APPLICATION_OVERLAY would fail silently.
 */
public final class HszOverlay {

    private final WeakReference<Activity> mActRef;
    private LinearLayout mRoot;
    private LinearLayout mCardPanel;
    private CheckBox mCbHook;
    private final TextView[] mPlayerViews = new TextView[HszCardDecoder.PLAYER_COUNT];
    private boolean mAdded = false;
    private int mX = 10, mY = 80;

    public HszOverlay(Activity act) {
        mActRef = new WeakReference<>(act);
    }

    public void show() {
        if (mAdded) return;
        Activity act = mActRef.get();
        if (act == null || act.isFinishing()) return;
        if (mRoot == null) buildView(act);
        try {
            ViewGroup decor = (ViewGroup) act.getWindow().getDecorView();
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT);
            lp.gravity = Gravity.TOP | Gravity.LEFT;
            lp.leftMargin = mX;
            lp.topMargin  = mY;
            decor.addView(mRoot, lp);
            mAdded = true;
        } catch (Throwable t) {
            de.robv.android.xposed.XposedBridge.log("[HSZ] overlay add err: " + t.getMessage());
        }
    }

    public void dismiss() {
        if (!mAdded || mRoot == null) return;
        try {
            ViewGroup parent = (ViewGroup) mRoot.getParent();
            if (parent != null) parent.removeView(mRoot);
        } catch (Throwable ignored) {}
        mAdded = false;
    }

    public void setHookEnabled(boolean on) {
        if (mRoot == null) return;
        mRoot.post(() -> {
            HszStore.setToushi(mRoot.getContext(), on);
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

    private void buildView(Activity act) {
        mRoot = new LinearLayout(act);
        mRoot.setOrientation(LinearLayout.VERTICAL);
        mRoot.setBackgroundColor(0xCC000000);
        mRoot.setPadding(12, 6, 12, 6);

        // Header: drag handle + Hook checkbox
        LinearLayout header = new LinearLayout(act);
        header.setOrientation(LinearLayout.HORIZONTAL);
        header.setGravity(Gravity.CENTER_VERTICAL);

        TextView dragHandle = new TextView(act);
        dragHandle.setText("≡ ");
        dragHandle.setTextColor(0xFFAAAAAA);
        dragHandle.setTextSize(14);
        dragHandle.setPadding(0, 6, 6, 6);
        header.addView(dragHandle);

        mCbHook = new CheckBox(act);
        mCbHook.setText("Hook");
        mCbHook.setTextColor(Color.WHITE);
        mCbHook.setTextSize(12);
        mCbHook.setChecked(HszStore.isToushiOn(act));
        mCbHook.setOnCheckedChangeListener((b, on) -> {
            HszStore.setToushi(act, on);
            mCardPanel.setVisibility(on ? View.VISIBLE : View.GONE);
        });
        header.addView(mCbHook);

        mRoot.addView(header);

        // Card data panel
        mCardPanel = new LinearLayout(act);
        mCardPanel.setOrientation(LinearLayout.VERTICAL);
        mCardPanel.setVisibility(HszStore.isToushiOn(act) ? View.VISIBLE : View.GONE);
        for (int p = 0; p < HszCardDecoder.PLAYER_COUNT; p++) {
            TextView tv = new TextView(act);
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
                    if (mDragging && mRoot != null && mRoot.getParent() != null) {
                        mX += dx;
                        mY += dy;
                        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mRoot.getLayoutParams();
                        lp.leftMargin = mX;
                        lp.topMargin  = mY;
                        mRoot.setLayoutParams(lp);
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
