import java.io.*;
import java.net.Socket;

public class ClientFactoryReader implements Runnable {
    static Socket serverDialogue;
    public ClientFactoryReader(){
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
            //DataOutputStream outputStream = new DataOutputStream(serverDialogue.getOutputStream());
            DataInputStream inputStream = new DataInputStream(serverDialogue.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (!serverDialogue.isOutputShutdown())
                if (bufferedReader.ready()) {
                    //outputStream.writeUTF(bufferedReader.readLine());
                    //outputStream.flush();
                    //System.out.println("Client wrote & start waiting for data from server...");
                    System.out.println("reading...");
                    String in = inputStream.readUTF();
                    System.out.println(in);
                }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
