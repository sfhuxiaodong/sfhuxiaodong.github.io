package hxd.util;

import java.io.*;
import java.net.URLDecoder;

/**
 * Created by Administrator on 2018/1/5.
 */
public class FileUtil {
    public static String readJson(String path) {
        File file = new File(path);
        String result=new String();
        FileInputStream fis = null;
        InputStreamReader isr=null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(file);
            isr=new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String temp=null;
            while(null!=(temp=br.readLine())){
                result+=temp;
                temp=null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static String getRealPath(Class clazz){
        String path=clazz.getProtectionDomain().getCodeSource().getLocation().getPath();
        try {
            path= URLDecoder.decode(path,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return path;
    }
//    public static int writeJson(){}
//    public static int writeJson(String name){
//        String path=FileUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//        try {
//            path = URLDecoder.decode(path, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        File parentPath=new File(path+"\\history");
//        if(!parentPath.exists()){
//            parentPath.mkdir();
//        }
//    }
//    public static int writeJson(String path){
//        File parentPath=new File(path);
//        if(!parentPath.exists()){
//            parentPath.mkdir();
//        }
//    }
//    public static int writeJson(String path,String name){}
}
