package ChainOfResponibility;

public abstract class Logger {
    protected Logger nextLogger;
    protected LoggerType loggerType;

    public void addNextLogger(Logger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(LoggerType loggerType, String logMessage){
        if(this.loggerType.getLevel() <= loggerType.getLevel()){
            write(logMessage);
        }
        if(nextLogger!=null){
            this.nextLogger.logMessage(loggerType, logMessage);
        }
    }

    public abstract void write(String message);
}
