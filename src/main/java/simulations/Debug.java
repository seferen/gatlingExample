package simulations;

import settings.Protocols;
import scenarios.example;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;

public class Debug extends Simulation {

    {
        setUp(scenario("debug")
                .exec(example.version())
                .injectOpen(atOnceUsers(1)))
                .protocols(Protocols.accountHttp);
    }

}
