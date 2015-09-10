package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.mvc.{Action, Controller}

import scala.concurrent.Future

class ScalaMap extends Controller with models.Util {
  def future = Action.async {
    println("Scala Benchmark")

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
        Ok(s"Got result: $i threads: $getThreadCount")
      }
  }
}
