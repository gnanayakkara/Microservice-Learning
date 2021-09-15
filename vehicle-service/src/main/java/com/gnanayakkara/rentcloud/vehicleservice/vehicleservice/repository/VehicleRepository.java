package com.gnanayakkara.rentcloud.vehicleservice.vehicleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnanayakkara.rentcloud.commons.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
