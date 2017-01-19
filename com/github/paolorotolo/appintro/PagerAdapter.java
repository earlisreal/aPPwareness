package com.github.paolorotolo.appintro;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private Map<Integer, Fragment> retainedFragments;

    public PagerAdapter(FragmentManager fm, @NonNull List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        this.retainedFragments = new HashMap();
    }

    public Fragment getItem(int position) {
        if (this.retainedFragments.containsKey(Integer.valueOf(position))) {
            return (Fragment) this.retainedFragments.get(Integer.valueOf(position));
        }
        return (Fragment) this.fragments.get(position);
    }

    public int getCount() {
        return this.fragments.size();
    }

    @NonNull
    public List<Fragment> getFragments() {
        return this.fragments;
    }

    @NonNull
    public Collection<Fragment> getRetainedFragments() {
        return this.retainedFragments.values();
    }

    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        this.retainedFragments.put(Integer.valueOf(position), fragment);
        return fragment;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        if (this.retainedFragments.containsKey(Integer.valueOf(position))) {
            this.retainedFragments.remove(Integer.valueOf(position));
        }
        super.destroyItem(container, position, object);
    }
}
