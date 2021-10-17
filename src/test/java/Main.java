import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {

        String url = "http://universities.hipolabs.com/search";
        String charset = "UTF-8";
//        String param1 = "mykey";
        String queryParam = "name";
        String queryVal = "middle";
        try {
//            String queryParam = String.format("key=%s", URLEncoder.encode(param1, charset));
            URLConnection connection = new URL(url + "?" + queryParam + "=" + queryVal).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            connection.setRequestProperty("Content-Type", "application/json");
            if (connection instanceof HttpURLConnection) {
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestMethod("GET");
//                System.out.println(httpConnection.getResponseCode());
//                System.out.println(httpConnection.getResponseMessage());
                BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String s = br.readLine();
                while (s!=null) {
                    sb.append(s);
                    s= br.readLine();
                }
                System.out.println(sb);
            } else {
                System.err.println("error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
