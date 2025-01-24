package chapter09plus

object Test02_Implicit {
  def main(args: Array[String]): Unit = {
    // 1. 隐式函数
//    implicit def convert(num: Int): MyRichInt = new MyRichInt(num)
//    println(12.myMax(15))
    println("============================")

    // 2. 隐式类（不能写在外面，因为作用域的范围会很大）
    implicit class MyRichInt2(val self: Int) {
      // 自定义比较大小的方法
      def myMax2(n: Int): Int = if ( n < self ) self else n
      def myMin2(n: Int): Int = if ( n < self ) n else self
    }
    println(12.myMin2(15))
    println("============================")

    // 3. 隐式参数
    implicit val str: String = "alice"
//    implicit val str2: String = "alice2" // 会报错，因为相同类型的隐式参数只能有一个

    def sayHi()(implicit name: String = "atguigu"): Unit = {
      println("hi, " + name)
    }
    sayHi          //这里不加()，调用的是隐式值alice, 如果加上()，调用的是默认值atguigu
    sayHi()        //因为默认是柯里化结构，sayHi()(implicit name: String = "atguigu")，这样就可以加括号了，不然就是函数没括号
    sayHi()()

    // 简便写法
    implicit val num: Int = 18
    def sayHiAge(): Unit = {
      println("hi, " + implicitly[Int])
    }
    sayHiAge
  }
}

// 自定义类
//class MyRichInt(val self: Int) {
//  // 自定义比较大小的方法
//  def myMax(n: Int): Int = if ( n < self ) self else n
//  def myMin(n: Int): Int = if ( n < self ) n else self
//}
