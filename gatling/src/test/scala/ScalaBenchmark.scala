import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ScalaBenchmark extends Simulation {
  val httpConf = http
    .baseURL("http://localhost:9000") // Here is the root for all relative URLs

  val scn = scenario("Scala Benchmark") // A scenario is a chain of requests and pauses
    .exec(http("/scala/future")
      .get("/scala/future"))

  setUp(scn.inject(atOnceUsers(100)).protocols(httpConf))
}
