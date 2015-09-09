package models

import scalaz.{-\/, \/-}
import scalaz.concurrent.{Task}
import scala.concurrent.{Promise, ExecutionContext, Future}

object ScalaFutureConverters {
  implicit def scalazTask2scalaFuture[T](task: Task[T]): Future[T] = {
    val p: Promise[T] = Promise()

    task.runAsync {
      case -\/(ex) => p.failure(ex)
      case \/-(r) => p.success(r)
    }

    p.future
  }
}
