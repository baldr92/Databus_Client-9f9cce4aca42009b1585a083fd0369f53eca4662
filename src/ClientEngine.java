import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientEngine {
    //Класс выполняющий запуск нескольких потоков клиентов
    public static void main (String args[]) {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            executorService.execute(new ClientFactory());
            executorService.shutdown();
    }
}