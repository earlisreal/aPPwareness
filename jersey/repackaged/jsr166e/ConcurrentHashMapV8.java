package jersey.repackaged.jsr166e;

import com.google.android.gms.drive.DriveFile;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import sun.misc.Unsafe;

public class ConcurrentHashMapV8<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    private static final long ABASE;
    private static final int ASHIFT;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MAX_RESIZERS;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1;
    static final int NCPU;
    static final int RESERVED = -3;
    private static int RESIZE_STAMP_BITS = 0;
    private static final int RESIZE_STAMP_SHIFT;
    static final int SEED_INCREMENT = 1640531527;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    static final int TREEBIN = -2;
    static final int TREEIFY_THRESHOLD = 8;
    private static final Unsafe f22U;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final AtomicInteger counterHashCodeGenerator;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    static final ThreadLocal<CounterHashCode> threadCounterHashCode;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient CounterCell[] counterCells;
    private transient EntrySetView<K, V> entrySet;
    private transient KeySetView<K, V> keySet;
    private volatile transient Node<K, V>[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient Node<K, V>[] table;
    private volatile transient int transferIndex;
    private transient ValuesView<K, V> values;

    static {
        RESIZE_STAMP_BITS = MIN_TRANSFER_STRIDE;
        MAX_RESIZERS = (1 << (32 - RESIZE_STAMP_BITS)) + MOVED;
        RESIZE_STAMP_SHIFT = 32 - RESIZE_STAMP_BITS;
        NCPU = Runtime.getRuntime().availableProcessors();
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", Segment[].class), new ObjectStreamField("segmentMask", Integer.TYPE), new ObjectStreamField("segmentShift", Integer.TYPE)};
        counterHashCodeGenerator = new AtomicInteger();
        threadCounterHashCode = new ThreadLocal();
        try {
            f22U = getUnsafe();
            Class<?> k = ConcurrentHashMapV8.class;
            SIZECTL = f22U.objectFieldOffset(k.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = f22U.objectFieldOffset(k.getDeclaredField("transferIndex"));
            BASECOUNT = f22U.objectFieldOffset(k.getDeclaredField("baseCount"));
            CELLSBUSY = f22U.objectFieldOffset(k.getDeclaredField("cellsBusy"));
            CELLVALUE = f22U.objectFieldOffset(CounterCell.class.getDeclaredField("value"));
            Class<?> ak = Node[].class;
            ABASE = (long) f22U.arrayBaseOffset(ak);
            int scale = f22U.arrayIndexScale(ak);
            if (((scale + MOVED) & scale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            ASHIFT = 31 - Integer.numberOfLeadingZeros(scale);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    static final int spread(int h) {
        return ((h >>> MIN_TRANSFER_STRIDE) ^ h) & HASH_BITS;
    }

    private static final int tableSizeFor(int c) {
        int n = c + MOVED;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> TREEIFY_THRESHOLD;
        n |= n >>> MIN_TRANSFER_STRIDE;
        if (n < 0) {
            return 1;
        }
        if (n < MAXIMUM_CAPACITY) {
            return n + 1;
        }
        return MAXIMUM_CAPACITY;
    }

    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Type c = x.getClass();
            if (c == String.class) {
                return c;
            }
            Type[] ts = c.getGenericInterfaces();
            if (ts != null) {
                for (int i = RESIZE_STAMP_SHIFT; i < ts.length; i++) {
                    Type t = ts[i];
                    if (t instanceof ParameterizedType) {
                        ParameterizedType p = (ParameterizedType) t;
                        if (p.getRawType() == Comparable.class) {
                            Type[] as = p.getActualTypeArguments();
                            if (as != null && as.length == 1 && as[RESIZE_STAMP_SHIFT] == c) {
                                return c;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    static int compareComparables(Class<?> kc, Object k, Object x) {
        if (x == null || x.getClass() != kc) {
            return RESIZE_STAMP_SHIFT;
        }
        return ((Comparable) k).compareTo(x);
    }

    static final <K, V> Node<K, V> tabAt(Node<K, V>[] tab, int i) {
        return (Node) f22U.getObjectVolatile(tab, (((long) i) << ASHIFT) + ABASE);
    }

    static final <K, V> boolean casTabAt(Node<K, V>[] tab, int i, Node<K, V> c, Node<K, V> v) {
        return f22U.compareAndSwapObject(tab, (((long) i) << ASHIFT) + ABASE, c, v);
    }

    static final <K, V> void setTabAt(Node<K, V>[] tab, int i, Node<K, V> v) {
        f22U.putObjectVolatile(tab, (((long) i) << ASHIFT) + ABASE, v);
    }

    public ConcurrentHashMapV8(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        int cap;
        if (initialCapacity >= DriveFile.MODE_WRITE_ONLY) {
            cap = MAXIMUM_CAPACITY;
        } else {
            cap = tableSizeFor(((initialCapacity >>> 1) + initialCapacity) + 1);
        }
        this.sizeCtl = cap;
    }

    public ConcurrentHashMapV8(Map<? extends K, ? extends V> m) {
        this.sizeCtl = MIN_TRANSFER_STRIDE;
        putAll(m);
    }

    public ConcurrentHashMapV8(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, 1);
    }

    public ConcurrentHashMapV8(int initialCapacity, float loadFactor, int concurrencyLevel) {
        if (loadFactor <= 0.0f || initialCapacity < 0 || concurrencyLevel <= 0) {
            throw new IllegalArgumentException();
        }
        int cap;
        if (initialCapacity < concurrencyLevel) {
            initialCapacity = concurrencyLevel;
        }
        long size = (long) (1.0d + ((double) (((float) ((long) initialCapacity)) / loadFactor)));
        if (size >= 1073741824) {
            cap = MAXIMUM_CAPACITY;
        } else {
            cap = tableSizeFor((int) size);
        }
        this.sizeCtl = cap;
    }

    public int size() {
        long n = sumCount();
        if (n < TRANSFERINDEX) {
            return RESIZE_STAMP_SHIFT;
        }
        return n > 2147483647L ? HASH_BITS : (int) n;
    }

    public boolean isEmpty() {
        return sumCount() <= TRANSFERINDEX;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(java.lang.Object r10) {
        /*
        r9 = this;
        r7 = 0;
        r8 = r10.hashCode();
        r3 = spread(r8);
        r6 = r9.table;
        if (r6 == 0) goto L_0x002b;
    L_0x000d:
        r4 = r6.length;
        if (r4 <= 0) goto L_0x002b;
    L_0x0010:
        r8 = r4 + -1;
        r8 = r8 & r3;
        r0 = tabAt(r6, r8);
        if (r0 == 0) goto L_0x002b;
    L_0x0019:
        r1 = r0.hash;
        if (r1 != r3) goto L_0x002c;
    L_0x001d:
        r2 = r0.key;
        if (r2 == r10) goto L_0x0029;
    L_0x0021:
        if (r2 == 0) goto L_0x0037;
    L_0x0023:
        r8 = r10.equals(r2);
        if (r8 == 0) goto L_0x0037;
    L_0x0029:
        r7 = r0.val;
    L_0x002b:
        return r7;
    L_0x002c:
        if (r1 >= 0) goto L_0x0037;
    L_0x002e:
        r5 = r0.find(r3, r10);
        if (r5 == 0) goto L_0x002b;
    L_0x0034:
        r7 = r5.val;
        goto L_0x002b;
    L_0x0037:
        r0 = r0.next;
        if (r0 == 0) goto L_0x002b;
    L_0x003b:
        r8 = r0.hash;
        if (r8 != r3) goto L_0x0037;
    L_0x003f:
        r2 = r0.key;
        if (r2 == r10) goto L_0x004b;
    L_0x0043:
        if (r2 == 0) goto L_0x0037;
    L_0x0045:
        r8 = r10.equals(r2);
        if (r8 == 0) goto L_0x0037;
    L_0x004b:
        r7 = r0.val;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.get(java.lang.Object):V");
    }

    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsValue(java.lang.Object r8) {
        /*
        r7 = this;
        r4 = 0;
        if (r8 != 0) goto L_0x0009;
    L_0x0003:
        r4 = new java.lang.NullPointerException;
        r4.<init>();
        throw r4;
    L_0x0009:
        r2 = r7.table;
        if (r2 == 0) goto L_0x0027;
    L_0x000d:
        r0 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Traverser;
        r5 = r2.length;
        r6 = r2.length;
        r0.<init>(r2, r5, r4, r6);
    L_0x0014:
        r1 = r0.advance();
        if (r1 == 0) goto L_0x0027;
    L_0x001a:
        r3 = r1.val;
        if (r3 == r8) goto L_0x0026;
    L_0x001e:
        if (r3 == 0) goto L_0x0014;
    L_0x0020:
        r5 = r8.equals(r3);
        if (r5 == 0) goto L_0x0014;
    L_0x0026:
        r4 = 1;
    L_0x0027:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.containsValue(java.lang.Object):boolean");
    }

    public V put(K key, V value) {
        return putVal(key, value, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final V putVal(K r20, V r21, boolean r22) {
        /*
        r19 = this;
        if (r20 == 0) goto L_0x0004;
    L_0x0002:
        if (r21 != 0) goto L_0x000a;
    L_0x0004:
        r16 = new java.lang.NullPointerException;
        r16.<init>();
        throw r16;
    L_0x000a:
        r16 = r20.hashCode();
        r9 = spread(r16);
        r4 = 0;
        r0 = r19;
        r15 = r0.table;
    L_0x0017:
        if (r15 == 0) goto L_0x001c;
    L_0x0019:
        r11 = r15.length;
        if (r11 != 0) goto L_0x0021;
    L_0x001c:
        r15 = r19.initTable();
        goto L_0x0017;
    L_0x0021:
        r16 = r11 + -1;
        r10 = r16 & r9;
        r7 = tabAt(r15, r10);
        if (r7 != 0) goto L_0x0052;
    L_0x002b:
        r16 = 0;
        r17 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;
        r18 = 0;
        r0 = r17;
        r1 = r20;
        r2 = r21;
        r3 = r18;
        r0.<init>(r9, r1, r2, r3);
        r0 = r16;
        r1 = r17;
        r16 = casTabAt(r15, r10, r0, r1);
        if (r16 == 0) goto L_0x0017;
    L_0x0046:
        r16 = 1;
        r0 = r19;
        r1 = r16;
        r0.addCount(r1, r4);
        r16 = 0;
    L_0x0051:
        return r16;
    L_0x0052:
        r8 = r7.hash;
        r16 = -1;
        r0 = r16;
        if (r8 != r0) goto L_0x0061;
    L_0x005a:
        r0 = r19;
        r15 = r0.helpTransfer(r15, r7);
        goto L_0x0017;
    L_0x0061:
        r12 = 0;
        monitor-enter(r7);
        r16 = tabAt(r15, r10);	 Catch:{ all -> 0x00bb }
        r0 = r16;
        if (r0 != r7) goto L_0x00e4;
    L_0x006b:
        if (r8 < 0) goto L_0x00c1;
    L_0x006d:
        r4 = 1;
        r5 = r7;
    L_0x006f:
        r0 = r5.hash;	 Catch:{ all -> 0x00bb }
        r16 = r0;
        r0 = r16;
        if (r0 != r9) goto L_0x00a2;
    L_0x0077:
        r6 = r5.key;	 Catch:{ all -> 0x00bb }
        r0 = r20;
        if (r6 == r0) goto L_0x0087;
    L_0x007d:
        if (r6 == 0) goto L_0x00a2;
    L_0x007f:
        r0 = r20;
        r16 = r0.equals(r6);	 Catch:{ all -> 0x00bb }
        if (r16 == 0) goto L_0x00a2;
    L_0x0087:
        r12 = r5.val;	 Catch:{ all -> 0x00bb }
        if (r22 != 0) goto L_0x008f;
    L_0x008b:
        r0 = r21;
        r5.val = r0;	 Catch:{ all -> 0x00bb }
    L_0x008f:
        r16 = r12;
    L_0x0091:
        monitor-exit(r7);	 Catch:{ all -> 0x00bb }
        if (r4 == 0) goto L_0x0017;
    L_0x0094:
        r17 = 8;
        r0 = r17;
        if (r4 < r0) goto L_0x009f;
    L_0x009a:
        r0 = r19;
        r0.treeifyBin(r15, r10);
    L_0x009f:
        if (r16 == 0) goto L_0x0046;
    L_0x00a1:
        goto L_0x0051;
    L_0x00a2:
        r14 = r5;
        r5 = r5.next;	 Catch:{ all -> 0x00bb }
        if (r5 != 0) goto L_0x00be;
    L_0x00a7:
        r16 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;	 Catch:{ all -> 0x00bb }
        r17 = 0;
        r0 = r16;
        r1 = r20;
        r2 = r21;
        r3 = r17;
        r0.<init>(r9, r1, r2, r3);	 Catch:{ all -> 0x00bb }
        r0 = r16;
        r14.next = r0;	 Catch:{ all -> 0x00bb }
        goto L_0x008f;
    L_0x00bb:
        r16 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x00bb }
        throw r16;
    L_0x00be:
        r4 = r4 + 1;
        goto L_0x006f;
    L_0x00c1:
        r0 = r7 instanceof jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin;	 Catch:{ all -> 0x00bb }
        r16 = r0;
        if (r16 == 0) goto L_0x00e4;
    L_0x00c7:
        r4 = 2;
        r0 = r7;
        r0 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin) r0;	 Catch:{ all -> 0x00bb }
        r16 = r0;
        r0 = r16;
        r1 = r20;
        r2 = r21;
        r13 = r0.putTreeVal(r9, r1, r2);	 Catch:{ all -> 0x00bb }
        if (r13 == 0) goto L_0x00e4;
    L_0x00d9:
        r12 = r13.val;	 Catch:{ all -> 0x00bb }
        if (r22 != 0) goto L_0x00e1;
    L_0x00dd:
        r0 = r21;
        r13.val = r0;	 Catch:{ all -> 0x00bb }
    L_0x00e1:
        r16 = r12;
        goto L_0x0091;
    L_0x00e4:
        r16 = r12;
        goto L_0x0091;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.putVal(java.lang.Object, java.lang.Object, boolean):V");
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        tryPresize(m.size());
        for (Entry<? extends K, ? extends V> e : m.entrySet()) {
            putVal(e.getKey(), e.getValue(), false);
        }
    }

    public V remove(Object key) {
        return replaceNode(key, null, null);
    }

    final V replaceNode(Object key, V value, Object cv) {
        int hash = spread(key.hashCode());
        Node<K, V>[] tab = this.table;
        while (tab != null) {
            int n = tab.length;
            if (n == 0) {
                break;
            }
            int i = (n + MOVED) & hash;
            Node<K, V> f = tabAt(tab, i);
            if (f == null) {
                break;
            }
            int fh = f.hash;
            if (fh == MOVED) {
                tab = helpTransfer(tab, f);
            } else {
                V v;
                V oldVal = null;
                boolean validated = false;
                synchronized (f) {
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            validated = true;
                            Node<K, V> e = f;
                            Node<K, V> pred = null;
                            do {
                                int i2 = e.hash;
                                if (r0 == hash) {
                                    K ek = e.key;
                                    if (ek == key || (ek != null && key.equals(ek))) {
                                        V ev = e.val;
                                        if (cv == null || cv == ev || (ev != null && cv.equals(ev))) {
                                            oldVal = ev;
                                            if (value != null) {
                                                e.val = value;
                                            } else if (pred != null) {
                                                pred.next = e.next;
                                            } else {
                                                setTabAt(tab, i, e.next);
                                            }
                                        }
                                        v = oldVal;
                                    }
                                }
                                pred = e;
                                e = e.next;
                            } while (e != null);
                            v = oldVal;
                        } else if (f instanceof TreeBin) {
                            validated = true;
                            TreeBin<K, V> t = (TreeBin) f;
                            TreeNode<K, V> r = t.root;
                            if (r != null) {
                                TreeNode<K, V> p = r.findTreeNode(hash, key, null);
                                if (p != null) {
                                    V pv = p.val;
                                    if (cv == null || cv == pv || (pv != null && cv.equals(pv))) {
                                        oldVal = pv;
                                        if (value != null) {
                                            p.val = value;
                                            v = oldVal;
                                        } else {
                                            if (t.removeTreeNode(p)) {
                                                setTabAt(tab, i, untreeify(t.first));
                                            }
                                            v = oldVal;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    v = null;
                }
                if (validated) {
                    if (v != null) {
                        if (value != null) {
                            return v;
                        }
                        addCount(-1, MOVED);
                        return v;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
        r15 = this;
        r11 = 0;
        r14 = -1;
        r2 = 0;
        r6 = 0;
        r9 = r15.table;
        r7 = r6;
    L_0x0008:
        if (r9 == 0) goto L_0x004b;
    L_0x000a:
        r10 = r9.length;
        if (r7 >= r10) goto L_0x004b;
    L_0x000d:
        r4 = tabAt(r9, r7);
        if (r4 != 0) goto L_0x0017;
    L_0x0013:
        r6 = r7 + 1;
    L_0x0015:
        r7 = r6;
        goto L_0x0008;
    L_0x0017:
        r5 = r4.hash;
        if (r5 != r14) goto L_0x0021;
    L_0x001b:
        r9 = r15.helpTransfer(r9, r4);
        r6 = 0;
        goto L_0x0015;
    L_0x0021:
        monitor-enter(r4);
        r10 = tabAt(r9, r7);	 Catch:{ all -> 0x0055 }
        if (r10 != r4) goto L_0x0058;
    L_0x0028:
        if (r5 < 0) goto L_0x0033;
    L_0x002a:
        r8 = r4;
    L_0x002b:
        if (r8 == 0) goto L_0x0040;
    L_0x002d:
        r12 = 1;
        r2 = r2 - r12;
        r8 = r8.next;	 Catch:{ all -> 0x0055 }
        goto L_0x002b;
    L_0x0033:
        r10 = r4 instanceof jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin;	 Catch:{ all -> 0x0055 }
        if (r10 == 0) goto L_0x003e;
    L_0x0037:
        r0 = r4;
        r0 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin) r0;	 Catch:{ all -> 0x0055 }
        r10 = r0;
        r8 = r10.first;	 Catch:{ all -> 0x0055 }
        goto L_0x002b;
    L_0x003e:
        r8 = r11;
        goto L_0x002b;
    L_0x0040:
        r6 = r7 + 1;
        r10 = 0;
        setTabAt(r9, r7, r10);	 Catch:{ all -> 0x0048 }
    L_0x0046:
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        goto L_0x0015;
    L_0x0048:
        r10 = move-exception;
    L_0x0049:
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        throw r10;
    L_0x004b:
        r10 = 0;
        r10 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r10 == 0) goto L_0x0054;
    L_0x0051:
        r15.addCount(r2, r14);
    L_0x0054:
        return;
    L_0x0055:
        r10 = move-exception;
        r6 = r7;
        goto L_0x0049;
    L_0x0058:
        r6 = r7;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.clear():void");
    }

    public KeySetView<K, V> keySet() {
        KeySetView<K, V> ks = this.keySet;
        if (ks != null) {
            return ks;
        }
        ks = new KeySetView(this, null);
        this.keySet = ks;
        return ks;
    }

    public Collection<V> values() {
        ValuesView<K, V> vs = this.values;
        if (vs != null) {
            return vs;
        }
        vs = new ValuesView(this);
        this.values = vs;
        return vs;
    }

    public Set<Entry<K, V>> entrySet() {
        EntrySetView<K, V> es = this.entrySet;
        if (es != null) {
            return es;
        }
        es = new EntrySetView(this);
        this.entrySet = es;
        return es;
    }

    public int hashCode() {
        int h = RESIZE_STAMP_SHIFT;
        Node<K, V>[] t = this.table;
        if (t != null) {
            Traverser<K, V> it = new Traverser(t, t.length, RESIZE_STAMP_SHIFT, t.length);
            while (true) {
                Node<K, V> p = it.advance();
                if (p == null) {
                    break;
                }
                h += p.key.hashCode() ^ p.val.hashCode();
            }
        }
        return h;
    }

    public String toString() {
        Node<K, V>[] t = this.table;
        int f = t == null ? RESIZE_STAMP_SHIFT : t.length;
        Traverser<K, V> it = new Traverser(t, f, RESIZE_STAMP_SHIFT, f);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Node<K, V> p = it.advance();
        if (p != null) {
            while (true) {
                K k = p.key;
                V v = p.val;
                if (k == this) {
                    k = "(this Map)";
                }
                sb.append(k);
                sb.append('=');
                if (v == this) {
                    v = "(this Map)";
                }
                sb.append(v);
                p = it.advance();
                if (p == null) {
                    break;
                }
                sb.append(',').append(' ');
            }
        }
        return sb.append('}').toString();
    }

    public boolean equals(Object o) {
        if (o != this) {
            if (!(o instanceof Map)) {
                return false;
            }
            Map<?, ?> m = (Map) o;
            Node<K, V>[] t = this.table;
            int f = t == null ? RESIZE_STAMP_SHIFT : t.length;
            Traverser<K, V> it = new Traverser(t, f, RESIZE_STAMP_SHIFT, f);
            while (true) {
                Node<K, V> p = it.advance();
                if (p == null) {
                    break;
                }
                V val = p.val;
                V v = m.get(p.key);
                if (v == null) {
                    return false;
                }
                if (v != val && !v.equals(val)) {
                    return false;
                }
            }
            for (Entry<?, ?> e : m.entrySet()) {
                Object mk = e.getKey();
                if (mk == null) {
                    return false;
                }
                Object mv = e.getValue();
                if (mv == null) {
                    return false;
                }
                Object v2 = get(mk);
                if (v2 == null) {
                    return false;
                }
                if (mv != v2 && !mv.equals(v2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        int sshift = RESIZE_STAMP_SHIFT;
        int ssize = 1;
        while (ssize < MIN_TRANSFER_STRIDE) {
            sshift++;
            ssize <<= 1;
        }
        int segmentShift = 32 - sshift;
        int segmentMask = ssize + MOVED;
        Segment[] segments = (Segment[]) new Segment[MIN_TRANSFER_STRIDE];
        for (int i = RESIZE_STAMP_SHIFT; i < segments.length; i++) {
            segments[i] = new Segment(LOAD_FACTOR);
        }
        s.putFields().put("segments", segments);
        s.putFields().put("segmentShift", segmentShift);
        s.putFields().put("segmentMask", segmentMask);
        s.writeFields();
        Node<K, V>[] t = this.table;
        if (t != null) {
            Traverser<K, V> it = new Traverser(t, t.length, RESIZE_STAMP_SHIFT, t.length);
            while (true) {
                Node<K, V> p = it.advance();
                if (p == null) {
                    break;
                }
                s.writeObject(p.key);
                s.writeObject(p.val);
            }
        }
        s.writeObject(null);
        s.writeObject(null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readObject(java.io.ObjectInputStream r34) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
        r33 = this;
        r5 = -1;
        r0 = r33;
        r0.sizeCtl = r5;
        r34.defaultReadObject();
        r26 = 0;
        r22 = 0;
    L_0x000c:
        r18 = r34.readObject();
        r32 = r34.readObject();
        if (r18 == 0) goto L_0x0034;
    L_0x0016:
        if (r32 == 0) goto L_0x0034;
    L_0x0018:
        r23 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;
        r5 = r18.hashCode();
        r5 = spread(r5);
        r0 = r23;
        r1 = r18;
        r2 = r32;
        r3 = r22;
        r0.<init>(r5, r1, r2, r3);
        r6 = 1;
        r26 = r26 + r6;
        r22 = r23;
        goto L_0x000c;
    L_0x0034:
        r6 = 0;
        r5 = (r26 > r6 ? 1 : (r26 == r6 ? 0 : -1));
        if (r5 != 0) goto L_0x0040;
    L_0x003a:
        r5 = 0;
        r0 = r33;
        r0.sizeCtl = r5;
    L_0x003f:
        return;
    L_0x0040:
        r6 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r5 = (r26 > r6 ? 1 : (r26 == r6 ? 0 : -1));
        if (r5 < 0) goto L_0x0084;
    L_0x0047:
        r20 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x0049:
        r0 = r20;
        r0 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8.Node[r0];
        r30 = r0;
        r30 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.Node[]) r30;
        r19 = r20 + -1;
        r10 = 0;
    L_0x0055:
        if (r22 == 0) goto L_0x0132;
    L_0x0057:
        r0 = r22;
        r0 = r0.next;
        r21 = r0;
        r0 = r22;
        r14 = r0.hash;
        r17 = r14 & r19;
        r0 = r30;
        r1 = r17;
        r13 = tabAt(r0, r1);
        if (r13 != 0) goto L_0x0094;
    L_0x006d:
        r16 = 1;
    L_0x006f:
        if (r16 == 0) goto L_0x0081;
    L_0x0071:
        r6 = 1;
        r10 = r10 + r6;
        r0 = r22;
        r0.next = r13;
        r0 = r30;
        r1 = r17;
        r2 = r22;
        setTabAt(r0, r1, r2);
    L_0x0081:
        r22 = r21;
        goto L_0x0055;
    L_0x0084:
        r0 = r26;
        r0 = (int) r0;
        r28 = r0;
        r5 = r28 >>> 1;
        r5 = r5 + r28;
        r5 = r5 + 1;
        r20 = tableSizeFor(r5);
        goto L_0x0049;
    L_0x0094:
        r0 = r22;
        r0 = r0.key;
        r18 = r0;
        r5 = r13.hash;
        if (r5 >= 0) goto L_0x00b6;
    L_0x009e:
        r29 = r13;
        r29 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin) r29;
        r0 = r22;
        r5 = r0.val;
        r0 = r29;
        r1 = r18;
        r5 = r0.putTreeVal(r14, r1, r5);
        if (r5 != 0) goto L_0x00b3;
    L_0x00b0:
        r6 = 1;
        r10 = r10 + r6;
    L_0x00b3:
        r16 = 0;
        goto L_0x006f;
    L_0x00b6:
        r12 = 0;
        r16 = 1;
        r24 = r13;
    L_0x00bb:
        if (r24 == 0) goto L_0x00dd;
    L_0x00bd:
        r0 = r24;
        r5 = r0.hash;
        if (r5 != r14) goto L_0x0116;
    L_0x00c3:
        r0 = r24;
        r0 = r0.key;
        r25 = r0;
        r0 = r25;
        r1 = r18;
        if (r0 == r1) goto L_0x00db;
    L_0x00cf:
        if (r25 == 0) goto L_0x0116;
    L_0x00d1:
        r0 = r18;
        r1 = r25;
        r5 = r0.equals(r1);
        if (r5 == 0) goto L_0x0116;
    L_0x00db:
        r16 = 0;
    L_0x00dd:
        if (r16 == 0) goto L_0x006f;
    L_0x00df:
        r5 = 8;
        if (r12 < r5) goto L_0x006f;
    L_0x00e3:
        r16 = 0;
        r6 = 1;
        r10 = r10 + r6;
        r0 = r22;
        r0.next = r13;
        r15 = 0;
        r31 = 0;
        r24 = r22;
    L_0x00f1:
        if (r24 == 0) goto L_0x0124;
    L_0x00f3:
        r4 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$TreeNode;
        r0 = r24;
        r5 = r0.hash;
        r0 = r24;
        r6 = r0.key;
        r0 = r24;
        r7 = r0.val;
        r8 = 0;
        r9 = 0;
        r4.<init>(r5, r6, r7, r8, r9);
        r0 = r31;
        r4.prev = r0;
        if (r31 != 0) goto L_0x011f;
    L_0x010c:
        r15 = r4;
    L_0x010d:
        r31 = r4;
        r0 = r24;
        r0 = r0.next;
        r24 = r0;
        goto L_0x00f1;
    L_0x0116:
        r12 = r12 + 1;
        r0 = r24;
        r0 = r0.next;
        r24 = r0;
        goto L_0x00bb;
    L_0x011f:
        r0 = r31;
        r0.next = r4;
        goto L_0x010d;
    L_0x0124:
        r5 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$TreeBin;
        r5.<init>(r15);
        r0 = r30;
        r1 = r17;
        setTabAt(r0, r1, r5);
        goto L_0x006f;
    L_0x0132:
        r0 = r30;
        r1 = r33;
        r1.table = r0;
        r5 = r20 >>> 2;
        r5 = r20 - r5;
        r0 = r33;
        r0.sizeCtl = r5;
        r0 = r33;
        r0.baseCount = r10;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.readObject(java.io.ObjectInputStream):void");
    }

    public V putIfAbsent(K key, V value) {
        return putVal(key, value, true);
    }

    public boolean remove(Object key, Object value) {
        if (key != null) {
            return (value == null || replaceNode(key, null, value) == null) ? false : true;
        } else {
            throw new NullPointerException();
        }
    }

    public boolean replace(K key, V oldValue, V newValue) {
        if (key != null && oldValue != null && newValue != null) {
            return replaceNode(key, newValue, oldValue) != null;
        } else {
            throw new NullPointerException();
        }
    }

    public V replace(K key, V value) {
        if (key != null && value != null) {
            return replaceNode(key, value, null);
        }
        throw new NullPointerException();
    }

    public V getOrDefault(Object key, V defaultValue) {
        V v = get(key);
        return v == null ? defaultValue : v;
    }

    public void forEach(BiAction<? super K, ? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] t = this.table;
        if (t != null) {
            Traverser<K, V> it = new Traverser(t, t.length, RESIZE_STAMP_SHIFT, t.length);
            while (true) {
                Node<K, V> p = it.advance();
                if (p != null) {
                    action.apply(p.key, p.val);
                } else {
                    return;
                }
            }
        }
    }

    public void replaceAll(BiFun<? super K, ? super V, ? extends V> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] t = this.table;
        if (t != null) {
            Traverser<K, V> it = new Traverser(t, t.length, RESIZE_STAMP_SHIFT, t.length);
            loop0:
            while (true) {
                Node<K, V> p = it.advance();
                if (p != null) {
                    V oldValue = p.val;
                    K key = p.key;
                    do {
                        V newValue = function.apply(key, oldValue);
                        if (newValue != null) {
                            if (replaceNode(key, newValue, oldValue) != null) {
                                break;
                            }
                            oldValue = get(key);
                        } else {
                            break loop0;
                        }
                    } while (oldValue != null);
                }
                return;
            }
            throw new NullPointerException();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V computeIfAbsent(K r27, jersey.repackaged.jsr166e.ConcurrentHashMapV8.Fun<? super K, ? extends V> r28) {
        /*
        r26 = this;
        if (r27 == 0) goto L_0x0004;
    L_0x0002:
        if (r28 != 0) goto L_0x000a;
    L_0x0004:
        r22 = new java.lang.NullPointerException;
        r22.<init>();
        throw r22;
    L_0x000a:
        r22 = r27.hashCode();
        r10 = spread(r22);
        r21 = 0;
        r5 = 0;
        r0 = r26;
        r0 = r0.table;
        r20 = r0;
        r22 = r21;
    L_0x001d:
        if (r20 == 0) goto L_0x0024;
    L_0x001f:
        r0 = r20;
        r12 = r0.length;
        if (r12 != 0) goto L_0x0029;
    L_0x0024:
        r20 = r26.initTable();
        goto L_0x001d;
    L_0x0029:
        r23 = r12 + -1;
        r11 = r23 & r10;
        r0 = r20;
        r8 = tabAt(r0, r11);
        if (r8 != 0) goto L_0x0082;
    L_0x0035:
        r17 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$ReservationNode;
        r17.<init>();
        monitor-enter(r17);
        r23 = 0;
        r0 = r20;
        r1 = r23;
        r2 = r17;
        r23 = casTabAt(r0, r11, r1, r2);	 Catch:{ all -> 0x007f }
        if (r23 == 0) goto L_0x0069;
    L_0x0049:
        r5 = 1;
        r14 = 0;
        r0 = r28;
        r1 = r27;
        r21 = r0.apply(r1);	 Catch:{ all -> 0x0078 }
        if (r21 == 0) goto L_0x0141;
    L_0x0055:
        r13 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;	 Catch:{ all -> 0x0078 }
        r22 = 0;
        r0 = r27;
        r1 = r21;
        r2 = r22;
        r13.<init>(r10, r0, r1, r2);	 Catch:{ all -> 0x0078 }
    L_0x0062:
        r0 = r20;
        setTabAt(r0, r11, r13);	 Catch:{ all -> 0x007f }
        r22 = r21;
    L_0x0069:
        monitor-exit(r17);	 Catch:{ all -> 0x007f }
        if (r5 == 0) goto L_0x001d;
    L_0x006c:
        if (r22 == 0) goto L_0x0077;
    L_0x006e:
        r24 = 1;
        r0 = r26;
        r1 = r24;
        r0.addCount(r1, r5);
    L_0x0077:
        return r22;
    L_0x0078:
        r22 = move-exception;
        r0 = r20;
        setTabAt(r0, r11, r14);	 Catch:{ all -> 0x007f }
        throw r22;	 Catch:{ all -> 0x007f }
    L_0x007f:
        r22 = move-exception;
        monitor-exit(r17);	 Catch:{ all -> 0x007f }
        throw r22;
    L_0x0082:
        r9 = r8.hash;
        r23 = -1;
        r0 = r23;
        if (r9 != r0) goto L_0x0093;
    L_0x008a:
        r0 = r26;
        r1 = r20;
        r20 = r0.helpTransfer(r1, r8);
        goto L_0x001d;
    L_0x0093:
        r4 = 0;
        monitor-enter(r8);
        r0 = r20;
        r23 = tabAt(r0, r11);	 Catch:{ all -> 0x00fb }
        r0 = r23;
        if (r0 != r8) goto L_0x00c1;
    L_0x009f:
        if (r9 < 0) goto L_0x0101;
    L_0x00a1:
        r5 = 1;
        r6 = r8;
    L_0x00a3:
        r0 = r6.hash;	 Catch:{ all -> 0x00fb }
        r22 = r0;
        r0 = r22;
        if (r0 != r10) goto L_0x00d4;
    L_0x00ab:
        r7 = r6.key;	 Catch:{ all -> 0x00fb }
        r0 = r27;
        if (r7 == r0) goto L_0x00bb;
    L_0x00b1:
        if (r7 == 0) goto L_0x00d4;
    L_0x00b3:
        r0 = r27;
        r22 = r0.equals(r7);	 Catch:{ all -> 0x00fb }
        if (r22 == 0) goto L_0x00d4;
    L_0x00bb:
        r0 = r6.val;	 Catch:{ all -> 0x00fb }
        r21 = r0;
    L_0x00bf:
        r22 = r21;
    L_0x00c1:
        monitor-exit(r8);	 Catch:{ all -> 0x00fb }
        if (r5 == 0) goto L_0x001d;
    L_0x00c4:
        r23 = 8;
        r0 = r23;
        if (r5 < r0) goto L_0x00d1;
    L_0x00ca:
        r0 = r26;
        r1 = r20;
        r0.treeifyBin(r1, r11);
    L_0x00d1:
        if (r4 != 0) goto L_0x006c;
    L_0x00d3:
        goto L_0x0077;
    L_0x00d4:
        r16 = r6;
        r6 = r6.next;	 Catch:{ all -> 0x00fb }
        if (r6 != 0) goto L_0x00fe;
    L_0x00da:
        r0 = r28;
        r1 = r27;
        r21 = r0.apply(r1);	 Catch:{ all -> 0x00fb }
        if (r21 == 0) goto L_0x00bf;
    L_0x00e4:
        r4 = 1;
        r22 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;	 Catch:{ all -> 0x00fb }
        r23 = 0;
        r0 = r22;
        r1 = r27;
        r2 = r21;
        r3 = r23;
        r0.<init>(r10, r1, r2, r3);	 Catch:{ all -> 0x00fb }
        r0 = r22;
        r1 = r16;
        r1.next = r0;	 Catch:{ all -> 0x00fb }
        goto L_0x00bf;
    L_0x00fb:
        r22 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00fb }
        throw r22;
    L_0x00fe:
        r5 = r5 + 1;
        goto L_0x00a3;
    L_0x0101:
        r0 = r8 instanceof jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin;	 Catch:{ all -> 0x00fb }
        r23 = r0;
        if (r23 == 0) goto L_0x00c1;
    L_0x0107:
        r5 = 2;
        r0 = r8;
        r0 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin) r0;	 Catch:{ all -> 0x00fb }
        r19 = r0;
        r0 = r19;
        r0 = r0.root;	 Catch:{ all -> 0x00fb }
        r18 = r0;
        if (r18 == 0) goto L_0x012a;
    L_0x0115:
        r22 = 0;
        r0 = r18;
        r1 = r27;
        r2 = r22;
        r15 = r0.findTreeNode(r10, r1, r2);	 Catch:{ all -> 0x00fb }
        if (r15 == 0) goto L_0x012a;
    L_0x0123:
        r0 = r15.val;	 Catch:{ all -> 0x00fb }
        r21 = r0;
        r22 = r21;
        goto L_0x00c1;
    L_0x012a:
        r0 = r28;
        r1 = r27;
        r21 = r0.apply(r1);	 Catch:{ all -> 0x00fb }
        if (r21 == 0) goto L_0x013e;
    L_0x0134:
        r4 = 1;
        r0 = r19;
        r1 = r27;
        r2 = r21;
        r0.putTreeVal(r10, r1, r2);	 Catch:{ all -> 0x00fb }
    L_0x013e:
        r22 = r21;
        goto L_0x00c1;
    L_0x0141:
        r13 = r14;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.computeIfAbsent(java.lang.Object, jersey.repackaged.jsr166e.ConcurrentHashMapV8$Fun):V");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V computeIfPresent(K r23, jersey.repackaged.jsr166e.ConcurrentHashMapV8.BiFun<? super K, ? super V, ? extends V> r24) {
        /*
        r22 = this;
        if (r23 == 0) goto L_0x0004;
    L_0x0002:
        if (r24 != 0) goto L_0x000a;
    L_0x0004:
        r20 = new java.lang.NullPointerException;
        r20.<init>();
        throw r20;
    L_0x000a:
        r20 = r23.hashCode();
        r11 = spread(r20);
        r19 = 0;
        r5 = 0;
        r4 = 0;
        r0 = r22;
        r0 = r0.table;
        r18 = r0;
    L_0x001c:
        if (r18 == 0) goto L_0x0023;
    L_0x001e:
        r0 = r18;
        r13 = r0.length;
        if (r13 != 0) goto L_0x0028;
    L_0x0023:
        r18 = r22.initTable();
        goto L_0x001c;
    L_0x0028:
        r20 = r13 + -1;
        r12 = r20 & r11;
        r0 = r18;
        r9 = tabAt(r0, r12);
        if (r9 != 0) goto L_0x0041;
    L_0x0034:
        if (r5 == 0) goto L_0x0040;
    L_0x0036:
        r0 = (long) r5;
        r20 = r0;
        r0 = r22;
        r1 = r20;
        r0.addCount(r1, r4);
    L_0x0040:
        return r19;
    L_0x0041:
        r10 = r9.hash;
        r20 = -1;
        r0 = r20;
        if (r10 != r0) goto L_0x0052;
    L_0x0049:
        r0 = r22;
        r1 = r18;
        r18 = r0.helpTransfer(r1, r9);
        goto L_0x001c;
    L_0x0052:
        monitor-enter(r9);
        r0 = r18;
        r20 = tabAt(r0, r12);	 Catch:{ all -> 0x009a }
        r0 = r20;
        if (r0 != r9) goto L_0x008e;
    L_0x005d:
        if (r10 < 0) goto L_0x00ab;
    L_0x005f:
        r4 = 1;
        r6 = r9;
        r15 = 0;
    L_0x0062:
        r0 = r6.hash;	 Catch:{ all -> 0x009a }
        r20 = r0;
        r0 = r20;
        if (r0 != r11) goto L_0x00a3;
    L_0x006a:
        r7 = r6.key;	 Catch:{ all -> 0x009a }
        r0 = r23;
        if (r7 == r0) goto L_0x007a;
    L_0x0070:
        if (r7 == 0) goto L_0x00a3;
    L_0x0072:
        r0 = r23;
        r20 = r0.equals(r7);	 Catch:{ all -> 0x009a }
        if (r20 == 0) goto L_0x00a3;
    L_0x007a:
        r0 = r6.val;	 Catch:{ all -> 0x009a }
        r20 = r0;
        r0 = r24;
        r1 = r23;
        r2 = r20;
        r19 = r0.apply(r1, r2);	 Catch:{ all -> 0x009a }
        if (r19 == 0) goto L_0x0092;
    L_0x008a:
        r0 = r19;
        r6.val = r0;	 Catch:{ all -> 0x009a }
    L_0x008e:
        monitor-exit(r9);	 Catch:{ all -> 0x009a }
        if (r4 == 0) goto L_0x001c;
    L_0x0091:
        goto L_0x0034;
    L_0x0092:
        r5 = -1;
        r8 = r6.next;	 Catch:{ all -> 0x009a }
        if (r15 == 0) goto L_0x009d;
    L_0x0097:
        r15.next = r8;	 Catch:{ all -> 0x009a }
        goto L_0x008e;
    L_0x009a:
        r20 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x009a }
        throw r20;
    L_0x009d:
        r0 = r18;
        setTabAt(r0, r12, r8);	 Catch:{ all -> 0x009a }
        goto L_0x008e;
    L_0x00a3:
        r15 = r6;
        r6 = r6.next;	 Catch:{ all -> 0x009a }
        if (r6 == 0) goto L_0x008e;
    L_0x00a8:
        r4 = r4 + 1;
        goto L_0x0062;
    L_0x00ab:
        r0 = r9 instanceof jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin;	 Catch:{ all -> 0x009a }
        r20 = r0;
        if (r20 == 0) goto L_0x008e;
    L_0x00b1:
        r4 = 2;
        r0 = r9;
        r0 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin) r0;	 Catch:{ all -> 0x009a }
        r17 = r0;
        r0 = r17;
        r0 = r0.root;	 Catch:{ all -> 0x009a }
        r16 = r0;
        if (r16 == 0) goto L_0x008e;
    L_0x00bf:
        r20 = 0;
        r0 = r16;
        r1 = r23;
        r2 = r20;
        r14 = r0.findTreeNode(r11, r1, r2);	 Catch:{ all -> 0x009a }
        if (r14 == 0) goto L_0x008e;
    L_0x00cd:
        r0 = r14.val;	 Catch:{ all -> 0x009a }
        r20 = r0;
        r0 = r24;
        r1 = r23;
        r2 = r20;
        r19 = r0.apply(r1, r2);	 Catch:{ all -> 0x009a }
        if (r19 == 0) goto L_0x00e2;
    L_0x00dd:
        r0 = r19;
        r14.val = r0;	 Catch:{ all -> 0x009a }
        goto L_0x008e;
    L_0x00e2:
        r5 = -1;
        r0 = r17;
        r20 = r0.removeTreeNode(r14);	 Catch:{ all -> 0x009a }
        if (r20 == 0) goto L_0x008e;
    L_0x00eb:
        r0 = r17;
        r0 = r0.first;	 Catch:{ all -> 0x009a }
        r20 = r0;
        r20 = untreeify(r20);	 Catch:{ all -> 0x009a }
        r0 = r18;
        r1 = r20;
        setTabAt(r0, r12, r1);	 Catch:{ all -> 0x009a }
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.computeIfPresent(java.lang.Object, jersey.repackaged.jsr166e.ConcurrentHashMapV8$BiFun):V");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V compute(K r29, jersey.repackaged.jsr166e.ConcurrentHashMapV8.BiFun<? super K, ? super V, ? extends V> r30) {
        /*
        r28 = this;
        if (r29 == 0) goto L_0x0004;
    L_0x0002:
        if (r30 != 0) goto L_0x000a;
    L_0x0004:
        r24 = new java.lang.NullPointerException;
        r24.<init>();
        throw r24;
    L_0x000a:
        r24 = r29.hashCode();
        r11 = spread(r24);
        r23 = 0;
        r5 = 0;
        r4 = 0;
        r0 = r28;
        r0 = r0.table;
        r22 = r0;
        r24 = r23;
    L_0x001e:
        if (r22 == 0) goto L_0x0025;
    L_0x0020:
        r0 = r22;
        r13 = r0.length;
        if (r13 != 0) goto L_0x002a;
    L_0x0025:
        r22 = r28.initTable();
        goto L_0x001e;
    L_0x002a:
        r25 = r13 + -1;
        r12 = r25 & r11;
        r0 = r22;
        r9 = tabAt(r0, r12);
        if (r9 != 0) goto L_0x0089;
    L_0x0036:
        r19 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$ReservationNode;
        r19.<init>();
        monitor-enter(r19);
        r25 = 0;
        r0 = r22;
        r1 = r25;
        r2 = r19;
        r25 = casTabAt(r0, r12, r1, r2);	 Catch:{ all -> 0x0086 }
        if (r25 == 0) goto L_0x006f;
    L_0x004a:
        r4 = 1;
        r15 = 0;
        r24 = 0;
        r0 = r30;
        r1 = r29;
        r2 = r24;
        r23 = r0.apply(r1, r2);	 Catch:{ all -> 0x007f }
        if (r23 == 0) goto L_0x01a1;
    L_0x005a:
        r5 = 1;
        r14 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;	 Catch:{ all -> 0x007f }
        r24 = 0;
        r0 = r29;
        r1 = r23;
        r2 = r24;
        r14.<init>(r11, r0, r1, r2);	 Catch:{ all -> 0x007f }
    L_0x0068:
        r0 = r22;
        setTabAt(r0, r12, r14);	 Catch:{ all -> 0x0086 }
        r24 = r23;
    L_0x006f:
        monitor-exit(r19);	 Catch:{ all -> 0x0086 }
        if (r4 == 0) goto L_0x001e;
    L_0x0072:
        if (r5 == 0) goto L_0x007e;
    L_0x0074:
        r0 = (long) r5;
        r26 = r0;
        r0 = r28;
        r1 = r26;
        r0.addCount(r1, r4);
    L_0x007e:
        return r24;
    L_0x007f:
        r24 = move-exception;
        r0 = r22;
        setTabAt(r0, r12, r15);	 Catch:{ all -> 0x0086 }
        throw r24;	 Catch:{ all -> 0x0086 }
    L_0x0086:
        r24 = move-exception;
        monitor-exit(r19);	 Catch:{ all -> 0x0086 }
        throw r24;
    L_0x0089:
        r10 = r9.hash;
        r25 = -1;
        r0 = r25;
        if (r10 != r0) goto L_0x009a;
    L_0x0091:
        r0 = r28;
        r1 = r22;
        r22 = r0.helpTransfer(r1, r9);
        goto L_0x001e;
    L_0x009a:
        monitor-enter(r9);
        r0 = r22;
        r25 = tabAt(r0, r12);	 Catch:{ all -> 0x00f4 }
        r0 = r25;
        if (r0 != r9) goto L_0x00d9;
    L_0x00a5:
        if (r10 < 0) goto L_0x012b;
    L_0x00a7:
        r4 = 1;
        r6 = r9;
        r17 = 0;
    L_0x00ab:
        r0 = r6.hash;	 Catch:{ all -> 0x00f4 }
        r24 = r0;
        r0 = r24;
        if (r0 != r11) goto L_0x00fd;
    L_0x00b3:
        r7 = r6.key;	 Catch:{ all -> 0x00f4 }
        r0 = r29;
        if (r7 == r0) goto L_0x00c3;
    L_0x00b9:
        if (r7 == 0) goto L_0x00fd;
    L_0x00bb:
        r0 = r29;
        r24 = r0.equals(r7);	 Catch:{ all -> 0x00f4 }
        if (r24 == 0) goto L_0x00fd;
    L_0x00c3:
        r0 = r6.val;	 Catch:{ all -> 0x00f4 }
        r24 = r0;
        r0 = r30;
        r1 = r29;
        r2 = r24;
        r23 = r0.apply(r1, r2);	 Catch:{ all -> 0x00f4 }
        if (r23 == 0) goto L_0x00ea;
    L_0x00d3:
        r0 = r23;
        r6.val = r0;	 Catch:{ all -> 0x00f4 }
    L_0x00d7:
        r24 = r23;
    L_0x00d9:
        monitor-exit(r9);	 Catch:{ all -> 0x00f4 }
        if (r4 == 0) goto L_0x001e;
    L_0x00dc:
        r25 = 8;
        r0 = r25;
        if (r4 < r0) goto L_0x0072;
    L_0x00e2:
        r0 = r28;
        r1 = r22;
        r0.treeifyBin(r1, r12);
        goto L_0x0072;
    L_0x00ea:
        r5 = -1;
        r8 = r6.next;	 Catch:{ all -> 0x00f4 }
        if (r17 == 0) goto L_0x00f7;
    L_0x00ef:
        r0 = r17;
        r0.next = r8;	 Catch:{ all -> 0x00f4 }
        goto L_0x00d7;
    L_0x00f4:
        r24 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00f4 }
        throw r24;
    L_0x00f7:
        r0 = r22;
        setTabAt(r0, r12, r8);	 Catch:{ all -> 0x00f4 }
        goto L_0x00d7;
    L_0x00fd:
        r17 = r6;
        r6 = r6.next;	 Catch:{ all -> 0x00f4 }
        if (r6 != 0) goto L_0x0128;
    L_0x0103:
        r24 = 0;
        r0 = r30;
        r1 = r29;
        r2 = r24;
        r23 = r0.apply(r1, r2);	 Catch:{ all -> 0x00f4 }
        if (r23 == 0) goto L_0x00d7;
    L_0x0111:
        r5 = 1;
        r24 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;	 Catch:{ all -> 0x00f4 }
        r25 = 0;
        r0 = r24;
        r1 = r29;
        r2 = r23;
        r3 = r25;
        r0.<init>(r11, r1, r2, r3);	 Catch:{ all -> 0x00f4 }
        r0 = r24;
        r1 = r17;
        r1.next = r0;	 Catch:{ all -> 0x00f4 }
        goto L_0x00d7;
    L_0x0128:
        r4 = r4 + 1;
        goto L_0x00ab;
    L_0x012b:
        r0 = r9 instanceof jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin;	 Catch:{ all -> 0x00f4 }
        r25 = r0;
        if (r25 == 0) goto L_0x00d9;
    L_0x0131:
        r4 = 1;
        r0 = r9;
        r0 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin) r0;	 Catch:{ all -> 0x00f4 }
        r21 = r0;
        r0 = r21;
        r0 = r0.root;	 Catch:{ all -> 0x00f4 }
        r20 = r0;
        if (r20 == 0) goto L_0x0167;
    L_0x013f:
        r24 = 0;
        r0 = r20;
        r1 = r29;
        r2 = r24;
        r16 = r0.findTreeNode(r11, r1, r2);	 Catch:{ all -> 0x00f4 }
    L_0x014b:
        if (r16 != 0) goto L_0x016a;
    L_0x014d:
        r18 = 0;
    L_0x014f:
        r0 = r30;
        r1 = r29;
        r2 = r18;
        r23 = r0.apply(r1, r2);	 Catch:{ all -> 0x00f4 }
        if (r23 == 0) goto L_0x017f;
    L_0x015b:
        if (r16 == 0) goto L_0x0171;
    L_0x015d:
        r0 = r23;
        r1 = r16;
        r1.val = r0;	 Catch:{ all -> 0x00f4 }
        r24 = r23;
        goto L_0x00d9;
    L_0x0167:
        r16 = 0;
        goto L_0x014b;
    L_0x016a:
        r0 = r16;
        r0 = r0.val;	 Catch:{ all -> 0x00f4 }
        r18 = r0;
        goto L_0x014f;
    L_0x0171:
        r5 = 1;
        r0 = r21;
        r1 = r29;
        r2 = r23;
        r0.putTreeVal(r11, r1, r2);	 Catch:{ all -> 0x00f4 }
        r24 = r23;
        goto L_0x00d9;
    L_0x017f:
        if (r16 == 0) goto L_0x019d;
    L_0x0181:
        r5 = -1;
        r0 = r21;
        r1 = r16;
        r24 = r0.removeTreeNode(r1);	 Catch:{ all -> 0x00f4 }
        if (r24 == 0) goto L_0x019d;
    L_0x018c:
        r0 = r21;
        r0 = r0.first;	 Catch:{ all -> 0x00f4 }
        r24 = r0;
        r24 = untreeify(r24);	 Catch:{ all -> 0x00f4 }
        r0 = r22;
        r1 = r24;
        setTabAt(r0, r12, r1);	 Catch:{ all -> 0x00f4 }
    L_0x019d:
        r24 = r23;
        goto L_0x00d9;
    L_0x01a1:
        r14 = r15;
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.compute(java.lang.Object, jersey.repackaged.jsr166e.ConcurrentHashMapV8$BiFun):V");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V merge(K r25, V r26, jersey.repackaged.jsr166e.ConcurrentHashMapV8.BiFun<? super V, ? super V, ? extends V> r27) {
        /*
        r24 = this;
        if (r25 == 0) goto L_0x0006;
    L_0x0002:
        if (r26 == 0) goto L_0x0006;
    L_0x0004:
        if (r27 != 0) goto L_0x000c;
    L_0x0006:
        r20 = new java.lang.NullPointerException;
        r20.<init>();
        throw r20;
    L_0x000c:
        r20 = r25.hashCode();
        r11 = spread(r20);
        r19 = 0;
        r5 = 0;
        r4 = 0;
        r0 = r24;
        r0 = r0.table;
        r18 = r0;
        r20 = r19;
    L_0x0020:
        if (r18 == 0) goto L_0x0027;
    L_0x0022:
        r0 = r18;
        r13 = r0.length;
        if (r13 != 0) goto L_0x002c;
    L_0x0027:
        r18 = r24.initTable();
        goto L_0x0020;
    L_0x002c:
        r21 = r13 + -1;
        r12 = r21 & r11;
        r0 = r18;
        r9 = tabAt(r0, r12);
        if (r9 != 0) goto L_0x0067;
    L_0x0038:
        r21 = 0;
        r22 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;
        r23 = 0;
        r0 = r22;
        r1 = r25;
        r2 = r26;
        r3 = r23;
        r0.<init>(r11, r1, r2, r3);
        r0 = r18;
        r1 = r21;
        r2 = r22;
        r21 = casTabAt(r0, r12, r1, r2);
        if (r21 == 0) goto L_0x0020;
    L_0x0055:
        r5 = 1;
        r19 = r26;
        r20 = r19;
    L_0x005a:
        if (r5 == 0) goto L_0x0066;
    L_0x005c:
        r0 = (long) r5;
        r22 = r0;
        r0 = r24;
        r1 = r22;
        r0.addCount(r1, r4);
    L_0x0066:
        return r20;
    L_0x0067:
        r10 = r9.hash;
        r21 = -1;
        r0 = r21;
        if (r10 != r0) goto L_0x0078;
    L_0x006f:
        r0 = r24;
        r1 = r18;
        r18 = r0.helpTransfer(r1, r9);
        goto L_0x0020;
    L_0x0078:
        monitor-enter(r9);
        r0 = r18;
        r21 = tabAt(r0, r12);	 Catch:{ all -> 0x00cf }
        r0 = r21;
        if (r0 != r9) goto L_0x00b6;
    L_0x0083:
        if (r10 < 0) goto L_0x00f7;
    L_0x0085:
        r4 = 1;
        r6 = r9;
        r15 = 0;
    L_0x0088:
        r0 = r6.hash;	 Catch:{ all -> 0x00cf }
        r20 = r0;
        r0 = r20;
        if (r0 != r11) goto L_0x00d8;
    L_0x0090:
        r7 = r6.key;	 Catch:{ all -> 0x00cf }
        r0 = r25;
        if (r7 == r0) goto L_0x00a0;
    L_0x0096:
        if (r7 == 0) goto L_0x00d8;
    L_0x0098:
        r0 = r25;
        r20 = r0.equals(r7);	 Catch:{ all -> 0x00cf }
        if (r20 == 0) goto L_0x00d8;
    L_0x00a0:
        r0 = r6.val;	 Catch:{ all -> 0x00cf }
        r20 = r0;
        r0 = r27;
        r1 = r20;
        r2 = r26;
        r19 = r0.apply(r1, r2);	 Catch:{ all -> 0x00cf }
        if (r19 == 0) goto L_0x00c7;
    L_0x00b0:
        r0 = r19;
        r6.val = r0;	 Catch:{ all -> 0x00cf }
    L_0x00b4:
        r20 = r19;
    L_0x00b6:
        monitor-exit(r9);	 Catch:{ all -> 0x00cf }
        if (r4 == 0) goto L_0x0020;
    L_0x00b9:
        r21 = 8;
        r0 = r21;
        if (r4 < r0) goto L_0x005a;
    L_0x00bf:
        r0 = r24;
        r1 = r18;
        r0.treeifyBin(r1, r12);
        goto L_0x005a;
    L_0x00c7:
        r5 = -1;
        r8 = r6.next;	 Catch:{ all -> 0x00cf }
        if (r15 == 0) goto L_0x00d2;
    L_0x00cc:
        r15.next = r8;	 Catch:{ all -> 0x00cf }
        goto L_0x00b4;
    L_0x00cf:
        r20 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00cf }
        throw r20;
    L_0x00d2:
        r0 = r18;
        setTabAt(r0, r12, r8);	 Catch:{ all -> 0x00cf }
        goto L_0x00b4;
    L_0x00d8:
        r15 = r6;
        r6 = r6.next;	 Catch:{ all -> 0x00cf }
        if (r6 != 0) goto L_0x00f4;
    L_0x00dd:
        r5 = 1;
        r19 = r26;
        r20 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;	 Catch:{ all -> 0x00cf }
        r21 = 0;
        r0 = r20;
        r1 = r25;
        r2 = r19;
        r3 = r21;
        r0.<init>(r11, r1, r2, r3);	 Catch:{ all -> 0x00cf }
        r0 = r20;
        r15.next = r0;	 Catch:{ all -> 0x00cf }
        goto L_0x00b4;
    L_0x00f4:
        r4 = r4 + 1;
        goto L_0x0088;
    L_0x00f7:
        r0 = r9 instanceof jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin;	 Catch:{ all -> 0x00cf }
        r21 = r0;
        if (r21 == 0) goto L_0x00b6;
    L_0x00fd:
        r4 = 2;
        r0 = r9;
        r0 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin) r0;	 Catch:{ all -> 0x00cf }
        r17 = r0;
        r0 = r17;
        r0 = r0.root;	 Catch:{ all -> 0x00cf }
        r16 = r0;
        if (r16 != 0) goto L_0x011b;
    L_0x010b:
        r14 = 0;
    L_0x010c:
        if (r14 != 0) goto L_0x0128;
    L_0x010e:
        r19 = r26;
    L_0x0110:
        if (r19 == 0) goto L_0x0145;
    L_0x0112:
        if (r14 == 0) goto L_0x0137;
    L_0x0114:
        r0 = r19;
        r14.val = r0;	 Catch:{ all -> 0x00cf }
        r20 = r19;
        goto L_0x00b6;
    L_0x011b:
        r20 = 0;
        r0 = r16;
        r1 = r25;
        r2 = r20;
        r14 = r0.findTreeNode(r11, r1, r2);	 Catch:{ all -> 0x00cf }
        goto L_0x010c;
    L_0x0128:
        r0 = r14.val;	 Catch:{ all -> 0x00cf }
        r20 = r0;
        r0 = r27;
        r1 = r20;
        r2 = r26;
        r19 = r0.apply(r1, r2);	 Catch:{ all -> 0x00cf }
        goto L_0x0110;
    L_0x0137:
        r5 = 1;
        r0 = r17;
        r1 = r25;
        r2 = r19;
        r0.putTreeVal(r11, r1, r2);	 Catch:{ all -> 0x00cf }
        r20 = r19;
        goto L_0x00b6;
    L_0x0145:
        if (r14 == 0) goto L_0x0161;
    L_0x0147:
        r5 = -1;
        r0 = r17;
        r20 = r0.removeTreeNode(r14);	 Catch:{ all -> 0x00cf }
        if (r20 == 0) goto L_0x0161;
    L_0x0150:
        r0 = r17;
        r0 = r0.first;	 Catch:{ all -> 0x00cf }
        r20 = r0;
        r20 = untreeify(r20);	 Catch:{ all -> 0x00cf }
        r0 = r18;
        r1 = r20;
        setTabAt(r0, r12, r1);	 Catch:{ all -> 0x00cf }
    L_0x0161:
        r20 = r19;
        goto L_0x00b6;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.merge(java.lang.Object, java.lang.Object, jersey.repackaged.jsr166e.ConcurrentHashMapV8$BiFun):V");
    }

    @Deprecated
    public boolean contains(Object value) {
        return containsValue(value);
    }

    public Enumeration<K> keys() {
        Node<K, V>[] t = this.table;
        int f = t == null ? RESIZE_STAMP_SHIFT : t.length;
        return new KeyIterator(t, f, RESIZE_STAMP_SHIFT, f, this);
    }

    public Enumeration<V> elements() {
        Node<K, V>[] t = this.table;
        int f = t == null ? RESIZE_STAMP_SHIFT : t.length;
        return new ValueIterator(t, f, RESIZE_STAMP_SHIFT, f, this);
    }

    public long mappingCount() {
        long n = sumCount();
        return n < TRANSFERINDEX ? TRANSFERINDEX : n;
    }

    public static <K> KeySetView<K, Boolean> newKeySet() {
        return new KeySetView(new ConcurrentHashMapV8(), Boolean.TRUE);
    }

    public static <K> KeySetView<K, Boolean> newKeySet(int initialCapacity) {
        return new KeySetView(new ConcurrentHashMapV8(initialCapacity), Boolean.TRUE);
    }

    public KeySetView<K, V> keySet(V mappedValue) {
        if (mappedValue != null) {
            return new KeySetView(this, mappedValue);
        }
        throw new NullPointerException();
    }

    static final int resizeStamp(int n) {
        return Integer.numberOfLeadingZeros(n) | (1 << (RESIZE_STAMP_BITS + MOVED));
    }

    private final Node<K, V>[] initTable() {
        Node<K, V>[] tab;
        int sc;
        while (true) {
            tab = this.table;
            if (tab != null && tab.length != 0) {
                break;
            }
            sc = this.sizeCtl;
            if (sc < 0) {
                Thread.yield();
            } else if (f22U.compareAndSwapInt(this, SIZECTL, sc, MOVED)) {
                try {
                    break;
                } catch (Throwable th) {
                    this.sizeCtl = sc;
                }
            }
        }
        tab = this.table;
        if (tab == null || tab.length == 0) {
            int n = sc > 0 ? sc : MIN_TRANSFER_STRIDE;
            Node<K, V>[] nt = (Node[]) new Node[n];
            tab = nt;
            this.table = nt;
            sc = n - (n >>> 2);
        }
        this.sizeCtl = sc;
        return tab;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addCount(long r36, int r38) {
        /*
        r35 = this;
        r0 = r35;
        r0 = r0.counterCells;
        r26 = r0;
        if (r26 != 0) goto L_0x001a;
    L_0x0008:
        r6 = f22U;
        r8 = BASECOUNT;
        r0 = r35;
        r10 = r0.baseCount;
        r12 = r10 + r36;
        r7 = r35;
        r6 = r6.compareAndSwapLong(r7, r8, r10, r12);
        if (r6 != 0) goto L_0x005e;
    L_0x001a:
        r33 = 1;
        r6 = threadCounterHashCode;
        r27 = r6.get();
        r27 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.CounterHashCode) r27;
        if (r27 == 0) goto L_0x0049;
    L_0x0026:
        if (r26 == 0) goto L_0x0049;
    L_0x0028:
        r0 = r26;
        r6 = r0.length;
        r28 = r6 + -1;
        if (r28 < 0) goto L_0x0049;
    L_0x002f:
        r0 = r27;
        r6 = r0.code;
        r6 = r6 & r28;
        r15 = r26[r6];
        if (r15 == 0) goto L_0x0049;
    L_0x0039:
        r14 = f22U;
        r16 = CELLVALUE;
        r0 = r15.value;
        r18 = r0;
        r20 = r18 + r36;
        r33 = r14.compareAndSwapLong(r15, r16, r18, r20);
        if (r33 != 0) goto L_0x0055;
    L_0x0049:
        r0 = r35;
        r1 = r36;
        r3 = r27;
        r4 = r33;
        r0.fullAddCount(r1, r3, r4);
    L_0x0054:
        return;
    L_0x0055:
        r6 = 1;
        r0 = r38;
        if (r0 <= r6) goto L_0x0054;
    L_0x005a:
        r12 = r35.sumCount();
    L_0x005e:
        if (r38 < 0) goto L_0x0054;
    L_0x0060:
        r0 = r35;
        r0 = r0.sizeCtl;
        r24 = r0;
        r0 = r24;
        r6 = (long) r0;
        r6 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));
        if (r6 < 0) goto L_0x0054;
    L_0x006d:
        r0 = r35;
        r0 = r0.table;
        r32 = r0;
        if (r32 == 0) goto L_0x0054;
    L_0x0075:
        r0 = r32;
        r0 = r0.length;
        r29 = r0;
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = r29;
        if (r0 >= r6) goto L_0x0054;
    L_0x0080:
        r31 = resizeStamp(r29);
        if (r24 >= 0) goto L_0x00c6;
    L_0x0086:
        r6 = RESIZE_STAMP_SHIFT;
        r6 = r24 >>> r6;
        r0 = r31;
        if (r6 != r0) goto L_0x0054;
    L_0x008e:
        r6 = r31 + 1;
        r0 = r24;
        if (r0 == r6) goto L_0x0054;
    L_0x0094:
        r6 = MAX_RESIZERS;
        r6 = r6 + r31;
        r0 = r24;
        if (r0 == r6) goto L_0x0054;
    L_0x009c:
        r0 = r35;
        r0 = r0.nextTable;
        r30 = r0;
        if (r30 == 0) goto L_0x0054;
    L_0x00a4:
        r0 = r35;
        r6 = r0.transferIndex;
        if (r6 <= 0) goto L_0x0054;
    L_0x00aa:
        r20 = f22U;
        r22 = SIZECTL;
        r25 = r24 + 1;
        r21 = r35;
        r6 = r20.compareAndSwapInt(r21, r22, r24, r25);
        if (r6 == 0) goto L_0x00c1;
    L_0x00b8:
        r0 = r35;
        r1 = r32;
        r2 = r30;
        r0.transfer(r1, r2);
    L_0x00c1:
        r12 = r35.sumCount();
        goto L_0x0060;
    L_0x00c6:
        r20 = f22U;
        r22 = SIZECTL;
        r6 = RESIZE_STAMP_SHIFT;
        r6 = r31 << r6;
        r25 = r6 + 2;
        r21 = r35;
        r6 = r20.compareAndSwapInt(r21, r22, r24, r25);
        if (r6 == 0) goto L_0x00c1;
    L_0x00d8:
        r6 = 0;
        r0 = r35;
        r1 = r32;
        r0.transfer(r1, r6);
        goto L_0x00c1;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.addCount(long, int):void");
    }

    final Node<K, V>[] helpTransfer(Node<K, V>[] tab, Node<K, V> f) {
        if (tab != null && (f instanceof ForwardingNode)) {
            Node<K, V>[] nextTab = ((ForwardingNode) f).nextTable;
            if (nextTab != null) {
                int rs = resizeStamp(tab.length);
                while (nextTab == this.nextTable && this.table == tab) {
                    int sc = this.sizeCtl;
                    if (sc >= 0 || (sc >>> RESIZE_STAMP_SHIFT) != rs || sc == rs + 1 || sc == MAX_RESIZERS + rs || this.transferIndex <= 0) {
                        return nextTab;
                    }
                    if (f22U.compareAndSwapInt(this, SIZECTL, sc, sc + 1)) {
                        transfer(tab, nextTab);
                        return nextTab;
                    }
                }
                return nextTab;
            }
        }
        return this.table;
    }

    private final void tryPresize(int size) {
        int c;
        if (size >= DriveFile.MODE_WRITE_ONLY) {
            c = MAXIMUM_CAPACITY;
        } else {
            c = tableSizeFor(((size >>> 1) + size) + 1);
        }
        while (true) {
            int sc = this.sizeCtl;
            if (sc >= 0) {
                int n;
                Node<K, V>[] tab = this.table;
                if (tab != null) {
                    n = tab.length;
                    if (n != 0) {
                        if (c > sc && n < MAXIMUM_CAPACITY) {
                            if (tab == this.table) {
                                int rs = resizeStamp(n);
                                if (sc >= 0) {
                                    if (f22U.compareAndSwapInt(this, SIZECTL, sc, (rs << RESIZE_STAMP_SHIFT) + 2)) {
                                        transfer(tab, null);
                                    }
                                } else if ((sc >>> RESIZE_STAMP_SHIFT) == rs && sc != rs + 1 && sc != MAX_RESIZERS + rs) {
                                    Node<K, V>[] nt = this.nextTable;
                                    if (nt != null && this.transferIndex > 0) {
                                        if (f22U.compareAndSwapInt(this, SIZECTL, sc, sc + 1)) {
                                            transfer(tab, nt);
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            continue;
                        } else {
                            return;
                        }
                    }
                }
                if (sc > c) {
                    n = sc;
                } else {
                    n = c;
                }
                if (f22U.compareAndSwapInt(this, SIZECTL, sc, MOVED)) {
                    try {
                        if (this.table == tab) {
                            this.table = (Node[]) new Node[n];
                            sc = n - (n >>> 2);
                        }
                        this.sizeCtl = sc;
                    } catch (Throwable th) {
                        this.sizeCtl = sc;
                    }
                } else {
                    continue;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void transfer(jersey.repackaged.jsr166e.ConcurrentHashMapV8.Node<K, V>[] r55, jersey.repackaged.jsr166e.ConcurrentHashMapV8.Node<K, V>[] r56) {
        /*
        r54 = this;
        r0 = r55;
        r0 = r0.length;
        r44 = r0;
        r6 = NCPU;
        r7 = 1;
        if (r6 <= r7) goto L_0x0055;
    L_0x000a:
        r6 = r44 >>> 3;
        r7 = NCPU;
        r52 = r6 / r7;
    L_0x0010:
        r6 = 16;
        r0 = r52;
        if (r0 >= r6) goto L_0x0018;
    L_0x0016:
        r52 = 16;
    L_0x0018:
        if (r56 != 0) goto L_0x0030;
    L_0x001a:
        r6 = r44 << 1;
        r0 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8.Node[r6];	 Catch:{ Throwable -> 0x0058 }
        r46 = r0;
        r46 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.Node[]) r46;	 Catch:{ Throwable -> 0x0058 }
        r56 = r46;
        r0 = r56;
        r1 = r54;
        r1.nextTable = r0;
        r0 = r44;
        r1 = r54;
        r1.transferIndex = r0;
    L_0x0030:
        r0 = r56;
        r0 = r0.length;
        r45 = r0;
        r31 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$ForwardingNode;
        r0 = r31;
        r1 = r56;
        r0.<init>(r1);
        r23 = 1;
        r30 = 0;
        r37 = 0;
        r25 = 0;
    L_0x0046:
        if (r23 == 0) goto L_0x0087;
    L_0x0048:
        r37 = r37 + -1;
        r0 = r37;
        r1 = r25;
        if (r0 >= r1) goto L_0x0052;
    L_0x0050:
        if (r30 == 0) goto L_0x0061;
    L_0x0052:
        r23 = 0;
        goto L_0x0046;
    L_0x0055:
        r52 = r44;
        goto L_0x0010;
    L_0x0058:
        r27 = move-exception;
        r6 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r0 = r54;
        r0.sizeCtl = r6;
    L_0x0060:
        return;
    L_0x0061:
        r0 = r54;
        r10 = r0.transferIndex;
        if (r10 > 0) goto L_0x006c;
    L_0x0067:
        r37 = -1;
        r23 = 0;
        goto L_0x0046;
    L_0x006c:
        r6 = f22U;
        r8 = TRANSFERINDEX;
        r0 = r52;
        if (r10 <= r0) goto L_0x0085;
    L_0x0074:
        r11 = r10 - r52;
    L_0x0076:
        r7 = r54;
        r6 = r6.compareAndSwapInt(r7, r8, r10, r11);
        if (r6 == 0) goto L_0x0046;
    L_0x007e:
        r25 = r11;
        r37 = r10 + -1;
        r23 = 0;
        goto L_0x0046;
    L_0x0085:
        r11 = 0;
        goto L_0x0076;
    L_0x0087:
        if (r37 < 0) goto L_0x0095;
    L_0x0089:
        r0 = r37;
        r1 = r44;
        if (r0 >= r1) goto L_0x0095;
    L_0x008f:
        r6 = r37 + r44;
        r0 = r45;
        if (r6 < r0) goto L_0x00d3;
    L_0x0095:
        if (r30 == 0) goto L_0x00ac;
    L_0x0097:
        r6 = 0;
        r0 = r54;
        r0.nextTable = r6;
        r0 = r56;
        r1 = r54;
        r1.table = r0;
        r6 = r44 << 1;
        r7 = r44 >>> 1;
        r6 = r6 - r7;
        r0 = r54;
        r0.sizeCtl = r6;
        goto L_0x0060;
    L_0x00ac:
        r12 = f22U;
        r14 = SIZECTL;
        r0 = r54;
        r0 = r0.sizeCtl;
        r16 = r0;
        r17 = r16 + -1;
        r13 = r54;
        r6 = r12.compareAndSwapInt(r13, r14, r16, r17);
        if (r6 == 0) goto L_0x0046;
    L_0x00c0:
        r6 = r16 + -2;
        r7 = resizeStamp(r44);
        r8 = RESIZE_STAMP_SHIFT;
        r7 = r7 << r8;
        if (r6 != r7) goto L_0x0060;
    L_0x00cb:
        r23 = 1;
        r30 = r23;
        r37 = r44;
        goto L_0x0046;
    L_0x00d3:
        r0 = r55;
        r1 = r37;
        r28 = tabAt(r0, r1);
        if (r28 != 0) goto L_0x00ea;
    L_0x00dd:
        r6 = 0;
        r0 = r55;
        r1 = r37;
        r2 = r31;
        r23 = casTabAt(r0, r1, r6, r2);
        goto L_0x0046;
    L_0x00ea:
        r0 = r28;
        r0 = r0.hash;
        r29 = r0;
        r6 = -1;
        r0 = r29;
        if (r0 != r6) goto L_0x00f9;
    L_0x00f5:
        r23 = 1;
        goto L_0x0046;
    L_0x00f9:
        monitor-enter(r28);
        r0 = r55;
        r1 = r37;
        r6 = tabAt(r0, r1);	 Catch:{ all -> 0x01a6 }
        r0 = r28;
        if (r6 != r0) goto L_0x01a3;
    L_0x0106:
        if (r29 < 0) goto L_0x01a9;
    L_0x0108:
        r51 = r29 & r44;
        r38 = r28;
        r0 = r28;
        r0 = r0.next;	 Catch:{ all -> 0x01a6 }
        r47 = r0;
    L_0x0112:
        if (r47 == 0) goto L_0x012b;
    L_0x0114:
        r0 = r47;
        r6 = r0.hash;	 Catch:{ all -> 0x01a6 }
        r24 = r6 & r44;
        r0 = r24;
        r1 = r51;
        if (r0 == r1) goto L_0x0124;
    L_0x0120:
        r51 = r24;
        r38 = r47;
    L_0x0124:
        r0 = r47;
        r0 = r0.next;	 Catch:{ all -> 0x01a6 }
        r47 = r0;
        goto L_0x0112;
    L_0x012b:
        if (r51 != 0) goto L_0x016f;
    L_0x012d:
        r40 = r38;
        r35 = 0;
    L_0x0131:
        r47 = r28;
        r36 = r35;
        r41 = r40;
    L_0x0137:
        r0 = r47;
        r1 = r38;
        if (r0 == r1) goto L_0x0186;
    L_0x013d:
        r0 = r47;
        r0 = r0.hash;	 Catch:{ all -> 0x01a6 }
        r48 = r0;
        r0 = r47;
        r0 = r0.key;	 Catch:{ all -> 0x01a6 }
        r49 = r0;
        r0 = r47;
        r0 = r0.val;	 Catch:{ all -> 0x01a6 }
        r50 = r0;
        r6 = r48 & r44;
        if (r6 != 0) goto L_0x0174;
    L_0x0153:
        r40 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;	 Catch:{ all -> 0x01a6 }
        r0 = r40;
        r1 = r48;
        r2 = r49;
        r3 = r50;
        r4 = r41;
        r0.<init>(r1, r2, r3, r4);	 Catch:{ all -> 0x01a6 }
        r35 = r36;
    L_0x0164:
        r0 = r47;
        r0 = r0.next;	 Catch:{ all -> 0x01a6 }
        r47 = r0;
        r36 = r35;
        r41 = r40;
        goto L_0x0137;
    L_0x016f:
        r35 = r38;
        r40 = 0;
        goto L_0x0131;
    L_0x0174:
        r35 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node;	 Catch:{ all -> 0x01a6 }
        r0 = r35;
        r1 = r48;
        r2 = r49;
        r3 = r50;
        r4 = r36;
        r0.<init>(r1, r2, r3, r4);	 Catch:{ all -> 0x01a6 }
        r40 = r41;
        goto L_0x0164;
    L_0x0186:
        r0 = r56;
        r1 = r37;
        r2 = r41;
        setTabAt(r0, r1, r2);	 Catch:{ all -> 0x01a6 }
        r6 = r37 + r44;
        r0 = r56;
        r1 = r36;
        setTabAt(r0, r6, r1);	 Catch:{ all -> 0x01a6 }
        r0 = r55;
        r1 = r37;
        r2 = r31;
        setTabAt(r0, r1, r2);	 Catch:{ all -> 0x01a6 }
        r23 = 1;
    L_0x01a3:
        monitor-exit(r28);	 Catch:{ all -> 0x01a6 }
        goto L_0x0046;
    L_0x01a6:
        r6 = move-exception;
        monitor-exit(r28);	 Catch:{ all -> 0x01a6 }
        throw r6;
    L_0x01a9:
        r0 = r28;
        r6 = r0 instanceof jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin;	 Catch:{ all -> 0x01a6 }
        if (r6 == 0) goto L_0x01a3;
    L_0x01af:
        r0 = r28;
        r0 = (jersey.repackaged.jsr166e.ConcurrentHashMapV8.TreeBin) r0;	 Catch:{ all -> 0x01a6 }
        r53 = r0;
        r42 = 0;
        r43 = 0;
        r33 = 0;
        r34 = 0;
        r39 = 0;
        r32 = 0;
        r0 = r53;
        r0 = r0.first;	 Catch:{ all -> 0x01a6 }
        r26 = r0;
    L_0x01c7:
        if (r26 == 0) goto L_0x021a;
    L_0x01c9:
        r0 = r26;
        r0 = r0.hash;	 Catch:{ all -> 0x01a6 }
        r18 = r0;
        r17 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$TreeNode;	 Catch:{ all -> 0x01a6 }
        r0 = r26;
        r0 = r0.key;	 Catch:{ all -> 0x01a6 }
        r19 = r0;
        r0 = r26;
        r0 = r0.val;	 Catch:{ all -> 0x01a6 }
        r20 = r0;
        r21 = 0;
        r22 = 0;
        r17.<init>(r18, r19, r20, r21, r22);	 Catch:{ all -> 0x01a6 }
        r6 = r18 & r44;
        if (r6 != 0) goto L_0x0204;
    L_0x01e8:
        r0 = r43;
        r1 = r17;
        r1.prev = r0;	 Catch:{ all -> 0x01a6 }
        if (r43 != 0) goto L_0x01fd;
    L_0x01f0:
        r42 = r17;
    L_0x01f2:
        r43 = r17;
        r39 = r39 + 1;
    L_0x01f6:
        r0 = r26;
        r0 = r0.next;	 Catch:{ all -> 0x01a6 }
        r26 = r0;
        goto L_0x01c7;
    L_0x01fd:
        r0 = r17;
        r1 = r43;
        r1.next = r0;	 Catch:{ all -> 0x01a6 }
        goto L_0x01f2;
    L_0x0204:
        r0 = r34;
        r1 = r17;
        r1.prev = r0;	 Catch:{ all -> 0x01a6 }
        if (r34 != 0) goto L_0x0213;
    L_0x020c:
        r33 = r17;
    L_0x020e:
        r34 = r17;
        r32 = r32 + 1;
        goto L_0x01f6;
    L_0x0213:
        r0 = r17;
        r1 = r34;
        r1.next = r0;	 Catch:{ all -> 0x01a6 }
        goto L_0x020e;
    L_0x021a:
        r6 = 6;
        r0 = r39;
        if (r0 > r6) goto L_0x024b;
    L_0x021f:
        r40 = untreeify(r42);	 Catch:{ all -> 0x01a6 }
    L_0x0223:
        r6 = 6;
        r0 = r32;
        if (r0 > r6) goto L_0x025a;
    L_0x0228:
        r35 = untreeify(r33);	 Catch:{ all -> 0x01a6 }
    L_0x022c:
        r0 = r56;
        r1 = r37;
        r2 = r40;
        setTabAt(r0, r1, r2);	 Catch:{ all -> 0x01a6 }
        r6 = r37 + r44;
        r0 = r56;
        r1 = r35;
        setTabAt(r0, r6, r1);	 Catch:{ all -> 0x01a6 }
        r0 = r55;
        r1 = r37;
        r2 = r31;
        setTabAt(r0, r1, r2);	 Catch:{ all -> 0x01a6 }
        r23 = 1;
        goto L_0x01a3;
    L_0x024b:
        if (r32 == 0) goto L_0x0257;
    L_0x024d:
        r40 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$TreeBin;	 Catch:{ all -> 0x01a6 }
        r0 = r40;
        r1 = r42;
        r0.<init>(r1);	 Catch:{ all -> 0x01a6 }
        goto L_0x0223;
    L_0x0257:
        r40 = r53;
        goto L_0x0223;
    L_0x025a:
        if (r39 == 0) goto L_0x0266;
    L_0x025c:
        r35 = new jersey.repackaged.jsr166e.ConcurrentHashMapV8$TreeBin;	 Catch:{ all -> 0x01a6 }
        r0 = r35;
        r1 = r33;
        r0.<init>(r1);	 Catch:{ all -> 0x01a6 }
        goto L_0x022c;
    L_0x0266:
        r35 = r53;
        goto L_0x022c;
        */
        throw new UnsupportedOperationException("Method not decompiled: jersey.repackaged.jsr166e.ConcurrentHashMapV8.transfer(jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node[], jersey.repackaged.jsr166e.ConcurrentHashMapV8$Node[]):void");
    }

    private final void treeifyBin(Node<K, V>[] tab, int index) {
        if (tab != null) {
            int n = tab.length;
            if (n < MIN_TREEIFY_CAPACITY) {
                tryPresize(n << 1);
                return;
            }
            Node<K, V> b = tabAt(tab, index);
            if (b != null && b.hash >= 0) {
                synchronized (b) {
                    if (tabAt(tab, index) == b) {
                        TreeNode<K, V> hd = null;
                        TreeNode<K, V> tl = null;
                        for (Node<K, V> e = b; e != null; e = e.next) {
                            TreeNode<K, V> p = new TreeNode(e.hash, e.key, e.val, null, null);
                            p.prev = tl;
                            if (tl == null) {
                                hd = p;
                            } else {
                                tl.next = p;
                            }
                            tl = p;
                        }
                        setTabAt(tab, index, new TreeBin(hd));
                    }
                }
            }
        }
    }

    static <K, V> Node<K, V> untreeify(Node<K, V> b) {
        Node<K, V> hd = null;
        Node<K, V> tl = null;
        for (Node<K, V> q = b; q != null; q = q.next) {
            Node<K, V> p = new Node(q.hash, q.key, q.val, null);
            if (tl == null) {
                hd = p;
            } else {
                tl.next = p;
            }
            tl = p;
        }
        return hd;
    }

    final int batchFor(long b) {
        if (b != Long.MAX_VALUE) {
            long n = sumCount();
            if (n > 1 && n >= b) {
                int sp = ForkJoinPool.getCommonPoolParallelism() << 2;
                if (b <= TRANSFERINDEX) {
                    return sp;
                }
                n /= b;
                return n < ((long) sp) ? (int) n : sp;
            }
        }
        return RESIZE_STAMP_SHIFT;
    }

    public void forEach(long parallelismThreshold, BiAction<? super K, ? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachMappingTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, action).invoke();
    }

    public <U> void forEach(long parallelismThreshold, BiFun<? super K, ? super V, ? extends U> transformer, Action<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedMappingTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, transformer, action).invoke();
    }

    public <U> U search(long parallelismThreshold, BiFun<? super K, ? super V, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return new SearchMappingsTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, searchFunction, new AtomicReference()).invoke();
    }

    public <U> U reduce(long parallelismThreshold, BiFun<? super K, ? super V, ? extends U> transformer, BiFun<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceMappingsTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, reducer).invoke();
    }

    public double reduceToDouble(long parallelismThreshold, ObjectByObjectToDouble<? super K, ? super V> transformer, double basis, DoubleByDoubleToDouble reducer) {
        if (transformer != null && reducer != null) {
            return ((Double) new MapReduceMappingsToDoubleTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).doubleValue();
        }
        throw new NullPointerException();
    }

    public long reduceToLong(long parallelismThreshold, ObjectByObjectToLong<? super K, ? super V> transformer, long basis, LongByLongToLong reducer) {
        if (transformer != null && reducer != null) {
            return ((Long) new MapReduceMappingsToLongTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).longValue();
        }
        throw new NullPointerException();
    }

    public int reduceToInt(long parallelismThreshold, ObjectByObjectToInt<? super K, ? super V> transformer, int basis, IntByIntToInt reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Integer) new MapReduceMappingsToIntTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).intValue();
    }

    public void forEachKey(long parallelismThreshold, Action<? super K> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachKeyTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, action).invoke();
    }

    public <U> void forEachKey(long parallelismThreshold, Fun<? super K, ? extends U> transformer, Action<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedKeyTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, transformer, action).invoke();
    }

    public <U> U searchKeys(long parallelismThreshold, Fun<? super K, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return new SearchKeysTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, searchFunction, new AtomicReference()).invoke();
    }

    public K reduceKeys(long parallelismThreshold, BiFun<? super K, ? super K, ? extends K> reducer) {
        if (reducer == null) {
            throw new NullPointerException();
        }
        return new ReduceKeysTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, reducer).invoke();
    }

    public <U> U reduceKeys(long parallelismThreshold, Fun<? super K, ? extends U> transformer, BiFun<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceKeysTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, reducer).invoke();
    }

    public double reduceKeysToDouble(long parallelismThreshold, ObjectToDouble<? super K> transformer, double basis, DoubleByDoubleToDouble reducer) {
        if (transformer != null && reducer != null) {
            return ((Double) new MapReduceKeysToDoubleTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).doubleValue();
        }
        throw new NullPointerException();
    }

    public long reduceKeysToLong(long parallelismThreshold, ObjectToLong<? super K> transformer, long basis, LongByLongToLong reducer) {
        if (transformer != null && reducer != null) {
            return ((Long) new MapReduceKeysToLongTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).longValue();
        }
        throw new NullPointerException();
    }

    public int reduceKeysToInt(long parallelismThreshold, ObjectToInt<? super K> transformer, int basis, IntByIntToInt reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Integer) new MapReduceKeysToIntTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).intValue();
    }

    public void forEachValue(long parallelismThreshold, Action<? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachValueTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, action).invoke();
    }

    public <U> void forEachValue(long parallelismThreshold, Fun<? super V, ? extends U> transformer, Action<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedValueTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, transformer, action).invoke();
    }

    public <U> U searchValues(long parallelismThreshold, Fun<? super V, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return new SearchValuesTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, searchFunction, new AtomicReference()).invoke();
    }

    public V reduceValues(long parallelismThreshold, BiFun<? super V, ? super V, ? extends V> reducer) {
        if (reducer == null) {
            throw new NullPointerException();
        }
        return new ReduceValuesTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, reducer).invoke();
    }

    public <U> U reduceValues(long parallelismThreshold, Fun<? super V, ? extends U> transformer, BiFun<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceValuesTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, reducer).invoke();
    }

    public double reduceValuesToDouble(long parallelismThreshold, ObjectToDouble<? super V> transformer, double basis, DoubleByDoubleToDouble reducer) {
        if (transformer != null && reducer != null) {
            return ((Double) new MapReduceValuesToDoubleTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).doubleValue();
        }
        throw new NullPointerException();
    }

    public long reduceValuesToLong(long parallelismThreshold, ObjectToLong<? super V> transformer, long basis, LongByLongToLong reducer) {
        if (transformer != null && reducer != null) {
            return ((Long) new MapReduceValuesToLongTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).longValue();
        }
        throw new NullPointerException();
    }

    public int reduceValuesToInt(long parallelismThreshold, ObjectToInt<? super V> transformer, int basis, IntByIntToInt reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Integer) new MapReduceValuesToIntTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).intValue();
    }

    public void forEachEntry(long parallelismThreshold, Action<? super Entry<K, V>> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachEntryTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, action).invoke();
    }

    public <U> void forEachEntry(long parallelismThreshold, Fun<Entry<K, V>, ? extends U> transformer, Action<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedEntryTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, transformer, action).invoke();
    }

    public <U> U searchEntries(long parallelismThreshold, Fun<Entry<K, V>, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return new SearchEntriesTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, searchFunction, new AtomicReference()).invoke();
    }

    public Entry<K, V> reduceEntries(long parallelismThreshold, BiFun<Entry<K, V>, Entry<K, V>, ? extends Entry<K, V>> reducer) {
        if (reducer == null) {
            throw new NullPointerException();
        }
        return (Entry) new ReduceEntriesTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, reducer).invoke();
    }

    public <U> U reduceEntries(long parallelismThreshold, Fun<Entry<K, V>, ? extends U> transformer, BiFun<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceEntriesTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, reducer).invoke();
    }

    public double reduceEntriesToDouble(long parallelismThreshold, ObjectToDouble<Entry<K, V>> transformer, double basis, DoubleByDoubleToDouble reducer) {
        if (transformer != null && reducer != null) {
            return ((Double) new MapReduceEntriesToDoubleTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).doubleValue();
        }
        throw new NullPointerException();
    }

    public long reduceEntriesToLong(long parallelismThreshold, ObjectToLong<Entry<K, V>> transformer, long basis, LongByLongToLong reducer) {
        if (transformer != null && reducer != null) {
            return ((Long) new MapReduceEntriesToLongTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).longValue();
        }
        throw new NullPointerException();
    }

    public int reduceEntriesToInt(long parallelismThreshold, ObjectToInt<Entry<K, V>> transformer, int basis, IntByIntToInt reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return ((Integer) new MapReduceEntriesToIntTask(null, batchFor(parallelismThreshold), RESIZE_STAMP_SHIFT, RESIZE_STAMP_SHIFT, this.table, null, transformer, basis, reducer).invoke()).intValue();
    }

    final long sumCount() {
        CounterCell[] as = this.counterCells;
        long sum = this.baseCount;
        if (as != null) {
            for (int i = RESIZE_STAMP_SHIFT; i < as.length; i++) {
                CounterCell a = as[i];
                if (a != null) {
                    sum += a.value;
                }
            }
        }
        return sum;
    }

    private final void fullAddCount(long x, CounterHashCode hc, boolean wasUncontended) {
        int h;
        if (hc == null) {
            hc = new CounterHashCode();
            int s = counterHashCodeGenerator.addAndGet(SEED_INCREMENT);
            if (s == 0) {
                h = 1;
            } else {
                h = s;
            }
            hc.code = h;
            threadCounterHashCode.set(hc);
        } else {
            h = hc.code;
        }
        boolean collide = false;
        while (true) {
            long v;
            CounterCell[] rs;
            CounterCell[] as = this.counterCells;
            if (as != null) {
                int n = as.length;
                if (n > 0) {
                    CounterCell a = as[(n + MOVED) & h];
                    if (a != null) {
                        if (wasUncontended) {
                            Unsafe unsafe = f22U;
                            long j = CELLVALUE;
                            v = a.value;
                            if (unsafe.compareAndSwapLong(a, j, v, v + x)) {
                                break;
                            } else if (this.counterCells != as || n >= NCPU) {
                                collide = false;
                            } else if (!collide) {
                                collide = true;
                            } else if (this.cellsBusy == 0 && f22U.compareAndSwapInt(this, CELLSBUSY, RESIZE_STAMP_SHIFT, 1)) {
                                try {
                                    if (this.counterCells == as) {
                                        rs = new CounterCell[(n << 1)];
                                        for (int i = RESIZE_STAMP_SHIFT; i < n; i++) {
                                            rs[i] = as[i];
                                        }
                                        this.counterCells = rs;
                                    }
                                    this.cellsBusy = RESIZE_STAMP_SHIFT;
                                    collide = false;
                                } catch (Throwable th) {
                                    this.cellsBusy = RESIZE_STAMP_SHIFT;
                                }
                            }
                        } else {
                            wasUncontended = true;
                        }
                    } else {
                        if (this.cellsBusy == 0) {
                            CounterCell counterCell = new CounterCell(x);
                            if (this.cellsBusy == 0 && f22U.compareAndSwapInt(this, CELLSBUSY, RESIZE_STAMP_SHIFT, 1)) {
                                boolean created = false;
                                try {
                                    rs = this.counterCells;
                                    if (rs != null) {
                                        int m = rs.length;
                                        if (m > 0) {
                                            int j2 = (m + MOVED) & h;
                                            if (rs[j2] == null) {
                                                rs[j2] = counterCell;
                                                created = true;
                                            }
                                        }
                                    }
                                    this.cellsBusy = RESIZE_STAMP_SHIFT;
                                    if (created) {
                                        break;
                                    }
                                } catch (Throwable th2) {
                                    this.cellsBusy = RESIZE_STAMP_SHIFT;
                                }
                            }
                        }
                        collide = false;
                    }
                    h ^= h << 13;
                    h ^= h >>> 17;
                    h ^= h << 5;
                }
            }
            if (this.cellsBusy == 0 && this.counterCells == as && f22U.compareAndSwapInt(this, CELLSBUSY, RESIZE_STAMP_SHIFT, 1)) {
                boolean init = false;
                try {
                    if (this.counterCells == as) {
                        rs = new CounterCell[2];
                        rs[h & 1] = new CounterCell(x);
                        this.counterCells = rs;
                        init = true;
                    }
                    this.cellsBusy = RESIZE_STAMP_SHIFT;
                    if (init) {
                        break;
                    }
                } catch (Throwable th3) {
                    this.cellsBusy = RESIZE_STAMP_SHIFT;
                }
            } else {
                Unsafe unsafe2 = f22U;
                long j3 = BASECOUNT;
                v = this.baseCount;
                if (unsafe2.compareAndSwapLong(this, j3, v, v + x)) {
                    break;
                }
            }
        }
        hc.code = h;
    }

    private static Unsafe getUnsafe() {
        Unsafe unsafe;
        try {
            unsafe = Unsafe.getUnsafe();
        } catch (SecurityException e) {
            try {
                unsafe = (Unsafe) AccessController.doPrivileged(new 1());
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }
        return unsafe;
    }
}
