package chapter06

trait Database {
  def query(sql: String): String
}

trait UserService {
  self: Database => // 自身类型，表示UserService只能与Database及其子类一起使用

  def getUser(id: Int): String = {
    query(s"SELECT * FROM users WHERE id = $id") // 可以直接调用 Database 的方法
  }
}

// 具体实现
class MySQLDatabase extends Database with Ball {
  def query(sql: String): String = s"Result of [$sql]"
}

// 将 UserService 混入 MySQLDatabase
class MyApp extends MySQLDatabase with UserService

object Main extends App {
  val app = new MyApp
  println(app.getUser(1)) // 输出: Result of [SELECT * FROM users WHERE id = 1]
}

