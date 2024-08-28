import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class ComputerDatabaseSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol =
            http.baseUrl("https://computer-database.gatling.io")
                    .acceptHeader("application/json")
                    .contentTypeHeader("application/json");

    ScenarioBuilder myFirstScenario = scenario("My First Scenario")
            .exec(http("Request 1")
                    .get("/computers/"));

    {
        setUp(
                myFirstScenario.injectOpen(constantUsersPerSec(2).during(60))
        ).protocols(httpProtocol);
    }
}