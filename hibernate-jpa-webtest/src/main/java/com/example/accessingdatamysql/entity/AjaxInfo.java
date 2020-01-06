package com.example.accessingdatamysql.entity;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class AjaxInfo {
    public AjaxInfo(){

    }
    public AjaxInfo(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    private Integer code=0;

    private String msg="操作成功";

    private Object data;


    public boolean isSuccess( ){
        if(0 == code){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        AjaxInfo ajaxInfo = new AjaxInfo();
        ajaxInfo.setCode(400);
        ajaxInfo.setMsg("找不到页面");
        String s = JSON.toJSONString(ajaxInfo);
        System.out.println(s);
        JSONObject jsonObject = JSON.parseObject(s);
        jsonObject.getString("data");

    }


}