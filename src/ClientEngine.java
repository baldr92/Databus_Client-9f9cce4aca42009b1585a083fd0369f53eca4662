import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientEngine {
    //Класс выполняющий запуск нескольких потоков клиентов
    public static void main (String args[]) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            int i = 0;
            while (i < 10) {
                i++;
                executorService.execute(new ClientFactory());
            }
            executorService.shutdown();
    }
}