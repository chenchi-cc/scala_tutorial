package chapter09plus

object TestImplicitParameter {
  implicit val name: String = "alice"
  def hiName(implicit name: String = "chenchi"): Unit = {
    println("hi, " + name)
  }

  def hiName2()(implicit name: String = "chenchi"): Unit = {
    println("hi, " + name)
  }

  def hiName3(): Unit = {
    println("hi, " + implicitly[String]) // 这里的implicitly是获取隐式值的方法
  }

  def main(args: Array[String]): Unit = {
    /**
     * Scala 的默认值解析优先级为：显式参数 > 隐式变量 > 默认值。
     * 因为默认值优先级低于隐式值，所以只有显式调用默认值函数才会有默认值
     */
    hiName  // alice，因为柯里化结构，implicit参数前面还有个()，类比hiName2，这里省略了，调用只能省略
    hiName() // chenchi，因为前面那个括号只能省略，所以这个调用的是默认值【显式调用】
//    hiName()() // 报错，第一个参数没括号，这里不能加括号
    hiName("Bob") // Bob，这里传入的参数是Bob，所以这里是Bob

    println("============================")

    hiName2 // alice
    hiName2() // alice
    hiName2()() // chenchi【显式调用】
    hiName2()("Bob") // Bob

    println("============================")

    hiName3 // alice
  }
}
