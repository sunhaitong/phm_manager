package com.chaos.manager.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result<T> {
    private static final Integer SC_OK_200 = 200;
    /**请求不通过*/
    private static final Integer SC_REQUEST_FAILED_740 = 740;
    private T content;
    private String msg;
    private Integer code;


    public Result(T content, String msg){
        this.content =  content;
        this.msg = msg;
        this.code = SC_OK_200;

    }

    public Result(T content){
        this.content =  content;
        this.code = SC_OK_200;

    }

    public Result(String msg, Integer code){
        this.msg =  msg;
        this.code = code;

    }


    public Result(){
        this.code = SC_OK_200;
    }

    public static  Result success(){
        return new Result();
    }

    public static<T> Result<T> success(T content){
        return new Result(content);
    }

    public static Result error(String msg,Integer code){
        return new Result(msg,code);
    }

    public Boolean isSuccess(){
        return code.equals(SC_OK_200);
    }

    /**
     * 后端逻辑不通过
     * @param msg
     * @return
     */
    public static Result error740(String msg){
        return error(msg,SC_REQUEST_FAILED_740);
    }
}
