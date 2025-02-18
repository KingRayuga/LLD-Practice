package MultiLevelParking;

public class Gate {
    private final int gateNumber;
    private final GateType gateType;

    Gate(int gateNumber, GateType gateType){
        this.gateNumber = gateNumber;
        this.gateType = gateType;
    }

    public GateType getGateType() {
        return gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }
}
