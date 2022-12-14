package it.gft.skillmanager.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class ProjectEmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @OneToOne
    private EmployeeEntity employee;

    @OneToOne
    private ProjectEntity project;

    public BigInteger getId() {
        return id;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employeeEntity) {
        this.employee = employeeEntity;
    }
}
