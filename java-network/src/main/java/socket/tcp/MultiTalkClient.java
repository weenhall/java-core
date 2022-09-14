package socket.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiTalkClient {
    int num;
    public static void main(String[] args) {
        try{
            Socket client=new Socket("127.0.0.1",4700);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw=new PrintWriter(client.getOutputStream());

            BufferedReader is=new BufferedReader(new InputStreamReader(client.getInputStream()));
            String readLine;
            readLine=br.readLine();
            while (!readLine.equals("goodBye")){
                pw.println(readLine);
                pw.flush();
                System.out.println("Client:"+readLine);
                System.out.println("Server:"+is.readLine());
                readLine=br.readLine();
            }
            pw.close();
            is.close();
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
