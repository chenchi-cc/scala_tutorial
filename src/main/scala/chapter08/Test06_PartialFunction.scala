package chapter08

object Test06_PartialFunction {
  def main(args: Array[String]): Unit = {
    val list: List[(String, Int)] = List(("a", 12), ("b", 35), ("c", 27), ("a", 13))

    // 1. map转换，实现key不变，value2倍
    val newList = list.map( tuple => (tuple._1, tuple._2 * 2) )
    // 2. 用模式匹配对元组元素赋值，实现功能
    val newList2 = list.map(
      tuple => {
        tuple match {
          case (word, count) => (word, count * 2)
        }
      }
    )
    // 3. 省略lambda表达式的写法，进行简化
    val newList3 = list.map({
      case (word, count) => (word, count * 2)
    }) // 这里的case是偏函数，小括号也可以省略，只是没必要
    println(newList)
    println(newList2)
    println(newList3)

    println("=====================================")
    // 偏函数的应用，求绝对值
    // 对输入数据分为不同的情形：正、负、0
    val positiveAbs: PartialFunction[Int, Int] = {
      case x if x > 0 => x
    }
    val negativeAbs: PartialFunction[Int, Int] = {
      case x if x < 0 => -x
    }
    val zeroAbs: PartialFunction[Int, Int] = {
      case 0 => 0
    }

    def abs(x: Int): Int = (positiveAbs orElse negativeAbs orElse zeroAbs) (x)

    println(abs(-67))
    println(abs(35))
    println(abs(0))

    val second: PartialFunction[List[Int], Option[Int]] = {
      case x :: y :: _ => Some(y)
    }
    second(List(1, 2, 3)) // Some(2)
    second(List(1)) // 会报异常，还是应该在函数定义的时候加上case _ => None
  }
}
