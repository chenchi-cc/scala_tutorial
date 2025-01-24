package chapter06

object Test05_Constructor {
  def main(args: Array[String]): Unit = {
    val student1 = new Student1() //如果函数声明的时候，没加小括号，调用一定不能加，但是类这里可以加也可以不加
    student1.Student1()
    println("=========================================")

    val student2 = new Student1("alice")
    println("=========================================")

    val student3 = new Student1("bob", 25)
  }
}

// 定义一个类
class Student1() {
  // 定义属性
  var name: String = _
  var age: Int = _

  println("1. 主构造方法被调用")

  // 声明辅助构造方法，【没有返回值，类似于Java】
  def this(name: String) = {
    this()    // 直接调用主构造器
    println("2. 辅助构造方法一被调用")
    this.name = name
    println(s"name: $name age: $age")
  }

  def this(name: String, age: Int) = {
    this(name)
    println("3. 辅助构造方法二被调用")
    this.age = age
    println(s"name: $name age: $age")
  }

  def Student1(): Unit = {
    println("一般方法被调用")
  }
}