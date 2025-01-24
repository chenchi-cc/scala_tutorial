package chapter07

object Test14_HighLevelFunction_Map {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 1. 过滤
    println("filter: " + list.filter( _ % 2 == 1 ))
    println("=======================")
    // 2. 映射map
    println("map: " + list.map(_ * 2))
    println("=======================")
    // 3. 扁平化
    val nestedList: List[List[Int]] = List(List(1, 2, 3), List(4, 5), List(6, 7, 8, 9))
    println("flatten: " + nestedList.flatten) // nestedList(0) ++ nestedList(1) ++ nestedList(2)
    println("=======================")
    // 4. 扁平映射
    // 将一组字符串进行分词，并保存成单词的列表
    val strings: List[String] = List("hello world", "hello scala", "hello java", "we study")
    println("flatMap: " + strings.flatMap(_.split(" ")))
    println("========================")
    // 5. 分组groupBy
    // 分成奇偶两组
    val groupMap: Map[Int, List[Int]] = list.groupBy( _ % 2)
    println("groupBy1: " + groupMap)
    // 给定一组词汇，按照单词的首字母进行分组
    val wordList = List("china", "america", "alice", "canada", "cary", "bob", "japan")
    println("groupBy2: " + wordList.groupBy( _.charAt(0) ) )
  }
}
