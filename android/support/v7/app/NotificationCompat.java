package android.support.v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.media.session.MediaSessionCompat.Token;

public class NotificationCompat extends android.support.v4.app.NotificationCompat {

    public static class Builder extends android.support.v4.app.NotificationCompat.Builder {
        public Builder(Context context) {
            super(context);
        }

        protected BuilderExtender getExtender() {
            if (VERSION.SDK_INT >= 21) {
                return new LollipopExtender();
            }
            if (VERSION.SDK_INT >= 16) {
                return new JellybeanExtender();
            }
            if (VERSION.SDK_INT >= 14) {
                return new IceCreamSandwichExtender();
            }
            return super.getExtender();
        }
    }

    private static class IceCreamSandwichExtender extends BuilderExtender {
        IceCreamSandwichExtender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder b, NotificationBuilderWithBuilderAccessor builder) {
            NotificationCompat.addMediaStyleToBuilderIcs(builder, b);
            return builder.build();
        }
    }

    private static class JellybeanExtender extends BuilderExtender {
        JellybeanExtender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder b, NotificationBuilderWithBuilderAccessor builder) {
            NotificationCompat.addMediaStyleToBuilderIcs(builder, b);
            Notification n = builder.build();
            NotificationCompat.addBigMediaStyleToBuilderJellybean(n, b);
            return n;
        }
    }

    private static class LollipopExtender extends BuilderExtender {
        LollipopExtender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder b, NotificationBuilderWithBuilderAccessor builder) {
            NotificationCompat.addMediaStyleToBuilderLollipop(builder, b.mStyle);
            return builder.build();
        }
    }

    public static class MediaStyle extends Style {
        int[] mActionsToShowInCompact;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        Token mToken;

        public MediaStyle() {
            this.mActionsToShowInCompact = null;
        }

        public MediaStyle(android.support.v4.app.NotificationCompat.Builder builder) {
            this.mActionsToShowInCompact = null;
            setBuilder(builder);
        }

        public MediaStyle setShowActionsInCompactView(int... actions) {
            this.mActionsToShowInCompact = actions;
            return this;
        }

        public MediaStyle setMediaSession(Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean show) {
            this.mShowCancelButton = show;
            return this;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }
    }

    public static Token getMediaSession(Notification notification) {
        Bundle extras = android.support.v4.app.NotificationCompat.getExtras(notification);
        if (extras != null) {
            if (VERSION.SDK_INT >= 21) {
                Parcelable tokenInner = extras.getParcelable(android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                if (tokenInner != null) {
                    return Token.fromToken(tokenInner);
                }
            }
            IBinder tokenInner2 = BundleCompat.getBinder(extras, android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (tokenInner2 != null) {
                Parcel p = Parcel.obtain();
                p.writeStrongBinder(tokenInner2);
                p.setDataPosition(0);
                Token token = (Token) Token.CREATOR.createFromParcel(p);
                p.recycle();
                return token;
            }
        }
        return null;
    }

    static void addMediaStyleToBuilderLollipop(NotificationBuilderWithBuilderAccessor builder, Style style) {
        if (style instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) style;
            NotificationCompatImpl21.addMediaStyle(builder, mediaStyle.mActionsToShowInCompact, mediaStyle.mToken != null ? mediaStyle.mToken.getToken() : null);
        }
    }

    static void addMediaStyleToBuilderIcs(NotificationBuilderWithBuilderAccessor builder, android.support.v4.app.NotificationCompat.Builder b) {
        if (b.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = b.mStyle;
            NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor = builder;
            NotificationCompatImplBase.overrideContentView(notificationBuilderWithBuilderAccessor, b.mContext, b.mContentTitle, b.mContentText, b.mContentInfo, b.mNumber, b.mLargeIcon, b.mSubText, b.mUseChronometer, b.mNotification.when, b.mActions, mediaStyle.mActionsToShowInCompact, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent);
        }
    }

    static void addBigMediaStyleToBuilderJellybean(Notification n, android.support.v4.app.NotificationCompat.Builder b) {
        if (b.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) b.mStyle;
            Notification notification = n;
            NotificationCompatImplBase.overrideBigContentView(notification, b.mContext, b.mContentTitle, b.mContentText, b.mContentInfo, b.mNumber, b.mLargeIcon, b.mSubText, b.mUseChronometer, b.mNotification.when, b.mActions, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent);
            Bundle extras = android.support.v4.app.NotificationCompat.getExtras(n);
            if (mediaStyle.mToken != null) {
                BundleCompat.putBinder(extras, android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION, (IBinder) mediaStyle.mToken.getToken());
            }
            if (mediaStyle.mActionsToShowInCompact != null) {
                extras.putIntArray(android.support.v4.app.NotificationCompat.EXTRA_COMPACT_ACTIONS, mediaStyle.mActionsToShowInCompact);
            }
        }
    }
}
