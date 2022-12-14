package it.gft.skillmanager.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private String vote;

    @OneToOne
    private EmployeeEntity employee;

    @OneToOne
    private ProjectEntity project;


    @OneToOne
    private SkillEntity skill;

    public BigInteger getId() {
        return id;
    }




    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public SkillEntity getSkill() {
        return skill;
    }

    public void setSkill(SkillEntity skill) {
        this.skill = skill;
    }
}
