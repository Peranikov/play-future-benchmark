package controllers

import play.api.mvc.{Action, Controller}
import scalaz.concurrent.Task

class ScalazMap extends Controller with models.Util {
  TODO

//   def future = Action.async {
//     Task(1)
//       .map(log(_, 1000))
//       .map(log(_))
//       .map(log(_))
//       .map(log(_))
//       .map(log(_))
//       .map(log(_))
//       .map(log(_))
//       .map(log(_))
//       .map(log(_))
//       .map(log(_))
//       .map { i =>
//         log(i)
//         Ok(s"Got result: $i threads: $getThreadCount")
//       }
//   }
 }
