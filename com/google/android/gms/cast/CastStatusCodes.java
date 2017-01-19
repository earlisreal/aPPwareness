package com.google.android.gms.cast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.iid.InstanceID;

public final class CastStatusCodes {
    public static final int APPLICATION_NOT_FOUND = 2004;
    public static final int APPLICATION_NOT_RUNNING = 2005;
    public static final int AUTHENTICATION_FAILED = 2000;
    public static final int CANCELED = 2002;
    public static final int ERROR_SERVICE_CREATION_FAILED = 2200;
    public static final int ERROR_SERVICE_DISCONNECTED = 2201;
    public static final int FAILED = 2100;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 14;
    public static final int INVALID_REQUEST = 2001;
    public static final int MESSAGE_SEND_BUFFER_TOO_FULL = 2007;
    public static final int MESSAGE_TOO_LARGE = 2006;
    public static final int NETWORK_ERROR = 7;
    public static final int NOT_ALLOWED = 2003;
    public static final int REPLACED = 2103;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 15;
    public static final int UNKNOWN_ERROR = 13;

    private CastStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        switch (i) {
            case SUCCESS /*0*/:
                return "SUCCESS";
            case NETWORK_ERROR /*7*/:
                return "NETWORK_ERROR";
            case INTERNAL_ERROR /*8*/:
                return "INTERNAL_ERROR";
            case UNKNOWN_ERROR /*13*/:
                return "UNKNOWN_ERROR";
            case INTERRUPTED /*14*/:
                return "INTERRUPTED";
            case TIMEOUT /*15*/:
                return InstanceID.ERROR_TIMEOUT;
            case AUTHENTICATION_FAILED /*2000*/:
                return "AUTHENTICATION_FAILED";
            case INVALID_REQUEST /*2001*/:
                return "INVALID_REQUEST";
            case CANCELED /*2002*/:
                return "CANCELED";
            case NOT_ALLOWED /*2003*/:
                return "NOT_ALLOWED";
            case APPLICATION_NOT_FOUND /*2004*/:
                return "APPLICATION_NOT_FOUND";
            case APPLICATION_NOT_RUNNING /*2005*/:
                return "APPLICATION_NOT_RUNNING";
            case MESSAGE_TOO_LARGE /*2006*/:
                return "MESSAGE_TOO_LARGE";
            case MESSAGE_SEND_BUFFER_TOO_FULL /*2007*/:
                return "MESSAGE_SEND_BUFFER_TOO_FULL";
            case FAILED /*2100*/:
                return "FAILED";
            case RemoteMediaPlayer.STATUS_CANCELED /*2101*/:
                return "STATUS_CANCELLED";
            case RemoteMediaPlayer.STATUS_TIMED_OUT /*2102*/:
                return "STATUS_TIMED_OUT";
            case REPLACED /*2103*/:
                return "REPLACED";
            case ERROR_SERVICE_CREATION_FAILED /*2200*/:
                return "ERROR_SERVICE_CREATION_FAILED";
            case ERROR_SERVICE_DISCONNECTED /*2201*/:
                return "ERROR_SERVICE_DISCONNECTED";
            default:
                return CommonStatusCodes.getStatusCodeString(i);
        }
    }
}
