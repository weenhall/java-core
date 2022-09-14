package socket.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket = null;
    int clientNum;

    public ServerThread(Socket socket, int num) {
        this.socket = socket;
        this.clientNum = num + 1;
    }

    @Override
    public void run() {
        try {
            String line;
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Client ["+clientNum+"] says:" + is.readLine());
            line = sin.readLine();
            while (!line.equals("goodBye")) {
                os.println(line);
                os.flush();
                System.out.println("Server says:" + line);
                System.out.println("Client ["+clientNum+"] says:"+ is.readLine());
                line = sin.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
