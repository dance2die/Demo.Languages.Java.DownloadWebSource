import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dance2die on 4/1/2016.
 */
public class DownloadMain {
    public static void main(final String[] args){
        DownloadContent();
    }

    private static void DownloadContent() {
        String urlText = "http://www.posh24.com/celebrities";
        String result = "";
        HttpURLConnection urlConnection = null;
        URL url;

        try {
            url = new URL(urlText);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
//            InputStreamReader reader = new InputStreamReader(inputStream, "ISO-8859-1");
            InputStreamReader reader = new InputStreamReader(inputStream, "ASCII");

            int data = reader.read();

            while (data != -1){
                char current = (char)data;
                result += current;
                data = reader.read();
            }

            System.out.println("result => " + result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
