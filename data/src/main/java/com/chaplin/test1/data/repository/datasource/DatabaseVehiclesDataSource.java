package com.chaplin.test1.data.repository.datasource;

import com.chaplin.test1.data.db.AppDatabase;
import com.chaplin.test1.data.entity.VehicleEntity;

import java.util.List;

import androidx.annotation.NonNull;

public class DatabaseVehiclesDataSource implements VehiclesDataSource {

    @NonNull
    private final AppDatabase mDatabase;

    public DatabaseVehiclesDataSource(@NonNull AppDatabase database) {
        mDatabase = database;
    }

    @Override
    public List<VehicleEntity> getVehicles() {
        return mDatabase.getVehiclesDao().loadVehicles();
    }

    /* package */ void saveVehicles(List<VehicleEntity> vehicles) {
        try {
            mDatabase.beginTransaction();
            mDatabase.getVehiclesDao().deleteAllVehicles();
            mDatabase.getVehiclesDao().saveVehicles(vehicles);
            mDatabase.setTransactionSuccessful();
        } finally {
            mDatabase.endTransaction();
        }

    }
}
