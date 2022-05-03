package com.travelAgency.demo.Service;

import com.travelAgency.demo.Converter.PassengerToPassengerResponseDto;
import com.travelAgency.demo.Converter.SaveRequestPassengerDtoToPassenger;
import com.travelAgency.demo.Dto.Passenger.PassengerRequestDto;
import com.travelAgency.demo.Dto.Passenger.PassengerResponseDto;
import com.travelAgency.demo.Enum.PassengerAgeCategory;
import com.travelAgency.demo.Enum.PassengerEducationStatus;
import com.travelAgency.demo.Model.Passenger;
import com.travelAgency.demo.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    SaveRequestPassengerDtoToPassenger saveRequestPassengerDtoToPassenger;

    @Autowired
    PassengerToPassengerResponseDto passengerToPassengerResponseDto;


    public long savePassenger(PassengerRequestDto passengerRequestDto, PassengerEducationStatus educationStatus, PassengerAgeCategory ageCategory){
        passengerRequestDto.setPassengerAgeCategory(ageCategory);
        passengerRequestDto.setPassengerEducationStatus(educationStatus);
        Passenger passenger = saveRequestPassengerDtoToPassenger.convertSaveRequestPassengerDtoToPassenger(passengerRequestDto);
        passengerRepository.save(passenger);
        return passenger.getPassengerId();
    }

    public List<PassengerResponseDto> getAllPassengers(){
        List<Passenger> passengerList = passengerRepository.findAll();
        return passengerToPassengerResponseDto.convertFromPassengerToPassengerResponseDto(passengerList);
    }
}
