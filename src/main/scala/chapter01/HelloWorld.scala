package chapter01

import scala.io.StdIn

/*
   object: 关键字，声明一个单例对象（伴生对象）
 */
object HelloWorld {
  /*
    main 方法：从外部可以直接调用执行的方法
    def 方法名称(参数名称: 参数类型): 返回值类型 = { 方法体 }
   */
  def main(args: Array[String]): Unit = {
    println("hello world")
    System.out.println("hello scala from java")

    var line = StdIn.readLine()
    println("line = " + line)

    var isResult: Boolean = true
    var isResult2: Boolean = false

    var age: Int = 20
    age += 1
  }

  def test(): Nothing = {
    throw new Exception()
  }

  test()
}