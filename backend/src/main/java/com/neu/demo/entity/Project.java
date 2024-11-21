package com.neu.demo.entity;

public class Project {
    String project_id;
    String project_name;
    String project_info;
    String ddl;
    String company;
    String status;
    double step;
    int ufp;
    double dfp;
    double s;
    int ei_num;
    int eo_num;
    int eq_num;
    int ilf_num;
    int elf_num;
    String auditStatus;
    String auditSuggest;

    public Project() {
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_info() {
        return project_info;
    }

    public void setProject_info(String project_info) {
        this.project_info = project_info;
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public int getUfp() {
        return ufp;
    }

    public void setUfp(int ufp) {
        this.ufp = ufp;
    }

    public double getDfp() {
        return dfp;
    }

    public void setDfp(double dfp) {
        this.dfp = dfp;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
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

    public String getAuditSuggest() {
        return auditSuggest;
    }

    public void setAuditSuggest(String auditSuggest) {
        this.auditSuggest = auditSuggest;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }
}
