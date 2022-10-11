package com.ds.algo.problem.solving.Arrays;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arcesium {

    public static final String GET_URL = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";

    public static void main(String[] args) throws IOException {
        Map<Integer , Integer> map = new HashMap<>();


        map.put(null , null);
        System.out.println(map.size());

        // System.out.println(tokenize("address,test" , ','));

    }

    public static List<String> tokenize(String input , Character ch) {
        List<String> ans = new ArrayList<>();

            int start = 0;
            for(int i = 0 ; i < input.length();i++) {
                if(input.charAt(i) == ch) {
                    ans.add(input.substring(start, i));
                    start = i+1;
                }
            }
            ans.add(input.substring(start));


        return ans;
    }


    public static void test() throws Exception {
        URL url  = new URL(GET_URL);
        HttpURLConnection connection  = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");

        InputStream response = connection.getInputStream();

    }

    private static void sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }

    }

}
