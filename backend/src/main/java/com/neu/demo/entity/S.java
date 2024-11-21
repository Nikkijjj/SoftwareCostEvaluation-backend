package com.neu.demo.entity;

public class S {
    private String project_id;
    private int s_id;
    private String type;
    private double value;

    public S(String project_id, int s_id, String type, double value) {
        this.project_id = project_id;
        this.s_id = s_id;
        this.type = type;
        this.value = value;
    }

    public S() {}

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
