package simulations;

import scenarios.example;
import settings.Properties;
import settings.Protocols;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;

public class Load extends Simulation {
  {
    setUp(
        scenario("Load")
            .exec(example.version())
            .injectOpen(incrementUsersPerSec(Properties.usersPerSec)
                .times(Properties.loadSteps)
                .eachLevelLasting(Properties.testDuration)
                .separatedByRampsLasting(Properties.rampUpDuration)
                .startingFrom(Properties.startUsersPerSec),
                constantUsersPerSec(Properties.testDuration)
                    .during(Properties.testDuration * 5)))
        .protocols(Protocols.accountHttp)
        .assertions(
            forAll().responseTime().max().lt(10000),
            forAll().failedRequests().percent().lt(1.0));
  }
}
