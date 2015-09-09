import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ScalazBenchmark extends Simulation {
  val httpConf = http
    .baseURL("http://localhost:9000") // Here is the root for all relative URLs

  val scn = scenario("Scalaz Benchmark") // A scenario is a chain of requests and pauses
    .exec(http("/scalaz/future")
      .get("/scalaz/future"))

  setUp(scn.inject(atOnceUsers(100)).protocols(httpConf))
}
