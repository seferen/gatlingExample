import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import settings.Properties;

public class Engine {
    private static final Logger log = LoggerFactory.getLogger(Engine.class);

    public static void main(String[] args) {

        log.info(
                "serviceUrl: {} startUsersPerSec: {} usersPerSec: {} rampUpDuration: {} testDuration: {} loadSteps: {} Name of simulation: {} ",
                Properties.serviceUrl,
                Properties.startUsersPerSec,
                Properties.usersPerSec,
                Properties.rampUpDuration,
                Properties.testDuration,
                Properties.loadSteps,
                Properties.test);

        GatlingPropertiesBuilder prop = new GatlingPropertiesBuilder();
        prop.simulationClass(Properties.test);
        Gatling.fromMap(prop.build());

    }
}
