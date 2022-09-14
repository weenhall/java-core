package socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;

public class MultiTalkServer {

    public static int clientNum=0;

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=null;
        boolean listening=true;
        try{
            serverSocket=new ServerSocket(4700);
        }catch (IOException e){
            System.out.println("端口4700已占用");
            System.exit(-1);
        }
        while (listening){
            new ServerThread(serverSocket.accept(),clientNum).start();
            clientNum++;
        }
        serverSocket.close();
    }
}
