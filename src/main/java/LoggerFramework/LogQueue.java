package LoggerFramework;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class LogQueue {
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private final Appender appender;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    LogQueue(Appender appender){
        this.appender = appender;
    }

    public void add(String message){
        queue.add(message);
    }

    public void startWorkerThread(){
        executorService.submit(() -> {
            try{
                while(!Thread.currentThread().isInterrupted()){
                    String message = queue.take();
                    appender.append(message);
                }
            }catch (Exception e){
                System.out.println("Thread interrupted " + e);
            }
        });
    }

}
