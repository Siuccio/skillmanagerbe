package it.gft.skillmanager.service;

import it.gft.skillmanager.entity.*;
import it.gft.skillmanager.model.*;
import it.gft.skillmanager.repository.ProjectEmployeeRepository;
import it.gft.skillmanager.repository.SkillRepository;
import it.gft.skillmanager.repository.ProjectSkillRepository;
import it.gft.skillmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectSkillRepository projectSkillRepository;

    public List<SkillOutBean> getSkillList(String name){
        List<SkillOutBean> allSkill = new ArrayList<SkillOutBean>();
        List<SkillEntity> skillEntities;
        if (name == null || name.isEmpty() ) {
            skillEntities= skillRepository.getAllSkillList();
        } else {
            skillEntities = skillRepository.getSkillList(name);
        }

        for(SkillEntity skillEntity:skillEntities){
            SkillOutBean skillOutBean=new SkillOutBean();
            skillOutBean.setId(skillEntity.getId());
            skillOutBean.setName(skillEntity.getName());
            allSkill.add(skillOutBean);
        }
        return allSkill;
    }

    public SkillOutBean postSkill(BigInteger idProject, List <PostSkill> postSkills){
        // inserimento
       // List<SkillOutBean> allSkill = new ArrayList<SkillOutBean>();
        SkillEntity skillEntity = new SkillEntity();
        for(PostSkill postSkill :postSkills){
            skillEntity = new SkillEntity();
            skillEntity.setName(postSkill.getName());
            if (postSkill.getId() == null ) {
                // devo inserire lo skill e recuperare l'id

                skillEntity = skillRepository.save(skillEntity);

            } else {
                // non devo aggiornare il database
                skillEntity= skillRepository.findById(postSkill.getId()).get();

            }

            ProjectSkillEntity projectSkillEntity = new ProjectSkillEntity();
            ProjectEntity projectEntity = new ProjectEntity();
            projectEntity = projectRepository.findById(idProject).get();

            projectSkillEntity.setProject(projectEntity);
            projectSkillEntity.setSkill(skillEntity);

            projectSkillEntity.setWeigth(postSkill.getWeigth());

            projectSkillEntity = projectSkillRepository.save(projectSkillEntity);

        }

        SkillOutBean skillOutBean=new SkillOutBean();
        skillOutBean.setId(skillEntity.getId());
        skillOutBean.setName(skillEntity.getName());
        return skillOutBean;
    }

    public ProjectSkillOutBean deleteProjectSkill(ProjectSkillInBean projectSkillInBean){

        ProjectSkillEntity projectSkillEntity = new ProjectSkillEntity();
        projectSkillEntity = projectSkillRepository.getProjectSkillById(projectSkillInBean.getProject_Id(), projectSkillInBean.getSkill_Id());

        ProjectSkillOutBean projectSkillOutBean = new ProjectSkillOutBean();
        projectSkillOutBean.setProjectEntities(projectSkillEntity.getProject());
        projectSkillOutBean.setSkillEntities(projectSkillEntity.getSkill());
        projectSkillOutBean.setWeigth(projectSkillEntity.getWeigth());
        projectSkillOutBean.setId(projectSkillEntity.getId());

        projectSkillRepository.deleteById(projectSkillEntity.getId());


        return projectSkillOutBean;
    }

    public ProjectSkillOutBean putProjectSkill(ProjectSkillInBean projectSkillInBean, PostProjectSkill postProjectSkill){
        // modifica

        // tutto da modificare

        ProjectSkillEntity projectSkillEntity = new ProjectSkillEntity();
        projectSkillEntity = projectSkillRepository.getProjectSkillById(projectSkillInBean.getProject_Id(), projectSkillInBean.getSkill_Id());


        projectSkillEntity.setWeigth(postProjectSkill.getWeigth());
        projectSkillEntity = projectSkillRepository.save(projectSkillEntity);

        ProjectSkillOutBean projectSkillOutBean = new ProjectSkillOutBean();
        projectSkillOutBean.setProjectEntities(projectSkillEntity.getProject());
        projectSkillOutBean.setSkillEntities(projectSkillEntity.getSkill());
        projectSkillOutBean.setWeigth(projectSkillEntity.getWeigth());
        projectSkillOutBean.setId(projectSkillEntity.getId());

        return projectSkillOutBean;
    }
}
