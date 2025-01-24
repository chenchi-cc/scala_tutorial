package chapter07

import scala.collection.immutable.Queue
import scala.collection.mutable

object Test19_Queue {
  def main(args: Array[String]): Unit = {
    // 不可变队列
    val queue1: Queue[String] = Queue("a", "b", "c")
    val queue_tmp = queue1.enqueue("d")
    println(queue1)
    println(queue_tmp)
    println("==========================")
    // 可变队列
    val queue2: mutable.Queue[String] = new mutable.Queue[String]()
    queue2.enqueue("a", "b", "c")
    println(queue2)
    queue2.dequeue()
    println(queue2)
    println(queue2.head)
    println(queue2.last)
  }
}
