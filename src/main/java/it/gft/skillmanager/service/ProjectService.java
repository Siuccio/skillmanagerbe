package it.gft.skillmanager.service;

import it.gft.skillmanager.entity.*;
import it.gft.skillmanager.model.EmployeeVote;
import it.gft.skillmanager.model.ProjectDetailOutBean;
import it.gft.skillmanager.entity.EmployeeEntity;
import it.gft.skillmanager.entity.ProjectEmployeeEntity;
import it.gft.skillmanager.entity.ProjectEntity;
import it.gft.skillmanager.model.ProjectInBean;
import it.gft.skillmanager.model.ProjectOutBean;
import it.gft.skillmanager.repository.EmployeeRepository;
import it.gft.skillmanager.repository.ProjectEmployeeRepository;
import it.gft.skillmanager.repository.ProjectRepository;
import it.gft.skillmanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ProjectEmployeeRepository projectEmployeeRepository;


    @Autowired
    private ProjectSkillRepository projectSkillRepository;


    public  List<ProjectOutBean> getProjectList(String code){
        List<ProjectOutBean> allProject = new ArrayList<ProjectOutBean>();


        List<ProjectEntity> projectEntities= projectRepository.getProjectList(code);
                //.findAll();
        for(ProjectEntity projectEntity:projectEntities){
            ProjectOutBean projectOutBean=new ProjectOutBean();
            projectOutBean.setId(projectEntity.getId());
            projectOutBean.setName(projectEntity.getName());


            allProject.add(projectOutBean);
        }
        return allProject;
    }

    public ProjectOutBean postProject(ProjectInBean  projectInBean){

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(projectInBean.getName());

        projectEntity = projectRepository.save(projectEntity);

        EmployeeEntity employee= employeeRepository.findById(projectInBean.getCodeEmployee()).get();

        ProjectEmployeeEntity projectEmployeeEntity = new ProjectEmployeeEntity();
        projectEmployeeEntity.setProject(projectEntity);
        projectEmployeeEntity.setEmployee(employee);
        //projectEmployeeEntity.setEmployee();

        projectEmployeeEntity = projectEmployeeRepository.save(projectEmployeeEntity);


        ProjectOutBean projectOutBean=new ProjectOutBean();
        projectOutBean.setId(projectEntity.getId());
        projectOutBean.setName(projectEntity.getName());
        return projectOutBean;
    }

    public ProjectOutBean putProject(ProjectInBean  projectInBean){

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity = projectRepository.getById(projectInBean.getId());


        projectEntity.setName(projectInBean.getName());
        projectEntity = projectRepository.save(projectEntity);

        ProjectOutBean projectOutBean=new ProjectOutBean();
        projectOutBean.setId(projectEntity.getId());
        projectOutBean.setName(projectEntity.getName());
        return projectOutBean;
    }

    public ProjectOutBean deleteProject(ProjectInBean  projectInBean){

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity = projectRepository.getById(projectInBean.getId());

        projectRepository.deleteById(projectInBean.getId());

        ProjectOutBean projectOutBean=new ProjectOutBean();
        projectOutBean.setId(projectEntity.getId());
        projectOutBean.setName(projectEntity.getName());
        return projectOutBean;
    }

    public ProjectDetailOutBean getProjectDetail(BigInteger projectId){
        ProjectDetailOutBean projectDetailOutBean=new ProjectDetailOutBean();
        List<VoteEntity>  votes=voteRepository.getVoteByProjectId(projectId);
        List<ProjectEmployeeEntity> projectEmployeeEntities=projectEmployeeRepository.getEmployeeByProject(projectId);
        List<ProjectSkillEntity> projectSkillEntities= projectSkillRepository.getSkillByProject(projectId);
        projectDetailOutBean.setVotes(votes);
        projectDetailOutBean.setProjectEmployeeEntities(projectEmployeeEntities);
        projectDetailOutBean.setProjectSkillEntities(projectSkillEntities);
        return projectDetailOutBean;
    }
}
