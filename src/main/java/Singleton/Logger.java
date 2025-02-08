package Singleton;

public class Logger {
    private Logger(){}
    private static class LoggerHelper{
        static final Logger logger = new Logger();
    }
    public static Logger getInstance(){
        return LoggerHelper.logger;
    }
    public void log(String message){
        System.out.println("logging message " + message);
    }
}
