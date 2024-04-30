package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
import z.b;
import z.e;
import z.f;
import z.g;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f1377b = {"_display_name", "_size"};

    /* renamed from: c  reason: collision with root package name */
    public static final File f1378c = new File("/");

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap f1379d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public g f1380a;

    public static g a(Context context, String str) {
        g gVar = new g();
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (resolveContentProvider != null) {
            XmlResourceParser loadXmlMetaData = resolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
            if (loadXmlMetaData == null) {
                throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            }
            while (true) {
                int next = loadXmlMetaData.next();
                if (next != 1) {
                    if (next == 2) {
                        String name = loadXmlMetaData.getName();
                        File file = null;
                        String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                        String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                        if ("root-path".equals(name)) {
                            file = f1378c;
                        } else if ("files-path".equals(name)) {
                            file = context.getFilesDir();
                        } else if ("cache-path".equals(name)) {
                            file = context.getCacheDir();
                        } else if ("external-path".equals(name)) {
                            file = Environment.getExternalStorageDirectory();
                        } else if ("external-files-path".equals(name)) {
                            Object obj = e.f7215a;
                            File[] b5 = b.b(context, null);
                            if (b5.length > 0) {
                                file = b5[0];
                            }
                        } else if ("external-cache-path".equals(name)) {
                            Object obj2 = e.f7215a;
                            File[] a5 = b.a(context);
                            if (a5.length > 0) {
                                file = a5[0];
                            }
                        } else if ("external-media-path".equals(name)) {
                            File[] a6 = f.a(context);
                            if (a6.length > 0) {
                                file = a6[0];
                            }
                        }
                        if (file == null) {
                            continue;
                        } else {
                            String str2 = new String[]{attributeValue2}[0];
                            if (str2 != null) {
                                file = new File(file, str2);
                            }
                            if (!TextUtils.isEmpty(attributeValue)) {
                                try {
                                    gVar.f7216a.put(attributeValue, file.getCanonicalFile());
                                } catch (IOException e4) {
                                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e4);
                                }
                            } else {
                                throw new IllegalArgumentException("Name must not be empty");
                            }
                        }
                    }
                } else {
                    return gVar;
                }
            }
        } else {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        g gVar;
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                String str = providerInfo.authority.split(";")[0];
                HashMap hashMap = f1379d;
                synchronized (hashMap) {
                    hashMap.remove(str);
                }
                synchronized (hashMap) {
                    try {
                        gVar = (g) hashMap.get(str);
                        if (gVar == null) {
                            try {
                                gVar = a(context, str);
                                hashMap.put(str, gVar);
                            } catch (IOException e4) {
                                throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e4);
                            } catch (XmlPullParserException e5) {
                                throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e5);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.f1380a = gVar;
                return;
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return this.f1380a.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        File a5 = this.f1380a.a(uri);
        int lastIndexOf = a5.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a5.getName().substring(lastIndexOf + 1));
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        int i4;
        File a5 = this.f1380a.a(uri);
        if ("r".equals(str)) {
            i4 = 268435456;
        } else if (!"w".equals(str) && !"wt".equals(str)) {
            if ("wa".equals(str)) {
                i4 = 704643072;
            } else if ("rw".equals(str)) {
                i4 = 939524096;
            } else if ("rwt".equals(str)) {
                i4 = 1006632960;
            } else {
                throw new IllegalArgumentException("Invalid mode: " + str);
            }
        } else {
            i4 = 738197504;
        }
        return ParcelFileDescriptor.open(a5, i4);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i4;
        String str3;
        File a5 = this.f1380a.a(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f1377b;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i5 = 0;
        for (String str4 : strArr) {
            if ("_display_name".equals(str4)) {
                strArr3[i5] = "_display_name";
                i4 = i5 + 1;
                if (queryParameter == null) {
                    str3 = a5.getName();
                } else {
                    str3 = queryParameter;
                }
                objArr[i5] = str3;
            } else if ("_size".equals(str4)) {
                strArr3[i5] = "_size";
                i4 = i5 + 1;
                objArr[i5] = Long.valueOf(a5.length());
            }
            i5 = i4;
        }
        String[] strArr4 = new String[i5];
        System.arraycopy(strArr3, 0, strArr4, 0, i5);
        Object[] objArr2 = new Object[i5];
        System.arraycopy(objArr, 0, objArr2, 0, i5);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}