package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.zzahp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {
    private final Context mContext;
    private final LayoutInflater mInflater;
    private final int zzaPY;
    private int zzaPZ;
    private final int zzaQa;
    private final List<DataBuffer<T>> zzaQb;
    private boolean zzaQc;

    public DataBufferAdapter(Context context, int i) {
        this(context, i, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2) {
        this(context, i, i2, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2, List<DataBuffer<T>> list) {
        this.zzaQc = true;
        this.mContext = context;
        this.zzaPZ = i;
        this.zzaPY = i;
        this.zzaQa = i2;
        this.zzaQb = list;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int i, int i2, DataBuffer<T>... dataBufferArr) {
        this(context, i, i2, Arrays.asList(dataBufferArr));
    }

    public DataBufferAdapter(Context context, int i, List<DataBuffer<T>> list) {
        this(context, i, 0, (List) list);
    }

    public DataBufferAdapter(Context context, int i, DataBuffer<T>... dataBufferArr) {
        this(context, i, 0, Arrays.asList(dataBufferArr));
    }

    private View zza(int i, View view, ViewGroup viewGroup, int i2) {
        View inflate = view == null ? this.mInflater.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.zzaQa == 0 ? (TextView) inflate : (TextView) inflate.findViewById(this.zzaQa);
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return inflate;
        } catch (Throwable e) {
            zzahp.zza("DataBufferAdapter", e, "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> dataBuffer) {
        this.zzaQb.add(dataBuffer);
        if (this.zzaQc) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer release : this.zzaQb) {
            release.release();
        }
        this.zzaQb.clear();
        if (this.zzaQc) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        int i = 0;
        for (DataBuffer count : this.zzaQb) {
            i = count.getCount() + i;
        }
        return i;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.zzaPZ);
    }

    public T getItem(int i) throws CursorIndexOutOfBoundsException {
        int i2 = i;
        for (DataBuffer dataBuffer : this.zzaQb) {
            int count = dataBuffer.getCount();
            if (count <= i2) {
                i2 -= count;
            } else {
                try {
                    return dataBuffer.get(i2);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(i, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(i, getCount());
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.zzaPY);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.zzaQc = true;
    }

    public void setDropDownViewResource(int i) {
        this.zzaPZ = i;
    }

    public void setNotifyOnChange(boolean z) {
        this.zzaQc = z;
    }
}
