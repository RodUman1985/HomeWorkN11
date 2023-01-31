
import java.io.*;
import java.net.Socket;

public class ServerSocket {
    private static Socket clientSocket;
    private static java.net.ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;



    public static void main(String[] args) {
        try {


            try {
                server = new java.net.ServerSocket(4006);
                System.out.println("сервер включен!!");
                clientSocket = server.accept();
                try {
                    boolean isConnected = true;
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter((new OutputStreamWriter(clientSocket.getOutputStream())));
                    out.write("привет сервер, пообщаемся... если надоест скажи"+"\n");
                    out.flush();
                    while (isConnected) {
                        String clientWorld = in.readLine();
                        if (clientWorld.equals(("-"))) {
                            out.write("я так и знал \n");
                            out.flush();
                            isConnected = false;

                        } else {

                            out.write(Calculator.calc(clientWorld)+"\n");
                            out.flush();
                        }
                        out.flush();
                    }
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }

            } finally {
                System.out.println("сервер закрыт");
                server.close();
            }
        } catch (IOException e) {
            System.out.println(e);

        }
    }
}
