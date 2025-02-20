package test

import scala.collection.mutable.ListBuffer

object Utils {
  private def dfs(list: List[String], index: Int, subsets: ListBuffer[String], res: ListBuffer[String]): Unit = {
    res.append(subsets.mkString(","))

    for (i <- index until list.length) {
      subsets.append(list(i))
      dfs(list, i + 1, subsets, res)
      subsets.remove(subsets.length - 1)
    }
  }

  /**
   * get all filter combination
   * 例如传入List("a", "b"), 返回List("", "a", "b", "a,b")
   * @param list
   * @return
   */
  def getFilterCombination(list: List[String]): List[String] = {
    val res = new ListBuffer[String]
    dfs(list, 0, new ListBuffer[String], res)
    res.toList
  }
}
