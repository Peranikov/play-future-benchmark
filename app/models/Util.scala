package models

trait Util {
  var threadCount = 0

  def log[Int](a: Int): Int = {
    log(a, 0)
  }

  def log[Int](a: Int, t: Long): Int = {
    updateThreadCount
    if (t > 0) {
      Thread.sleep(t)
    }
    a
  }

  def updateThreadCount = {
    val c = Thread.activeCount()
    if (threadCount < c) {
      threadCount = c
    }
  }

  def getThreadCount = {
    threadCount
  }
}
