package it.gft.skillmanager.service;

import it.gft.skillmanager.entity.*;
import it.gft.skillmanager.model.*;
import it.gft.skillmanager.repository.EmployeeRepository;
import it.gft.skillmanager.repository.ProjectEmployeeRepository;
import it.gft.skillmanager.repository.ProjectRepository;
import it.gft.skillmanager.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ProjectEmployeeRepository projectEmployeeRepository;


    public List<EmployeeOutBean> getEmployeeList(String name){
        List<EmployeeOutBean> allEmployee = new ArrayList<EmployeeOutBean>();
        List<EmployeeEntity> employeeEntities;
        if (name == null || name.isEmpty() ) {
            employeeEntities= employeeRepository.getAllEmployeeList();
        } else {
            employeeEntities = employeeRepository.getEmployeeList(name);
        }

        for(EmployeeEntity employeeEntity:employeeEntities){
            EmployeeOutBean employeeOutBean=new EmployeeOutBean();
            employeeOutBean.setCode(employeeEntity.getCode());
            employeeOutBean.setName(employeeEntity.getName());
            employeeOutBean.setSurname(employeeEntity.getSurmane());
            allEmployee.add(employeeOutBean);
        }
        return allEmployee;
    }

    public  List<EmployeeOutBean> getEmployeeProjectList(BigInteger id){
        List<EmployeeOutBean> allEmployee = new ArrayList<EmployeeOutBean>();


        List<EmployeeEntity> employeeEntities= employeeRepository.getEmployeeProjectList(id);
        //.findAll();
        for(EmployeeEntity employeeEntity:employeeEntities){
            EmployeeOutBean employeeOutBean=new EmployeeOutBean();
            employeeOutBean.setCode(employeeEntity.getCode());
            employeeOutBean.setName(employeeEntity.getName());
            employeeOutBean.setSurname(employeeEntity.getSurmane());


            allEmployee.add(employeeOutBean);
        }
        return allEmployee;
    }

    public EmployeeOutBean postEmployee(BigInteger idProject, EmployeeInBean employeeInBean){

        // inserimento
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setCode(employeeInBean.getCode());
        employeeEntity.setName(employeeInBean.getName());
        employeeEntity.setSurmane(employeeInBean.getSurname());
        employeeEntity = employeeRepository.save(employeeEntity);


        ProjectEmployeeEntity projectEmployeeEntity = new ProjectEmployeeEntity();
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity = projectRepository.findById(idProject).get();

        projectEmployeeEntity.setProject(projectEntity);
        projectEmployeeEntity.setEmployee(employeeEntity);

        projectEmployeeEntity = projectEmployeeRepository.save(projectEmployeeEntity);

        EmployeeOutBean employeeOutBean=new EmployeeOutBean();
        employeeOutBean.setCode(employeeEntity.getCode());
        employeeOutBean.setName(employeeEntity.getName());
        employeeOutBean.setSurname(employeeEntity.getSurmane());
        return employeeOutBean;
    }


    @Transactional
    public EmployeeOutBean deleteEmployee(EmployeeInBean employeeInBean){

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setCode(employeeInBean.getCode());
        //employeeEntity = employeeRepository.getEmployeeByCode(employeeEntity.getCode());

        projectEmployeeRepository.deleteAllProjectByEmpCode(employeeEntity.getCode());

        EmployeeOutBean employeeOutBean=new EmployeeOutBean();
        employeeOutBean.setCode(employeeEntity.getCode());
        employeeOutBean.setName("prova");
        employeeOutBean.setSurname("cancellazione");

        voteRepository.deleteVoteByEmpCode(employeeEntity.getCode());

        employeeRepository.deleteEmployeeByCode(employeeEntity.getCode());

        return employeeOutBean;
    }

    public ProjectEmployeeOutBean deleteProjectEmployee(ProjectEmployeeInBean projectEmployeeInBean){

        ProjectEmployeeEntity projectEmployeeEntity = new ProjectEmployeeEntity();
        projectEmployeeEntity = projectEmployeeRepository.getProjectEmployeeById(projectEmployeeInBean.getProject_Id(),projectEmployeeInBean.getEmployeeCode()) ;

        ProjectEmployeeOutBean projectEmployeeOutBean = new ProjectEmployeeOutBean();
        projectEmployeeOutBean.setProject_Id(projectEmployeeEntity.getProject().getId());
        projectEmployeeOutBean.setEmployeeCode(projectEmployeeEntity.getEmployee().getCode());
        projectEmployeeOutBean.setId(projectEmployeeEntity.getId());

        projectEmployeeRepository.deleteById(projectEmployeeEntity.getId());
        return projectEmployeeOutBean;
    }
/*
    public ProjectEmployeeOutBean putProjectEmployee(ProjectEmployeeInBean projectEmployeeInBean){
        // modifica

        // tutto da modificare

        ProjectEmployeeEntity projectEmployeeEntity = new ProjectEmployeeEntity();
        projectEmployeeEntity = projectEmployeeRepository  .getProjectEmployeeById(projectEmployeeInBean.getProject_Id(), projectEmployeeInBean.getEmployeeCode());


        //projectEmployeeEntity.setWeigth(postProjectEmployee.getWeigth());
        projectEmployeeEntity = projectEmployeeRepository.save(projectEmployeeEntity);

        ProjectEmployeeOutBean projectEmployeeOutBean = new ProjectEmployeeOutBean();
        projectEmployeeOutBean.setProjectEntities(projectEmployeeEntity.getProject());
        projectEmployeeOutBean.setEmployeeEntities(projectEmployeeEntity.getEmployee());
        //projectEmployeeOutBean.setWeigth(projectEmployeeEntity.getWeigth());
        projectEmployeeOutBean.setId(projectEmployeeEntity.getId());

        return projectEmployeeOutBean;
    }

 */

    public EmployeeOutBean putEmployee(EmployeeInBean  employeeInBean){

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setCode(employeeInBean.getCode());
        employeeEntity.setName(employeeInBean.getName());
        employeeEntity.setSurmane(employeeInBean.getSurname());
//
        employeeEntity = employeeRepository.save(employeeEntity);

        EmployeeOutBean employeeOutBean=new EmployeeOutBean();
        employeeOutBean.setSurname(employeeEntity.getSurmane());
        employeeOutBean.setName(employeeEntity.getName());
        employeeOutBean.setCode(employeeEntity.getCode());
        return employeeOutBean;
    }
}
