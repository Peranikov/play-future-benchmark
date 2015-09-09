package controllers

import play.api.mvc.{Action, Controller}
import scalaz.concurrent.Future

class Scalaz extends Controller with models.Util {

  def future = Action {

    println("ScalazFuture Start");

    val f1 = createFuture
    val f2 = createFuture
    val f3 = createFuture

    Future.gatherUnordered(f1 ::f2 ::f3 :: Nil).run

    println(s"ScalazFuture End ThreadCount: $getThreadCount");

    Ok(s"Scala'z' Future Test.")
  }

  def createFuture = {
    Future(sleep(1000))
  }
}
