package chapter06

object Test10_AnnoymousClass extends App {
  // 创建匿名子类
  val person = new Person10 {
    override var name: String = "alice"
    override def eat(): Unit = {
      println(s"person name $name is eating")
    }
  }

  person.eat()
}

// 定义抽象类
abstract class Person10 {
  var name: String
  def eat(): Unit
}
