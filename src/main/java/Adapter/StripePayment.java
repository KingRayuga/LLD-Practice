package Adapter;

public class StripePayment implements PaymentProcessor{
    @Override
    public void doTransaction() {
        System.out.println("doing transaction.....");
    }
}
