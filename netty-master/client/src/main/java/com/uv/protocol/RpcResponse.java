package com.uv.protocol;
/*
 * @author 闫志行
 * 传输响应对象
 */

import java.io.Serializable;

public class RpcResponse implements Serializable{

    private static final long serialVersionUID = -4546652381492921069L;


    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override public String toString() {
        return "RpcResponse{" + "status=" + status + ", id='" + id + '\'' + ", content='" + content
            + '\'' + '}';
    }
}
