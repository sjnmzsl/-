package com.example.yanx.bean;

public class TokenBean {

    /**
     * errno : 0
     * errmsg :
     * data : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoiZ2Nob2M2Nm1hNiIsImlhdCI6MTYwOTY3NzE1NX0.JKAFumO8_LKgbN2vqqiqPnQGy5OImHWtYz0o_9OaqG8
     */

    private Integer errno;
    private String errmsg;
    private String data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
