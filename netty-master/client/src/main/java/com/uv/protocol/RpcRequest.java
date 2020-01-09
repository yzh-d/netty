package com.uv.protocol;
/*
 * @author 闫志行
 * 传输请求对象
 */

import java.io.Serializable;

public class RpcRequest implements Serializable{

    private static final long serialVersionUID = -2577707401136472809L;

    private String id;

    private String type;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override public String toString() {
        return "RpcRequest{" + "id='" + id + '\'' + ", type='" + type + '\'' + ", content='"
            + content + '\'' + '}';
    }
}
