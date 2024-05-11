package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part{
    String companyName;

    public OutsourcedPart() {
    }

//    public OutsourcedPart(int id, String name, double price, int inv, String companyName) {
//        this.setId(id);
//        this.setName(name);
//        this.setPrice(price);
//        this.setInv(inv);
//        this.setCompanyName(companyName);
//    }

    public OutsourcedPart(int id, String name, double price, int inv, int minInv, int maxInv, String companyName) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setInv(inv);
        this.setMinInv(minInv);
        this.setMaxInv(maxInv);
        this.setCompanyName(companyName);
        if (!isInvValid()) {
            throw new IllegalArgumentException("Inventory level is not within the specified limits");
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
