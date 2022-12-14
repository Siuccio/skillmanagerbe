package it.gft.skillmanager.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PostSkill {

    private BigInteger id;
    private String name;
    private BigDecimal weigth;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWeigth() {
        return weigth;
    }

    public void setWeigth(BigDecimal weigth) {
        this.weigth = weigth;
    }
}
