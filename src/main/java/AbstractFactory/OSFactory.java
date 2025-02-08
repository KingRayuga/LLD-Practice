package AbstractFactory;

public class OSFactory {
    public OS getOS(OSType osType){
        return switch (osType){
            case MAC -> new Mac();
            case WINDOWS -> new Windows();
        };
    }
}
