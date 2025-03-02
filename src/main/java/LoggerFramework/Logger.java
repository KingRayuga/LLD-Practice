package LoggerFramework;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Logger {
    private static class LoggerHelper{
        static final Logger INSTANCE = new Logger();
    }

    public Logger getInstance(){
        return LoggerHelper.INSTANCE;
    }

    private final Map<LogLevel, List<LogQueue>> logQueues = new EnumMap<>(LogLevel.class);

    private Logger() {
        for (LogLevel level : LogLevel.values()) {
            List<LogQueue> queues = new ArrayList<>();
            queues.add(new LogQueue(AppenderFactory.getAppender(AppendType.FILE, level.name().toLowerCase() + ".log")));
            queues.add(new LogQueue(AppenderFactory.getAppender(AppendType.CONSOLE, null)));  // Console logging
            logQueues.put(level, queues);
        }
    }

    private void log(LogLevel level, String message){
        String formattedMessage = LogFormatter.format(level, message);

        for(LogQueue logQueue: logQueues.get(level)){
            logQueue.add(formattedMessage);
        }
    }


    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
