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
@DiscriminatorValue("1")
public class InhousePart extends Part{
    int partId;

    public InhousePart() {
    }

//    public InhousePart(int partId, String name, double price, int inv) {
//        this.setPartId(partId);
//        this.setName(name);
//        this.setPrice(price);
//        this.setInv(inv);
//    }

    public InhousePart(int partId, String name, double price, int inv, int minInv, int maxInv) {
        this.setPartId(partId);
        this.setName(name);
        this.setPrice(price);
        this.setInv(inv);
        this.setMinInv(minInv);
        this.setMaxInv(maxInv);
        // This validation is redundant with the validator that works with the form. This validation would protect against hard coded parts, such as the sample inventory.
        if (!isInvValid()) {
            throw new IllegalArgumentException("Inventory level is not within the specified limits");
        }
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}
