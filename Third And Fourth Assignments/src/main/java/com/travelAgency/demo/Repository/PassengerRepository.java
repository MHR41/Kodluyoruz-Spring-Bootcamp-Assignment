package com.travelAgency.demo.Repository;

import com.travelAgency.demo.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
