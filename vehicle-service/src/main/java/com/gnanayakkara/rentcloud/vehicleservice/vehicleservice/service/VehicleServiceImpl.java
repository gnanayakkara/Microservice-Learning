package com.gnanayakkara.rentcloud.vehicleservice.vehicleservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnanayakkara.rentcloud.commons.model.Vehicle;
import com.gnanayakkara.rentcloud.vehicleservice.vehicleservice.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle fetchFindByID(int id) {
		
		Optional<Vehicle> optional = vehicleRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Vehicle> fetchAll() {
		return vehicleRepository.findAll();
	}

}
