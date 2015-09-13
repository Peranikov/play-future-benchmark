package models

trait Util {
  var requestCount = 0
  var threadCount = 0

  def log[Int](a: Int): Int = {
    log(a, 0)
  }

  def log[Int](a: Int, t: Long): Int = {
    updateThreadCount
    incrementRequestCount
    if (t > 0) {
      Thread.sleep(t)
    }
    a
  }

  def incrementRequestCount = {
    requestCount = requestCount + 1
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

  def getRequestCount = {
    requestCount
  }
}
