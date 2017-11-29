package com.dou.kotlinexam.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nnbinh on 11/27/17.
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder<T>> {
    private boolean animationsLocked = false;
    private boolean delayEnterAnimation = true;
    private int lastAnimatedPosition = -1;
    protected List<T> mData = new ArrayList<T>();


    public BaseRecyclerAdapter() {
    }

    public BaseRecyclerAdapter(List<T> data) {
        setData(data);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder<T> holder, int position) {
        holder.bindItem(mData.get(position), position);
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }

    public List<T> getData() {
        return mData;
    }

    public void setData(List<T> items) {
        if (items != null) {
            mData = new ArrayList<>(items);
        }else {
            this.mData = items;
        }
        notifyDataSetChanged();
    }

    public void addAll(List<T> items) {
        if (items == null || items.size() == 0)
            return;

        if (mData == null || mData.isEmpty()) {
            mData = new ArrayList<T>(items);
            notifyDataSetChanged();
        }else {
            int start = mData.size() - 1;
            mData.addAll(items);


            notifyItemRangeInserted(start, items.size() - 1);
        }
    }

    public void add(T item) {
        if (isDataNullOrEmpty()) {
            mData = new ArrayList<>();
            mData.add(item);
            notifyDataSetChanged();
        }else {
            mData.add(item);
            notifyItemInserted(mData.size() -1);
        }
    }
    public void add(int index, T item) {
        if (item == null)
            return;

        if (mData == null || mData.size() == 0) {
            mData = new ArrayList<T>();
            mData.add(item);
            notifyDataSetChanged();
        }else {
            mData.add(index, item);
            notifyItemInserted(index);
        }
    }


    public void addOnTop(T item) {
        add(0, item);
    }

    public void addOnTop(List<T> items) {
        for (int i = items.size() - 1; i >= 0; i--) {
            T item = items.get(i);
            add(0, item);
        }
    }

    public void remove(int position) {
        if (position < mData.size()) {
            T item = mData.get(position);
            if (item != null) {
                remove(mData.get(position));
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, mData.size());
            }
        }
    }

    public void remove(T item) {
        mData.remove(item);
    }

    public void runEnterAnimation(View view, int position) {
        if (animationsLocked) return;

        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position;
            view.setTranslationY(100);
            view.setAlpha(0.f);
            view.animate()
                    .translationY(0).alpha(1.f)
                    .setStartDelay(delayEnterAnimation ? 20 * (position) : 0)
                    .setInterpolator(new DecelerateInterpolator(2.f))
                    .setDuration(1000)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            animationsLocked = true;
                        }
                    })
                    .start();
        }
    }

    private Boolean isDataNullOrEmpty() {
        return  mData == null || mData.size() <= 0;
    }
}
