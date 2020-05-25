/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blooddonermanagement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
/**
 *
 * @author Administrator
 */
public class sms {
    
    public String sendsms(String num,String name,String address)
    {
        String num1=num;
        String name1=name;
        String dist=address;
        try {
			// Construct data
			String apiKey = "apikey=" + "SPnqpVxsMe0-X8LQnybWOpK3SZZ7Kigfmz8aP4Kh25";
			String message = "&message=" + "NEED A BLOOD ARJENT REQUESTER NAME :"+name1+" "+"Mobile:"+num;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + dist;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
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
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
        
        
    }
    
    public static void main(String[] args)
    {
     
      
    }
    
}
