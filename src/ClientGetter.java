import java.io.*;
import java.net.Socket;

public class ClientGetter {
    public static void main(String args[]) {
        try {

            Socket socket = new Socket("127.0.0.1", 4242);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            while(!socket.isInputShutdown()){
                if(bufferedReader.ready()) {
                    System.out.println("ClientEngineWriter starts writing in channel");
                    String text = bufferedReader.readLine();
                    outputStream.writeUTF(text);
                    outputStream.flush();
                    System.out.println("Your message " + "<<" + text + ">>" + "  has been sent");
                    System.out.println("Гет реди фо геттин сообщение с сервера");
                    String getTextFromServer = inputStream.readUTF();
                    System.out.println(getTextFromServer);
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
            System.out.println(io.getMessage());
        }
    }

    public void getMessageFromServer(){

    }
    public void createFile(){

    }
    public void writeToFile(){

    }
}
