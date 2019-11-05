package com.example.demo.app.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo.app.R;
import com.zftlive.android.library.widget.dialog.bean.ItemBean;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {
    private List<ItemBean> itemBeanList;
    private Context mContext;

    public ItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setItemBeanList(List<ItemBean> itemBeanList) {
        this.itemBeanList = itemBeanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_item_model, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder) viewHolder).mTitletv.setText(itemBeanList.get(i).leftMainTitle);
        if (itemBeanList.get(i).leftSubTitleBgResId != 0) {
            Drawable drawable = mContext.getDrawable(itemBeanList.get(i).leftSubTitleBgResId);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((ViewHolder) viewHolder).mTitletv.setCompoundDrawables(drawable, null, null, null);
        }
        if (i == 2) {
            ((ViewHolder) viewHolder).mBottomView.setVisibility(View.VISIBLE);
        } else {
            ((ViewHolder) viewHolder).mBottomView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return itemBeanList == null ? 0 : itemBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitletv;
        private View mBottomView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitletv = itemView.findViewById(R.id.tv_title);
            mBottomView = itemView.findViewById(R.id.view_bottom);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
