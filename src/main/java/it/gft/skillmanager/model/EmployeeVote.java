package it.gft.skillmanager.model;

import it.gft.skillmanager.entity.EmployeeEntity;
import it.gft.skillmanager.entity.ProjectEmployeeEntity;
import it.gft.skillmanager.entity.ProjectSkillEntity;
import it.gft.skillmanager.entity.VoteEntity;

public class EmployeeVote {

    private ProjectEmployeeEntity emp;
    private VoteEntity vote;
    private ProjectSkillEntity skill;
    public EmployeeVote(ProjectEmployeeEntity emp, VoteEntity vote, ProjectSkillEntity skill) {
        this.emp = emp;
        this.vote = vote;
        this.skill=skill;
    }

    public ProjectEmployeeEntity getEmp() {
        return emp;
    }

    public void setEmp(ProjectEmployeeEntity emp) {
        this.emp = emp;
    }

    public VoteEntity getVote() {
        return vote;
    }

    public void setVote(VoteEntity vote) {
        this.vote = vote;
    }

    public ProjectSkillEntity getSkill() {
        return skill;
    }

    public void setSkill(ProjectSkillEntity skill) {
        this.skill = skill;
    }
}
