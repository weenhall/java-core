import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class GetAndPost {

    public static void main(String[] args) {
        String getResult=sendGet("localhost:8080/test","admin");
        String postResult=sendPost("localhost:8080/test","admin");
        System.out.println(getResult+"-------"+postResult);
    }

    public static String sendGet(String url,String param){
        String result="";
        BufferedReader in=null;
        try{
            String urlNameStr=url+"?"+param;
            URL realUrl=new URL(urlNameStr);
            URLConnection connection=realUrl.openConnection();
            //设置请求属性
            connection.setRequestProperty("accept","/");
            connection.setRequestProperty("connection","Keep-Alive");
            connection.connect();
            //读取response
            in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line=in.readLine())!=null){
                result+=line;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static String sendPost(String url,String param){
        PrintWriter out=null;
        BufferedReader in=null;
        String result="";
        try{
            URL realUrl=new URL(url);
            URLConnection connection=realUrl.openConnection();
            connection.setRequestProperty("accept","/");
            connection.setRequestProperty("connection","Keep-Alive");
            connection.setDoOutput(true);
            out=new PrintWriter(connection.getOutputStream());
            //设置请求参数
            out.print(param);
            //flush输出流的缓冲
            out.flush();

            in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line=in.readLine())!=null){
                result+=line;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out!=null){
                out.close();
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
