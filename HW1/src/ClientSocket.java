import java.io.*;
import java.net.Socket;

public class ClientSocket {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localHost", 4006);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String serverWorld = in.readLine();
                System.out.println(serverWorld);
                boolean isConnected = true;

                while (isConnected) {
                    String clientWorld = reader.readLine();
                    out.write(clientWorld + "\n");
                    out.flush();
                    if (!clientWorld.equals("-")) {
                        String res = in.readLine();
                        System.out.println(res);
                    } else {
                        System.out.println(in.readLine());
                        isConnected = false;
                    }


                }
            }finally {
                System.out.println("клиент будет закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        }catch (IOException e){
            System.out.println(e);}
    }

}