package com.company;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class Main {

    private static HttpURLConnection connection;
    public static void main(String[] args) throws IOException {

        try {
            // Create a neat value object to hold the URL
            URL url = new URL("http://52.20.176.4:8090/api/eftv2/");
            String username = "apiaccount";
            String password = "abc.123!";


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String userCredentials = username + ":" +password;
            String encoded = Base64.getEncoder().encodeToString((userCredentials).getBytes(StandardCharsets.UTF_8));  //Java 8
            connection.setRequestProperty("Authorization", "Basic " + encoded);


            //set up request
            connection.setRequestMethod("GET");
           connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);


            //get response status from the server
            int status = connection.getResponseCode();
            System.out.println(status);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
