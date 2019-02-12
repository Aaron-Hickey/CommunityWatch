package controllers;

import play.mvc.Result;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import static play.mvc.Results.ok;

public class SMSController {
    public SMSController(){};
    public Result testSMS() {
        try {
            // Construct data
            String apiKey = "apikey=" + "fnl4MNxc9Ww-m3T2oQy8nGQH1CTOvAcqSxlbTjny1B";
            String message = "&message=" + "SMS Test";
            String sender = "&sender=" + "Community Watch";
            String numbers = "&numbers=" + "+353876032236";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return ok(stringBuffer.toString());
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return ok("Error "+e);
        }
    }

    public Result sendSMS(String location, String messageParam, String user, String number) {
        try {
            // Construct data
            String apiKey = "apikey=" + "fnl4MNxc9Ww-m3T2oQy8nGQH1CTOvAcqSxlbTjny1B";
            String message = "&message=" + messageParam + "sent from" + user;
            String sender = "&sender=" + location + "Community Watch";
            String numbers = "&numbers=" + number;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return ok(stringBuffer.toString());
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return ok("Error "+e);
        }
    }
}