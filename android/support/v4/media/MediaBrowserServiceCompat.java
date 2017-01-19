package android.support.v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.BuildCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG;
    public static final String KEY_MEDIA_ITEM = "media_item";
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap<IBinder, ConnectionRecord> mConnections;
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler;
    private MediaBrowserServiceImpl mImpl;
    Token mSession;

    public static class Result<T> {
        private Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendResultCalled;

        Result(Object debug) {
            this.mDebug = debug;
        }

        public void sendResult(T result) {
            if (this.mSendResultCalled) {
                throw new IllegalStateException("sendResult() called twice for: " + this.mDebug);
            }
            this.mSendResultCalled = true;
            onResultSent(result, this.mFlags);
        }

        public void detach() {
            if (this.mDetachCalled) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            } else if (this.mSendResultCalled) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            } else {
                this.mDetachCalled = true;
            }
        }

        boolean isDone() {
            return (this.mDetachCalled || this.mSendResultCalled) ? true : MediaBrowserServiceCompat.DEBUG;
        }

        void setFlags(int flags) {
            this.mFlags = flags;
        }

        void onResultSent(T t, int flags) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.1 */
    class C00941 extends Result<List<MediaItem>> {
        final /* synthetic */ ConnectionRecord val$connection;
        final /* synthetic */ Bundle val$options;
        final /* synthetic */ String val$parentId;

        C00941(Object debug, ConnectionRecord connectionRecord, String str, Bundle bundle) {
            this.val$connection = connectionRecord;
            this.val$parentId = str;
            this.val$options = bundle;
            super(debug);
        }

        void onResultSent(List<MediaItem> list, int flags) {
            if (MediaBrowserServiceCompat.this.mConnections.get(this.val$connection.callbacks.asBinder()) == this.val$connection) {
                List<MediaItem> filteredList;
                if ((flags & MediaBrowserServiceCompat.RESULT_FLAG_OPTION_NOT_HANDLED) != 0) {
                    filteredList = MediaBrowserServiceCompat.this.applyOptions(list, this.val$options);
                } else {
                    filteredList = list;
                }
                try {
                    this.val$connection.callbacks.onLoadChildren(this.val$parentId, filteredList, this.val$options);
                } catch (RemoteException e) {
                    Log.w(MediaBrowserServiceCompat.TAG, "Calling onLoadChildren() failed for id=" + this.val$parentId + " package=" + this.val$connection.pkg);
                }
            } else if (MediaBrowserServiceCompat.DEBUG) {
                Log.d(MediaBrowserServiceCompat.TAG, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.val$connection.pkg + " id=" + this.val$parentId);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.2 */
    class C00952 extends Result<MediaItem> {
        final /* synthetic */ ResultReceiver val$receiver;

        C00952(Object debug, ResultReceiver resultReceiver) {
            this.val$receiver = resultReceiver;
            super(debug);
        }

        void onResultSent(MediaItem item, int flags) {
            if ((flags & MediaBrowserServiceCompat.RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED) != 0) {
                this.val$receiver.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, item);
            this.val$receiver.send(0, bundle);
        }
    }

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String rootId, @Nullable Bundle extras) {
            if (rootId == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.mRootId = rootId;
            this.mExtras = extras;
        }

        public String getRootId() {
            return this.mRootId;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }
    }

    private class ConnectionRecord {
        ServiceCallbacks callbacks;
        String pkg;
        BrowserRoot root;
        Bundle rootHints;
        HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions;

        ConnectionRecord() {
            this.subscriptions = new HashMap();
        }
    }

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(Token token);
    }

    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, ServiceCompatProxy {
        Messenger mMessenger;
        Object mServiceObj;

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1 */
        class C00961 implements Runnable {
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;

            C00961(String str, Bundle bundle) {
                this.val$parentId = str;
                this.val$options = bundle;
            }

            public void run() {
                for (IBinder binder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                    ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(binder);
                    List<Pair<IBinder, Bundle>> callbackList = (List) connection.subscriptions.get(this.val$parentId);
                    if (callbackList != null) {
                        for (Pair<IBinder, Bundle> callback : callbackList) {
                            if (MediaBrowserCompatUtils.hasDuplicatedItems(this.val$options, (Bundle) callback.second)) {
                                MediaBrowserServiceCompat.this.performLoadChildren(this.val$parentId, connection, (Bundle) callback.second);
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2 */
        class C00972 extends Result<List<MediaItem>> {
            final /* synthetic */ ResultWrapper val$resultWrapper;

            C00972(Object debug, ResultWrapper resultWrapper) {
                this.val$resultWrapper = resultWrapper;
                super(debug);
            }

            void onResultSent(List<MediaItem> list, int flags) {
                List<Parcel> parcelList = null;
                if (list != null) {
                    parcelList = new ArrayList();
                    for (MediaItem item : list) {
                        Parcel parcel = Parcel.obtain();
                        item.writeToParcel(parcel, 0);
                        parcelList.add(parcel);
                    }
                }
                this.val$resultWrapper.sendResult(parcelList);
            }

            public void detach() {
                this.val$resultWrapper.detach();
            }
        }

        MediaBrowserServiceImplApi21() {
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
        }

        public void setSessionToken(Token token) {
            MediaBrowserServiceCompatApi21.setSessionToken(this.mServiceObj, token.getToken());
        }

        public void notifyChildrenChanged(String parentId, Bundle options) {
            if (this.mMessenger == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, parentId);
            } else {
                MediaBrowserServiceCompat.this.mHandler.post(new C00961(parentId, options));
            }
        }

        public Bundle getBrowserRootHints() {
            if (this.mMessenger == null) {
                return null;
            }
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren or onLoadItem methods");
            } else if (MediaBrowserServiceCompat.this.mCurConnection.rootHints != null) {
                return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            } else {
                return null;
            }
        }

        public BrowserRoot onGetRoot(String clientPackageName, int clientUid, Bundle rootHints) {
            Bundle rootExtras = null;
            if (!(rootHints == null || rootHints.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0)) {
                rootHints.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                rootExtras = new Bundle();
                rootExtras.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, MediaBrowserServiceCompat.RESULT_FLAG_OPTION_NOT_HANDLED);
                BundleCompat.putBinder(rootExtras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
            }
            BrowserRoot root = MediaBrowserServiceCompat.this.onGetRoot(clientPackageName, clientUid, rootHints);
            if (root == null) {
                return null;
            }
            if (rootExtras == null) {
                rootExtras = root.getExtras();
            } else if (root.getExtras() != null) {
                rootExtras.putAll(root.getExtras());
            }
            return new BrowserRoot(root.getRootId(), rootExtras);
        }

        public void onLoadChildren(String parentId, ResultWrapper<List<Parcel>> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadChildren(parentId, new C00972(parentId, resultWrapper));
        }
    }

    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1 */
        class C00981 extends Result<MediaItem> {
            final /* synthetic */ ResultWrapper val$resultWrapper;

            C00981(Object debug, ResultWrapper resultWrapper) {
                this.val$resultWrapper = resultWrapper;
                super(debug);
            }

            void onResultSent(MediaItem item, int flags) {
                if (item == null) {
                    this.val$resultWrapper.sendResult(null);
                    return;
                }
                Parcel parcelItem = Parcel.obtain();
                item.writeToParcel(parcelItem, 0);
                this.val$resultWrapper.sendResult(parcelItem);
            }

            public void detach() {
                this.val$resultWrapper.detach();
            }
        }

        MediaBrowserServiceImplApi23() {
            super();
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public void onLoadItem(String itemId, ResultWrapper<Parcel> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadItem(itemId, new C00981(itemId, resultWrapper));
        }
    }

    class MediaBrowserServiceImplApi24 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi24.ServiceCompatProxy {

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi24.1 */
        class C00991 extends Result<List<MediaItem>> {
            final /* synthetic */ ResultWrapper val$resultWrapper;

            C00991(Object debug, ResultWrapper resultWrapper) {
                this.val$resultWrapper = resultWrapper;
                super(debug);
            }

            void onResultSent(List<MediaItem> list, int flags) {
                List<Parcel> parcelList = null;
                if (list != null) {
                    parcelList = new ArrayList();
                    for (MediaItem item : list) {
                        Parcel parcel = Parcel.obtain();
                        item.writeToParcel(parcel, 0);
                        parcelList.add(parcel);
                    }
                }
                this.val$resultWrapper.sendResult(parcelList, flags);
            }

            public void detach() {
                this.val$resultWrapper.detach();
            }
        }

        MediaBrowserServiceImplApi24() {
            super();
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi24.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public void notifyChildrenChanged(String parentId, Bundle options) {
            if (options == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, parentId);
            } else {
                MediaBrowserServiceCompatApi24.notifyChildrenChanged(this.mServiceObj, parentId, options);
            }
        }

        public void onLoadChildren(String parentId, ResultWrapper resultWrapper, Bundle options) {
            MediaBrowserServiceCompat.this.onLoadChildren(parentId, new C00991(parentId, resultWrapper), options);
        }

        public Bundle getBrowserRootHints() {
            return MediaBrowserServiceCompatApi24.getBrowserRootHints(this.mServiceObj);
        }
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1 */
        class C01001 implements Runnable {
            final /* synthetic */ Token val$token;

            C01001(Token token) {
                this.val$token = token;
            }

            public void run() {
                Iterator<ConnectionRecord> iter = MediaBrowserServiceCompat.this.mConnections.values().iterator();
                while (iter.hasNext()) {
                    ConnectionRecord connection = (ConnectionRecord) iter.next();
                    try {
                        connection.callbacks.onConnect(connection.root.getRootId(), this.val$token, connection.root.getExtras());
                    } catch (RemoteException e) {
                        Log.w(MediaBrowserServiceCompat.TAG, "Connection for " + connection.pkg + " is no longer valid.");
                        iter.remove();
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.2 */
        class C01012 implements Runnable {
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;

            C01012(String str, Bundle bundle) {
                this.val$parentId = str;
                this.val$options = bundle;
            }

            public void run() {
                for (IBinder binder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                    ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(binder);
                    List<Pair<IBinder, Bundle>> callbackList = (List) connection.subscriptions.get(this.val$parentId);
                    if (callbackList != null) {
                        for (Pair<IBinder, Bundle> callback : callbackList) {
                            if (MediaBrowserCompatUtils.hasDuplicatedItems(this.val$options, (Bundle) callback.second)) {
                                MediaBrowserServiceCompat.this.performLoadChildren(this.val$parentId, connection, (Bundle) callback.second);
                            }
                        }
                    }
                }
            }
        }

        MediaBrowserServiceImplBase() {
        }

        public void onCreate() {
            this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        }

        public IBinder onBind(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.mMessenger.getBinder();
            }
            return null;
        }

        public void setSessionToken(Token token) {
            MediaBrowserServiceCompat.this.mHandler.post(new C01001(token));
        }

        public void notifyChildrenChanged(@NonNull String parentId, Bundle options) {
            MediaBrowserServiceCompat.this.mHandler.post(new C01012(parentId, options));
        }

        public Bundle getBrowserRootHints() {
            if (MediaBrowserServiceCompat.this.mCurConnection != null) {
                return MediaBrowserServiceCompat.this.mCurConnection.rootHints == null ? null : new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            } else {
                throw new IllegalStateException("This should be called inside of onLoadChildren or onLoadItem methods");
            }
        }
    }

    private class ServiceBinderImpl {

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.1 */
        class C01021 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ String val$pkg;
            final /* synthetic */ Bundle val$rootHints;
            final /* synthetic */ int val$uid;

            C01021(ServiceCallbacks serviceCallbacks, String str, Bundle bundle, int i) {
                this.val$callbacks = serviceCallbacks;
                this.val$pkg = str;
                this.val$rootHints = bundle;
                this.val$uid = i;
            }

            public void run() {
                IBinder b = this.val$callbacks.asBinder();
                MediaBrowserServiceCompat.this.mConnections.remove(b);
                ConnectionRecord connection = new ConnectionRecord();
                connection.pkg = this.val$pkg;
                connection.rootHints = this.val$rootHints;
                connection.callbacks = this.val$callbacks;
                connection.root = MediaBrowserServiceCompat.this.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
                if (connection.root == null) {
                    Log.i(MediaBrowserServiceCompat.TAG, "No root for client " + this.val$pkg + " from service " + getClass().getName());
                    try {
                        this.val$callbacks.onConnectFailed();
                        return;
                    } catch (RemoteException e) {
                        Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnectFailed() failed. Ignoring. pkg=" + this.val$pkg);
                        return;
                    }
                }
                try {
                    MediaBrowserServiceCompat.this.mConnections.put(b, connection);
                    if (MediaBrowserServiceCompat.this.mSession != null) {
                        this.val$callbacks.onConnect(connection.root.getRootId(), MediaBrowserServiceCompat.this.mSession, connection.root.getExtras());
                    }
                } catch (RemoteException e2) {
                    Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnect() failed. Dropping client. pkg=" + this.val$pkg);
                    MediaBrowserServiceCompat.this.mConnections.remove(b);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.2 */
        class C01032 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;

            C01032(ServiceCallbacks serviceCallbacks) {
                this.val$callbacks = serviceCallbacks;
            }

            public void run() {
                if (((ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.remove(this.val$callbacks.asBinder())) == null) {
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.3 */
        class C01043 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ String val$id;
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ IBinder val$token;

            C01043(ServiceCallbacks serviceCallbacks, String str, IBinder iBinder, Bundle bundle) {
                this.val$callbacks = serviceCallbacks;
                this.val$id = str;
                this.val$token = iBinder;
                this.val$options = bundle;
            }

            public void run() {
                ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connection == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "addSubscription for callback that isn't registered id=" + this.val$id);
                } else {
                    MediaBrowserServiceCompat.this.addSubscription(this.val$id, connection, this.val$token, this.val$options);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.4 */
        class C01054 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ String val$id;
            final /* synthetic */ IBinder val$token;

            C01054(ServiceCallbacks serviceCallbacks, String str, IBinder iBinder) {
                this.val$callbacks = serviceCallbacks;
                this.val$id = str;
                this.val$token = iBinder;
            }

            public void run() {
                ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connection == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription for callback that isn't registered id=" + this.val$id);
                } else if (!MediaBrowserServiceCompat.this.removeSubscription(this.val$id, connection, this.val$token)) {
                    Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription called for " + this.val$id + " which is not subscribed");
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.5 */
        class C01065 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ String val$mediaId;
            final /* synthetic */ ResultReceiver val$receiver;

            C01065(ServiceCallbacks serviceCallbacks, String str, ResultReceiver resultReceiver) {
                this.val$callbacks = serviceCallbacks;
                this.val$mediaId = str;
                this.val$receiver = resultReceiver;
            }

            public void run() {
                ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connection == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "getMediaItem for callback that isn't registered id=" + this.val$mediaId);
                } else {
                    MediaBrowserServiceCompat.this.performLoadItem(this.val$mediaId, connection, this.val$receiver);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.6 */
        class C01076 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ Bundle val$rootHints;

            C01076(ServiceCallbacks serviceCallbacks, Bundle bundle) {
                this.val$callbacks = serviceCallbacks;
                this.val$rootHints = bundle;
            }

            public void run() {
                IBinder b = this.val$callbacks.asBinder();
                MediaBrowserServiceCompat.this.mConnections.remove(b);
                ConnectionRecord connection = new ConnectionRecord();
                connection.callbacks = this.val$callbacks;
                connection.rootHints = this.val$rootHints;
                MediaBrowserServiceCompat.this.mConnections.put(b, connection);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.7 */
        class C01087 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;

            C01087(ServiceCallbacks serviceCallbacks) {
                this.val$callbacks = serviceCallbacks;
            }

            public void run() {
                MediaBrowserServiceCompat.this.mConnections.remove(this.val$callbacks.asBinder());
            }
        }

        ServiceBinderImpl() {
        }

        public void connect(String pkg, int uid, Bundle rootHints, ServiceCallbacks callbacks) {
            if (MediaBrowserServiceCompat.this.isValidPackage(pkg, uid)) {
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new C01021(callbacks, pkg, rootHints, uid));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + uid + " package=" + pkg);
        }

        public void disconnect(ServiceCallbacks callbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new C01032(callbacks));
        }

        public void addSubscription(String id, IBinder token, Bundle options, ServiceCallbacks callbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new C01043(callbacks, id, token, options));
        }

        public void removeSubscription(String id, IBinder token, ServiceCallbacks callbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new C01054(callbacks, id, token));
        }

        public void getMediaItem(String mediaId, ResultReceiver receiver, ServiceCallbacks callbacks) {
            if (!TextUtils.isEmpty(mediaId) && receiver != null) {
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new C01065(callbacks, mediaId, receiver));
            }
        }

        public void registerCallbacks(ServiceCallbacks callbacks, Bundle rootHints) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new C01076(callbacks, rootHints));
        }

        public void unregisterCallbacks(ServiceCallbacks callbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new C01087(callbacks));
        }
    }

    private interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, Token token, Bundle bundle) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String str, List<MediaItem> list, Bundle bundle) throws RemoteException;
    }

    private class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(Messenger callbacks) {
            this.mCallbacks = callbacks;
        }

        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        public void onConnect(String root, Token session, Bundle extras) throws RemoteException {
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, MediaBrowserServiceCompat.RESULT_FLAG_OPTION_NOT_HANDLED);
            Bundle data = new Bundle();
            data.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, root);
            data.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, session);
            data.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, extras);
            sendRequest(MediaBrowserServiceCompat.RESULT_FLAG_OPTION_NOT_HANDLED, data);
        }

        public void onConnectFailed() throws RemoteException {
            sendRequest(MediaBrowserServiceCompat.RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED, null);
        }

        public void onLoadChildren(String mediaId, List<MediaItem> list, Bundle options) throws RemoteException {
            Bundle data = new Bundle();
            data.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, mediaId);
            data.putBundle(MediaBrowserProtocol.DATA_OPTIONS, options);
            if (list != null) {
                String str = MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST;
                if (list instanceof ArrayList) {
                    list = (ArrayList) list;
                } else {
                    Object list2 = new ArrayList(list);
                }
                data.putParcelableArrayList(str, list);
            }
            sendRequest(3, data);
        }

        private void sendRequest(int what, Bundle data) throws RemoteException {
            Message msg = Message.obtain();
            msg.what = what;
            msg.arg1 = MediaBrowserServiceCompat.RESULT_FLAG_OPTION_NOT_HANDLED;
            msg.setData(data);
            this.mCallbacks.send(msg);
        }
    }

    private final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;

        ServiceHandler() {
            this.mServiceBinderImpl = new ServiceBinderImpl();
        }

        public void handleMessage(Message msg) {
            Bundle data = msg.getData();
            switch (msg.what) {
                case MediaBrowserServiceCompat.RESULT_FLAG_OPTION_NOT_HANDLED /*1*/:
                    this.mServiceBinderImpl.connect(data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS), new ServiceCallbacksCompat(msg.replyTo));
                case MediaBrowserServiceCompat.RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED /*2*/:
                    this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(msg.replyTo));
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    this.mServiceBinderImpl.addSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), data.getBundle(MediaBrowserProtocol.DATA_OPTIONS), new ServiceCallbacksCompat(msg.replyTo));
                case Dimension.UNIT_IN /*4*/:
                    this.mServiceBinderImpl.removeSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(msg.replyTo));
                case Dimension.UNIT_MM /*5*/:
                    this.mServiceBinderImpl.getMediaItem(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(msg.replyTo));
                case BuyButtonText.LOGO_ONLY /*6*/:
                    this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(msg.replyTo), data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS));
                case BuyButtonText.DONATE_WITH /*7*/:
                    this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(msg.replyTo));
                default:
                    Log.w(MediaBrowserServiceCompat.TAG, "Unhandled message: " + msg + "\n  Service version: " + MediaBrowserServiceCompat.RESULT_FLAG_OPTION_NOT_HANDLED + "\n  Client version: " + msg.arg1);
            }
        }

        public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
            Bundle data = msg.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            return super.sendMessageAtTime(msg, uptimeMillis);
        }

        public void postOrRun(Runnable r) {
            if (Thread.currentThread() == getLooper().getThread()) {
                r.run();
            } else {
                post(r);
            }
        }
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaItem>> result);

    public MediaBrowserServiceCompat() {
        this.mConnections = new ArrayMap();
        this.mHandler = new ServiceHandler();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 24 || BuildCompat.isAtLeastN()) {
            this.mImpl = new MediaBrowserServiceImplApi24();
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserServiceImplApi23();
        } else if (VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserServiceImplApi21();
        } else {
            this.mImpl = new MediaBrowserServiceImplBase();
        }
        this.mImpl.onCreate();
    }

    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
    }

    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaItem>> result, @NonNull Bundle options) {
        result.setFlags(RESULT_FLAG_OPTION_NOT_HANDLED);
        onLoadChildren(parentId, result);
    }

    public void onLoadItem(String itemId, Result<MediaItem> result) {
        result.setFlags(RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED);
        result.sendResult(null);
    }

    public void setSessionToken(Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        } else {
            this.mSession = token;
            this.mImpl.setSessionToken(token);
        }
    }

    @Nullable
    public Token getSessionToken() {
        return this.mSession;
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public void notifyChildrenChanged(@NonNull String parentId) {
        if (parentId == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(parentId, null);
    }

    public void notifyChildrenChanged(@NonNull String parentId, @NonNull Bundle options) {
        if (parentId == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (options == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        } else {
            this.mImpl.notifyChildrenChanged(parentId, options);
        }
    }

    boolean isValidPackage(String pkg, int uid) {
        if (pkg == null) {
            return DEBUG;
        }
        String[] packages = getPackageManager().getPackagesForUid(uid);
        int N = packages.length;
        for (int i = 0; i < N; i += RESULT_FLAG_OPTION_NOT_HANDLED) {
            if (packages[i].equals(pkg)) {
                return true;
            }
        }
        return DEBUG;
    }

    void addSubscription(String id, ConnectionRecord connection, IBinder token, Bundle options) {
        List<Pair<IBinder, Bundle>> callbackList = (List) connection.subscriptions.get(id);
        if (callbackList == null) {
            callbackList = new ArrayList();
        }
        for (Pair<IBinder, Bundle> callback : callbackList) {
            if (token == callback.first && MediaBrowserCompatUtils.areSameOptions(options, (Bundle) callback.second)) {
                return;
            }
        }
        callbackList.add(new Pair(token, options));
        connection.subscriptions.put(id, callbackList);
        performLoadChildren(id, connection, options);
    }

    boolean removeSubscription(String id, ConnectionRecord connection, IBinder token) {
        if (token != null) {
            boolean removed = DEBUG;
            List<Pair<IBinder, Bundle>> callbackList = (List) connection.subscriptions.get(id);
            if (callbackList != null) {
                Iterator<Pair<IBinder, Bundle>> iter = callbackList.iterator();
                while (iter.hasNext()) {
                    if (token == ((Pair) iter.next()).first) {
                        removed = true;
                        iter.remove();
                    }
                }
                if (callbackList.size() == 0) {
                    connection.subscriptions.remove(id);
                }
            }
            return removed;
        } else if (connection.subscriptions.remove(id) != null) {
            return true;
        } else {
            return DEBUG;
        }
    }

    void performLoadChildren(String parentId, ConnectionRecord connection, Bundle options) {
        Result<List<MediaItem>> result = new C00941(parentId, connection, parentId, options);
        this.mCurConnection = connection;
        if (options == null) {
            onLoadChildren(parentId, result);
        } else {
            onLoadChildren(parentId, result, options);
        }
        this.mCurConnection = null;
        if (!result.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connection.pkg + " id=" + parentId);
        }
    }

    List<MediaItem> applyOptions(List<MediaItem> list, Bundle options) {
        if (list == null) {
            return null;
        }
        int page = options.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int pageSize = options.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (page == -1 && pageSize == -1) {
            return list;
        }
        int fromIndex = pageSize * page;
        int toIndex = fromIndex + pageSize;
        if (page < 0 || pageSize < RESULT_FLAG_OPTION_NOT_HANDLED || fromIndex >= list.size()) {
            return Collections.EMPTY_LIST;
        }
        if (toIndex > list.size()) {
            toIndex = list.size();
        }
        return list.subList(fromIndex, toIndex);
    }

    void performLoadItem(String itemId, ConnectionRecord connection, ResultReceiver receiver) {
        Result<MediaItem> result = new C00952(itemId, receiver);
        this.mCurConnection = connection;
        onLoadItem(itemId, result);
        this.mCurConnection = null;
        if (!result.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + itemId);
        }
    }
}
