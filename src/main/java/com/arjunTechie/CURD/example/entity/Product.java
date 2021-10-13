package com.arjunTechie.CURD.example.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
//we can use @Getter and @Setter and @ToString annotation
//or
//@Data
@RequiredArgsConstructor  // lombok  to get getter and setter manually
@AllArgsConstructor // from lombok
//@NoArgsConstructor // from lombok
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double price;


}
