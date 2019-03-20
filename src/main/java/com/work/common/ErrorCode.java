package com.work.common;

/**
 * @author 杜晓鹏
 * @create 2019-03-20 8:39
 */
public class ErrorCode {
    public enum CheckCode{
        CHECK_ERROR(1,"用户名已存在"),
        CHECK_RIGHT(0,"用户名可以使用");
        private Integer code;
        private String msg;
        private CheckCode(Integer code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
