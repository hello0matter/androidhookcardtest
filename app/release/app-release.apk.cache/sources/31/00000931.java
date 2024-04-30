package p1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b {
    public static void a(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long j4 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Animator animator = (Animator) arrayList.get(i4);
            j4 = Math.max(j4, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j4);
        arrayList.add(0, ofInt);
        animatorSet.playTogether(arrayList);
    }
}