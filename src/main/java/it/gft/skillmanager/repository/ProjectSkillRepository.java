package it.gft.skillmanager.repository;

import it.gft.skillmanager.entity.ProjectEmployeeEntity;
import it.gft.skillmanager.entity.ProjectSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProjectSkillRepository extends JpaRepository<ProjectSkillEntity, BigInteger> {


    @Query("Select a from ProjectSkillEntity a where a.project.id=:projectId")
    public List<ProjectSkillEntity> getSkillByProject(BigInteger projectId);

    @Query("Select a from ProjectSkillEntity a where a.project.id=:projectId and a.skill.id=:skillId")
    public ProjectSkillEntity getProjectSkillById(BigInteger projectId, BigInteger skillId);

}

