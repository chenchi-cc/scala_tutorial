package chapter09plus

object TestImplicitClass {
  def main(args: Array[String]): Unit = {
    implicit class MyRichInt(val self: Int) {
      // 自定义比较大小的方法
      def myMax(n: Int): Int = if ( n < self ) self else n
      def myMin(n: Int): Int = if ( n < self ) n else self
    }

    println(12.myMax(15))
    println(12.myMin(15))
  }
}
