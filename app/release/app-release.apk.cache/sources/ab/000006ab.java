package f0;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final b f4514a = new Object();

    public static j a(Context context, e eVar) {
        Cursor cursor;
        int i4;
        int i5;
        Uri withAppendedId;
        int i6;
        boolean z4;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = eVar.f4515a;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider != null) {
            String str2 = resolveContentProvider.packageName;
            String str3 = eVar.f4516b;
            if (str2.equals(str3)) {
                Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    arrayList.add(signature.toByteArray());
                }
                b bVar = f4514a;
                Collections.sort(arrayList, bVar);
                List list = eVar.f4518d;
                if (list == null) {
                    list = a0.j.b(resources, 0);
                }
                int i7 = 0;
                loop1: while (true) {
                    cursor = null;
                    if (i7 < list.size()) {
                        ArrayList arrayList2 = new ArrayList((Collection) list.get(i7));
                        Collections.sort(arrayList2, bVar);
                        if (arrayList.size() == arrayList2.size()) {
                            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                                if (!Arrays.equals((byte[]) arrayList.get(i8), (byte[]) arrayList2.get(i8))) {
                                    break;
                                }
                            }
                            break loop1;
                        }
                        i7++;
                    } else {
                        resolveContentProvider = null;
                        break;
                    }
                }
                if (resolveContentProvider == null) {
                    return new j(1, null);
                }
                String str4 = resolveContentProvider.authority;
                ArrayList arrayList3 = new ArrayList();
                Uri build = new Uri.Builder().scheme("content").authority(str4).build();
                Uri build2 = new Uri.Builder().scheme("content").authority(str4).appendPath("file").build();
                try {
                    cursor = c.a(context.getContentResolver(), build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{eVar.f4517c}, null, null);
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("result_code");
                        arrayList3 = new ArrayList();
                        int columnIndex2 = cursor.getColumnIndex("_id");
                        int columnIndex3 = cursor.getColumnIndex("file_id");
                        int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursor.getColumnIndex("font_weight");
                        int columnIndex6 = cursor.getColumnIndex("font_italic");
                        while (cursor.moveToNext()) {
                            if (columnIndex != -1) {
                                i4 = cursor.getInt(columnIndex);
                            } else {
                                i4 = 0;
                            }
                            if (columnIndex4 != -1) {
                                i5 = cursor.getInt(columnIndex4);
                            } else {
                                i5 = 0;
                            }
                            if (columnIndex3 == -1) {
                                withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                            } else {
                                withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                            }
                            Uri uri = withAppendedId;
                            if (columnIndex5 != -1) {
                                i6 = cursor.getInt(columnIndex5);
                            } else {
                                i6 = 400;
                            }
                            int i9 = i6;
                            if (columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            arrayList3.add(new k(uri, i5, i9, z4, i4));
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return new j(0, (k[]) arrayList3.toArray(new k[0]));
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str3);
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
    }
}