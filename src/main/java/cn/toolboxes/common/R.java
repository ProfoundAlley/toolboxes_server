package cn.toolboxes.common;

import lombok.Data;

@Data
public class R<T> {
    String code;
    T data;
    String url;
    String msg;

    // 成功
    public static <T> R ok(T data){
        R<T> r = new R<>();
        r.data = data;
        r.code = "0";
        return r;
    }

    // 失败
    public static R no(String msg){
        R r = new R<>();
        r.msg = msg;
        r.code = "-1";
        return r;
    }

    // 跳转
    public static R url(String url){
        R r = new R<>();
        r.url = url;
        r.code = "1";
        return r;
    }

}
