package it.gft.skillmanager.model;

import java.util.List;

public class PostSkillRequest {

    private List<PostSkill> skill;

    public List<PostSkill> getSkill() {
        return skill;
    }

    public void setSkill(List<PostSkill> skill) {
        this.skill = skill;
    }
}
