package com.longer.service.response;

import java.util.List;

public class CategoryResult extends BaseResult {

    /**
     * message : success
     * data : {"version":"47041978557|14|1559706641","data":[{"default_add":1,"web_url":"","stick":1,"category":"关注","name":"关注","icon_url":"","concern_id":"","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%85%B3%E6%B3%A8@3x_2c347b458b109f5f3446f90c6b117731.jpg","tip_new":0,"flags":0,"type":4},{"default_add":1,"web_url":"","stick":1,"category":"__all__","name":"推荐","icon_url":"","concern_id":"","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E6%8E%A8%E8%8D%90@3x_b7c4a5d40c37a9d075a541b54e9d3058.jpg","tip_new":0,"flags":0,"type":4},{"category":"hotsoon_video","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%B0%8F%E8%A7%86%E9%A2%91_9278d74ee2c7b8ab2d1aa941bae8906e.jpg","web_url":"","flags":0,"name":"小视频","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"video","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E8%A7%86%E9%A2%91@3x_3607ce50553e0c1c690d52098cf3e192.jpg","web_url":"","flags":0,"name":"视频","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_hot","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E7%83%AD%E7%82%B9@3x_abe62ee4894b68712c205134df944ee7.jpg","web_url":"","flags":0,"name":"热点","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_local","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E6%9C%AC%E5%9C%B0@3x_4e8773877596d221d6fb9973090e6b9d.jpg","web_url":"","flags":0,"name":"深圳","tip_new":0,"default_add":1,"concern_id":"6216118346014788098","type":4,"icon_url":""},{"category":"news_entertainment","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%A8%B1%E4%B9%90_d1014b2c62d907653fc9f8d41ca739be.jpg","web_url":"","flags":0,"name":"娱乐","tip_new":0,"default_add":1,"concern_id":"6215497896830175745","type":4,"icon_url":""},{"category":"组图","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%9B%BE%E7%89%87_59e7147288fee8995efc4c1b01a8aed1.jpg","web_url":"","flags":0,"name":"图片","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_car","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E6%87%82%E8%BD%A6%E5%B8%9D_5fdf4b983637a0dd1044585615b546ed.jpeg","web_url":"","flags":0,"name":"懂车帝","tip_new":0,"default_add":1,"concern_id":"6215497898671475202","type":4,"icon_url":""},{"category":"news_sports","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E4%BD%93%E8%82%B2_584ebd40bf126e96659df421973bba57.jpg","web_url":"","flags":0,"name":"体育","tip_new":0,"default_add":1,"concern_id":"6215497726554016258","type":4,"icon_url":""},{"category":"news_finance","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E8%B4%A2%E7%BB%8F_958b5f3134f64c8222a560dcef5677fc.jpg","web_url":"","flags":0,"name":"财经","tip_new":0,"default_add":1,"concern_id":"6215497900357585410","type":4,"icon_url":""},{"category":"news_tech","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E7%A7%91%E6%8A%80_840f792f4d1922118219a1373bace126.jpg","web_url":"","flags":0,"name":"科技","tip_new":0,"default_add":1,"concern_id":"6215497899594222081","type":4,"icon_url":""},{"category":"news_house","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E6%88%BF%E4%BA%A7_a1638d0d36df9a64f01fad0c7d4b7f45.jpg","web_url":"","flags":0,"name":"房产","tip_new":0,"default_add":1,"concern_id":"6215497897127971330","type":4,"icon_url":""},{"category":"news_world","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%9B%BD%E9%99%85_f70ea0d49c0d2c615ffbe086888b2da9.jpg","web_url":"","flags":0,"name":"国际","tip_new":0,"default_add":1,"concern_id":"6215497896255556098","type":4,"icon_url":""},{"category":"news_military","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%86%9B%E4%BA%8B_285ff6818097fc703e6be8dc51a08543.jpg","web_url":"","flags":0,"name":"军事","tip_new":0,"default_add":1,"concern_id":"6215497895454444033","type":4,"icon_url":""},{"category":"Learning","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E7%B2%BE%E5%93%81%E8%AF%BE_77ba083eb765e63ccaf88d2ece060fb6.jpg","web_url":"https://learning.snssdk.com/feoffline/learning_core/toutiao_wallet_web_page/page/channel.html?is_web_refresh=1","flags":1,"name":"精品课","tip_new":0,"default_add":1,"concern_id":"","type":5,"icon_url":""},{"category":"news_health","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%81%A5%E5%BA%B7_24ae84b0d926933d59aec0085846d3ed.jpg","web_url":"","flags":0,"name":"健康","tip_new":0,"default_add":1,"concern_id":"6215497895248923137","type":4,"icon_url":""},{"category":"news_history","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%8E%86%E5%8F%B2_d36c9c08f32139ca7fea2c869963b710.jpg","web_url":"","flags":0,"name":"历史","tip_new":0,"default_add":1,"concern_id":"6215497901590710786","type":4,"icon_url":""},{"category":"fangxingou","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E6%94%BE%E5%BF%83%E8%B4%AD_45ef6d6036ea5485ea9c7724b8bd9f4d.jpg","web_url":"https://haohuo.jinritemai.com/views/channel/list.html?come_from=1&origin_type=2100&tt_project_id=6&version=180801","flags":0,"name":"值点","tip_new":0,"default_add":1,"concern_id":"","type":5,"icon_url":""},{"category":"novel_channel","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%B0%8F%E8%AF%B4_d2af7ed2fc6344fa4eb7b6cd4f9bf21b.jpeg","web_url":"https://ic.snssdk.com/feoffline/novel/channel/index.html?aid=35&device_id=47041978557&is_web_refresh=1&app_name=news_article_lite","flags":1,"name":"小说","tip_new":0,"default_add":1,"concern_id":"","type":5,"icon_url":""}]}
     */

    private String message;
    private DataBeanX data;

    @Override
    public String toString() {
        return "CategoryResult{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        @Override
        public String toString() {
            return "DataBeanX{" +
                    "version='" + version + '\'' +
                    ", data=" + data +
                    '}';
        }

        /**
         * version : 47041978557|14|1559706641
         * data : [{"default_add":1,"web_url":"","stick":1,"category":"关注","name":"关注","icon_url":"","concern_id":"","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%85%B3%E6%B3%A8@3x_2c347b458b109f5f3446f90c6b117731.jpg","tip_new":0,"flags":0,"type":4},{"default_add":1,"web_url":"","stick":1,"category":"__all__","name":"推荐","icon_url":"","concern_id":"","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E6%8E%A8%E8%8D%90@3x_b7c4a5d40c37a9d075a541b54e9d3058.jpg","tip_new":0,"flags":0,"type":4},{"category":"hotsoon_video","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%B0%8F%E8%A7%86%E9%A2%91_9278d74ee2c7b8ab2d1aa941bae8906e.jpg","web_url":"","flags":0,"name":"小视频","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"video","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E8%A7%86%E9%A2%91@3x_3607ce50553e0c1c690d52098cf3e192.jpg","web_url":"","flags":0,"name":"视频","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_hot","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E7%83%AD%E7%82%B9@3x_abe62ee4894b68712c205134df944ee7.jpg","web_url":"","flags":0,"name":"热点","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_local","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E6%9C%AC%E5%9C%B0@3x_4e8773877596d221d6fb9973090e6b9d.jpg","web_url":"","flags":0,"name":"深圳","tip_new":0,"default_add":1,"concern_id":"6216118346014788098","type":4,"icon_url":""},{"category":"news_entertainment","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%A8%B1%E4%B9%90_d1014b2c62d907653fc9f8d41ca739be.jpg","web_url":"","flags":0,"name":"娱乐","tip_new":0,"default_add":1,"concern_id":"6215497896830175745","type":4,"icon_url":""},{"category":"组图","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%9B%BE%E7%89%87_59e7147288fee8995efc4c1b01a8aed1.jpg","web_url":"","flags":0,"name":"图片","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_car","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E6%87%82%E8%BD%A6%E5%B8%9D_5fdf4b983637a0dd1044585615b546ed.jpeg","web_url":"","flags":0,"name":"懂车帝","tip_new":0,"default_add":1,"concern_id":"6215497898671475202","type":4,"icon_url":""},{"category":"news_sports","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E4%BD%93%E8%82%B2_584ebd40bf126e96659df421973bba57.jpg","web_url":"","flags":0,"name":"体育","tip_new":0,"default_add":1,"concern_id":"6215497726554016258","type":4,"icon_url":""},{"category":"news_finance","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E8%B4%A2%E7%BB%8F_958b5f3134f64c8222a560dcef5677fc.jpg","web_url":"","flags":0,"name":"财经","tip_new":0,"default_add":1,"concern_id":"6215497900357585410","type":4,"icon_url":""},{"category":"news_tech","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E7%A7%91%E6%8A%80_840f792f4d1922118219a1373bace126.jpg","web_url":"","flags":0,"name":"科技","tip_new":0,"default_add":1,"concern_id":"6215497899594222081","type":4,"icon_url":""},{"category":"news_house","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E6%88%BF%E4%BA%A7_a1638d0d36df9a64f01fad0c7d4b7f45.jpg","web_url":"","flags":0,"name":"房产","tip_new":0,"default_add":1,"concern_id":"6215497897127971330","type":4,"icon_url":""},{"category":"news_world","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%9B%BD%E9%99%85_f70ea0d49c0d2c615ffbe086888b2da9.jpg","web_url":"","flags":0,"name":"国际","tip_new":0,"default_add":1,"concern_id":"6215497896255556098","type":4,"icon_url":""},{"category":"news_military","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%86%9B%E4%BA%8B_285ff6818097fc703e6be8dc51a08543.jpg","web_url":"","flags":0,"name":"军事","tip_new":0,"default_add":1,"concern_id":"6215497895454444033","type":4,"icon_url":""},{"category":"Learning","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E7%B2%BE%E5%93%81%E8%AF%BE_77ba083eb765e63ccaf88d2ece060fb6.jpg","web_url":"https://learning.snssdk.com/feoffline/learning_core/toutiao_wallet_web_page/page/channel.html?is_web_refresh=1","flags":1,"name":"精品课","tip_new":0,"default_add":1,"concern_id":"","type":5,"icon_url":""},{"category":"news_health","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%81%A5%E5%BA%B7_24ae84b0d926933d59aec0085846d3ed.jpg","web_url":"","flags":0,"name":"健康","tip_new":0,"default_add":1,"concern_id":"6215497895248923137","type":4,"icon_url":""},{"category":"news_history","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%8E%86%E5%8F%B2_d36c9c08f32139ca7fea2c869963b710.jpg","web_url":"","flags":0,"name":"历史","tip_new":0,"default_add":1,"concern_id":"6215497901590710786","type":4,"icon_url":""},{"category":"fangxingou","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E6%94%BE%E5%BF%83%E8%B4%AD_45ef6d6036ea5485ea9c7724b8bd9f4d.jpg","web_url":"https://haohuo.jinritemai.com/views/channel/list.html?come_from=1&origin_type=2100&tt_project_id=6&version=180801","flags":0,"name":"值点","tip_new":0,"default_add":1,"concern_id":"","type":5,"icon_url":""},{"category":"novel_channel","image_url":"http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%B0%8F%E8%AF%B4_d2af7ed2fc6344fa4eb7b6cd4f9bf21b.jpeg","web_url":"https://ic.snssdk.com/feoffline/novel/channel/index.html?aid=35&device_id=47041978557&is_web_refresh=1&app_name=news_article_lite","flags":1,"name":"小说","tip_new":0,"default_add":1,"concern_id":"","type":5,"icon_url":""}]
         */

        private String version;
        private List<DataBean> data;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * default_add : 1
             * web_url :
             * stick : 1
             * category : 关注
             * name : 关注
             * icon_url :
             * concern_id :
             * image_url : http://s2.pstatp.com/site_new/promotion/landing_page/img/%E5%85%B3%E6%B3%A8@3x_2c347b458b109f5f3446f90c6b117731.jpg
             * tip_new : 0
             * flags : 0
             * type : 4
             */

            private int default_add;
            private String web_url;
            private int stick;
            private String category;
            private String name;
            private String icon_url;
            private String concern_id;
            private String image_url;
            private int tip_new;
            private int flags;
            private int type;

            @Override
            public String toString() {
                return "DataBean{" +
                        "default_add=" + default_add +
                        ", web_url='" + web_url + '\'' +
                        ", stick=" + stick +
                        ", category='" + category + '\'' +
                        ", name='" + name + '\'' +
                        ", icon_url='" + icon_url + '\'' +
                        ", concern_id='" + concern_id + '\'' +
                        ", image_url='" + image_url + '\'' +
                        ", tip_new=" + tip_new +
                        ", flags=" + flags +
                        ", type=" + type +
                        '}';
            }

            public int getDefault_add() {
                return default_add;
            }

            public void setDefault_add(int default_add) {
                this.default_add = default_add;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }

            public int getStick() {
                return stick;
            }

            public void setStick(int stick) {
                this.stick = stick;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public String getConcern_id() {
                return concern_id;
            }

            public void setConcern_id(String concern_id) {
                this.concern_id = concern_id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public int getTip_new() {
                return tip_new;
            }

            public void setTip_new(int tip_new) {
                this.tip_new = tip_new;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
