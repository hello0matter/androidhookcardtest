package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public final class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final z f5914a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5915b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5916c;

    public y(Context context, z zVar, XmlResourceParser xmlResourceParser) {
        this.f5915b = -1;
        this.f5916c = 17;
        this.f5914a = zVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), t.k.f6661n);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 1) {
                this.f5915b = obtainStyledAttributes.getResourceId(index, this.f5915b);
            } else if (index == 0) {
                this.f5916c = obtainStyledAttributes.getInt(index, this.f5916c);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.view.View] */
    public final void a(MotionLayout motionLayout, int i4, z zVar) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i5 = this.f5915b;
        MotionLayout motionLayout2 = motionLayout;
        if (i5 != -1) {
            motionLayout2 = motionLayout.findViewById(i5);
        }
        if (motionLayout2 == null) {
            Log.e("MotionScene", "OnClick could not find id " + i5);
            return;
        }
        int i6 = zVar.f5920d;
        int i7 = zVar.f5919c;
        if (i6 == -1) {
            motionLayout2.setOnClickListener(this);
            return;
        }
        int i8 = this.f5916c;
        int i9 = i8 & 1;
        boolean z8 = true;
        if (i9 != 0 && i4 == i6) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((i8 & 256) != 0 && i4 == i6) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z9 = z4 | z5;
        if (i9 != 0 && i4 == i6) {
            z6 = true;
        } else {
            z6 = false;
        }
        boolean z10 = z6 | z9;
        if ((i8 & 16) != 0 && i4 == i7) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean z11 = z10 | z7;
        if ((i8 & 4096) == 0 || i4 != i7) {
            z8 = false;
        }
        if (z11 | z8) {
            motionLayout2.setOnClickListener(this);
        }
    }

    public final void b(MotionLayout motionLayout) {
        int i4 = this.f5915b;
        if (i4 == -1) {
            return;
        }
        View findViewById = motionLayout.findViewById(i4);
        if (findViewById == null) {
            Log.e("MotionScene", " (*)  could not find id " + i4);
            return;
        }
        findViewById.setOnClickListener(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onClick(android.view.View r13) {
        /*
            r12 = this;
            o.z r13 = r12.f5914a
            androidx.constraintlayout.motion.widget.b r0 = r13.f5926j
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.f1077a
            boolean r2 = r1.f1064y
            if (r2 != 0) goto Lb
            return
        Lb:
            int r2 = r13.f5920d
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = -1
            if (r2 != r4) goto L32
            int r0 = r1.getCurrentState()
            if (r0 != r4) goto L1e
            int r13 = r13.f5919c
            r1.z(r13)
            return
        L1e:
            o.z r2 = new o.z
            androidx.constraintlayout.motion.widget.b r4 = r13.f5926j
            r2.<init>(r4, r13)
            r2.f5920d = r0
            int r13 = r13.f5919c
            r2.f5919c = r13
            r1.setTransition(r2)
            r1.o(r3)
            return
        L32:
            o.z r0 = r0.f1079c
            int r2 = r12.f5916c
            r5 = r2 & 1
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L43
            r8 = r2 & 256(0x100, float:3.59E-43)
            if (r8 == 0) goto L41
            goto L43
        L41:
            r8 = r7
            goto L44
        L43:
            r8 = r6
        L44:
            r9 = r2 & 16
            if (r9 != 0) goto L4e
            r10 = r2 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L4d
            goto L4e
        L4d:
            r6 = r7
        L4e:
            if (r8 == 0) goto L6d
            if (r6 == 0) goto L6d
            if (r0 == r13) goto L57
            r1.setTransition(r13)
        L57:
            int r10 = r1.getCurrentState()
            int r11 = r1.getEndState()
            if (r10 == r11) goto L6e
            float r10 = r1.getProgress()
            r11 = 1056964608(0x3f000000, float:0.5)
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L6c
            goto L6e
        L6c:
            r6 = r7
        L6d:
            r7 = r8
        L6e:
            if (r13 != r0) goto L71
            goto L82
        L71:
            int r0 = r13.f5919c
            int r8 = r13.f5920d
            if (r8 != r4) goto L7c
            int r4 = r1.f1056u
            if (r4 == r0) goto Lb2
            goto L82
        L7c:
            int r4 = r1.f1056u
            if (r4 == r8) goto L82
            if (r4 != r0) goto Lb2
        L82:
            if (r7 == 0) goto L8d
            if (r5 == 0) goto L8d
            r1.setTransition(r13)
            r1.o(r3)
            goto Lb2
        L8d:
            r0 = 0
            if (r6 == 0) goto L99
            if (r9 == 0) goto L99
            r1.setTransition(r13)
            r1.o(r0)
            goto Lb2
        L99:
            if (r7 == 0) goto La6
            r4 = r2 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto La6
            r1.setTransition(r13)
            r1.setProgress(r3)
            goto Lb2
        La6:
            if (r6 == 0) goto Lb2
            r2 = r2 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto Lb2
            r1.setTransition(r13)
            r1.setProgress(r0)
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o.y.onClick(android.view.View):void");
    }
}