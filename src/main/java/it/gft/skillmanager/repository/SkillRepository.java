package it.gft.skillmanager.repository;

import it.gft.skillmanager.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;


public interface SkillRepository extends JpaRepository<SkillEntity, BigInteger> {
    // resta da rendere opzionale il parametro
    @Query("Select s from SkillEntity s where s.name LIKE CONCAT('%',:name,'%')" )
    public List<SkillEntity> getSkillList(String name);

    @Query("Select s from SkillEntity s " )
    public List<SkillEntity> getAllSkillList();


}
