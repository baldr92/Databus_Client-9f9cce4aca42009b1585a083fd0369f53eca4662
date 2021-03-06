import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientEngineReader {
    public static void main (String args[]) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new ClientFactoryReader());
        executorService.shutdown();
    }
}