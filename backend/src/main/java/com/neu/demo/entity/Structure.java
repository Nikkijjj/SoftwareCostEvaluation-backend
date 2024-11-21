package com.neu.demo.entity;

public class Structure {
    private String module_id;
    private String project_id;
    private String parent_id;
    private String module_name;
    private String module_desc;
    private int ufp;
    private int ei_num;
    private int eo_num;
    private int eq_num;
    private int ilf_num;
    private int elf_num;
    private double step;

    public Structure() {
    }

    public String getModule_id() {
        return module_id;
    }

    public void setModule_id(String module_id) {
        this.module_id = module_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getModule_desc() {
        return module_desc;
    }

    public void setModule_desc(String module_desc) {
        this.module_desc = module_desc;
    }

    public int getUfp() {
        return ufp;
    }

    public void setUfp(int ufp) {
        this.ufp = ufp;
    }

    public int getEi_num() {
        return ei_num;
    }

    public void setEi_num(int ei_num) {
        this.ei_num = ei_num;
    }

    public int getEo_num() {
        return eo_num;
    }

    public void setEo_num(int eo_num) {
        this.eo_num = eo_num;
    }

    public int getEq_num() {
        return eq_num;
    }

    public void setEq_num(int eq_num) {
        this.eq_num = eq_num;
    }

    public int getIlf_num() {
        return ilf_num;
    }

    public void setIlf_num(int ilf_num) {
        this.ilf_num = ilf_num;
    }

    public int getElf_num() {
        return elf_num;
    }

    public void setElf_num(int elf_num) {
        this.elf_num = elf_num;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }
}
