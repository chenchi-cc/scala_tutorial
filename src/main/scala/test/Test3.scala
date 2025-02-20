package test

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * val res1 = new mutable.HashSet[String]
 * res_filter.foreach(res_pre_level => {
 * for (item <- l1) {
 * val res_pre_level_arr = res_pre_level.split(",").toBuffer
 * if (!res_pre_level_arr.contains(item)) {
 * res_pre_level_arr.append(item)
 * res1.add(res_pre_level_arr.sorted.mkString(","))
 * }
 * }
 * })
 */
object Test3 {

  def dfs(list: List[String], index: Int, subsets:ListBuffer[String], res: ListBuffer[String]): Unit = {
    res.append(subsets.mkString(","))

    for (i <- index until list.length) {
      subsets.append(list(i))
      dfs(list, i + 1, subsets, res)
      subsets.remove(subsets.length - 1)
    }
  }

  def main(args: Array[String]): Unit = {
//    val l_filter = List("") //, "is_cheat_author"
    val l1 = List("source", "author_type", "author_category")
    val l2 = List("source", "author_type", "author_category", "fans_level", "active_period_type", "is_mcn")
    val l3 = List("author_type", "author_category", "fans_level", "active_period_type", "is_mcn",
      "is_wind_plan_sup_author", "is_yinhuo_dapan_author", "news_overall_level", "video_overall_level", "dynamic_overall_level")

    val ll = new ListBuffer[String]
    dfs(List(), 0, new ListBuffer[String], ll)
    ll.foreach(println)

    val l_filter = ll.toList

    val res_filter = new mutable.HashSet[Set[String]] //外层set是用来去重的，里层Set("source", "author_type", "author_category")和Set("author_type", "author_category", "source")是一样的
    for (item_filter <- l_filter) {
      res_filter.add(Set(item_filter))
    }

    val res1 = new mutable.HashSet[Set[String]]
    res_filter.foreach(res_pre_level => {
      for (item <- l1) {
        if (!res_pre_level.contains(item)) {
          res1.add(res_pre_level + item)
        }
      }
    })

    val res2 = new mutable.HashSet[Set[String]]
    res1.foreach(res_pre_level => {
      for (item <- l2) {
        if (!res_pre_level.contains(item)) {
          res2.add(res_pre_level + item)
        }
      }
    })

    val res3 = new mutable.HashSet[Set[String]]
    res2.foreach(res_pre_level => {
      for (item <- l3) {
        if (!res_pre_level.contains(item)) {
          res3.add(res_pre_level + item)
        }
      }
    })

    println(res_filter.size)
    println(res1.size)
    println(res2.size)
    println(res3.size)

    println(res2)

    val res = res_filter ++ res1 ++ res2 ++ res3
    println(res.size)
    res.map(_.filter(_.nonEmpty)). //去除里层set中的空字符串
      filter(_.size == 3).
      toList.
      sortBy(_.mkString(",")).
      foreach(println)
  }
}
