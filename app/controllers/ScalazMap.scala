package controllers

import play.api.mvc.{Action, Controller}
import scalaz.concurrent.Task
import models.ScalaFutureConverters._

class ScalazMap extends Controller with models.Util {
  def future = Action.async {
    val t = Task(1)
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
        Ok(s"Got result: $i threads: $getThreadCount")
      }

    scalazTask2scalaFuture(t)
  }
}
