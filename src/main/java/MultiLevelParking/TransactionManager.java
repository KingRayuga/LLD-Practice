package MultiLevelParking;

import java.time.Instant;

class TransactionManager {
    private static class TransactionManagerHelper {
        private static final TransactionManager INSTANCE = new TransactionManager();
    }

    private TransactionManager() {}

    public static TransactionManager getInstance() {
        return TransactionManagerHelper.INSTANCE;
    }

    public Receipt makePayment(ParkingSpot spot, Payment payment) {
        long exitTime = Instant.now().getEpochSecond();
        double totalAmount = calculateAmount(spot.getEntryTime(), exitTime);
        payment.doTransaction();
        return new Receipt(spot.getCurrentVehicle().getVehicleNumber(), spot.getEntryTime(), exitTime, spot.getLocationCode(), totalAmount);
    }

    private double calculateAmount(long entryTime, long exitTime) {
        return (exitTime - entryTime) * 0.05; // Example calculation
    }
}