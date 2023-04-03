package scenarios;

import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class example {

        public static ChainBuilder version() {
                return exec(http("GET version")
                                .post("version"));
        }

}
