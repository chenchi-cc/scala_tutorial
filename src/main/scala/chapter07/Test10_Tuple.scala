package chapter07

object Test10_Tuple {
  def main(args: Array[String]): Unit = {
    // 1. 创建元组
    val tuple: (String, Int, Char, Boolean) = ("hello", 100, 'a', true)
    println(tuple)

    // 2. 访问数据
    println("第一个元素：" + tuple._1 + "，" + tuple.productElement(0))
    println("第二个元素：" + tuple._2 + "，" + tuple.productElement(1))
    println("第三个元素：" + tuple._3 + "，" + tuple.productElement(2))
    println("第四个元素：" + tuple._4 + "，" + tuple.productElement(3))

    println("====================")
    // 3. 遍历元组数据
    for (elem <- tuple.productIterator)
      println(elem)

    // 4. 嵌套元组
    val mulTuple = (12, 0.3, "hello", (23, "scala"), 29)
    println(mulTuple._4._2)
  }
}
