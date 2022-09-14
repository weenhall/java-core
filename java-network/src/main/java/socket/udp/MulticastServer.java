package socket.udp;

public class MulticastServer {

    public static void main(String[] args) throws Exception{
        new MulticastServerThread().start();
    }
}
