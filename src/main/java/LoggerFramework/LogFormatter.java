package LoggerFramework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFormatter {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String format(LogLevel level, String message){
        return "[" + LocalDateTime.now().format(dateTimeFormatter) + "] [" + level + "] [" + message + "]";
    }
}
