package com.gnanayakkara.rentcloud.vehicleservice.vehicleservice.service;

import java.util.List;

import com.gnanayakkara.rentcloud.commons.model.Vehicle;

public interface VehicleService {

	public Vehicle save(Vehicle vehicle);
	
	public Vehicle fetchFindByID(int id);
	
	public List<Vehicle> fetchAll();
}
