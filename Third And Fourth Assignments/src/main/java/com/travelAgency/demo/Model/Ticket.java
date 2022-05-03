package com.travelAgency.demo.Model;

import com.travelAgency.demo.Enum.SeatType;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketNo;

    @Column
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passengerId")
    private Passenger passenger;

    @OneToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    @Column
    private double price;

    @Column
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
}
