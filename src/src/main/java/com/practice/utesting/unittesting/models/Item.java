package com.practice.utesting.unittesting.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@NoArgsConstructor
public class Item {

    @Id @Getter @Setter
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int price;
    @Getter @Setter
    private int quantity;

    @Transient
    @Getter @Setter
    private long totalValue;

    public Item(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
