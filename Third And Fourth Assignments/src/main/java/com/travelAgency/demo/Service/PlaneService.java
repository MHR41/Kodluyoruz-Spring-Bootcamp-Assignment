package com.travelAgency.demo.Service;

import com.travelAgency.demo.Converter.PlaneRequestDtoToPlane;
import com.travelAgency.demo.Dto.Plane.PlaneRequestDto;
import com.travelAgency.demo.Dto.Plane.PlaneResponseDto;
import com.travelAgency.demo.Exception.NotFoundException;
import com.travelAgency.demo.Model.Plane;
import com.travelAgency.demo.Repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneService {

    @Autowired
    PlaneRequestDtoToPlane planeRequestDtoToPlane;

    @Autowired
    PlaneRepository planeRepository;

    public Integer savePlane(PlaneRequestDto planeRequestDto){
        Plane plane = planeRequestDtoToPlane.convertPlaneRequestDtoToPlane(planeRequestDto);
        return planeRepository.save(plane).getId();
    }

    public void deletePlane(int planeId){
        planeRepository.findById(planeId).orElseThrow(()-> new NotFoundException("Plane is not exist with id "+planeId));
        planeRepository.deleteById(planeId);
    }

    public List<PlaneResponseDto> findAll() {
        List<PlaneResponseDto> planeResponseDtoList = new ArrayList<>();
        List<Plane> planeList = planeRepository.findAll();

        for (Plane plane : planeList) {
            PlaneResponseDto planeResponseDto = new PlaneResponseDto();
            planeResponseDto.setPlaneName(plane.getPlaneName());
            planeResponseDto.setCapacity(plane.getCapacity());
            planeResponseDto.setId(plane.getId());

            planeResponseDtoList.add(planeResponseDto);
        }
        return planeResponseDtoList;
    }
}
