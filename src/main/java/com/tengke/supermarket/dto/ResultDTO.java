package com.tengke.supermarket.dto;

/**
 * @Author: Mr.Chen
 * @Description: 统一api响应结果，格式为{status:'',msg:'',Object:''}
 * @Date:Created in 0:50 2020/5/18
 */
public class ResultDTO {
    /**
     * {200：请求成功；301：重定向；404：资源不存在；500：服务器内部错误}
     */
    private Integer status;
    private String msg;
    private Object data;

    private ResultDTO() {
    }

    private ResultDTO(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 静态构建方法，对外开放，方便调用
     *
     * @return ""
     */
    public static ResultDTO create() {
        return new ResultDTO();
    }

    /**
     * 请求成功，统一返回200
     * @param msg '响应消息'
     * @return ''
     */
    public static ResultDTO success(String msg) {
        return new ResultDTO(200, msg, null);
    }

    public static ResultDTO success(String msg, Object obj) {
        return new ResultDTO(200, msg, obj);
    }

    /**
     * 请求出错，统一为服务器错误
     * @param msg '响应消息'
     * @return ''
     */
    public static ResultDTO error(String msg) {
        return new ResultDTO(500, msg, null);
    }

    public static ResultDTO error(String msg, Object obj) {
        return new ResultDTO(500, msg, obj);
    }

    public ResultDTO setStatus(Integer status) {
        this.status = status;
        return this;
    }
    public ResultDTO setMsg(String msg) {
        this.msg = msg;
        return this;
    }
    public ResultDTO setData(Object data) {
        this.data = data;
        return this;
    }

    public Integer getStatus() {
        return status;
    }
    public String getMsg() {
        return msg;
    }
    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
