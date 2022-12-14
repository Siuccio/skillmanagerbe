package it.gft.skillmanager.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ProjectSkillInBean {

    private BigInteger id;
    private  BigInteger skill_Id;
    private  BigInteger project_Id;

    public BigDecimal getWeigth() {
        return weigth;
    }

    public void setWeigth(BigDecimal weigth) {
        this.weigth = weigth;
    }

    private BigDecimal weigth;


    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getSkill_Id() { return skill_Id; }
    public void setSkill_Id(BigInteger skill_Id) { this.skill_Id = skill_Id; }

    public BigInteger getProject_Id() {
        return project_Id;
    }
    public void setProject_Id(BigInteger project_Id) {
        this.project_Id = project_Id;
    }
}
