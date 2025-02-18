package MultiLevelParking;

import java.time.Instant;

public class ParkingSpot {
    private final String locationCode;
    private final VehicleType vehicleType;
    private Vehicle currentVehicle;
    private long entryTime;

    ParkingSpot(String locationCode, VehicleType vehicleType){
        this.locationCode = locationCode;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public void setCurrentVehicle(Vehicle currentVehicle) {
        this.currentVehicle = currentVehicle;
        this.entryTime = Instant.now().getEpochSecond();
    }

    public boolean isReserved(){
        return this.currentVehicle!=null;
    }
}
