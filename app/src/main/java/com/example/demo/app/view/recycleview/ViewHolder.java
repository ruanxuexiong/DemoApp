package com.example.demo.app.view.recycleview;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder<T extends View> extends RecyclerView.ViewHolder{

    //用于缓存已找到界面
    private SparseArray<View> viewSparseArray;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        viewSparseArray = new SparseArray<>();
    }

    public T getView(int viewId) {
        //对已有的view做缓存
        View view = null;
        if (viewSparseArray != null) {
            view = viewSparseArray.get(viewId);
        }
        if (view == null) {
            view = itemView.findViewById(viewId);
            if (viewSparseArray != null)
                viewSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    public T getViewGroup(int viewId) {
        //对已有的view做缓存
        View view = null;
        if (viewSparseArray != null)
            view = viewSparseArray.get(viewId);
        //使用缓存的方式减少findViewById的次数
        if (view == null) {
            view = itemView.findViewById(viewId);
            viewSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    @SuppressLint("SetTextI18n")
    //通用的功能进行封装  设置文本 设置条目点击事件  设置图片
    public ViewHolder setText(int viewId, CharSequence text) {
        TextView view = (TextView) getView(viewId);
        view.setText("" + text);
        //希望可以链式调用
        return this;
    }

    public ViewHolder setHintText(int viewId, CharSequence text) {
        TextView view = (TextView) getView(viewId);
        view.setHint("" + text);
        return this;
    }

    /**
     * 设置本地图片
     *
     * @param viewId
     * @param resId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView iv = (ImageView) getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

    /**
     * 加载图片资源路径
     *
     * @param viewId
     * @param imageLoader
     * @return
     */
    public ViewHolder setImagePath(int viewId, HolderImageLoader imageLoader) {
        ImageView iv = (ImageView) getView(viewId);
        imageLoader.loadImage(iv, imageLoader.path);
        return this;
    }

    public abstract class HolderImageLoader {
        /**
         * 需要去复写这个方法加载图片
         *
         * @param iv
         * @param path
         */
        String path;

        HolderImageLoader(String path) {
            this.path = path;
        }

        public abstract void loadImage(ImageView iv, String path);
    }

    /**
     * 设置View的Visibility
     */
    public ViewHolder setViewVisibility(int viewId, int visibility) {
        getView(viewId).setVisibility(visibility);
        return this;
    }

    /**
     * 设置条目点击事件
     */
    public void setOnItemClickListener(View.OnClickListener listener) {
        itemView.setOnClickListener(listener);
    }

    /**
     * 设置条目长按事件
     */
    public void setOnItemLongClickListener(View.OnLongClickListener listener) {
        itemView.setOnLongClickListener(listener);
    }

}
