package com.uv.entity;

import java.io.Serializable;


public class User implements Serializable {
    private static final long serialVersionUID = -7776017450107481817L;
    private int id;

    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override public String toString() {
        return "User{" + "id=" + id + ", content='" + content + '\'' + '}';
    }
}
