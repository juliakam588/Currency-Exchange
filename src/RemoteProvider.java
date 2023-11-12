import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class RemoteProvider {
    public byte[] getData(String url) throws IOException {
        URL web = new URL(url);
        URLConnection conn = web.openConnection();
        return conn.getInputStream().readAllBytes();
    }
}
