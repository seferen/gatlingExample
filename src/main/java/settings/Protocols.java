package settings;

import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.http.HttpDsl.*;

public class Protocols {
    public static HttpProtocolBuilder accountHttp = http.baseUrl(
            Properties.serviceUrl)
            .warmUp(String.format("%s/version", Properties.serviceUrl));

}
