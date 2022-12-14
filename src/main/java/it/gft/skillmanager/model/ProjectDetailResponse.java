package it.gft.skillmanager.model;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class ProjectDetailResponse {

    private BigInteger id;



    private List<String> employee;

    private List<Map<String,String>> skill;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }




    public List<String> getEmployee() {
        return employee;
    }

    public void setEmployee(List<String> employee) {
        this.employee = employee;
    }

    public List<Map<String,String>>  getSkill() {
        return skill;
    }

    public void setSkill(List<Map<String,String>>  skill) {
        this.skill = skill;
    }
}


