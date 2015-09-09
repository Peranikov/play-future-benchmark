package controllers

import play.api.mvc.{Action, Controller}
import play.libs.Akka

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

class AkkaEc extends Controller with models.Util {
  implicit val executionContext = Akka.system.dispatchers.lookup("my-dispatcher")

  def future = Action {

    println("Akka Future Start");

    val f1 = createFuture
    val f2 = createFuture
    val f3 = createFuture

    Await.result(f1, Duration.Inf)
    Await.result(f2, Duration.Inf)
    Await.result(f3, Duration.Inf)

    println(s"AkkaFuture End ThreadCount: $getThreadCount");

    Ok(s"Akka Future Test.")
  }

  def createFuture = {
    Future(sleep(1000))
  }
}
