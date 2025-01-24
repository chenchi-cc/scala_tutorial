package chapter06

object Test12_Singleton extends App {
  val student1 = Student12.getInstance()
  student1.printInfo()

  val student2 = Student12.getInstance()
  student2.printInfo()

  /**
   * 对普通类，== 和 eq 默认行为都是比较引用。
   * case class 自动重写了 equals，使得 == 比较值。
   * 如果需要在普通类中实现值比较，可以手动重写 equals 方法和 hashCode 方法。
   */
  println(student1.eq(student2)) // 判断两个对象地址是否相同
}

class Student12 private(val name: String, val age: Int){
  def printInfo(){
    println(s"student: name = ${name}, age = $age, school = ${Student11.school}")
  }
}

// 饿汉式
//object Student12 {
//  private val student: Student12 = new Student12("alice", 18)
//  def getInstance(): Student12 = student
//}

// 懒汉式
object Student12 {
  private var student: Student12 = _
  def getInstance(): Student12 = {
    if (student == null){
      // 如果没有对象实例的话，就创建一个
      student = new Student12("alice", 18)
    }
    student
  }
}
