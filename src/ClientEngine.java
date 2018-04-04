import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientEngine {
    //Класс выполняющий запуск нескольких потоков клиентов
    public static void main (String args[]) {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            int i = 0;
            while (i < 10) {
                i++;
                Socket socket = new Socket("127.0.0.1", 4242);
                executorService.execute(new ClientFactory());
            }
            executorService.shutdown();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

}