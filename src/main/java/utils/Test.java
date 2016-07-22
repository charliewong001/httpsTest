package utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestServerSSL {
    /** * The main method. * * @param args * the arguments */ 
     public static void main(String[] args) {
         DefaultHttpClient httpclient = new DefaultHttpClient();
         try { 
             // 信任自身签发证书
             SSLSocketFactory socketFactory = new SSLSocketFactory( new TrustSelfSignedStrategy()); 
             Scheme sch = new Scheme("https", socketFactory, 8443); 
             httpclient.getConnectionManager().getSchemeRegistry().register(sch); 
             HttpGet httpget = new HttpGet( "https://server:8443/api/rest/test");
             HttpResponse response = httpclient.execute(httpget);
             HttpEntity entity = response.getEntity(); 
             System.out.println("-------------response-------------"); 
             System.out.println(response.getStatusLine()); 
             if (entity != null) { 
                 System.out.println("Response content length: " + entity.getContentLength()); 
                 int length = (int) entity.getContentLength(); 
                 byte[] b = new byte[length]; 
                 entity.getContent().read(b); 
                 System.out.println(new String(b)); 
                 } 
             if (entity != null) { 
                 entity.consumeContent();
                 } 
             } catch (Exception e) { 
                 // TODO: handle exception e.printStackTrace();
                 } 
         ().shutdown(); }
}}}}
