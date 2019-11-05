package com.longer.service.response;

/**
 * @author
 * @description: 新闻详情
 * @date 2017/6/28  15:25
 */

public class NewsDetailResult extends BaseResult {

    public String has_more;
    public String message;
    public String success;
    public DataBean data;

    public String getHas_more() {
        return has_more;
    }

    public void setHas_more(String has_more) {
        this.has_more = has_more;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NewsDetailResult{" +
                "has_more='" + has_more + '\'' +
                ", message='" + message + '\'' +
                ", success='" + success + '\'' +
                ", data=" + data +
                '}';
    }

    public NewsDetailResult(String more, String _message, DataBean result) {
        has_more = more;
        message = _message;
        data = result;
    }
    public static class DataBean{
        public String detail_source;
        public MediaUserBean media_user;
        public int publish_time;
        public String title;
        public String url;
        public boolean is_original;
        public boolean is_pgc_article;
        public String content;
        public String source;
        public int video_play_count;

        @Override
        public String toString() {
            return "DataBean{" +
                    "detail_source='" + detail_source + '\'' +
                    ", media_user=" + media_user +
                    ", publish_time=" + publish_time +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", is_original=" + is_original +
                    ", is_pgc_article=" + is_pgc_article +
                    ", content='" + content + '\'' +
                    ", source='" + source + '\'' +
                    ", video_play_count=" + video_play_count +
                    '}';
        }

        public static class MediaUserBean {
            /**
             * no_display_pgc_icon : false
             * avatar_url : http://p1.pstatp.com/thumb/411000674c8942528d2
             * id : 6347463786
             * screen_name : 发现世界
             */

            public boolean no_display_pgc_icon;
            public String avatar_url;
            public String id;
            public String screen_name;
        }
    }
}
