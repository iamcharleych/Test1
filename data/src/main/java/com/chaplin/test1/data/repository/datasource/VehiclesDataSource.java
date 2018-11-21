package com.chaplin.test1.data.repository.datasource;

import com.chaplin.test1.data.entity.VehicleEntity;

import java.util.List;

public interface VehiclesDataSource {

    List<VehicleEntity> getVehicles();
}
