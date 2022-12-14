package it.gft.skillmanager.controller;

import it.gft.skillmanager.model.PostProject;
import it.gft.skillmanager.model.ProjectInBean;
import it.gft.skillmanager.model.ProjectOutBean;
import it.gft.skillmanager.entity.*;
import it.gft.skillmanager.model.*;
import it.gft.skillmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class ProjectController {


    @Autowired
    private ProjectService projectService;

    @RequestMapping("/user/{code}/project")
    public ProjectResponse getProject(@PathVariable("code") String code) {
        System.out.println("/user/{code}/project - getProject - code" + code );
        ProjectResponse p=new ProjectResponse();
        p.setProjects(projectService.getProjectList(code));
       return p;
    }

    @RequestMapping("/project/{id}")
    public ProjectDetailResponse getProjectDetail(@PathVariable("id") BigInteger id) {
        System.out.println("/project/{id} - getProjectDetail - id" + id.toString() );
        ProjectDetailOutBean projectDetailOutBean=projectService.getProjectDetail(id);
        ProjectDetailResponse projectDetailResponse= mapper(projectDetailOutBean);
        projectDetailResponse.setId(id);
        return projectDetailResponse;
    }

    private ProjectDetailResponse mapper(ProjectDetailOutBean projectDetailOutBean){
        ProjectDetailResponse projectDetailResponse=new ProjectDetailResponse();
        List<ProjectSkillEntity> projectSkillEntities=projectDetailOutBean.getProjectSkillEntities();
        List<ProjectEmployeeEntity> projectEmployeeEntities=projectDetailOutBean.getProjectEmployeeEntities();
        List<VoteEntity>  voteEntities= projectDetailOutBean.getVotes();
        List<Map<String,String>> skill=new ArrayList<>();
        for(ProjectSkillEntity projectSkillEntity:projectSkillEntities){
            Map<String,String> map=new HashMap<>();
            map.put("name",projectSkillEntity.getSkill().getName());
            map.put("skillId",projectSkillEntity.getSkill().getId().toString());
            for(ProjectEmployeeEntity projectEmployeeEntity:projectEmployeeEntities){
                map.put(projectEmployeeEntity.getEmployee().getCode(),getVote(projectEmployeeEntity.getEmployee().getCode(),projectSkillEntity.getSkill().getName(),voteEntities));
            }
            skill.add(map);

        }
        projectDetailResponse.setSkill(skill);
        projectDetailResponse.setEmployee(projectEmployeeEntities.stream().map(x->x.getEmployee().getCode()).collect(Collectors.toList()));
        return projectDetailResponse;
    }

    private String getVote(String emp,String skill, List<VoteEntity> voteEntities){
        List<VoteEntity> list=voteEntities.stream().filter(v->skill.equals(v.getSkill().getName()) && emp.equals(v.getEmployee().getCode())).collect(Collectors.toList());
        if(list.size()>0)
            return list.get(0).getVote();
        return "-";
    }


    @RequestMapping(value = "/user/{code}/project",method = RequestMethod.POST)
    public ProjectOutBean postProject(@PathVariable("code") String code,@RequestBody PostProject postProject) {
        System.out.println("/user/{code}/project - postProject - code" + code );
        ProjectInBean projectInBean=new ProjectInBean();
        projectInBean.setCodeEmployee(code);
        projectInBean.setName(postProject.getName());
        return projectService.postProject(projectInBean);
    }

    // MODIFICA PROGETTO
    @RequestMapping(value = "/project/{code}",method = RequestMethod.PUT)
    public ProjectOutBean putProject(@PathVariable("code") BigInteger code, @RequestBody PostProject postProject) {
        System.out.println("/project/{code} - putProject - code" + code.toString() );
        ProjectInBean projectInBean=new ProjectInBean();
        projectInBean.setId(code);
        projectInBean.setName(postProject.getName());
        return projectService.putProject(projectInBean);
    }


    @RequestMapping(value = "/project/{code}",method = RequestMethod.DELETE)
    public ProjectOutBean deleteProject(@PathVariable("code") BigInteger code) {
        System.out.println("/project/{code} - deleteProject - code" + code.toString() );
        ProjectInBean projectInBean=new ProjectInBean();
        projectInBean.setId(code);
        return projectService.deleteProject(projectInBean);
    }

}

