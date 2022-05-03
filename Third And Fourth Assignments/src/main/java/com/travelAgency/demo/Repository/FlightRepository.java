package com.travelAgency.demo.Repository;

import com.travelAgency.demo.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findAllByPlaneId(int planeId);
}
