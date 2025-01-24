package test

trait Ball {
  def describe(): String = "ball"
}

// 定义颜色特征
trait ColorBall extends Ball {
  var color: String = "red"
  override def describe(): String = color + "-" + super.describe()
}

// 定义种类特征
trait CategoryBall extends Ball {
  var category: String = "foot"
  override def describe(): String = category + "-" + super.describe()
}

// 定义一个自定义球的类
class MyBall extends CategoryBall with ColorBall {
  override def describe(): String = "my ball is a " + super.describe()
}

object TestMain extends App {
  val myBall = new MyBall
  println(myBall.describe())
}
