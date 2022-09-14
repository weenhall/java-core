package socket.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {

    public static void main(String[] args) {
        ServerSocket server=null;
        try{
            server=new ServerSocket(4700);
            Socket socket=null;
            socket=server.accept();

            String line;
            BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os=new PrintWriter(socket.getOutputStream());
            BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Client says:"+is.readLine());
            line=sin.readLine();
            while (!line.equals("goodBye")){
                os.println(line);
                os.flush();
                System.out.println("Server says:"+line);
                System.out.println("Client says:"+is.readLine());
                line=sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
