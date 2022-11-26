package com.denich.nextgenmessenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class coding {
    public static String coder(String s) {
        String result = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Base64.Encoder encoder = encoder = Base64.getEncoder();
            result = encoder.encodeToString(s.getBytes()) + encoder.encodeToString("NextGen".getBytes());
        }
            return result;

    }

    public static String decoder(String s) {
        String result = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Base64.Decoder decoder = Base64.getDecoder();
            Base64.Encoder encoder = Base64.getEncoder();
            String key = encoder.encodeToString("NextGen".getBytes());
            s = s.substring(0, s.length() - key.length());
            byte[] bytes = decoder.decode(s);
            result = new String(bytes);
        }
        return result;
    }

    public static void postzapros(String sender, String message) throws IOException {
        String urladres = "http://192.168.1.2:8080/transactions/new";
        URL url;
        HttpURLConnection httpURLConnection;
        OutputStream os = null;
        InputStreamReader isR = null;
        BufferedReader bfR = null;
        try{
            url = new URL(urladres);
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            String stroka ="{\"sender\": \""+sender+"\",\"message\":\""+message+"\"}";
            byte[] out = stroka.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnection.connect();
            httpURLConnection.setConnectTimeout(200);
            httpURLConnection.setReadTimeout(200);
            httpURLConnection.connect();
            try{
                os = httpURLConnection.getOutputStream();
                os.write(out);
            } catch (Exception e){
                System.err.print(e.getMessage());
            }
            if (HttpURLConnection.HTTP_OK==httpURLConnection.getResponseCode()){
                isR = new InputStreamReader(httpURLConnection.getInputStream());
                bfR = new BufferedReader(isR);
                while (bfR.readLine()!= null){
                    System.out.println(bfR.readLine());
                }
            }

        } catch (MalformedURLException e) {
            System.err.print(e.getMessage());
        } catch (IOException e) {
            System.err.print(e.getMessage());
        } finally {
            if(isR!=null)isR.close();
            if(bfR!=null)bfR.close();
            if(os!=null)os.close();
        }
    }
}