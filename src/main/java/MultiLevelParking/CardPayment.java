package MultiLevelParking;

class CardPayment implements Payment {
    @Override
    public void doTransaction() {
        System.out.println("Transaction completed using Card.");
    }
}