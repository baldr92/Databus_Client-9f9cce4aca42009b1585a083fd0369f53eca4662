import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientEngineWriter {
    //Класс выполняющий запуск нескольких потоков клиентов
    public static void main (String args[]) {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            executorService.execute(new ClientFactoryWriter());

            executorService.shutdown();
    }
}