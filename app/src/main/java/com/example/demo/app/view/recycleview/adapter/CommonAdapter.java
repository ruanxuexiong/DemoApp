package com.example.demo.app.view.recycleview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.app.view.recycleview.MultipleType;
import com.example.demo.app.view.recycleview.ViewHolder;

import java.util.*;

/**
 * desc: 通用的 Adapter
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    protected LayoutInflater mInflater = null;

    public MultipleType<T> mTypeSupport = null;

    //使用接口回调点击事件
    private OnItemClickListener mItemClickListener = null;

    //使用接口回调点击事件
    private OnItemLongClickListener mItemLongClickListener = null;

    private int mLayoutId;
    public ArrayList<T> mData = new ArrayList<>();

    public CommonAdapter(Context mContext) {
        this.mLayoutId = -1;
        mInflater = LayoutInflater.from(mContext);
    }


    //需要多布局
    public CommonAdapter(Context mContext, MultipleType<T> typeSupport) {
        this(mContext);
        this.mTypeSupport = typeSupport;
    }

    //需要多布局
    public CommonAdapter(Context mContext, ArrayList<T> mData, MultipleType<T> typeSupport) {
        this(mContext);
        this.mTypeSupport = typeSupport;
        this.mData = mData;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mTypeSupport != null) {
            //需要多布局
            mLayoutId = viewType;
        }
        //创建view
        View view = null;
        if (mInflater != null)
            view = mInflater.inflate(mLayoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        //多布局问题
        return mTypeSupport == null ? super.getItemViewType(position) : mTypeSupport.getLayout(mData.get(position), position);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        bindData(viewHolder, mData.get(position), position);

        //条目点击事件
        if (mItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(mData.get(position), position);
                }
            });
        }

        //长按点击事件
        if (mItemLongClickListener != null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mItemLongClickListener.onItemLongClick(mData.get(position), position);
                    return false;
                }
            });
        }
    }


    /**
     * 将必要参数传递出去
     *
     * @param holder
     * @param data
     * @param position
     */
    protected abstract void bindData(ViewHolder holder, T data, int position);


    @Override
    public int getItemCount() {
        return mData.size();
    }


    void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    void setOnItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        this.mItemLongClickListener = itemLongClickListener;
    }
}
