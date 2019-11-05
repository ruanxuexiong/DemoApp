package com.longer.service.response;

import java.util.List;

public class NewsResult extends BaseResult{



    private String message;
    private int total_number;
    private boolean has_more;
    private int login_status;
    private int show_et_status;
    private String post_content_hint;
    private boolean has_more_to_refresh;
    private int action_to_last_stick;
    private int feed_flag;
    private TipsBean tips;
    private boolean is_use_bytedance_stream;
    private boolean get_offline_pool;
    private LocationBean location;
    private Object api_base_info;
    private List<DataBean> data;
    private List<?> sub_entrance_list;

    @Override
    public String toString() {
        return "NewsResult{" +
                "message='" + message + '\'' +
                ", total_number=" + total_number +
                ", has_more=" + has_more +
                ", login_status=" + login_status +
                ", show_et_status=" + show_et_status +
                ", post_content_hint='" + post_content_hint + '\'' +
                ", has_more_to_refresh=" + has_more_to_refresh +
                ", action_to_last_stick=" + action_to_last_stick +
                ", feed_flag=" + feed_flag +
                ", tips=" + tips +
                ", is_use_bytedance_stream=" + is_use_bytedance_stream +
                ", get_offline_pool=" + get_offline_pool +
                ", location=" + location +
                ", api_base_info=" + api_base_info +
                ", data=" + data +
                ", sub_entrance_list=" + sub_entrance_list +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public int getLogin_status() {
        return login_status;
    }

    public void setLogin_status(int login_status) {
        this.login_status = login_status;
    }

    public int getShow_et_status() {
        return show_et_status;
    }

    public void setShow_et_status(int show_et_status) {
        this.show_et_status = show_et_status;
    }

    public String getPost_content_hint() {
        return post_content_hint;
    }

    public void setPost_content_hint(String post_content_hint) {
        this.post_content_hint = post_content_hint;
    }

    public boolean isHas_more_to_refresh() {
        return has_more_to_refresh;
    }

    public void setHas_more_to_refresh(boolean has_more_to_refresh) {
        this.has_more_to_refresh = has_more_to_refresh;
    }

    public int getAction_to_last_stick() {
        return action_to_last_stick;
    }

    public void setAction_to_last_stick(int action_to_last_stick) {
        this.action_to_last_stick = action_to_last_stick;
    }

    public int getFeed_flag() {
        return feed_flag;
    }

    public void setFeed_flag(int feed_flag) {
        this.feed_flag = feed_flag;
    }

    public TipsBean getTips() {
        return tips;
    }

    public void setTips(TipsBean tips) {
        this.tips = tips;
    }

    public boolean isIs_use_bytedance_stream() {
        return is_use_bytedance_stream;
    }

    public void setIs_use_bytedance_stream(boolean is_use_bytedance_stream) {
        this.is_use_bytedance_stream = is_use_bytedance_stream;
    }

    public boolean isGet_offline_pool() {
        return get_offline_pool;
    }

    public void setGet_offline_pool(boolean get_offline_pool) {
        this.get_offline_pool = get_offline_pool;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public Object getApi_base_info() {
        return api_base_info;
    }

    public void setApi_base_info(Object api_base_info) {
        this.api_base_info = api_base_info;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<?> getSub_entrance_list() {
        return sub_entrance_list;
    }

    public void setSub_entrance_list(List<?> sub_entrance_list) {
        this.sub_entrance_list = sub_entrance_list;
    }

    public static class TipsBean {
        /**
         * type : app
         * display_duration : 2
         * display_info : 今日头条推荐引擎有12条更新
         * display_template : 今日头条推荐引擎有%s条更新
         * open_url :
         * web_url :
         * download_url :
         * app_name : 今日头条
         * package_name :
         */

        private String type;
        private int display_duration;
        private String display_info;
        private String display_template;
        private String open_url;
        private String web_url;
        private String download_url;
        private String app_name;
        private String package_name;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getDisplay_duration() {
            return display_duration;
        }

        public void setDisplay_duration(int display_duration) {
            this.display_duration = display_duration;
        }

        public String getDisplay_info() {
            return display_info;
        }

        public void setDisplay_info(String display_info) {
            this.display_info = display_info;
        }

        public String getDisplay_template() {
            return display_template;
        }

        public void setDisplay_template(String display_template) {
            this.display_template = display_template;
        }

        public String getOpen_url() {
            return open_url;
        }

        public void setOpen_url(String open_url) {
            this.open_url = open_url;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }
    }

    public static class LocationBean {
        /**
         * city_name : 深圳
         * city_code : 440300
         * district_name : 南山
         * district_code : 440305
         * local_category : 深圳
         */

        private String city_name;
        private String city_code;
        private String district_name;
        private String district_code;
        private String local_category;

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public void setDistrict_name(String district_name) {
            this.district_name = district_name;
        }

        public String getDistrict_code() {
            return district_code;
        }

        public void setDistrict_code(String district_code) {
            this.district_code = district_code;
        }

        public String getLocal_category() {
            return local_category;
        }

        public void setLocal_category(String local_category) {
            this.local_category = local_category;
        }
    }

    public static class DataBean {
        /**
         * content : {"abstract":"","allow_download":false,"article_sub_type":0,"article_type":0,"ban_comment":0,"ban_immersive":0,"behot_time":1564583983,"bury_count":0,"cell_ctrls":{"cell_flag":0,"cell_height":0,"cell_layout_style":1,"content_decoration":null,"need_client_impr_recycle":null},"cell_height":0,"cell_type":25,"comment_count":0,"content_decoration":"","cursor":1564583983999,"data_callback":"window.refresh","data_type":1,"data_url":"http://ic.snssdk.com/stream/widget/goapi/local/weather/?city_name=%E6%B7%B1%E5%9C%B3\u0026district_name=\u0026en_city=sz","digg_count":0,"has_m3u8_video":false,"has_mp4_video":0,"has_video":false,"hot":0,"id":4494734731,"ignore_web_transform":0,"interaction_data":"","is_deleted":false,"is_subject":false,"item_version":0,"level":0,"log_pb":{"impr_id":"20190731223943010026057076142D50F","is_following":"0"},"read_count":0,"refresh_interval":5,"req_id":"20190731223943010026057076142D50F","rid":"20190731223943010026057076142D50F","share_count":0,"share_info":null,"show_dislike":true,"show_portrait":false,"show_portrait_article":false,"template_md5":"78bb376b20274147f1ced98e8fd1b24e","template_url":"https://ic.snssdk.com/stream/widget/template/local/","tip":0,"ugc_recommend":{"activity":"","reason":""},"user_repin":0,"user_verified":0,"verified_content":"","video_style":0}
         * code :
         */

        private String content;
        private String code;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
