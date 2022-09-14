package socket.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class QuoteServerThread extends Thread {

    protected DatagramSocket socket=null;
    protected BufferedReader in=null;
    protected boolean moreQuotes=true;

    public QuoteServerThread() throws IOException {
        this("QuoteServerThread");
    }

    public QuoteServerThread(String name) throws IOException {
        super(name);
        socket=new DatagramSocket(4445);
        try{
            in=new BufferedReader(new FileReader(new File("JavaNetWork/src/main/resources/menu.txt")));
        }catch (FileNotFoundException e){
            System.out.println("找不到menu.txt");
        }
    }

    @Override
    public void run() {
        while (moreQuotes){
            try{
                byte[] buf=new byte[256];
                DatagramPacket packet=new DatagramPacket(buf,buf.length);
                socket.receive(packet);

                String str=null;
                if(in==null){
                    str=new Date().toString();
                }else{
                    str=getNextQuote();
                }
                buf=str.getBytes();
                //send response to client
                InetAddress address=packet.getAddress();
                int port=packet.getPort();
                packet=new DatagramPacket(buf,buf.length,address,port);
                socket.send(packet);
            }catch (Exception e){
                e.printStackTrace();
                moreQuotes=false;
            }
        }
        socket.close();
    }

    private String getNextQuote(){
        String returnStr=null;
        try{
            if((returnStr=in.readLine())==null){
                in.close();
                moreQuotes=false;
                returnStr="没有更多商品了";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnStr;
    }
}
