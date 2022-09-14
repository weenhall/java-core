import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author weenhall
 */
public class JsonTest {
    public static void main(String[] args) {
        String str="{\"_id\": \"PDP2G_1566351110\", \"time_lst\": [], \"power_lst\": [240.1269989013672, 244.49200439453125], \"water_lst\": [841, 841]}";
        JSONObject jobj=JSONObject.parseObject(str);

        System.out.println("key:_id,value:"+jobj.getString("_id"));
        System.out.println("key:time_lst,value:"+jobj.getJSONArray("time_lst"));
        System.out.println("key:power_lst,value:"+jobj.getJSONArray("power_lst"));
        System.out.println("key:water_lst,value:"+jobj.getJSONArray("water_lst"));

        Object [] power_lst=jobj.getJSONArray("power_lst").toArray();
        List<String> water_lst=jobj.getJSONArray("water_lst").toJavaList(String.class);
        System.out.println(power_lst.toString());

        Map<String,Object> jsonMap=jobj.getInnerMap();
        System.out.println(jsonMap.toString());

        try {
           Date date= new SimpleDateFormat("yyyyMMdd").parse("430922199403020515".substring(6,14));
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
