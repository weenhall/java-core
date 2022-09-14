import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

    public static void main(String[] args) {
        try{
            URL cs=new URL("https://www.sina.com/");
            URLConnection tc=cs.openConnection();
            BufferedReader in=new BufferedReader(new InputStreamReader(tc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
