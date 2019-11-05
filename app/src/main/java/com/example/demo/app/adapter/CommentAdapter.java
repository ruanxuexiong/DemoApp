package com.example.demo.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.app.R;
import com.example.demo.app.util.TimeUtils;
import com.longer.service.response.CommentResult;
import com.xing.widget.ReadMoreTextView;
import com.zftlive.android.library.imageloader.ToolImage;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter {

    private List<CommentResult.DataBean> dataBeanList;
    private Context mContext;

    public CommentAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDataBeanList(List<CommentResult.DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_comment, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((ViewHolder) viewHolder).mNameTv.setText(dataBeanList.get(position).getComment().getUser_name());
        ((ViewHolder) viewHolder).readMoreTextView.setText(dataBeanList.get(position).getComment().getText());
        ((ViewHolder) viewHolder).mTime.setText(TimeUtils.getNormalTime(dataBeanList.get(position).getComment().getCreate_time()));
        if(dataBeanList.get(position).getComment().getReply_count()==0){
            ((ViewHolder) viewHolder).mReplyCount.setVisibility(View.GONE);
        }else{
            ((ViewHolder) viewHolder).mReplyCount.setVisibility(View.VISIBLE);
            ((ViewHolder) viewHolder).mReplyCount.setText(dataBeanList.get(position).getComment().getReply_count() + "回复");
        }

        ToolImage.init(mContext).displayImage(dataBeanList.get(position).getComment().getUser_profile_image_url(), ((ViewHolder) viewHolder).mAvatarImg, ToolImage.getRoundOptions(R.mipmap.ic_launcher));
    }

    @Override
    public int getItemCount() {
        return dataBeanList == null ? 0 : dataBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mAvatarImg;
        private TextView mNameTv, mTime, mReplyCount;
        private ReadMoreTextView readMoreTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mAvatarImg = itemView.findViewById(R.id.iv_avatar);
            mNameTv = itemView.findViewById(R.id.tv_name);
            readMoreTextView = itemView.findViewById(R.id.tv_description);
            mTime = itemView.findViewById(R.id.tv_time);
            mReplyCount = itemView.findViewById(R.id.tv_reply_count);
        }
    }
}
