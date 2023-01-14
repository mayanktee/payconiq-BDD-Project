package org.utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Utils {

    public static String getGlobalValues(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis= new FileInputStream("src/test/resources/global.properties");

        prop.load(fis);
        return prop.getProperty(key);
    }

    public static Map addQueryParams(String key, String value) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis= new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        prop.get(key);
        Map map = new HashMap();
        map.put(key,value);
        return map;
    }

    public static Map<String,String > getAllRequestParams(String key) throws IOException {

        ArrayList<String> al = new ArrayList();
        Map<String,String> map= new HashMap();
        Properties prop = new Properties();
        FileInputStream fis= new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        int len = prop.get(key).toString().split(",").length;
        System.out.println();

        for (int i=0;i<len;i++) {
            String params = prop.get(key).toString().split(",")[i];
            params.split("=");
            map.put(params.split("=")[0],params.split("=")[1]);
        }
        return map;

    }

    public static String getJsonPath(Response response, String key)
    {
        String resp=response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
