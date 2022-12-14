package it.gft.skillmanager.controller;

import it.gft.skillmanager.model.*;
import it.gft.skillmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee")
    public EmployeeResponse getEmployee(@RequestParam(value = "name",required = false) String name) {
        System.out.println("/employee - getEmployee - name" + name );
        EmployeeResponse p=new EmployeeResponse();
        p.setEmployees(employeeService.getEmployeeList(name));
        return p;
    }

    @RequestMapping("/project/{id}/employee")
    public EmployeeResponse getEmployees(@PathVariable("id") BigInteger id) {
        System.out.println("/project/{id}/employee - getEmployees - id" + id.toString() );
        EmployeeResponse p=new EmployeeResponse();
        p.setEmployees(employeeService.getEmployeeProjectList(id));
        return p;
    }

    // MODIFICA - solo l'employee
    @RequestMapping(value = "/employee/{code}",method = RequestMethod.PUT)
    public EmployeeOutBean putEmployee(@PathVariable("code") String code, @RequestBody PostEmployee postEmployee) {
        System.out.println("/employee/{code} - putEmployee - code" + code );
        EmployeeInBean employeeInBean = new EmployeeInBean();
        employeeInBean.setSurname(postEmployee.getSurname());
        employeeInBean.setName(postEmployee.getName());
        employeeInBean.setCode(code);
        return employeeService.putEmployee(employeeInBean);
    }

    // CANCELLA - SOLO l'employee - se ha progetti collegati prima li cancella
    @RequestMapping(value = "/employee/{code}",method = RequestMethod.DELETE)
    public EmployeeOutBean deleteEmployee(@PathVariable("code") String code) {
        System.out.println("/employee/{code} - deleteEmployee - code" + code );
        EmployeeInBean employeeInBean = new EmployeeInBean();
        employeeInBean.setCode(code);
        return employeeService.deleteEmployee(employeeInBean);
    }

    @RequestMapping(value = "/project/{id}/employee/{code}",method = RequestMethod.DELETE)
    public ProjectEmployeeOutBean deleteProjectEmployee(@PathVariable("id") BigInteger idProject, @PathVariable("code") String code) {
        System.out.println("/project/{id}/employee/{code} - deleteProjectEmployee - id" + idProject.toString() + " code" + code );
        ProjectEmployeeInBean projectEmployeeInBean = new ProjectEmployeeInBean();
        projectEmployeeInBean.setEmployeeCode(code);
        projectEmployeeInBean.setProject_Id(idProject);
        return employeeService.deleteProjectEmployee(projectEmployeeInBean);
    }

}
