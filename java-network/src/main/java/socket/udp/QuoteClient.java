package socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
//客户模拟询问商家
public class QuoteClient {

    public static void main(String[] args) throws Exception{
        if(args.length!=1){
            System.out.println("Usage:java QuoteClient <hostname>");
            return;
        }
        DatagramSocket socket=new DatagramSocket();
        //send request
        byte[] buf=new byte[256];
        InetAddress address=InetAddress.getByName(args[0]);
        DatagramPacket packet=new DatagramPacket(buf,buf.length,address,4445);
        socket.send(packet);

        //get response
        packet=new DatagramPacket(buf,buf.length);
        socket.receive(packet);
        String received=new String(packet.getData());
        System.out.println("Quote of the Moment:"+received);
    }
}
