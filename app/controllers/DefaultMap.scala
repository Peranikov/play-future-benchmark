package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import scala.concurrent.Future

class DefaultMap extends Controller with models.Util {
  def future = Action.async {
    println("Default Benchmark")

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
        println(s"threads: $getThreadCount")
        Ok("OK")
      }
  }
}
