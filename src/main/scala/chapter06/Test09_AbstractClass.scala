package chapter06

object Test09_AbstractClass {
  def main(args: Array[String]): Unit = {
    val student = new Student9
    student.eat()
    student.sleep()
  }
}

// 定义抽象类
abstract class Person9(var a: Int) {
  // 非抽象属性
  var name: String = "person"

  // 抽象属性
  var age: Int

  // 非抽象方法
  def eat(): Unit = {
    println("person eat")
  }

  // 抽象方法
  def sleep(): Unit
}

// 定义具体的实现子类
class Student9 extends Person9(10) {
  println(a)
  // 实现抽象属性和方法
  override var age: Int = 18

  override def sleep(): Unit = {
    println("student sleep")
  }

  // 重写非抽象属性和方法
//  override val name: String = "student"   //父类是val，这么写不报错
//  override var name: String = "student"   //父类是var，这么写报错
  name = "student"


  override def eat(): Unit = {
    super.eat() //这个super可以不放在第一行
    println("student eat")
  }
}