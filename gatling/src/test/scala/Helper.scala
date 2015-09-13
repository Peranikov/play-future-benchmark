import io.gatling.http.Predef._

object Helper {
  val baseURL = "http://192.168.33.10:9000"
  val users = 10000

  def httpConf = {
    http.baseURL(baseURL) // Here is the root for all relative URLs
  }
}
