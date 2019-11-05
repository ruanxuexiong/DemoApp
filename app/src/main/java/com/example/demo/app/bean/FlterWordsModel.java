package com.example.demo.app.bean;

public class FlterWordsModel extends BaseModel{

    /**
     * id : 9:1
     * is_selected : false
     * name : 内容太水
     */

    private String id;
    private boolean is_selected;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIs_selected() {
        return is_selected;
    }

    public void setIs_selected(boolean is_selected) {
        this.is_selected = is_selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
