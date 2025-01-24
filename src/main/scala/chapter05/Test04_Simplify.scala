package chapter05

// 函数至简原则
object Test04_Simplify {
  def main(args: Array[String]): Unit = {

    def f0(name: String): String = {
      return name
    }

    println(f0("atguigu"))

    println("f0==========================")

    //    （1）return可以省略，Scala会使用函数体的最后一行代码作为返回值
    def f1(name: String): String = {
      name
    }
    println(f1("atguigu"))

    println("f1==========================")

    //    （2）如果函数体只有一行代码，可以省略花括号
    def f2(name: String): String = name
    println(f2("atguigu"))

    println("f2==========================")

    //    （3）返回值类型如果能够推断出来，那么可以省略（:和返回值类型一起省略）
    def f3(name: String) = name
    println(f3("atguigu"))

    println("f3==========================")

    //    （4）如果有return，则不能省略返回值类型，必须指定
//    def f4(name: String) = {
//      return name
//    }
//
//    println(f4("atguigu"))

    println("f4==========================")

    //    （5）如果函数明确声明unit，那么即使函数体中使用return关键字也不起作用
    def f5(name: String): Unit = {
      return name
    }

    println(f5("atguigu"))

    println("f5==========================")

    //    （6）Scala如果期望是无返回值类型，可以省略等号
    def f6(name: String) {
      println(name)
    }

    println(f6("atguigu"))

    println("f6==========================")

    //    （7）如果函数无参，但是声明了参数列表，那么调用时，小括号，可加可不加
    def f7(): Unit = {
      println("atguigu")
    }

    f7()
    f7

    println("f7==========================")

    //    （8）如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
    def f8: Unit = {
      println("atguigu")
    }

//    f8()
    f8

    println("f8==========================")

    //    （9）如果不关心名称，只关心逻辑处理，那么函数名（def）可以省略
    def f9(name: String): Unit = {
      println(name)
    }
    val f9_ = f9 _
    f9_("hello flink")

    // 匿名函数，lambda表达式
    val chenchi = (name: String) => { println(name) }
    chenchi("hello spark")

    println("f9==========================")

    def f_test(f: (Int, Int) => Int): Int = {
      f(2, 4)
    }

    // （2）定义一个函数，参数和返回值类型和 f1 的输入参数一致
    def add(a: Int, b: Int): Int = a + b
    // （3）将 add 函数作为参数传递给 f1 函数，如果能够推断出来不是调用，_
    println(f_test(add))
    println(f_test(add _))

  }
}
