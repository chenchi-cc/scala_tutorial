package chapter07

object Test08_ImmutableMap {
  def main(args: Array[String]): Unit = {
    // 1. 创建map
    val map1: Map[String, Int] = Map("a" -> 13, "b" -> 25, "hello" -> 3)
    println(map1)
    println(map1.getClass)

    println("==========================")
    // 2. 遍历元素
    for (elem <- map1) {
      println(elem)
    }

    map1.foreach(println)
    map1.foreach( (kv: (String, Int)) => println(kv) )

    println("============================")

    // 3. 取map中所有的key 或者 value
    for (key <- map1.keys){
      val result: Option[Int] = map1.get(key)
      println(s"$key ---> ${result}")
    }

    //判断是否存在key
    println(map1.contains("a"))
    if(map1.contains("a")) println("a的值为：" + map1("a"))

    // 4. 访问某一个key的value
    println("a: " + map1.get("a").get)
    println("c: " + map1.get("c"))
    println("c: " + map1.getOrElse("c", 0))

    println(map1("a"))
  }
}
