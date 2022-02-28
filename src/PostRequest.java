import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {

    public static final String URI_POST = "http://httpbin.org/forms/post";

    public static void main(String[] args) throws FileNotFoundException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request= HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("")))
                .timeout(Duration.ofSeconds(5))
                .uri(URI.create(URI_POST))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::print)
                .join();
    }
}
