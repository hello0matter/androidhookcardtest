package s0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class h extends l2.f {

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6510c;

    /* renamed from: d  reason: collision with root package name */
    public final f f6511d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6512e;

    public h(TextView textView) {
        super(13, 0);
        this.f6510c = textView;
        this.f6512e = true;
        this.f6511d = new f(textView);
    }

    @Override // l2.f
    public final InputFilter[] g(InputFilter[] inputFilterArr) {
        if (!this.f6512e) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i4 = 0; i4 < inputFilterArr.length; i4++) {
                InputFilter inputFilter = inputFilterArr[i4];
                if (inputFilter instanceof f) {
                    sparseArray.put(i4, inputFilter);
                }
            }
            if (sparseArray.size() != 0) {
                int length = inputFilterArr.length;
                InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
                int i5 = 0;
                for (int i6 = 0; i6 < length; i6++) {
                    if (sparseArray.indexOfKey(i6) < 0) {
                        inputFilterArr2[i5] = inputFilterArr[i6];
                        i5++;
                    }
                }
                return inputFilterArr2;
            }
            return inputFilterArr;
        }
        int length2 = inputFilterArr.length;
        int i7 = 0;
        while (true) {
            f fVar = this.f6511d;
            if (i7 < length2) {
                if (inputFilterArr[i7] != fVar) {
                    i7++;
                } else {
                    return inputFilterArr;
                }
            } else {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = fVar;
                return inputFilterArr3;
            }
        }
    }

    @Override // l2.f
    public final boolean m() {
        return this.f6512e;
    }

    @Override // l2.f
    public final void o(boolean z4) {
        if (z4) {
            TextView textView = this.f6510c;
            textView.setTransformationMethod(t(textView.getTransformationMethod()));
        }
    }

    @Override // l2.f
    public final void r(boolean z4) {
        this.f6512e = z4;
        TextView textView = this.f6510c;
        textView.setTransformationMethod(t(textView.getTransformationMethod()));
        textView.setFilters(g(textView.getFilters()));
    }

    @Override // l2.f
    public final TransformationMethod t(TransformationMethod transformationMethod) {
        if (this.f6512e) {
            if (!(transformationMethod instanceof k) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                return new k(transformationMethod);
            }
            return transformationMethod;
        } else if (transformationMethod instanceof k) {
            return ((k) transformationMethod).f6518a;
        } else {
            return transformationMethod;
        }
    }
}