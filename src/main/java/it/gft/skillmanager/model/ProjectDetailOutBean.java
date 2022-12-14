package it.gft.skillmanager.model;

import it.gft.skillmanager.entity.EmployeeEntity;
import it.gft.skillmanager.entity.ProjectEmployeeEntity;
import it.gft.skillmanager.entity.ProjectSkillEntity;
import it.gft.skillmanager.entity.VoteEntity;

import java.math.BigInteger;
import java.util.List;

public class ProjectDetailOutBean {

    private BigInteger id;
    private String name;
    private List<VoteEntity>  votes;
    private List<ProjectEmployeeEntity> projectEmployeeEntities;
    private List<ProjectSkillEntity> projectSkillEntities;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VoteEntity> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteEntity> votes) {
        this.votes = votes;
    }

    public List<ProjectEmployeeEntity> getProjectEmployeeEntities() {
        return projectEmployeeEntities;
    }

    public void setProjectEmployeeEntities(List<ProjectEmployeeEntity> projectEmployeeEntities) {
        this.projectEmployeeEntities = projectEmployeeEntities;
    }

    public List<ProjectSkillEntity> getProjectSkillEntities() {
        return projectSkillEntities;
    }

    public void setProjectSkillEntities(List<ProjectSkillEntity> projectSkillEntities) {
        this.projectSkillEntities = projectSkillEntities;
    }
}
