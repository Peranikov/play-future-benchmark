package controllers

import java.util.concurrent.Executors

import play.api.mvc.{Action, Controller}
import scalaz.concurrent.Task
import scalaz.concurrent.Strategy._
import models.ScalaFutureConverters._

class ScalazMap extends Controller with models.Util {
  def future = Action.async {
    println("Scalaz Benchmark")

    val pool = Executors.newFixedThreadPool(1, DefaultDaemonThreadFactory)
    val t = Task(1)(pool)
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

    scalazTask2scalaFuture(t)
  }
}
