package it.gft.skillmanager.model;

import java.math.BigInteger;

public class ProjectEmployeeOutBean {

    private BigInteger id;

    private String employeeCode;

    private  BigInteger project_Id;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public BigInteger getProject_Id() {
        return project_Id;
    }

    public void setProject_Id(BigInteger project_Id) {
        this.project_Id = project_Id;
    }
}
