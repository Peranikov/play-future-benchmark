package controllers

import play.api.mvc.{Action, Controller}

import scala.concurrent.{Future, Await}
import scala.concurrent.duration.Duration
import play.api.libs.concurrent.Execution.Implicits.defaultContext

class DefaultContext extends Controller with models.Util {

  def future = Action {

    println("Default Future Start");

    val f1 = createFuture
    val f2 = createFuture
    val f3 = createFuture

    Await.result(f1, Duration.Inf)
    Await.result(f2, Duration.Inf)
    Await.result(f3, Duration.Inf)

    println(s"DefaultFuture End ThreadCount: $getThreadCount");

    Ok(s"Default Future Test.")
  }

  def createFuture = {
    Future(sleep(1000))
  }

}
