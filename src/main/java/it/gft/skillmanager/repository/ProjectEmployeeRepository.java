package it.gft.skillmanager.repository;

import it.gft.skillmanager.entity.EmployeeEntity;
import it.gft.skillmanager.entity.ProjectEmployeeEntity;
import it.gft.skillmanager.entity.ProjectEntity;
import it.gft.skillmanager.entity.ProjectSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployeeEntity, BigInteger> {


    @Query("Select a from ProjectEmployeeEntity a where a.project.id=:projectId")
    public List<ProjectEmployeeEntity> getEmployeeByProject(BigInteger projectId);
    @Query("Select a from ProjectEntity a inner join ProjectEmployeeEntity b on a.id=b.project.id and b.employee.code=:code")
    public List<ProjectEmployeeEntity> getProjectList(String code);

    @Query("Select a from ProjectEmployeeEntity a where a.project.id=:projectId and a.employee.code=:code")
    public ProjectEmployeeEntity getProjectEmployeeById(BigInteger projectId, String code);

    @Modifying
    @Query("delete from ProjectEmployeeEntity a where a.employee.code=:code")
    public void  deleteAllProjectByEmpCode(String code);

}
