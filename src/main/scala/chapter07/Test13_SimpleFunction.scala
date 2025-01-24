package chapter07

object Test13_SimpleFunction {
  def main(args: Array[String]): Unit = {
    val list = List(5, 1, 8, 2, -3, 4)
    val list2 = List(("a", 5), ("b", 1), ("c", 8), ("d", 2), ("e", -3), ("f", 4))
    //    （1）求和
    println("sum: " + list.sum)
    //    （2）求乘积
    println("product: " + list.product)
    //    （3）最大值
    println("max: " + list.max)
    println("maxBy: " + list2.maxBy( _._2 ))
    //    （4）最小值
    println("min: " + list.min)
    println("minBy: " + list2.minBy(_._2))
    println("========================")
    //    （5）排序
    // 5.1 sorted
    println("sorted: " + list.sorted) // 从小到大排序
    println("sorted.reverse: " + list.sorted.reverse) // 从大到小排序
    println("sorted(Ordering[Int].reverse): " + list.sorted(Ordering[Int].reverse)) // 从大到小排序, 隐式参数
    // 5.2 sortBy
    println("sortBy: " + list2.sortBy(_._2)) // 从小到大排序
    println("sortBy: " + list2.sortBy(-_._2)) // 从大到小排序
    println("sortBy(_._2)(Ordering[Int].reverse): " + list2.sortBy(_._2)(Ordering[Int].reverse)) // 从大到小排序, 隐式参数
    // 5.3 sortWith
    println("product: " + list.sortWith( _ < _ )) // 从小到大排序, (a: Int, b: Int) => {a < b}
    println("product: " + list.sortWith( _ > _)) // 从大到小排序, (a: Int, b: Int) => {a > b}
  }
}
