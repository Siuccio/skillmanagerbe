package it.gft.skillmanager.service;

import it.gft.skillmanager.entity.*;
import it.gft.skillmanager.model.PostSkill;
import it.gft.skillmanager.model.SkillOutBean;
import it.gft.skillmanager.model.VoteOutBean;
import it.gft.skillmanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class VoteService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private VoteRepository voteRepository;

    public VoteOutBean postVote(BigInteger idProject, BigInteger idSkill, String employeeCode, String vote){

        VoteEntity voteEntity = new VoteEntity();
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity = projectRepository.getById(idProject);
        SkillEntity skillEntity = new SkillEntity();
        skillEntity = skillRepository.getById(idSkill);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity = employeeRepository.getEmployeeByCode(employeeCode);


        voteEntity.setVote(vote);
        voteEntity.setProject(projectEntity);
        voteEntity.setEmployee(employeeEntity);
        voteEntity.setSkill( skillEntity);

        voteEntity = voteRepository.save(voteEntity);

        VoteOutBean voteOutBean=new VoteOutBean();
        voteOutBean.setEmp(employeeEntity);
        voteOutBean.setSkill(skillEntity);
        voteOutBean.setVote(voteEntity);

        return voteOutBean;
    }
}
