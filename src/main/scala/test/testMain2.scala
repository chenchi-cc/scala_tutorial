package test

case class People(name: String, age: Int) {
  def this() = {
    this("Alice", 25)
  }
  def printer(): Unit = {
    println(s"Name: $name, Age: $age")
  }
}

object testMain2 {
  def main(args: Array[String]): Unit = {
    val p1 = new People()
    val p2 = new People()
    val p3 = p1
    println(p1 == p2)
  }
}
