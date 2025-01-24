package chapter06

object MyExercise extends App {
//  val animal = new Animal("dog", 2, 10.0)
////  println(animal.name) //访问不到，因为name没有定义为val或var
//  println(animal.age)
//  println(animal.weight)
//
//  animal.age += 1
//  animal.weight += 1.0 //不能重新赋值，因为是val
//  val ball1 = new Sphere() //这里小括号加不加都行，哪怕类声明主构造器没有小括号，这里也是加不加都行
//  println("=========================================")
//  val ball2 = new Sphere("red")
//  println("=========================================")
//  val ball3 = new Sphere("blue", 10.0)

//  val singleton = new TestSingleton("alice")
//  singleton.printInfo()

  val singleton1 = TestSingleton.getInstance()

  val singleton2 = TestSingleton.getInstance()

  singleton1.printInfo()

  println(singleton1.eq(singleton2))

}

class TestSingleton private(name: String) {
  def printInfo(): Unit = {
    println(s"student: name = ${name}")
  }
}

object TestSingleton {
  var tt: TestSingleton = _
  def getInstance(): TestSingleton = {
    if(tt == null) {
      tt = new TestSingleton("alice")
    }
    tt
  }
}

//class Sphere() {
//  var color: String = _
//  var radius: Double = _
//  println(s"1.主构造方法被调用: color = ${this.color}, radius = ${this.radius}")
//
//  def this(color: String) = { //辅助构造方法【没有返回值，类似于Java】
//    this() //直接调用主构造器，不写会报错
//    this.color = color
//    println(s"2.辅助构造方法一被调用: color = ${this.color}, radius = ${this.radius}")
//  }
//
//  def this(color: String, radius: Double) = { //辅助构造方法【没有返回值，类似于Java】
//    this(color) //调用前一个辅助构造器，不写会报错
//    this.radius = radius
//    println(s"3.辅助构造方法二被调用: color = ${this.color}, radius = ${this.radius}")
//  }
//}

//class Animal(name: String, var age: Int, val weight: Double)

