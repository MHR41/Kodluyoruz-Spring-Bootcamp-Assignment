package com.travelAgency.demo.Model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String planeName;

    @Column
    private int capacity;

}
