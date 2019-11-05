package com.example.demo.app.bean;

import com.google.gson.Gson;
import com.zftlive.android.library.base.adapter.IAdapterModel;

import java.util.List;

/**
 * @author ChayChan
 * @description: TODO
 * @date 2017/7/6  15:11
 */

public class NewsModel extends BaseModel implements IAdapterModel {


    public int article_type;
    public String tag;
    public String title;
    public int hot;
    public String source;
    public int comment_count;
    public String article_url;
    public int gallary_image_count;
    public int video_style;
    public String item_id;
    public UserModel user_info;
    public long behot_time;
    public String url;
    public boolean has_image;
    public boolean has_video;
    public int video_duration;
    public VideoModel video_detail_info;
    public String group_id;
    public ImageModel middle_image;
    public List<ImageModel> image_list;
    public RawDataModel raw_data;
    public List<FlterWordsModel> filter_words;
    public String category;
    public String videoUrl;//zh 真实的视频播放地址


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
