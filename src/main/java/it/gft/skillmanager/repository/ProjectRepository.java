package it.gft.skillmanager.repository;

import it.gft.skillmanager.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, BigInteger> {
    @Query("Select a from ProjectEntity a inner join ProjectEmployeeEntity b on a.id=b.project.id and b.employee.code=:code")
    public List<ProjectEntity> getProjectList(String code);

}
