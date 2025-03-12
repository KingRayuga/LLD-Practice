package ATM;

public enum Cash {
    TWO_THOUSAND(2000),
    ONE_THOUSAND(1000),
    FIVE_HUNDRED(500),
    TWO_HUNDRED(200),
    ONE_HUNDRED(100),
    FIFTY(50),
    TWENTY(20),
    TEN(10);

    private final int value;

    Cash(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
