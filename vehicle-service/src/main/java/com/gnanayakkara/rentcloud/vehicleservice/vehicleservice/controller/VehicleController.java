package com.gnanayakkara.rentcloud.vehicleservice.vehicleservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnanayakkara.rentcloud.commons.model.Vehicle;
import com.gnanayakkara.rentcloud.vehicleservice.vehicleservice.service.VehicleService;

@RestController
@RequestMapping(value = "/services")
public class VehicleController {
 
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(value = "vehicle",method = RequestMethod.POST)
	public Vehicle save(@RequestBody Vehicle vehicle) {
		return vehicleService.save(vehicle);
	}
	
	@RequestMapping(value = "vehicle", method = RequestMethod.GET)
	public ResponseEntity<Vehicle> fetchByID(@RequestParam int id) {
		Vehicle vehicle = vehicleService.fetchFindByID(id);
		
		if(vehicle == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(vehicle);
	}
	
	@RequestMapping(value = "vehicles", method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> fetchAllVehicles() {
		
		List<Vehicle> vehicles = vehicleService.fetchAll();
		
		if(vehicles == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(vehicles);
	}
}
