package models

trait Util {
  var threadCount = 0

  def calc[A](a: A) = {
    val now = new java.util.Date();
    updateThreadCount
    a
  }

  def sleep(t: Long) = {
    updateThreadCount
    Thread.sleep(t)
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
