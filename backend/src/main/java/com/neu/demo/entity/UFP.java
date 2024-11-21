package com.neu.demo.entity;

public class UFP {
    int ufp_id;
    String module_id;
    String type;
    String detail;

    public UFP() {
    }

    public String getModule_id() {
        return module_id;
    }

    public void setModule_id(String module_id) {
        this.module_id = module_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUfp_id() {
        return ufp_id;
    }

    public void setUfp_id(int ufp_id) {
        this.ufp_id = ufp_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
