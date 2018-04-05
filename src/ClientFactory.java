import java.io.*;
import java.net.Socket;

public class ClientFactory implements Runnable {
    static Socket serverDialogue;
    public ClientFactory(){
        try {
            serverDialogue = new Socket("127.0.0.1", 4242);
            System.out.println("Client connected with socket");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            DataOutputStream outputStream = new DataOutputStream(serverDialogue.getOutputStream());
            DataInputStream inputStream = new DataInputStream(serverDialogue.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int i = 0;
            // создаём рабочий цикл
            while (i < 5) {

                // пишем сообщение автогенерируемое циклом клиента в канал
                // сокета для сервера
                outputStream.writeUTF("clientCommand " + i + " sent");

                // проталкиваем сообщение из буфера сетевых сообщений в канал
                outputStream.flush();

                // ждём чтобы сервер успел прочесть сообщение из сокета и
                // ответить

                System.out.println("Client wrote & start waiting for data from server...");

                // забираем ответ из канала сервера в сокете
                // клиента и сохраняем её в ois переменную, печатаем на
                // консоль
                System.out.println("reading...");
                String in = inputStream.readUTF();
                System.out.println(in);
                i++;
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
