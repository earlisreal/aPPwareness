package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class zzbti implements Closeable {
    private static final char[] zzcpF;
    private final Reader in;
    private int limit;
    private int pos;
    private boolean zzcpG;
    private final char[] zzcpH;
    private int zzcpI;
    private int zzcpJ;
    private int zzcpK;
    private long zzcpL;
    private int zzcpM;
    private String zzcpN;
    private int[] zzcpO;
    private int zzcpP;
    private String[] zzcpQ;
    private int[] zzcpR;

    /* renamed from: com.google.android.gms.internal.zzbti.1 */
    static class C12401 extends zzbsn {
        C12401() {
        }

        public void zzi(zzbti com_google_android_gms_internal_zzbti) throws IOException {
            if (com_google_android_gms_internal_zzbti instanceof zzbsy) {
                ((zzbsy) com_google_android_gms_internal_zzbti).zzabT();
                return;
            }
            int zzG = com_google_android_gms_internal_zzbti.zzcpK;
            if (zzG == 0) {
                zzG = com_google_android_gms_internal_zzbti.zzacd();
            }
            if (zzG == 13) {
                com_google_android_gms_internal_zzbti.zzcpK = 9;
            } else if (zzG == 12) {
                com_google_android_gms_internal_zzbti.zzcpK = 8;
            } else if (zzG == 14) {
                com_google_android_gms_internal_zzbti.zzcpK = 10;
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzbti.zzabQ());
                int zzI = com_google_android_gms_internal_zzbti.getLineNumber();
                int zzJ = com_google_android_gms_internal_zzbti.getColumnNumber();
                String path = com_google_android_gms_internal_zzbti.getPath();
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" ").append(" at line ").append(zzI).append(" column ").append(zzJ).append(" path ").append(path).toString());
            }
        }
    }

    static {
        zzcpF = ")]}'\n".toCharArray();
        zzbsn.zzcny = new C12401();
    }

    public zzbti(Reader reader) {
        this.zzcpG = false;
        this.zzcpH = new char[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        this.pos = 0;
        this.limit = 0;
        this.zzcpI = 0;
        this.zzcpJ = 0;
        this.zzcpK = 0;
        this.zzcpO = new int[32];
        this.zzcpP = 0;
        int[] iArr = this.zzcpO;
        int i = this.zzcpP;
        this.zzcpP = i + 1;
        iArr[i] = 6;
        this.zzcpQ = new String[32];
        this.zzcpR = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    private int getColumnNumber() {
        return (this.pos - this.zzcpJ) + 1;
    }

    private int getLineNumber() {
        return this.zzcpI + 1;
    }

    private int zzacd() throws IOException {
        int zzbh;
        int i = this.zzcpO[this.zzcpP - 1];
        if (i == 1) {
            this.zzcpO[this.zzcpP - 1] = 2;
        } else if (i == 2) {
            switch (zzbh(true)) {
                case C0394R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    break;
                case C0394R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                    zzaci();
                    break;
                case C0394R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                    this.zzcpK = 4;
                    return 4;
                default:
                    throw zzjZ("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.zzcpO[this.zzcpP - 1] = 4;
            if (i == 5) {
                switch (zzbh(true)) {
                    case C0394R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                        break;
                    case C0394R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                        zzaci();
                        break;
                    case 125:
                        this.zzcpK = 2;
                        return 2;
                    default:
                        throw zzjZ("Unterminated object");
                }
            }
            zzbh = zzbh(true);
            switch (zzbh) {
                case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.zzcpK = 13;
                    return 13;
                case C0394R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    zzaci();
                    this.zzcpK = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.zzcpK = 2;
                        return 2;
                    }
                    throw zzjZ("Expected name");
                default:
                    zzaci();
                    this.pos--;
                    if (zzc((char) zzbh)) {
                        this.zzcpK = 14;
                        return 14;
                    }
                    throw zzjZ("Expected name");
            }
        } else if (i == 4) {
            this.zzcpO[this.zzcpP - 1] = 5;
            switch (zzbh(true)) {
                case C0394R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    break;
                case C0394R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    zzaci();
                    if ((this.pos < this.limit || zzqe(1)) && this.zzcpH[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                default:
                    throw zzjZ("Expected ':'");
            }
        } else if (i == 6) {
            if (this.zzcpG) {
                zzacl();
            }
            this.zzcpO[this.zzcpP - 1] = 7;
        } else if (i == 7) {
            if (zzbh(false) == -1) {
                this.zzcpK = 17;
                return 17;
            }
            zzaci();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (zzbh(true)) {
            case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                if (this.zzcpP == 1) {
                    zzaci();
                }
                this.zzcpK = 9;
                return 9;
            case C0394R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                zzaci();
                this.zzcpK = 8;
                return 8;
            case C0394R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
            case C0394R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                break;
            case C0394R.styleable.AppCompatTheme_controlBackground /*91*/:
                this.zzcpK = 3;
                return 3;
            case C0394R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                if (i == 1) {
                    this.zzcpK = 4;
                    return 4;
                }
                break;
            case 123:
                this.zzcpK = 1;
                return 1;
            default:
                this.pos--;
                if (this.zzcpP == 1) {
                    zzaci();
                }
                zzbh = zzace();
                if (zzbh != 0) {
                    return zzbh;
                }
                zzbh = zzacf();
                if (zzbh != 0) {
                    return zzbh;
                }
                if (zzc(this.zzcpH[this.pos])) {
                    zzaci();
                    this.zzcpK = 10;
                    return 10;
                }
                throw zzjZ("Expected value");
        }
        if (i == 1 || i == 2) {
            zzaci();
            this.pos--;
            this.zzcpK = 7;
            return 7;
        }
        throw zzjZ("Unexpected value");
    }

    private int zzace() throws IOException {
        String str;
        int i;
        char c = this.zzcpH[this.pos];
        String str2;
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            if (this.pos + i2 >= this.limit && !zzqe(i2 + 1)) {
                return 0;
            }
            char c2 = this.zzcpH[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != r1.charAt(i2)) {
                return 0;
            }
            i2++;
        }
        if ((this.pos + length < this.limit || zzqe(length + 1)) && zzc(this.zzcpH[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.zzcpK = i;
        return i;
    }

    private int zzacf() throws IOException {
        char[] cArr = this.zzcpH;
        int i = this.pos;
        long j = 0;
        Object obj = null;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.limit;
        int i6 = i;
        while (true) {
            Object obj2;
            if (i6 + i4 == i5) {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (zzqe(i4 + 1)) {
                    i6 = this.pos;
                    i5 = this.limit;
                } else if (i3 != 2 && i2 != 0 && (j != Long.MIN_VALUE || obj != null)) {
                    if (obj == null) {
                        j = -j;
                    }
                    this.zzcpL = j;
                    this.pos += i4;
                    this.zzcpK = 15;
                    return 15;
                } else if (i3 == 2 && i3 != 4 && i3 != 7) {
                    return 0;
                } else {
                    this.zzcpM = i4;
                    this.zzcpK = 16;
                    return 16;
                }
            }
            char c = cArr[i6 + i4];
            int i7;
            switch (c) {
                case C0394R.styleable.AppCompatTheme_dialogTheme /*43*/:
                    if (i3 != 5) {
                        return 0;
                    }
                    i = 6;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case C0394R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                    if (i3 == 0) {
                        i = 1;
                        i7 = i2;
                        obj2 = 1;
                        i3 = i7;
                        continue;
                    } else if (i3 == 5) {
                        i = 6;
                        i3 = i2;
                        obj2 = obj;
                        break;
                    } else {
                        return 0;
                    }
                case C0394R.styleable.AppCompatTheme_actionDropDownStyle /*46*/:
                    if (i3 != 2) {
                        return 0;
                    }
                    i = 3;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case C0394R.styleable.AppCompatTheme_searchViewStyle /*69*/:
                case Quests.SELECT_COMPLETED_UNCLAIMED /*101*/:
                    if (i3 != 2 && i3 != 4) {
                        return 0;
                    }
                    i = 5;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i3 != 1 && i3 != 0) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5 && i3 != 6) {
                                        i = i3;
                                        i3 = i2;
                                        obj2 = obj;
                                        break;
                                    }
                                    i = 7;
                                    i3 = i2;
                                    obj2 = obj;
                                    break;
                                }
                                i = 4;
                                i3 = i2;
                                obj2 = obj;
                                break;
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - 48));
                                i = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) ? 1 : 0;
                                i &= i2;
                                obj2 = obj;
                                j = j2;
                                i7 = i3;
                                i3 = i;
                                i = i7;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = 2;
                        i3 = i2;
                        obj2 = obj;
                        continue;
                    } else if (zzc(c)) {
                        return 0;
                    }
                    break;
            }
            if (i3 != 2) {
            }
            if (i3 == 2) {
            }
            this.zzcpM = i4;
            this.zzcpK = 16;
            return 16;
            i4++;
            obj = obj2;
            i2 = i3;
            i3 = i;
        }
    }

    private String zzacg() throws IOException {
        StringBuilder stringBuilder = null;
        int i = 0;
        while (true) {
            String str;
            if (this.pos + i < this.limit) {
                switch (this.zzcpH[this.pos + i]) {
                    case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    case ConnectionResult.CANCELED /*13*/:
                    case Message.MAX_TYPE_LENGTH /*32*/:
                    case C0394R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    case C0394R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    case C0394R.styleable.AppCompatTheme_controlBackground /*91*/:
                    case C0394R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                    case '{':
                    case '}':
                        break;
                    case C0394R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case C0394R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                    case C0394R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                    case C0394R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    case C0394R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                        zzaci();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.zzcpH.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.zzcpH, this.pos, i);
                this.pos = i + this.pos;
                i = !zzqe(1) ? 0 : 0;
            } else if (zzqe(i + 1)) {
            }
            if (stringBuilder == null) {
                str = new String(this.zzcpH, this.pos, i);
            } else {
                stringBuilder.append(this.zzcpH, this.pos, i);
                str = stringBuilder.toString();
            }
            this.pos = i + this.pos;
            return str;
        }
    }

    private void zzach() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.zzcpH[this.pos + i]) {
                    case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    case ConnectionResult.CANCELED /*13*/:
                    case Message.MAX_TYPE_LENGTH /*32*/:
                    case C0394R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                    case C0394R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    case C0394R.styleable.AppCompatTheme_controlBackground /*91*/:
                    case C0394R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
                    case '{':
                    case '}':
                        break;
                    case C0394R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case C0394R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                    case C0394R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                    case C0394R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                    case C0394R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                        zzaci();
                        break;
                    default:
                        i++;
                }
                this.pos = i + this.pos;
                return;
            }
            this.pos = i + this.pos;
        } while (zzqe(1));
    }

    private void zzaci() throws IOException {
        if (!this.zzcpG) {
            throw zzjZ("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void zzacj() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || zzqe(1)) {
                char[] cArr = this.zzcpH;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.zzcpI++;
                    this.zzcpJ = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private char zzack() throws IOException {
        if (this.pos != this.limit || zzqe(1)) {
            char[] cArr = this.zzcpH;
            int i = this.pos;
            this.pos = i + 1;
            char c = cArr[i];
            switch (c) {
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    this.zzcpI++;
                    this.zzcpJ = this.pos;
                    return c;
                case C0394R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                    return '\b';
                case Quests.SELECT_ENDING_SOON /*102*/:
                    return '\f';
                case C0394R.styleable.AppCompatTheme_ratingBarStyleSmall /*110*/:
                    return '\n';
                case C0394R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.pos + 4 <= this.limit || zzqe(4)) {
                        int i2 = this.pos;
                        int i3 = i2 + 4;
                        int i4 = i2;
                        c = '\u0000';
                        for (i = i4; i < i3; i++) {
                            char c2 = this.zzcpH[i];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                c = (char) (c + ((c2 - 97) + 10));
                            } else if (c2 < 'A' || c2 > 'F') {
                                String str = "\\u";
                                String valueOf = String.valueOf(new String(this.zzcpH, this.pos, 4));
                                throw new NumberFormatException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                            } else {
                                c = (char) (c + ((c2 - 65) + 10));
                            }
                        }
                        this.pos += 4;
                        return c;
                    }
                    throw zzjZ("Unterminated escape sequence");
                default:
                    return c;
            }
        }
        throw zzjZ("Unterminated escape sequence");
    }

    private void zzacl() throws IOException {
        zzbh(true);
        this.pos--;
        if (this.pos + zzcpF.length <= this.limit || zzqe(zzcpF.length)) {
            int i = 0;
            while (i < zzcpF.length) {
                if (this.zzcpH[this.pos + i] == zzcpF[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.pos += zzcpF.length;
        }
    }

    private int zzbh(boolean z) throws IOException {
        char[] cArr = this.zzcpH;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            int lineNumber;
            if (i == i2) {
                this.pos = i;
                if (zzqe(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z) {
                    return -1;
                } else {
                    String valueOf = String.valueOf("End of input at line ");
                    lineNumber = getLineNumber();
                    throw new EOFException(new StringBuilder(String.valueOf(valueOf).length() + 30).append(valueOf).append(lineNumber).append(" column ").append(getColumnNumber()).toString());
                }
            }
            lineNumber = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.zzcpI++;
                this.zzcpJ = lineNumber;
                i = lineNumber;
            } else if (c == ' ' || c == '\r') {
                i = lineNumber;
            } else if (c == '\t') {
                i = lineNumber;
            } else if (c == '/') {
                this.pos = lineNumber;
                if (lineNumber == i2) {
                    this.pos--;
                    boolean zzqe = zzqe(2);
                    this.pos++;
                    if (!zzqe) {
                        return c;
                    }
                }
                zzaci();
                switch (cArr[this.pos]) {
                    case C0394R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                        this.pos++;
                        if (zzjY("*/")) {
                            i = this.pos + 2;
                            i2 = this.limit;
                            break;
                        }
                        throw zzjZ("Unterminated comment");
                    case C0394R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                        this.pos++;
                        zzacj();
                        i = this.pos;
                        i2 = this.limit;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = lineNumber;
                zzaci();
                zzacj();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = lineNumber;
                return c;
            }
        }
    }

    private boolean zzc(char c) throws IOException {
        switch (c) {
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
            case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
            case ConnectionResult.CANCELED /*13*/:
            case Message.MAX_TYPE_LENGTH /*32*/:
            case C0394R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
            case C0394R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
            case C0394R.styleable.AppCompatTheme_controlBackground /*91*/:
            case C0394R.styleable.AppCompatTheme_alertDialogStyle /*93*/:
            case '{':
            case '}':
                break;
            case C0394R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
            case C0394R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
            case C0394R.styleable.AppCompatTheme_toolbarStyle /*59*/:
            case C0394R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
            case C0394R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                zzaci();
                break;
            default:
                return true;
        }
        return false;
    }

    private String zzd(char c) throws IOException {
        char[] cArr = this.zzcpH;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(zzack());
                    i = this.pos;
                    i2 = this.limit;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.zzcpI++;
                    this.zzcpJ = i4;
                }
                i3 = i4;
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (zzqe(1));
        throw zzjZ("Unterminated string");
    }

    private void zze(char c) throws IOException {
        char[] cArr = this.zzcpH;
        do {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (i3 < i2) {
                i = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i;
                    return;
                }
                if (c2 == '\\') {
                    this.pos = i;
                    zzack();
                    i = this.pos;
                    i2 = this.limit;
                } else if (c2 == '\n') {
                    this.zzcpI++;
                    this.zzcpJ = i;
                }
                i3 = i;
            }
            this.pos = i3;
        } while (zzqe(1));
        throw zzjZ("Unterminated string");
    }

    private boolean zzjY(String str) throws IOException {
        while (true) {
            if (this.pos + str.length() > this.limit && !zzqe(str.length())) {
                return false;
            }
            if (this.zzcpH[this.pos] == '\n') {
                this.zzcpI++;
                this.zzcpJ = this.pos + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.zzcpH[this.pos + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private IOException zzjZ(String str) throws IOException {
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new zzbtl(new StringBuilder((String.valueOf(str).length() + 45) + String.valueOf(path).length()).append(str).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    private void zzqd(int i) {
        if (this.zzcpP == this.zzcpO.length) {
            Object obj = new int[(this.zzcpP * 2)];
            Object obj2 = new int[(this.zzcpP * 2)];
            Object obj3 = new String[(this.zzcpP * 2)];
            System.arraycopy(this.zzcpO, 0, obj, 0, this.zzcpP);
            System.arraycopy(this.zzcpR, 0, obj2, 0, this.zzcpP);
            System.arraycopy(this.zzcpQ, 0, obj3, 0, this.zzcpP);
            this.zzcpO = obj;
            this.zzcpR = obj2;
            this.zzcpQ = obj3;
        }
        int[] iArr = this.zzcpO;
        int i2 = this.zzcpP;
        this.zzcpP = i2 + 1;
        iArr[i2] = i;
    }

    private boolean zzqe(int i) throws IOException {
        Object obj = this.zzcpH;
        this.zzcpJ -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(obj, this.pos, obj, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.in.read(obj, this.limit, obj.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.zzcpI == 0 && this.zzcpJ == 0 && this.limit > 0 && obj[0] == '\ufeff') {
                this.pos++;
                this.zzcpJ++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    public void beginArray() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        if (i == 3) {
            zzqd(1);
            this.zzcpR[this.zzcpP - 1] = 0;
            this.zzcpK = 0;
            return;
        }
        String valueOf = String.valueOf(zzabQ());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 74) + String.valueOf(path).length()).append("Expected BEGIN_ARRAY but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void beginObject() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        if (i == 1) {
            zzqd(3);
            this.zzcpK = 0;
            return;
        }
        String valueOf = String.valueOf(zzabQ());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 75) + String.valueOf(path).length()).append("Expected BEGIN_OBJECT but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void close() throws IOException {
        this.zzcpK = 0;
        this.zzcpO[0] = 8;
        this.zzcpP = 1;
        this.in.close();
    }

    public void endArray() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        if (i == 4) {
            this.zzcpP--;
            int[] iArr = this.zzcpR;
            int i2 = this.zzcpP - 1;
            iArr[i2] = iArr[i2] + 1;
            this.zzcpK = 0;
            return;
        }
        String valueOf = String.valueOf(zzabQ());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 72) + String.valueOf(path).length()).append("Expected END_ARRAY but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void endObject() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        if (i == 2) {
            this.zzcpP--;
            this.zzcpQ[this.zzcpP] = null;
            int[] iArr = this.zzcpR;
            int i2 = this.zzcpP - 1;
            iArr[i2] = iArr[i2] + 1;
            this.zzcpK = 0;
            return;
        }
        String valueOf = String.valueOf(zzabQ());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 73) + String.valueOf(path).length()).append("Expected END_OBJECT but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.zzcpP;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.zzcpO[i2]) {
                case MessageApi.FILTER_PREFIX /*1*/:
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    append.append('[').append(this.zzcpR[i2]).append(']');
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                case Dimension.UNIT_IN /*4*/:
                case Dimension.UNIT_MM /*5*/:
                    append.append('.');
                    if (this.zzcpQ[i2] == null) {
                        break;
                    }
                    append.append(this.zzcpQ[i2]);
                    break;
                default:
                    break;
            }
        }
        return append.toString();
    }

    public boolean hasNext() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.zzcpG;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        if (i == 5) {
            this.zzcpK = 0;
            int[] iArr = this.zzcpR;
            i = this.zzcpP - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        } else if (i == 6) {
            this.zzcpK = 0;
            int[] iArr2 = this.zzcpR;
            r2 = this.zzcpP - 1;
            iArr2[r2] = iArr2[r2] + 1;
            return false;
        } else {
            String valueOf = String.valueOf(zzabQ());
            r2 = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 72) + String.valueOf(path).length()).append("Expected a boolean but was ").append(valueOf).append(" at line ").append(r2).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
    }

    public double nextDouble() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        if (i == 15) {
            this.zzcpK = 0;
            int[] iArr = this.zzcpR;
            int i2 = this.zzcpP - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.zzcpL;
        }
        if (i == 16) {
            this.zzcpN = new String(this.zzcpH, this.pos, this.zzcpM);
            this.pos += this.zzcpM;
        } else if (i == 8 || i == 9) {
            this.zzcpN = zzd(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.zzcpN = zzacg();
        } else if (i != 11) {
            String valueOf = String.valueOf(zzabQ());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 71) + String.valueOf(path).length()).append("Expected a double but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.zzcpK = 11;
        double parseDouble = Double.parseDouble(this.zzcpN);
        if (this.zzcpG || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.zzcpN = null;
            this.zzcpK = 0;
            int[] iArr2 = this.zzcpR;
            columnNumber = this.zzcpP - 1;
            iArr2[columnNumber] = iArr2[columnNumber] + 1;
            return parseDouble;
        }
        columnNumber = getLineNumber();
        int columnNumber2 = getColumnNumber();
        String path2 = getPath();
        throw new zzbtl(new StringBuilder(String.valueOf(path2).length() + Quests.SELECT_ENDING_SOON).append("JSON forbids NaN and infinities: ").append(parseDouble).append(" at line ").append(columnNumber).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
    }

    public int nextInt() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        int[] iArr;
        int i2;
        if (i == 15) {
            i = (int) this.zzcpL;
            if (this.zzcpL != ((long) i)) {
                long j = this.zzcpL;
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                throw new NumberFormatException(new StringBuilder(String.valueOf(path).length() + 89).append("Expected an int but was ").append(j).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
            }
            this.zzcpK = 0;
            iArr = this.zzcpR;
            i2 = this.zzcpP - 1;
            iArr[i2] = iArr[i2] + 1;
        } else {
            String valueOf;
            int columnNumber2;
            String path2;
            if (i == 16) {
                this.zzcpN = new String(this.zzcpH, this.pos, this.zzcpM);
                this.pos += this.zzcpM;
            } else if (i == 8 || i == 9) {
                this.zzcpN = zzd(i == 8 ? '\'' : '\"');
                try {
                    i = Integer.parseInt(this.zzcpN);
                    this.zzcpK = 0;
                    iArr = this.zzcpR;
                    i2 = this.zzcpP - 1;
                    iArr[i2] = iArr[i2] + 1;
                } catch (NumberFormatException e) {
                }
            } else {
                valueOf = String.valueOf(zzabQ());
                i2 = getLineNumber();
                columnNumber2 = getColumnNumber();
                path2 = getPath();
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(i2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
            }
            this.zzcpK = 11;
            double parseDouble = Double.parseDouble(this.zzcpN);
            i = (int) parseDouble;
            if (((double) i) != parseDouble) {
                valueOf = this.zzcpN;
                i2 = getLineNumber();
                columnNumber2 = getColumnNumber();
                path2 = getPath();
                throw new NumberFormatException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(i2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
            }
            this.zzcpN = null;
            this.zzcpK = 0;
            iArr = this.zzcpR;
            i2 = this.zzcpP - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return i;
    }

    public long nextLong() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        if (i == 15) {
            this.zzcpK = 0;
            int[] iArr = this.zzcpR;
            int i2 = this.zzcpP - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.zzcpL;
        }
        long parseLong;
        int i3;
        if (i == 16) {
            this.zzcpN = new String(this.zzcpH, this.pos, this.zzcpM);
            this.pos += this.zzcpM;
        } else if (i == 8 || i == 9) {
            this.zzcpN = zzd(i == 8 ? '\'' : '\"');
            try {
                parseLong = Long.parseLong(this.zzcpN);
                this.zzcpK = 0;
                int[] iArr2 = this.zzcpR;
                i3 = this.zzcpP - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(zzabQ());
            int lineNumber = getLineNumber();
            i3 = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(i3).append(" path ").append(path).toString());
        }
        this.zzcpK = 11;
        double parseDouble = Double.parseDouble(this.zzcpN);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            valueOf = this.zzcpN;
            lineNumber = getLineNumber();
            i3 = getColumnNumber();
            path = getPath();
            throw new NumberFormatException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(i3).append(" path ").append(path).toString());
        }
        this.zzcpN = null;
        this.zzcpK = 0;
        iArr2 = this.zzcpR;
        i3 = this.zzcpP - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseLong;
    }

    public String nextName() throws IOException {
        String zzacg;
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        if (i == 14) {
            zzacg = zzacg();
        } else if (i == 12) {
            zzacg = zzd('\'');
        } else if (i == 13) {
            zzacg = zzd('\"');
        } else {
            String valueOf = String.valueOf(zzabQ());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.zzcpK = 0;
        this.zzcpQ[this.zzcpP - 1] = zzacg;
        return zzacg;
    }

    public void nextNull() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        if (i == 7) {
            this.zzcpK = 0;
            int[] iArr = this.zzcpR;
            int i2 = this.zzcpP - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String valueOf = String.valueOf(zzabQ());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 67) + String.valueOf(path).length()).append("Expected null but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String nextString() throws IOException {
        String zzacg;
        int lineNumber;
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        if (i == 10) {
            zzacg = zzacg();
        } else if (i == 8) {
            zzacg = zzd('\'');
        } else if (i == 9) {
            zzacg = zzd('\"');
        } else if (i == 11) {
            zzacg = this.zzcpN;
            this.zzcpN = null;
        } else if (i == 15) {
            zzacg = Long.toString(this.zzcpL);
        } else if (i == 16) {
            zzacg = new String(this.zzcpH, this.pos, this.zzcpM);
            this.pos += this.zzcpM;
        } else {
            String valueOf = String.valueOf(zzabQ());
            lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 71) + String.valueOf(path).length()).append("Expected a string but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.zzcpK = 0;
        int[] iArr = this.zzcpR;
        lineNumber = this.zzcpP - 1;
        iArr[lineNumber] = iArr[lineNumber] + 1;
        return zzacg;
    }

    public final void setLenient(boolean z) {
        this.zzcpG = z;
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.zzcpK;
            if (i2 == 0) {
                i2 = zzacd();
            }
            if (i2 == 3) {
                zzqd(1);
                i++;
            } else if (i2 == 1) {
                zzqd(3);
                i++;
            } else if (i2 == 4) {
                this.zzcpP--;
                i--;
            } else if (i2 == 2) {
                this.zzcpP--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                zzach();
            } else if (i2 == 8 || i2 == 12) {
                zze('\'');
            } else if (i2 == 9 || i2 == 13) {
                zze('\"');
            } else if (i2 == 16) {
                this.pos += this.zzcpM;
            }
            this.zzcpK = 0;
        } while (i != 0);
        int[] iArr = this.zzcpR;
        int i3 = this.zzcpP - 1;
        iArr[i3] = iArr[i3] + 1;
        this.zzcpQ[this.zzcpP - 1] = "null";
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        int lineNumber = getLineNumber();
        return new StringBuilder(String.valueOf(valueOf).length() + 39).append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(getColumnNumber()).toString();
    }

    public zzbtj zzabQ() throws IOException {
        int i = this.zzcpK;
        if (i == 0) {
            i = zzacd();
        }
        switch (i) {
            case MessageApi.FILTER_PREFIX /*1*/:
                return zzbtj.BEGIN_OBJECT;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return zzbtj.END_OBJECT;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return zzbtj.BEGIN_ARRAY;
            case Dimension.UNIT_IN /*4*/:
                return zzbtj.END_ARRAY;
            case Dimension.UNIT_MM /*5*/:
            case BuyButtonText.LOGO_ONLY /*6*/:
                return zzbtj.BOOLEAN;
            case BuyButtonText.DONATE_WITH /*7*/:
                return zzbtj.NULL;
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return zzbtj.STRING;
            case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
            case ConnectionResult.CANCELED /*13*/:
            case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                return zzbtj.NAME;
            case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
            case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                return zzbtj.NUMBER;
            case ConnectionResult.SIGN_IN_FAILED /*17*/:
                return zzbtj.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }
}
