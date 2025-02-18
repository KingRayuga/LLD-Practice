package MultiLevelParking;

class Receipt {
    private final String vehicleNumber;
    private final long entryTime;
    private final long exitTime;
    private final String locationCode;
    private final double totalAmount;

    public Receipt(String vehicleNumber, long entryTime, long exitTime, String locationCode, double totalAmount) {
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.locationCode = locationCode;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", locationCode='" + locationCode + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
