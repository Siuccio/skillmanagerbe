package it.gft.skillmanager.repository;

import it.gft.skillmanager.entity.EmployeeEntity;
import it.gft.skillmanager.entity.ProjectEntity;
import it.gft.skillmanager.entity.VoteEntity;
import it.gft.skillmanager.model.EmployeeVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, BigInteger> {
    @Query("Select a from VoteEntity a where a.id=:projectId order by a.skill.name")
    public List<VoteEntity> getVoteByProjectId(BigInteger projectId);


    @Query(value = "select new it.gft.skillmanager.model.EmployeeVote(e,v,s) from ProjectEmployeeEntity e LEFT JOIN VoteEntity v ON " +
            "(e.employee.code=v.employee.code AND e.project.id=:projectId)  RIGHT JOIN ProjectSkillEntity s on v.skill.id=s.skill.id")
    public List<EmployeeVote> getVoteEmployeeByProjectId(BigInteger projectId);

    @Modifying
    @Query("Delete from VoteEntity a where  a.employee.code=:code")
    public void deleteVoteByEmpCode(String code);

}
