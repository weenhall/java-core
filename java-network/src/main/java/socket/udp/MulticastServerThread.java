package socket.udp;

import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class MulticastServerThread extends Thread {

    private long FIVE_SENCOND = 5000;
    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean moreQuotes = true;

    public MulticastServerThread() throws Exception {
        super("MulticastServerThread");
    }

    @Override
    public void run() {
        try {
            while (moreQuotes) {
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                String str = null;
                if (in == null) {
                    str = new Date().toString();
                } else {
                    str = getNextQuote();
                }
                buf = str.getBytes();
                //发送数据包
                InetAddress group=InetAddress.getByName("127.0.0.1");
                packet=new DatagramPacket(buf,buf.length,group,4446);
                socket.send(packet);
                try{
                    sleep((long)Math.random()*FIVE_SENCOND);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    moreQuotes=false;
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
