package chapter05

object MyExercise {
  def map(arr: Array[Int], op: Int=>Int): Array[Int] = {
    for (elem <- arr) yield op(elem)
  }

  def filter(arr: Array[Int], op: Int=>Boolean): Array[Int] = {
    for (elem <- arr if op(elem)) yield elem
  }

  def reduce(arr: Array[Int], op: (Int, Int)=>Int): Int = {
    if(arr.length == 0) throw new UnsupportedOperationException("数组不能为空")
    var result = arr(0)
    for (i <- 1 until arr.length) {
      result = op(result, arr(i))
    }
    result
  }

  def test_breakable: Unit = {
    import scala.util.control.Breaks._
    breakable({
      for (i <- 1 to 10) {
        if (i == 5) {
          break //可加括号，可不加
        }
        println(i)
      }
    }) //breakable这个小括号可以单独省略，花括号也可以单独省略，但是小括号和花括号不能同时省略
  }


  def main(args: Array[String]): Unit = {
    test_breakable //如果函数声明的时候，没加小括号，调用一定不能加

//    val arr = Array(1, 2, 3, 4, 5)
//    println(map(arr, _ * 2).mkString(","))
//    println(filter(arr, _ % 2 == 0).mkString(","))
//    println(reduce(arr, _ + _))


//    def operateArray(arr: Array[Int], op: Int=>Int): Array[Int] = {
//      for (elem <- arr) yield op(elem)
//    }
//
//    val ints: Array[Int] = operateArray(Array(1, 2, 3, 4), _ * 2)
//    println(ints.mkString(","))

//    //闭包：初始形态
//    def f1(a: Int): Int=>Int = {
//      def f2(b: Int): Int = {
//        a + b
//      }
//      f2
//    }
//    println(f1(1)(2))
//
//    //闭包：简化1
//    def f3(a: Int): Int=>Int = {
//      (b: Int) => { //匿名函数
//        a + b
//      }
//    }
//    println(f3(1)(2))
//
//    //闭包：简化2
//    def f4(a: Int): Int=>Int = {
//      b => a + b //匿名函数
//    }
//    println(f4(1)(2))
//
//    //闭包：简化3
//    def f5(a: Int): Int=>Int = a + _ //匿名函数，变量使用一次
//    println(f5(1)(2))
//
//    //柯里化
//    def f6(a: Int)(b: Int): Int = {
//      a + b
//    }
//    println(f6(1)(2))
  }
}
