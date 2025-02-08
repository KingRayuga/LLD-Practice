package Adapter;

public class LegacyBankAdapter implements PaymentProcessor{

    private final LegacyBankAPi legacyBankAPi;

    public LegacyBankAdapter(LegacyBankAPi legacyBankAPi){
        this.legacyBankAPi = legacyBankAPi;
    }
    @Override
    public void doTransaction() {
        legacyBankAPi.completePayment();
    }
}
