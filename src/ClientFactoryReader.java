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
            InputStreamReader inputStream = new InputStreamReader(serverDialogue.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            String msg;
            while ( (msg = bufferedReader.readLine()) != null) {
                //if (bufferedReader.ready()) {
                //outputStream.writeUTF(bufferedReader.readLine());
                //outputStream.flush();
                //System.out.println("Client wrote & start waiting for data from server...");
                System.out.println("reading...");
                Thread.sleep(2000);
                //String in = bufferedReader.readLine();
                System.out.println(msg);
                //}
            }
        } catch (IOException io) {
            io.printStackTrace();
        } catch ( InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
