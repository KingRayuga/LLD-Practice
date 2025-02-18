package MultiLevelParking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingArea {
    private final int level;
    private final List<ParkingSpot> parkingSpotList;

    ParkingArea(int level){
        this.level = level;
        parkingSpotList = new ArrayList<>();
    }

    public int getLevel() {
        return level;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpotList.add(parkingSpot);
    }

    public Optional<ParkingSpot> findParkingSpot(VehicleType vehicleType){
        for(ParkingSpot parkingSpot: parkingSpotList){
            if(!parkingSpot.isReserved() && parkingSpot.getVehicleType()==vehicleType){
                return Optional.of(parkingSpot);
            }
        }
        return Optional.empty();
    }

    public Optional<ParkingSpot> getVehicle(Vehicle vehicle){
        for(ParkingSpot parkingSpot: parkingSpotList){
            if(!parkingSpot.isReserved() && vehicle.equals(parkingSpot.getCurrentVehicle())){
                return Optional.of(parkingSpot);
            }
        }
        return Optional.empty();
    }
}
