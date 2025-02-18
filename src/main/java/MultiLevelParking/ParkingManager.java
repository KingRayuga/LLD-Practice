package MultiLevelParking;

import java.util.*;

class ParkingManager {
    private static class ParkingManagerHelper {
        private static final ParkingManager INSTANCE = new ParkingManager();
    }

    private final List<ParkingArea> parkingAreas;
    private final Map<Vehicle, ParkingSpot> occupiedSpots;
    private final TransactionManager transactionManager;

    private ParkingManager() {
        parkingAreas = new ArrayList<>();
        occupiedSpots = new HashMap<>();
        transactionManager = TransactionManager.getInstance();
    }

    public static ParkingManager getInstance() {
        return ParkingManagerHelper.INSTANCE;
    }

    public Optional<ParkingSpot> findAndReserveSpot(Vehicle vehicle) {
        for (ParkingArea area : parkingAreas) {
            Optional<ParkingSpot> spot = area.findParkingSpot(vehicle.getVehicleType());
            if (spot.isPresent()) {
                ParkingSpot parkingSpot = spot.get();
                parkingSpot.setCurrentVehicle(vehicle);
                occupiedSpots.put(vehicle, parkingSpot);
                return spot;
            }
        }
        return Optional.empty();
    }

    public PaymentStatus exitVehicle(Vehicle vehicle, Payment payment) {
        ParkingSpot spot = occupiedSpots.remove(vehicle);
        if (spot != null) {
            Receipt receipt = transactionManager.makePayment(spot, payment);
            spot.setCurrentVehicle(null);
            return PaymentStatus.SUCCESS;
        }
        return PaymentStatus.FAILED;
    }
}
