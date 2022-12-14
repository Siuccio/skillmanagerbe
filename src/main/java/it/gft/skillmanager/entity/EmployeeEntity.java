package it.gft.skillmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class EmployeeEntity {

    @Id
    private String code;

    private String name;

    private String surmane;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurmane() {
        return surmane;
    }

    public void setSurmane(String surmane) {
        this.surmane = surmane;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(surmane, that.surmane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, surmane);
    }
}
