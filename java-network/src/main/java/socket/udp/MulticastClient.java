package socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
//接受广播中的数据包
public class MulticastClient {

    public static void main(String[] args) throws IOException {
        MulticastSocket socket=new MulticastSocket(4446);
        InetAddress address=InetAddress.getByName("127.0.0.1");
        socket.joinGroup(address);
        DatagramPacket packet;

        for(int i=0;i<5;i++){
            byte [] buf=new byte[256];
            packet=new DatagramPacket(buf,buf.length);
            socket.receive(packet);
            String received=new String(packet.getData());
            System.out.println("接收到的广播数据:"+received);
        }
        socket.leaveGroup(address);
        socket.close();
    }
}
