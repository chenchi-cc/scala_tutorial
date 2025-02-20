package test

import scala.collection.mutable

object Test5 extends App {
  val l_filter = Utils.getFilterCombination(List("is_cheat_author"))
  println(l_filter)

  val ll = List(
    List("source", "author_type", "author_category"),
    List("source", "author_type", "author_category", "fans_level", "active_period_type", "is_mcn"),
    List("author_type", "author_category", "fans_level", "active_period_type", "is_mcn",
    "is_wind_plan_sup_author", "is_yinhuo_dapan_author", "news_overall_level", "video_overall_level", "dynamic_overall_level")
  )


  val res_filter = new mutable.HashSet[Set[String]] //外层set是用来去重的，里层Set("source", "author_type", "author_category")和Set("author_type", "author_category", "source")是一样的
  for (item_filter <- l_filter) {
    res_filter.add(Set(item_filter))
  }
  println(res_filter)

  val level = 3
  val levelMap = new mutable.HashMap[String, mutable.HashSet[Set[String]]]
  var resPreSets = res_filter
  var index = 0
  while (index < level) {
    val res = new mutable.HashSet[Set[String]]
    resPreSets.foreach(res_pre_level => {
      for (item <- ll(index) if !res_pre_level.contains(item)) {
        res.add(res_pre_level.filter(_.nonEmpty) + item) //去除里层set中的空字符串，只有第一层需要去除，因为l_filter里面才有空字符串（什么筛选条件都不选）
      }
    })

    levelMap.put(s"level_${index + 1}", res)
    resPreSets = res
    index += 1
  }

  val res1 = levelMap.getOrElse("level_1", null)
  println(res1)

  val res2 = levelMap.getOrElse("level_2", null)
  println(res2)

  val res3 = levelMap.getOrElse("level_3", null)
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
