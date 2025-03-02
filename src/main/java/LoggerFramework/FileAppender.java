package LoggerFramework;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.concurrent.locks.ReentrantLock;

public class FileAppender implements Appender{
    private final String path;
    private ReentrantLock lock = new ReentrantLock();

    FileAppender(String path){
        this.path = path;
    }

    @Override
    public void append(String message) {
        lock.lock();
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(path))){
            printWriter.println(message);
        } catch(Exception e){
            System.out.println("got error while appending logs to file " + e);
        } finally {
            lock.unlock();
        }
    }
}
