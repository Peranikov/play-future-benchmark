package controllers

import play.api.mvc.{Action, Controller}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
//  implicit val ec = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(4))

class Scala extends Controller with models.Util {

  def future = Action {

    println("Scala Future Start");

    val f1 = createFuture
    val f2 = createFuture
    val f3 = createFuture

    Await.result(f1, Duration.Inf)
    Await.result(f2, Duration.Inf)
    Await.result(f3, Duration.Inf)

    println(s"ScalaFuture End ThreadCount: $getThreadCount");

    Ok(s"Scala Future Test.")
  }

  def createFuture = {
    Future(sleep(1000))
  }
}
