package it.gft.skillmanager.model;

import it.gft.skillmanager.entity.ProjectEntity;
import it.gft.skillmanager.entity.SkillEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class ProjectSkillOutBean {

    private BigInteger id;

    public BigDecimal getWeigth() {
        return weigth;
    }

    public void setWeigth(BigDecimal weigth) {
        this.weigth = weigth;
    }

    private BigDecimal weigth;

    private ProjectEntity projectEntities;
    private SkillEntity skillEntities;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public ProjectEntity getProjectEntities() {
        return projectEntities;
    }

    public void setProjectEntities(ProjectEntity projectEntities) {
        this.projectEntities = projectEntities;
    }

    public SkillEntity getSkillEntities() {
        return skillEntities;
    }

    public void setSkillEntities(SkillEntity skillEntities) {
        this.skillEntities = skillEntities;
    }


}
