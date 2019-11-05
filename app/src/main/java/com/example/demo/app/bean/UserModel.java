package com.example.demo.app.bean;

import java.io.Serializable;

/**
 * @author ChayChan
 * @description: 用户实体类
 * @date 2017/7/9  10:43
 */

public class UserModel extends BaseModel {
    /**
     * verified_content :
     * avatar_url : http://p3.pstatp.com/thumb/216b000e0abb3ee9cb91
     * user_id : 59834611934
     * name : 电竞手游君
     * follower_count : 0
     * follow : false
     * user_auth_info :
     * user_verified : false
     * description : 游戏 资讯 游戏攻略 你要的这里都有，来这里就对了。
     */
    public String verified_content;
    public String avatar_url;
    public long user_id;
    public String name;
    public int follower_count;
    public boolean follow;
    public String user_auth_info;
    public boolean user_verified;
    public String description;

    @Override
    public String toString() {
        return "UserModel{" +
                "verified_content='" + verified_content + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", follower_count=" + follower_count +
                ", follow=" + follow +
                ", user_auth_info='" + user_auth_info + '\'' +
                ", user_verified=" + user_verified +
                ", description='" + description + '\'' +
                '}';
    }
}
