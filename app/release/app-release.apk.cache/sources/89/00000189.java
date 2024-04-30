package androidx.appcompat.widget;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import com.example.msphone.R;
import com.google.android.material.navigation.NavigationBarItemView;

/* loaded from: classes.dex */
public final class v2 implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f923a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f924b;

    public /* synthetic */ v2(int i4, Object obj) {
        this.f923a = i4;
        this.f924b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        q1.a aVar;
        int i12 = this.f923a;
        Object obj = this.f924b;
        switch (i12) {
            case 0:
                SearchView searchView = (SearchView) obj;
                View view2 = searchView.f621x;
                if (view2.getWidth() > 1) {
                    Resources resources = searchView.getContext().getResources();
                    int paddingLeft = searchView.f615r.getPaddingLeft();
                    Rect rect = new Rect();
                    boolean a5 = e4.a(searchView);
                    int dimensionPixelSize = searchView.M ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
                    SearchView.SearchAutoComplete searchAutoComplete = searchView.f613p;
                    searchAutoComplete.getDropDownBackground().getPadding(rect);
                    int i13 = rect.left;
                    searchAutoComplete.setDropDownHorizontalOffset(a5 ? -i13 : paddingLeft - (i13 + dimensionPixelSize));
                    searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
                    return;
                }
                return;
            case 1:
                NavigationBarItemView navigationBarItemView = (NavigationBarItemView) obj;
                if (navigationBarItemView.f3628n.getVisibility() != 0 || (aVar = navigationBarItemView.F) == null) {
                    return;
                }
                Rect rect2 = new Rect();
                ImageView imageView = navigationBarItemView.f3628n;
                imageView.getDrawingRect(rect2);
                aVar.setBounds(rect2);
                aVar.i(imageView, null);
                return;
            default:
                q2.a aVar2 = (q2.a) obj;
                int i14 = q2.a.N;
                aVar2.getClass();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                aVar2.I = iArr[0];
                view.getWindowVisibleDisplayFrame(aVar2.C);
                return;
        }
    }
}