package LoggerFramework;

public class AppenderFactory {
    public static Appender getAppender(AppendType appendType, String path){
        return switch(appendType){
            case FILE -> new FileAppender(path);
            case CONSOLE -> new ConsoleAppender();
        };
    }
}
