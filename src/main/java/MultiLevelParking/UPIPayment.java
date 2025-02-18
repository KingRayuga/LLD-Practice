package MultiLevelParking;

class UPIPayment implements Payment {
    @Override
    public void doTransaction() {
        System.out.println("Transaction completed using UPI.");
    }
}