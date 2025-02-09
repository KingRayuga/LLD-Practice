import ChainOfResponibility.*;

public class Main {
    public static void main(String[] args){
        Logger infoLogger = new InfoLogger();
        Logger debugLogger = new DebugLogger();
        Logger errorLogger = new ErrorLogger();

        infoLogger.addNextLogger(debugLogger);
        debugLogger.addNextLogger(errorLogger);

        infoLogger.logMessage(LoggerType.INFO, "This is an info message");
        infoLogger.logMessage(LoggerType.DEBUG, "This is a debug message");
        infoLogger.logMessage(LoggerType.ERROR, "This is an error message");
    }
}
