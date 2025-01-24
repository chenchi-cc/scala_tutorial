package chapter07

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Test20_Stack {
  def main(args: Array[String]): Unit = {
    // 传统方式：已废弃
    val stackOld = new mutable.Stack[Int]
    stackOld.push(1)
    stackOld.push(2)
    stackOld.push(3)
    println(stackOld)
    stackOld.pop()  // 出栈
    println(stackOld.top)

    // 新方式：不可变栈
    var stack: List[Int] = Nil
    // 压栈操作 (Push)
    stack = 10 +: stack
    stack = 20 +: stack
    stack = 30 +: stack
    println(s"Stack after push: $stack") // 输出: Stack after push: List(30, 20, 10)
    // 弹栈操作 (Pop)
    val top = stack.head // 获取栈顶元素
    stack = stack.tail // 移除栈顶元素
    println(s"Popped element: $top") // 输出: Popped element: 30
    println(s"Stack after pop: $stack") // 输出: Stack after pop: List(20, 10)
    // 检查栈是否为空
    println(s"Is stack empty? ${stack.isEmpty}") // 输出: Is stack empty? false
    println("-----------------------------------")

    // 新方式：可变栈
    val stack2 = ListBuffer[Int]()
    // 压栈操作
    stack2.prepend(10)
    stack2.prepend(20)
    stack2.prepend(30)
    println(s"Stack after push: $stack2") // 输出: Stack after push: ListBuffer(10, 20, 30)
    // 弹栈操作
    val top2 = stack2.remove(0) // 移除并返回栈顶元素
    println(s"Popped element: $top2") // 输出: Popped element: 30
    println(s"Stack after pop: $stack2") // 输出: Stack after pop: ListBuffer(10, 20)
    // 检查是否为空
    println(s"Is stack empty? ${stack2.isEmpty}") // 输出: Is stack empty? false

  }
}
