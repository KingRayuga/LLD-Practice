package ChainOfResponibility;

public class InfoLogger extends Logger{
    public InfoLogger(){
        this.loggerType = LoggerType.INFO;
    }

    @Override
    public void write(String message) {
        System.out.println(this.loggerType.name() + ": " + message);
    }
}
