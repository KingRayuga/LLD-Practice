package ChainOfResponibility;

public class DebugLogger extends Logger{
    public DebugLogger(){
        this.loggerType = LoggerType.DEBUG;
    }

    @Override
    public void write(String message) {
        System.out.println(this.loggerType.name() + ": " + message);
    }
}
