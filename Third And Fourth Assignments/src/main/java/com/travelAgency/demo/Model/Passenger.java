package com.travelAgency.demo.Model;

import com.travelAgency.demo.Enum.PassengerAgeCategory;
import com.travelAgency.demo.Enum.PassengerEducationStatus;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table
@Data
public class Passenger {
    @Id
    @Max(value = 99999999999l)
    @Min(value = 10000000000l)
    private long passengerId;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    @Enumerated(EnumType.STRING)
    private PassengerAgeCategory passengerAgeCategory;

    @Column
    @Enumerated(EnumType.STRING)
    private PassengerEducationStatus passengerEducationStatus;

}
