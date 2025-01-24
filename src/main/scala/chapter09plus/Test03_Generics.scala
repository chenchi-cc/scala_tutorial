package chapter09plus

object Test03_Generics {
  def main(args: Array[String]): Unit = {
    // 1. 协变和逆变
    val child: Parent = new Child
    val childList: MyList[Parent] = new MyList[Child]
    val childArray: MyArray[SubChild] = new MyArray[Child]

    // 2. 上下限
    def test[A <: Child](a: A): Unit = {
      println(a.getClass.getName)
    }

    test[Child](new Child)
    test[Child](new SubChild)
    test[SubChild](new SubChild)
//    test[SubChild](new Child) // 报错
//    test[Parent](new Parent) // 报错
  }
}

// 定义继承关系
class Parent {}
class Child extends Parent {}
class SubChild extends Child {}

// 定义带泛型的集合类型
class MyList[+E] {}
class MyArray[-E] {}

