import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ScalazBenchmark extends Simulation {
  val url = "/scalaz/future"
  val scenarioName = "Scalaz Benchmark"
  val scn = scenario(scenarioName).exec(http(url).get(url))
  setUp(scn.inject(atOnceUsers(Helper.users)).protocols(Helper.httpConf))
}

class DefaultBenchmark extends Simulation {
  val url = "/default/future"
  val scenarioName = "Default Benchmark"
  val scn = scenario(scenarioName).exec(http(url).get(url))
  setUp(scn.inject(atOnceUsers(Helper.users)).protocols(Helper.httpConf))
}

class AkkaBenchmark extends Simulation {
  val url = "/akka/future"
  val scenarioName = "Akka Benchmark"
  val scn = scenario(scenarioName).exec(http(url).get(url))
  setUp(scn.inject(atOnceUsers(Helper.users)).protocols(Helper.httpConf))
}

class ScalaBenchmark extends Simulation {
  val url = "/scala/future"
  val scenarioName = "Scala Benchmark"
  val scn = scenario(scenarioName).exec(http(url).get(url))
  setUp(scn.inject(atOnceUsers(Helper.users)).protocols(Helper.httpConf))
}