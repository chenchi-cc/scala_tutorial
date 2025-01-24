package chapter09plus

class MyRichInt(val sef: Int) {
  def myMax(n: Int): Int = if(sef > n) sef else n
  def myMin(n: Int): Int = if(sef < n) sef else n
}

object TestImplicitFunction {
  // 使用 implicit 关键字声明的函数称之为隐式函数
  implicit def convert(n: Int): MyRichInt = new MyRichInt(n)
  //写在外面作用域范围会更大
  //写在main方法里面，作用域范围只在main方法里面
  //均生效

  def main(args: Array[String]): Unit = {
    // 当想调用对象功能时，如果编译错误，那么编译器会尝试在当前作用域范围内查找能调用对应功能的转换规则，
    // 这个调用过程是由编译器完成的，所以称之为隐式转换，也称之为自动转换
    println(12.myMax(15))
    println(12.myMin(15))
  }
}
