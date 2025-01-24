package chapter07

object Test15_HighLevelFunction_Reduce {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    val list2 = List(3, 4, 5, 8, 10)
    // 1. reduce, left和right可以是两个不同类型，但是reduce要求a和b类型一致
    println(list.reduce( _ + _ )) // (a, b) => a + b，可以直接调用sum函数
    println(list.reduceLeft(_ + _))
    println(list.reduceRight(_ + _))
    println("===========================")
    println(list2.reduce(_ - _))    // -24
    println(list2.reduceLeft(_ - _))
    println(list2.reduceRight(_ - _))    // 3 - (4 - (5 - (8 - 10))), 6
    println("===========================")
    // 2. fold和reduce类似，多一个初始值，left和right可以是两个不同类型，但是fold要求a和b类型一致
    println(list.fold(10)(_ + _))     // 10 + 1 + 2 + 3 + 4  (a: Int, b: Int) => a + b
    println(list.foldLeft(10)(_ - _))    // 10 - 1 - 2 - 3 - 4
    println(list2.foldRight(11)(_ - _))    // 3 - (4 - (5 - (8 - (10 - 11)))),  -5
  }
}
