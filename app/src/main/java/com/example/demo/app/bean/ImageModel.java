package com.example.demo.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author ChayChan
 * @description: 图片实体类
 * @date 2017/7/9  10:39
 */

public class ImageModel extends BaseModel {
    /**
     * url : http://p3.pstatp.com/list/300x196/2c23000095ae9f56b15f.webp
     * width : 700
     * url_list : [{"url":"http://p3.pstatp.com/list/300x196/2c23000095ae9f56b15f.webp"},{"url":"http://pb9.pstatp.com/list/300x196/2c23000095ae9f56b15f.webp"},{"url":"http://pb1.pstatp.com/list/300x196/2c23000095ae9f56b15f.webp"}]
     * uri : list/2c23000095ae9f56b15f
     * height : 393
     */
    public String url;
    public int width;
    public String uri;
    public int height;
    public List<UrlListBeanX> url_list;

    public static class UrlListBeanX extends BaseModel {
        /**
         * url : http://p3.pstatp.com/list/300x196/2c23000095ae9f56b15f.webp
         */
        private static final long serialVersionUID = -6377960213315892547L;
        public String url;
    }

    @Override
    public String toString() {
        return "ImageModel{" +
                "url='" + url + '\'' +
                ", width=" + width +
                ", uri='" + uri + '\'' +
                ", height=" + height +
                ", url_list=" + url_list +
                '}';
    }
}
