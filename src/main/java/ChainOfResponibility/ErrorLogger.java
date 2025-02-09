package ChainOfResponibility;

public class ErrorLogger extends Logger{

    public ErrorLogger(){
        this.loggerType = LoggerType.ERROR;
    }

    @Override
    public void write(String message) {
        System.out.println(this.loggerType.name() + ": " + message);
    }
}
