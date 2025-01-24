package chapter07

object Test12_DerivedCollection {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3, 4, 5)
    val list2 = List(6, 7, 8, 9, 10, 1)
    //    （1）获取集合的头
    println("head: " + list1.head)
    //    （2）获取集合的尾（不是头的就是尾）
    println("tail: " + list1.tail)
    //    （3）集合最后一个数据
    println("last: " + list1.last)
    //    （4）集合初始数据（不包含最后一个）
    println("init: " + list1.init)
    //    （5）反转
    println("reverse: " + list1.reverse)
    //    （6）取前（后）n个元素
    println("take(3): " + list1.take(3)) // take默认是takeLeft
    println("takeRight(4): " + list1.takeRight(4))
    //    （7）去掉前（后）n个元素
    println("drop(3): " + list1.drop(3)) // drop默认是dropLeft
    println("dropRight(4): " + list1.dropRight(4))
    println("-----------------------")
    //    （8）并集就是++, 如果是set做并集，会去重
    println("union: " + list1.union(list2) + ", " + (list1 ++ list2))
    println("-----------------------")
    //    （9）交集
    println("intersection: " + list1.intersect(list2))
    println("-----------------------")
    //    （10）差集
    println("diff1: " + list1.diff(list2))
    println("diff2: " + list2.diff(list1))
    println("-----------------------")
    //    （11）拉链
    println("zip1: " + list1.zip(list2))
    println("zip2: " + list2.zip(list1))
    println("-----------------------")
    //    （12）滑窗
    for (elem <- list1.sliding(3)) // 默认步长为1
      println(elem)
    println("-----------------------")
    for (elem <- list1.sliding(3, 3))
      println(elem)
  }
}
