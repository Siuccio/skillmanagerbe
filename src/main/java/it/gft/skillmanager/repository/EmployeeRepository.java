package it.gft.skillmanager.repository;

import it.gft.skillmanager.entity.EmployeeEntity;
import it.gft.skillmanager.entity.ProjectEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

    @Query("Select a from EmployeeEntity a where  a.code=:code")
    public EmployeeEntity getEmployeeByCode(String code);

    @Modifying
    @Query("Delete from EmployeeEntity a where  a.code=:code")
    public void deleteEmployeeByCode(String code);


    // resta da rendere opzionale il parametro
    @Query("Select s from EmployeeEntity s where s.name LIKE CONCAT('%',:name,'%')" )
    public List<EmployeeEntity> getEmployeeList(String name);

    @Query("Select s from EmployeeEntity s " )
    public List<EmployeeEntity> getAllEmployeeList();


    @Query("Select a from EmployeeEntity a inner join ProjectEmployeeEntity b on a.code=b.employee.code and b.project.id=:id" )
    public List<EmployeeEntity> getEmployeeProjectList(BigInteger id);

}
