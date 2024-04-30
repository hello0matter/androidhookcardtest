package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.c;
import q.d;
import q.g;
import q.j;
import t.k;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {

    /* renamed from: j  reason: collision with root package name */
    public g f1008j;

    public Flow(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f1008j = new g();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.f6649b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == 0) {
                    this.f1008j.M0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    g gVar = this.f1008j;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar.f6262j0 = dimensionPixelSize;
                    gVar.f6263k0 = dimensionPixelSize;
                    gVar.f6264l0 = dimensionPixelSize;
                    gVar.f6265m0 = dimensionPixelSize;
                } else if (index == 11) {
                    g gVar2 = this.f1008j;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar2.f6264l0 = dimensionPixelSize2;
                    gVar2.f6266n0 = dimensionPixelSize2;
                    gVar2.f6267o0 = dimensionPixelSize2;
                } else if (index == 12) {
                    this.f1008j.f6265m0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f1008j.f6266n0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f1008j.f6262j0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f1008j.f6267o0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f1008j.f6263k0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 37) {
                    this.f1008j.K0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 27) {
                    this.f1008j.f6273u0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 36) {
                    this.f1008j.f6274v0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 21) {
                    this.f1008j.f6275w0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 29) {
                    this.f1008j.f6277y0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 23) {
                    this.f1008j.f6276x0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 31) {
                    this.f1008j.f6278z0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 25) {
                    this.f1008j.A0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 20) {
                    this.f1008j.C0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 28) {
                    this.f1008j.E0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 22) {
                    this.f1008j.D0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 30) {
                    this.f1008j.F0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 34) {
                    this.f1008j.B0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 24) {
                    this.f1008j.I0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 33) {
                    this.f1008j.J0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 26) {
                    this.f1008j.G0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 35) {
                    this.f1008j.H0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 32) {
                    this.f1008j.L0 = obtainStyledAttributes.getInt(index, -1);
                }
            }
        }
        this.f1226d = this.f1008j;
        l();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void h(c cVar, j jVar, Constraints.LayoutParams layoutParams, SparseArray sparseArray) {
        super.h(cVar, jVar, layoutParams, sparseArray);
        if (jVar instanceof g) {
            g gVar = (g) jVar;
            int i4 = layoutParams.R;
            if (i4 != -1) {
                gVar.M0 = i4;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void i(d dVar, boolean z4) {
        g gVar = this.f1008j;
        int i4 = gVar.f6264l0;
        if (i4 > 0 || gVar.f6265m0 > 0) {
            if (z4) {
                gVar.f6266n0 = gVar.f6265m0;
                gVar.f6267o0 = i4;
                return;
            }
            gVar.f6266n0 = i4;
            gVar.f6267o0 = gVar.f6265m0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0179, code lost:
        r0 = r28;
        r3 = r40.L0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x017d, code lost:
        if (r3 > 0) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x017f, code lost:
        r3 = 0;
        r4 = 0;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0182, code lost:
        if (r3 >= r7) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0184, code lost:
        if (r3 <= 0) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0186, code lost:
        r4 = r4 + r40.H0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0189, code lost:
        r15 = r14[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x018b, code lost:
        if (r15 != null) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x018e, code lost:
        r15 = r40.E(r15, r0) + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0193, code lost:
        if (r15 <= r0) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0196, code lost:
        r8 = r8 + 1;
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0199, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x019c, code lost:
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x019d, code lost:
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01a0, code lost:
        if (r40.Q0 != null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01a2, code lost:
        r40.Q0 = new int[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01a7, code lost:
        if (r3 != 0) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01aa, code lost:
        if (r1 == 1) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01ac, code lost:
        if (r8 != 0) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01ae, code lost:
        if (r1 != 0) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01b0, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01b2, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01b3, code lost:
        if (r4 != false) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01b5, code lost:
        if (r1 != 0) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x01b7, code lost:
        r42 = r4;
        r3 = (int) java.lang.Math.ceil(r7 / r8);
        r17 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01c5, code lost:
        r42 = r4;
        r17 = r5;
        r8 = (int) java.lang.Math.ceil(r7 / r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01d2, code lost:
        r4 = r40.P0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01d4, code lost:
        if (r4 == null) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01d7, code lost:
        if (r4.length >= r8) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01d9, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01db, code lost:
        r5 = null;
        java.util.Arrays.fill(r4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01e0, code lost:
        r40.P0 = new q.d[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01e4, code lost:
        r4 = r40.O0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01e6, code lost:
        if (r4 == null) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01e9, code lost:
        if (r4.length >= r3) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01ec, code lost:
        java.util.Arrays.fill(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01f0, code lost:
        r40.O0 = new q.d[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01f4, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01f5, code lost:
        if (r4 >= r8) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01f7, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01f8, code lost:
        if (r5 >= r3) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01fa, code lost:
        r15 = (r5 * r8) + r4;
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0200, code lost:
        if (r1 != 1) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0202, code lost:
        r15 = (r4 * r3) + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0207, code lost:
        if (r15 < r14.length) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0209, code lost:
        r28 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x020c, code lost:
        r6 = r14[r15];
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x020e, code lost:
        if (r6 != null) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0211, code lost:
        r15 = r40.F(r6, r0);
        r28 = r13;
        r13 = r40.P0[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x021b, code lost:
        if (r13 == null) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0221, code lost:
        if (r13.n() >= r15) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0223, code lost:
        r40.P0[r4] = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0227, code lost:
        r13 = r40.E(r6, r0);
        r15 = r40.O0[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x022f, code lost:
        if (r15 == null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0235, code lost:
        if (r15.k() >= r13) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0237, code lost:
        r40.O0[r5] = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x023b, code lost:
        r5 = r5 + 1;
        r6 = r18;
        r13 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0242, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0249, code lost:
        r18 = r6;
        r28 = r13;
        r4 = 0;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x024f, code lost:
        if (r4 >= r8) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0251, code lost:
        r6 = r40.P0[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0255, code lost:
        if (r6 == null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0257, code lost:
        if (r4 <= 0) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0259, code lost:
        r5 = r5 + r40.G0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x025c, code lost:
        r5 = r40.F(r6, r0) + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0262, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0265, code lost:
        r4 = 0;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0267, code lost:
        if (r4 >= r3) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0269, code lost:
        r13 = r40.O0[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x026d, code lost:
        if (r13 == null) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x026f, code lost:
        if (r4 <= 0) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0271, code lost:
        r6 = r6 + r40.H0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0274, code lost:
        r6 = r40.E(r13, r0) + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x027a, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x027d, code lost:
        r2[0] = r5;
        r2[1] = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0283, code lost:
        if (r1 != 0) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0285, code lost:
        if (r5 <= r0) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0287, code lost:
        if (r8 <= 1) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0289, code lost:
        r8 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x028b, code lost:
        r4 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x028e, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0290, code lost:
        if (r6 <= r0) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0292, code lost:
        if (r3 <= 1) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0294, code lost:
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0297, code lost:
        r5 = r17;
        r6 = r18;
        r13 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x029f, code lost:
        r17 = r5;
        r18 = r6;
        r28 = r13;
        r13 = true;
        r0 = r40.Q0;
        r0[0] = r8;
        r0[1] = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x02ad, code lost:
        r29 = r2;
        r37 = r10;
        r36 = r11;
        r32 = r12;
        r16 = r13;
        r33 = r17;
        r34 = r18;
        r30 = r20;
        r31 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x02bf, code lost:
        r1 = 0;
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x02c2, code lost:
        r17 = r5;
        r18 = r6;
        r28 = r13;
        r13 = true;
        r6 = r40.M0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x02cd, code lost:
        if (r7 != 0) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x02d0, code lost:
        r4.clear();
        r19 = r7;
        r29 = r2;
        r30 = r20;
        r32 = r12;
        r31 = r21;
        r33 = r17;
        r34 = r18;
        r36 = r11;
        r16 = true;
        r37 = r10;
        r10 = r8;
        r5 = new q.f(r40, r6, r40.f6227y, r40.f6228z, r40.A, r40.B, r28);
        r4.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x030d, code lost:
        if (r6 != 0) goto L315;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x030f, code lost:
        r5 = r5;
        r1 = 0;
        r2 = 0;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0313, code lost:
        if (r13 >= r19) goto L271;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0315, code lost:
        r8 = r14[r13];
        r17 = r40.F(r8, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0320, code lost:
        if (r8.J[0] != r10) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0322, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0324, code lost:
        r18 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0326, code lost:
        if (r2 == r28) goto L268;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x032d, code lost:
        if (((r40.G0 + r2) + r17) <= r28) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0331, code lost:
        if (r5.f6245b == null) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0333, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0336, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0337, code lost:
        if (r7 != false) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0339, code lost:
        if (r13 <= 0) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x033b, code lost:
        r1 = r40.L0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x033d, code lost:
        if (r1 <= 0) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0341, code lost:
        if ((r13 % r1) != 0) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0344, code lost:
        if (r7 == false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0346, code lost:
        r41 = r15;
        r19 = r10;
        r10 = r8;
        r7 = new q.f(r40, r6, r40.f6227y, r40.f6228z, r40.A, r40.B, r28);
        r7.f6257n = r13;
        r4.add(r7);
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x036d, code lost:
        r2 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0370, code lost:
        r19 = r10;
        r41 = r15;
        r10 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0375, code lost:
        if (r13 <= 0) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0377, code lost:
        r2 = (r40.G0 + r17) + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x037d, code lost:
        r5.a(r10);
        r13 = r13 + 1;
        r15 = r41;
        r1 = r18;
        r10 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0389, code lost:
        r41 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x038d, code lost:
        r19 = r10;
        r41 = r15;
        r5 = r5;
        r1 = 0;
        r2 = 0;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0395, code lost:
        if (r10 >= r19) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0397, code lost:
        r13 = r14[r10];
        r15 = r40.E(r13, r28);
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x03a3, code lost:
        if (r13.J[1] != r8) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x03a5, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x03a7, code lost:
        r17 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x03a9, code lost:
        if (r2 == r28) goto L340;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x03af, code lost:
        if (((r40.H0 + r2) + r15) <= r28) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x03b3, code lost:
        if (r5.f6245b == null) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x03b5, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x03b8, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x03b9, code lost:
        if (r7 != false) goto L335;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x03bb, code lost:
        if (r10 <= 0) goto L335;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x03bd, code lost:
        r1 = r40.L0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x03bf, code lost:
        if (r1 <= 0) goto L335;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x03c3, code lost:
        if ((r10 % r1) != 0) goto L335;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x03c6, code lost:
        if (r7 == false) goto L336;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x03c8, code lost:
        r42 = r14;
        r18 = r8;
        r7 = new q.f(r40, r6, r40.f6227y, r40.f6228z, r40.A, r40.B, r28);
        r7.f6257n = r10;
        r4.add(r7);
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x03ee, code lost:
        r2 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x03f0, code lost:
        r18 = r8;
        r42 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x03f4, code lost:
        if (r10 <= 0) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x03f6, code lost:
        r2 = (r40.H0 + r15) + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x03fb, code lost:
        r5.a(r13);
        r10 = r10 + 1;
        r14 = r42;
        r1 = r17;
        r19 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0407, code lost:
        r2 = r4.size();
        r3 = r40.f6266n0;
        r4 = r40.f6262j0;
        r5 = r40.f6267o0;
        r6 = r40.f6263k0;
        r7 = r40.J;
        r8 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x041a, code lost:
        if (r7[0] == r8) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x041e, code lost:
        if (r7[1] != r8) goto L277;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0421, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0423, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0425, code lost:
        if (r1 <= 0) goto L289;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0427, code lost:
        if (r7 == false) goto L289;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0429, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x042a, code lost:
        if (r1 >= r2) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x042c, code lost:
        r7 = (q.f) r4.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0432, code lost:
        if (r6 != 0) goto L287;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0434, code lost:
        r8 = r7.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0438, code lost:
        r7.e(r28 - r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x043e, code lost:
        r8 = r7.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0443, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0446, code lost:
        r1 = r40.B;
        r7 = r40.A;
        r8 = r40.f6227y;
        r10 = r40.f6228z;
        r15 = r1;
        r38 = r7;
        r11 = 0;
        r13 = 0;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0454, code lost:
        if (r11 >= r2) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0456, code lost:
        r41 = r1;
        r1 = (q.f) r4.get(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0460, code lost:
        if (r6 != 0) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0464, code lost:
        if (r11 >= (r2 - 1)) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0466, code lost:
        r15 = ((q.f) r4.get(r11 + 1)).f6245b.f6228z;
        r42 = r7;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0477, code lost:
        r6 = r40.f6263k0;
        r15 = r41;
        r42 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x047d, code lost:
        r7 = r1.f6245b.B;
        r1.f(r6, r8, r10, r38, r15, r3, r4, r5, r6, r28);
        r4 = java.lang.Math.max(r13, r1.d());
        r1 = r1.c() + r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x04a7, code lost:
        if (r11 <= 0) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x04a9, code lost:
        r1 = r1 + r40.H0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x04ac, code lost:
        r14 = r1;
        r13 = r4;
        r10 = r7;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x04b1, code lost:
        r42 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x04b5, code lost:
        if (r11 >= (r2 - 1)) goto L311;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x04b7, code lost:
        r38 = ((q.f) r4.get(r11 + 1)).f6245b.f6227y;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x04c7, code lost:
        r5 = r40.f6267o0;
        r38 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x04cb, code lost:
        r7 = r1.f6245b.A;
        r1.f(r6, r8, r10, r38, r15, r3, r4, r5, r6, r28);
        r3 = r1.d() + r13;
        r1 = java.lang.Math.max(r14, r1.c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x04f5, code lost:
        if (r11 <= 0) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x04f7, code lost:
        r3 = r3 + r40.G0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x04fa, code lost:
        r14 = r1;
        r13 = r3;
        r8 = r7;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x04fe, code lost:
        r11 = r11 + 1;
        r1 = r41;
        r7 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0506, code lost:
        r29[0] = r13;
        r29[1] = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x050d, code lost:
        r29 = r2;
        r33 = r5;
        r34 = r6;
        r37 = r10;
        r36 = r11;
        r32 = r12;
        r42 = r14;
        r30 = r20;
        r31 = r21;
        r16 = true;
        r16 = 1;
        r11 = r7;
        r28 = r13;
        r3 = r40.M0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0529, code lost:
        if (r11 != 0) goto L346;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0531, code lost:
        if (r4.size() != 0) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0533, code lost:
        r10 = new q.f(r40, r3, r40.f6227y, r40.f6228z, r40.A, r40.B, r28);
        r4.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0548, code lost:
        r10 = (q.f) r4.get(0);
        r10.f6246c = 0;
        r10.f6245b = null;
        r10.f6255l = 0;
        r10.f6256m = 0;
        r10.f6257n = 0;
        r10.f6258o = 0;
        r10.f6259p = 0;
        r10.f(r3, r40.f6227y, r40.f6228z, r40.A, r40.B, r40.f6266n0, r40.f6262j0, r40.f6267o0, r40.f6263k0, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0588, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0589, code lost:
        if (r0 >= r11) goto L352;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x058b, code lost:
        r10.a(r42[r0]);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0593, code lost:
        r1 = 0;
        r29[0] = r10.d();
        r29[1] = r10.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x05a0, code lost:
        r0 = (r29[r1] + r34) + r33;
        r1 = (r29[r16] + r31) + r30;
        r4 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x05b2, code lost:
        if (r4 != 1073741824) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x05b4, code lost:
        r0 = r32;
        r11 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x05b9, code lost:
        if (r4 != Integer.MIN_VALUE) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x05bb, code lost:
        r11 = java.lang.Math.min(r0, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x05c1, code lost:
        r0 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x05c4, code lost:
        if (r4 != 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x05c6, code lost:
        r11 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x05c8, code lost:
        r0 = r32;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x05cb, code lost:
        if (r0 != 1073741824) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x05cd, code lost:
        r13 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x05d0, code lost:
        if (r0 != Integer.MIN_VALUE) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x05d2, code lost:
        r13 = java.lang.Math.min(r1, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x05d9, code lost:
        if (r0 != 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x05db, code lost:
        r13 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x05dd, code lost:
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x05de, code lost:
        r40.f6269q0 = r11;
        r40.f6270r0 = r13;
        r40.A(r11);
        r40.x(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x05ea, code lost:
        if (r40.f6285i0 <= 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x05ec, code lost:
        r14 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x05f0, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00be, code lost:
        if (r40.f6274v0 == (-1)) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c0, code lost:
        r40.f6274v0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cb, code lost:
        if (r40.f6274v0 == (-1)) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ce, code lost:
        r1 = r40.f6284h0;
        r7 = 0;
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d3, code lost:
        r14 = r40.f6285i0;
        r18 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d9, code lost:
        if (r7 >= r14) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e1, code lost:
        if (r40.f6284h0[r7].X != 8) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e3, code lost:
        r17 = r17 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e5, code lost:
        r7 = r7 + 1;
        r1 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ea, code lost:
        if (r17 <= 0) goto L355;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ec, code lost:
        r7 = new q.d[r14 - r17];
        r14 = 0;
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f5, code lost:
        if (r14 >= r40.f6285i0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f7, code lost:
        r1 = r40.f6284h0[r14];
        r20 = r3;
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0103, code lost:
        if (r1.X == 8) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0105, code lost:
        r7[r17] = r1;
        r17 = r17 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0109, code lost:
        r14 = r14 + 1;
        r3 = r20;
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0110, code lost:
        r20 = r3;
        r21 = r4;
        r14 = r7;
        r7 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0118, code lost:
        r20 = r3;
        r21 = r4;
        r7 = r14;
        r14 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x011f, code lost:
        r40.R0 = r14;
        r40.S0 = r7;
        r1 = r40.K0;
        r4 = r40.N0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0127, code lost:
        if (r1 == 0) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x012a, code lost:
        if (r1 == 1) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012d, code lost:
        if (r1 == 2) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012f, code lost:
        r29 = r2;
        r33 = r5;
        r34 = r6;
        r37 = r10;
        r36 = r11;
        r32 = r12;
        r28 = r13;
        r30 = r20;
        r31 = r21;
        r1 = 0;
        r16 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0146, code lost:
        r1 = r40.M0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0148, code lost:
        if (r1 != 0) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x014a, code lost:
        r3 = r40.L0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x014c, code lost:
        if (r3 > 0) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x014e, code lost:
        r3 = 0;
        r4 = 0;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0151, code lost:
        if (r3 >= r7) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0153, code lost:
        if (r3 <= 0) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0155, code lost:
        r4 = r4 + r40.G0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0158, code lost:
        r15 = r14[r3];
        r0 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x015c, code lost:
        if (r15 != null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x015f, code lost:
        r15 = r40.F(r15, r0) + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0164, code lost:
        if (r15 <= r0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0167, code lost:
        r8 = r8 + 1;
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x016a, code lost:
        r3 = r3 + 1;
        r28 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0171, code lost:
        r0 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0173, code lost:
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0175, code lost:
        r0 = r28;
        r8 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v8 */
    @Override // androidx.constraintlayout.widget.VirtualLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(q.g r40, int r41, int r42) {
        /*
            Method dump skipped, instructions count: 1539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.m(q.g, int, int):void");
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onMeasure(int i4, int i5) {
        m(this.f1008j, i4, i5);
    }

    public void setFirstHorizontalBias(float f4) {
        this.f1008j.C0 = f4;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i4) {
        this.f1008j.f6275w0 = i4;
        requestLayout();
    }

    public void setFirstVerticalBias(float f4) {
        this.f1008j.D0 = f4;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i4) {
        this.f1008j.f6276x0 = i4;
        requestLayout();
    }

    public void setHorizontalAlign(int i4) {
        this.f1008j.I0 = i4;
        requestLayout();
    }

    public void setHorizontalBias(float f4) {
        this.f1008j.A0 = f4;
        requestLayout();
    }

    public void setHorizontalGap(int i4) {
        this.f1008j.G0 = i4;
        requestLayout();
    }

    public void setHorizontalStyle(int i4) {
        this.f1008j.f6273u0 = i4;
        requestLayout();
    }

    public void setMaxElementsWrap(int i4) {
        this.f1008j.L0 = i4;
        requestLayout();
    }

    public void setOrientation(int i4) {
        this.f1008j.M0 = i4;
        requestLayout();
    }

    public void setPadding(int i4) {
        g gVar = this.f1008j;
        gVar.f6262j0 = i4;
        gVar.f6263k0 = i4;
        gVar.f6264l0 = i4;
        gVar.f6265m0 = i4;
        requestLayout();
    }

    public void setPaddingBottom(int i4) {
        this.f1008j.f6263k0 = i4;
        requestLayout();
    }

    public void setPaddingLeft(int i4) {
        this.f1008j.f6266n0 = i4;
        requestLayout();
    }

    public void setPaddingRight(int i4) {
        this.f1008j.f6267o0 = i4;
        requestLayout();
    }

    public void setPaddingTop(int i4) {
        this.f1008j.f6262j0 = i4;
        requestLayout();
    }

    public void setVerticalAlign(int i4) {
        this.f1008j.J0 = i4;
        requestLayout();
    }

    public void setVerticalBias(float f4) {
        this.f1008j.B0 = f4;
        requestLayout();
    }

    public void setVerticalGap(int i4) {
        this.f1008j.H0 = i4;
        requestLayout();
    }

    public void setVerticalStyle(int i4) {
        this.f1008j.f6274v0 = i4;
        requestLayout();
    }

    public void setWrapMode(int i4) {
        this.f1008j.K0 = i4;
        requestLayout();
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}