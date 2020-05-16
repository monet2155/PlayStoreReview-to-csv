

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        JsonArray jsonArray = new JsonArray();
        try {
            FileReader fileReader = new FileReader("E:/Java/.idea/Resources/review.json");
            JsonParser parser = new JsonParser();

            jsonArray = (JsonArray) parser.parse(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fos = new FileOutputStream("E:/Java/.idea/Resources/review.csv");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "EUC-KR");

            BufferedWriter bufferedWriter = new BufferedWriter(osw);
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject obj = (JsonObject) jsonArray.get(i);

                String name = StringUtils.substringBetween(obj.get("body").toString(), "<span class=\\\"X43Kjb\\\">", "</span>");
                String rating = StringUtils.substringBetween(obj.get("body").toString(), "별표 5개 만점에 ", "개를 받았습니다.");
                String date = StringUtils.substringBetween(obj.get("body").toString(), "<span class=\\\"p2TkOb\\\">", "</span>");
                String content = StringUtils.substringBetween(obj.get("body").toString(), "<span jsname=\\\"bN97Pc\\\">", "</span>");

                System.out.println(name + " : " + rating + " : " + date + " : " + content);


                bufferedWriter.write(name+","+rating+"개," + date + "," + content);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(jsonArray.size());

    }

    public void jsonParser(){

    }
}
