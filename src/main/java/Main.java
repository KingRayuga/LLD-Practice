import Adapter.LegacyBankAPi;
import Adapter.LegacyBankAdapter;
import Adapter.PaymentProcessor;
import Adapter.StripePayment;


public class Main {
    public static void main(String[] args){
        PaymentProcessor stripePayment = new StripePayment();
        PaymentProcessor legacyPayment = new LegacyBankAdapter(new LegacyBankAPi());
        stripePayment.doTransaction();
        legacyPayment.doTransaction();
    }
}
