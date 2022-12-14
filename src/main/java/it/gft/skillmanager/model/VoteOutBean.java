package it.gft.skillmanager.model;

import it.gft.skillmanager.entity.EmployeeEntity;
import it.gft.skillmanager.entity.SkillEntity;

import it.gft.skillmanager.entity.VoteEntity;

public class VoteOutBean {
    private EmployeeEntity emp;
    private VoteEntity vote;
    private SkillEntity skill;


    public EmployeeEntity getEmp() {
        return emp;
    }

    public void setEmp(EmployeeEntity emp) {
        this.emp = emp;
    }

    public VoteEntity getVote() {
        return vote;
    }

    public void setVote(VoteEntity vote) {
        this.vote = vote;
    }

    public SkillEntity getSkill() {
        return skill;
    }

    public void setSkill(SkillEntity skill) {
        this.skill = skill;
    }
}
