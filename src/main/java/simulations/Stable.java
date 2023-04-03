package simulations;

import scenarios.example;
import settings.Properties;
import settings.Protocols;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;

public class Stable extends Simulation {
    {
        setUp(
                scenario("Stable")
                        .exec(example.version())
                        .injectOpen(
                                rampUsersPerSec(Properties.startUsersPerSec)
                                        .to(Properties.usersPerSec)
                                        .during(Properties.rampUpDuration),
                                constantUsersPerSec(Properties.usersPerSec)
                                        .during(Properties.testDuration)))
                .protocols(Protocols.accountHttp)
                .assertions(
                        forAll().responseTime().max().lt(10000),
                        forAll().failedRequests().percent().lt(1.0));
    }
}
