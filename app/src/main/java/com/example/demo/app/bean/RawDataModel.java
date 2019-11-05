package com.example.demo.app.bean;

import java.util.List;

public class RawDataModel extends BaseModel {

    public ActionModel action;
    public String rich_title;
    public UserInfoModel user;
    public List<ImageModel> animated_image_list;
    public VideoBean video;

    public static class VideoBean extends BaseModel {
        public String video_id;
    }
}
