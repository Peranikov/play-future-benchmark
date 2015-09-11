import io.gatling.http.Predef._

object Helper {
  val baseURL = "http://localhost:9000"
  val users = 5000

  def httpConf = {
    http.baseURL(baseURL) // Here is the root for all relative URLs
  }
}
