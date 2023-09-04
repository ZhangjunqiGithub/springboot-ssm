package com.springtest05.controller.utils;

import lombok.Data;
//不用再写getter和setter了
@Data
public class R {
    private Boolean flag;
    private Object data;

    public R() {}

    public R(Boolean flag) {
        this.flag =flag;
    }

    public R(Boolean flag, Object data) {
        this.flag =flag;
        this.data = data;
    }
}
