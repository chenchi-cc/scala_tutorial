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
object Test4 {

  def main(args: Array[String]): Unit = {
    //"is_cheat_author"
    val l1 = List("first_category")
    val l2 = List("fans_level", "post_source_from")
    val l3 = List("fans_level", "post_source_from", "task_id", "hot_eventid", "is_mcn", "active_period_type",
      "is_yh_dapan", "is_search_share", "is_search_create", "is_tianhai", "is_yishan", "is_toutiao_intro", "is_quanwang_popular", "is_big_promotion",
      "activity_task_id", "is_spring_breeze")

    val l_filter = Utils.getFilterCombination(List("new_type"))

    val res_filter = new mutable.HashSet[Set[String]] //外层set是用来去重的，里层Set("source", "author_type", "author_category")和Set("author_type", "author_category", "source")是一样的
    for (item_filter <- l_filter) {
      res_filter.add(Set(item_filter))
    }
    println(res_filter)

    val res1 = new mutable.HashSet[Set[String]]
    res_filter.foreach(res_pre_level => {
      for (item <- l1 if !res_pre_level.contains(item)) {
          res1.add(res_pre_level.filter(_.nonEmpty) + item) //去除里层set中的空字符串，只有第一层需要去除，因为l_filter里面才有空字符串（什么筛选条件都不选）
      }
    })
    println(res1)

    val res2 = new mutable.HashSet[Set[String]]
    res1.foreach(res_pre_level => {
      for (item <- l2 if !res_pre_level.contains(item)) {
          res2.add(res_pre_level + item)
      }
    })
    println(res2)

    val res3 = new mutable.HashSet[Set[String]]
    res2.foreach(res_pre_level => {
      for (item <- l3 if !res_pre_level.contains(item)) {
          res3.add(res_pre_level + item)
      }
    })
    println(res3)

    val res = res_filter ++ res1 ++ res2 ++ res3
    println(res_filter.size)
    println(res1.size)
    println(res2.size)
    println(res3.size)
    println(res.
      toList.
      map("(" + _.mkString(",") + ")").
      sorted.
      mkString(",\n")
    )


  }
}
