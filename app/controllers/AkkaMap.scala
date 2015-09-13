package controllers

import play.api.mvc.{Action, Controller}
import play.libs.Akka
import scala.concurrent.Future

class AkkaMap extends Controller with models.Util {
  implicit val executionContext = Akka.system.dispatchers.lookup("my-dispatcher")

  def future = Action.async {
    Future(1)
      .map(log(_, 1000))
      .map(log(_))
      .map(log(_))
      .map(log(_))
      .map(log(_))
      .map(log(_))
      .map(log(_))
      .map(log(_))
      .map(log(_))
      .map(log(_))
      .map { i =>
        log(i)
        println(s"$getRequestCount\t$getThreadCount")
        Ok(s"Got result: $i threads: $getThreadCount")
      }
  }
}
