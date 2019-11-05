package com.example.demo.app.bean;

public class UserInfoModel extends BaseModel {

    /**
     * info : {"avatar_url":"http://p1.pstatp.com/thumb/3797/2889309425","ban_status":false,"desc":"爱你你是我的梁山伯~","live_info_type":0,"living_count":0,"medals":null,"media_id":null,"name":"你也想护肤吗","origin_profile_url":"https://www.douyin.com/share/user/102864045641/","origin_user_id":102864045641,"real_name":null,"room_schema":"","schema":"sslocal://profile?uid=102931260164&refer=ies_video","user_auth_info":"","user_decoration":"","user_id":102931260164,"user_verified":0,"verified_content":""}
     * relation : {"is_followed":0,"is_following":0,"is_friend":0,"is_real_friend":null,"remark_name":""}
     * relation_count : {"followers_count":0,"followings_count":0}
     */

    private InfoBean info;
    private RelationBean relation;
    private RelationCountBean relation_count;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public RelationBean getRelation() {
        return relation;
    }

    public void setRelation(RelationBean relation) {
        this.relation = relation;
    }

    public RelationCountBean getRelation_count() {
        return relation_count;
    }

    public void setRelation_count(RelationCountBean relation_count) {
        this.relation_count = relation_count;
    }

    public static class InfoBean extends BaseModel {
        /**
         * avatar_url : http://p1.pstatp.com/thumb/3797/2889309425
         * ban_status : false
         * desc : 爱你你是我的梁山伯~
         * live_info_type : 0
         * living_count : 0
         * medals : null
         * media_id : null
         * name : 你也想护肤吗
         * origin_profile_url : https://www.douyin.com/share/user/102864045641/
         * origin_user_id : 102864045641
         * real_name : null
         * room_schema :
         * schema : sslocal://profile?uid=102931260164&refer=ies_video
         * user_auth_info :
         * user_decoration :
         * user_id : 102931260164
         * user_verified : 0
         * verified_content :
         */

        private String avatar_url;
        private boolean ban_status;
        private String desc;
        private int live_info_type;
        private int living_count;
        private Object medals;
        private Object media_id;
        private String name;
        private String origin_profile_url;
        private long origin_user_id;
        private Object real_name;
        private String room_schema;
        private String schema;
        private String user_auth_info;
        private String user_decoration;
        private long user_id;
        private int user_verified;
        private String verified_content;


        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public boolean isBan_status() {
            return ban_status;
        }

        public void setBan_status(boolean ban_status) {
            this.ban_status = ban_status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getLive_info_type() {
            return live_info_type;
        }

        public void setLive_info_type(int live_info_type) {
            this.live_info_type = live_info_type;
        }

        public int getLiving_count() {
            return living_count;
        }

        public void setLiving_count(int living_count) {
            this.living_count = living_count;
        }

        public Object getMedals() {
            return medals;
        }

        public void setMedals(Object medals) {
            this.medals = medals;
        }

        public Object getMedia_id() {
            return media_id;
        }

        public void setMedia_id(Object media_id) {
            this.media_id = media_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrigin_profile_url() {
            return origin_profile_url;
        }

        public void setOrigin_profile_url(String origin_profile_url) {
            this.origin_profile_url = origin_profile_url;
        }

        public long getOrigin_user_id() {
            return origin_user_id;
        }

        public void setOrigin_user_id(long origin_user_id) {
            this.origin_user_id = origin_user_id;
        }

        public Object getReal_name() {
            return real_name;
        }

        public void setReal_name(Object real_name) {
            this.real_name = real_name;
        }

        public String getRoom_schema() {
            return room_schema;
        }

        public void setRoom_schema(String room_schema) {
            this.room_schema = room_schema;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }

        public String getUser_auth_info() {
            return user_auth_info;
        }

        public void setUser_auth_info(String user_auth_info) {
            this.user_auth_info = user_auth_info;
        }

        public String getUser_decoration() {
            return user_decoration;
        }

        public void setUser_decoration(String user_decoration) {
            this.user_decoration = user_decoration;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public int getUser_verified() {
            return user_verified;
        }

        public void setUser_verified(int user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }
    }

    public static class RelationBean extends BaseModel {
        /**
         * is_followed : 0
         * is_following : 0
         * is_friend : 0
         * is_real_friend : null
         * remark_name :
         */

        private int is_followed;
        private int is_following;
        private int is_friend;
        private Object is_real_friend;
        private String remark_name;

        public int getIs_followed() {
            return is_followed;
        }

        public void setIs_followed(int is_followed) {
            this.is_followed = is_followed;
        }

        public int getIs_following() {
            return is_following;
        }

        public void setIs_following(int is_following) {
            this.is_following = is_following;
        }

        public int getIs_friend() {
            return is_friend;
        }

        public void setIs_friend(int is_friend) {
            this.is_friend = is_friend;
        }

        public Object getIs_real_friend() {
            return is_real_friend;
        }

        public void setIs_real_friend(Object is_real_friend) {
            this.is_real_friend = is_real_friend;
        }

        public String getRemark_name() {
            return remark_name;
        }

        public void setRemark_name(String remark_name) {
            this.remark_name = remark_name;
        }
    }

    public static class RelationCountBean extends BaseModel {
        /**
         * followers_count : 0
         * followings_count : 0
         */

        private int followers_count;
        private int followings_count;

        public int getFollowers_count() {
            return followers_count;
        }

        public void setFollowers_count(int followers_count) {
            this.followers_count = followers_count;
        }

        public int getFollowings_count() {
            return followings_count;
        }

        public void setFollowings_count(int followings_count) {
            this.followings_count = followings_count;
        }
    }
}
