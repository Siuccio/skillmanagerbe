package it.gft.skillmanager.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
public class ProjectSkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @OneToOne
    private SkillEntity skill;

    @OneToOne
    private ProjectEntity project;

    private BigDecimal weigth;



    public BigInteger getId() {
        return id;
    }



    public SkillEntity getSkill() {
        return skill;
    }

    public void setSkill(SkillEntity skill) {
        this.skill = skill;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public BigDecimal getWeigth() {
        return weigth;
    }

    public void setWeigth(BigDecimal weigth) {
        this.weigth = weigth;
    }
}
