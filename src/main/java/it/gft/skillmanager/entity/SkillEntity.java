package it.gft.skillmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;
@Entity
public class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private String name;

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
