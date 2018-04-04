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
            System.out.println("Stream of in and out has been created");
            String getText = bufferedReader.readLine();
            outputStream.writeUTF(getText);
            outputStream.flush();
            System.out.println("Your message was successfully sent");
            System.out.println("Receive your message from Server");
            Thread.sleep(1000);
            String textFromServer = inputStream.readUTF();
            System.out.println("Ваше сообщение от Сервера: " + textFromServer);
        } catch (IOException io) {
            io.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
