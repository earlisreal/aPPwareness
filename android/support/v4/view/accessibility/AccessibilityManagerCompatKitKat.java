package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

class AccessibilityManagerCompatKitKat {

    interface TouchExplorationStateChangeListenerBridge {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompatKitKat.1 */
    static class C01651 implements TouchExplorationStateChangeListener {
        final /* synthetic */ TouchExplorationStateChangeListenerBridge val$bridge;

        C01651(TouchExplorationStateChangeListenerBridge touchExplorationStateChangeListenerBridge) {
            this.val$bridge = touchExplorationStateChangeListenerBridge;
        }

        public void onTouchExplorationStateChanged(boolean enabled) {
            this.val$bridge.onTouchExplorationStateChanged(enabled);
        }
    }

    public static class TouchExplorationStateChangeListenerWrapper implements TouchExplorationStateChangeListener {
        final Object mListener;
        final TouchExplorationStateChangeListenerBridge mListenerBridge;

        public TouchExplorationStateChangeListenerWrapper(Object listener, TouchExplorationStateChangeListenerBridge listenerBridge) {
            this.mListener = listener;
            this.mListenerBridge = listenerBridge;
        }

        public int hashCode() {
            return this.mListener == null ? 0 : this.mListener.hashCode();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TouchExplorationStateChangeListenerWrapper other = (TouchExplorationStateChangeListenerWrapper) o;
            if (this.mListener != null) {
                return this.mListener.equals(other.mListener);
            }
            if (other.mListener != null) {
                return false;
            }
            return true;
        }

        public void onTouchExplorationStateChanged(boolean enabled) {
            this.mListenerBridge.onTouchExplorationStateChanged(enabled);
        }
    }

    AccessibilityManagerCompatKitKat() {
    }

    public static Object newTouchExplorationStateChangeListener(TouchExplorationStateChangeListenerBridge bridge) {
        return new C01651(bridge);
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager manager, Object listener) {
        return manager.addTouchExplorationStateChangeListener((TouchExplorationStateChangeListener) listener);
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager manager, Object listener) {
        return manager.removeTouchExplorationStateChangeListener((TouchExplorationStateChangeListener) listener);
    }
}
