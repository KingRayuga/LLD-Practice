package MultiLevelParking;

public class VehicleFactory {
    public Vehicle getVehicle(String vehicleNumber, VehicleType vehicleType){
        return switch (vehicleType) {
            case BUS -> new Bus(vehicleNumber);
            case CAR -> new Car(vehicleNumber);
            case BIKE -> new Bike(vehicleNumber);
        };
    }
}
