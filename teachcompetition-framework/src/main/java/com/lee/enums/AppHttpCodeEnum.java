package com.lee.enums;

public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    PARAM_INVALID(400,"出现错误"),
    NOT_POINT(403,"评分不存在"),
    SYSTEM_ERROR(500,"出现错误"),
    DATA_NOT_EXIST(502,"用户不存在"),
    VIDEO_OVER_SIZE(504, "视频不能超过500M"),
    PASSWORD_ERROR(506,"密码与原密码不一致"),
    FILE_TYPE_ERROR(507,"文件类型错误,请上传pdf格式文件"),
    NOT_WORK(508, "作品不存在"),
    FILE_OVER_SIZE(509, "文件不能超过100M"),
    UPLOAD_NOT_SUCCESSFUL(510, "密码不能为空"),
    VIDEO_TYPE_ERROR(512, "视频文件必须为mp4"),
    LOGIN_ERROR(505,"用户名或密码错误");





    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
