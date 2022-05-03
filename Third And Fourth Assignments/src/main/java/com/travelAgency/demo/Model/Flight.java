package com.travelAgency.demo.Model;

import com.travelAgency.demo.Enum.FlightType;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @Column
    private Date date;

    @Column
    @Enumerated(EnumType.STRING)
    private FlightType flightType;

    @Column
    private String arrival;

    @Column
    private String departure;

}
