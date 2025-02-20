package test

import scala.collection.mutable.ListBuffer

object Test6 {

  def getAllUsedDimSum(filter_dim_size: Int, bin_grouping_id: String): Int = {
    bin_grouping_id.substring(filter_dim_size).count(_ == '1')
  }

  def getAllUsedDimName(filter_dim_size: Int, bin_grouping_id: String, group_dims: Array[String]): List[String] = {
    val list_buffer = new ListBuffer[String]
    for (i <- filter_dim_size until bin_grouping_id.length) {
      if (bin_grouping_id(i) == '1') {
        list_buffer.append(group_dims(i))
      }
    }
    list_buffer.toList
  }

  def getThreeLevelsDimName(filter_dim_size: Int, bin_grouping_id: String, group_dims: Array[String]): (String, String, String) = {
    getAllUsedDimSum(filter_dim_size, bin_grouping_id) match {
      case 0 => ("ALL", "ALL", "ALL")
      case 1 => {
        val dim_name = getAllUsedDimName(filter_dim_size, bin_grouping_id, group_dims)
        (dim_name.head, "ALL", "ALL")
      }
      case 2 => {
        val dim_name = getAllUsedDimName(filter_dim_size, bin_grouping_id, group_dims).sortBy(dim_name => group_dims.indexOf(dim_name))
        (dim_name.head, dim_name(1), "ALL")
      }
      case 3 => {
        val dim_name = getAllUsedDimName(filter_dim_size, bin_grouping_id, group_dims).sortBy(dim_name => group_dims.indexOf(dim_name))
        (dim_name.head, dim_name(1), dim_name(2))
      }
    }
  }

  def generateReverseOrderSql(filter_dim_size: Int, tuple: (String, String, String), dim_chinese_name_map: Map[String, String], bin_grouping_id: String, group_dims: Array[String], tab_name: String = "level_data_base_no_addition"): String = {
    val threeLevelsDimName = getThreeLevelsDimName(filter_dim_size, bin_grouping_id, group_dims)

    getAllUsedDimSum(filter_dim_size, bin_grouping_id) match {
      case 2 => s"""
                   |SELECT
                   |    ${group_dims.take(filter_dim_size).mkString(",")},  --截取前filter_dim_size个维度
                   |    grouping_id,
                   |    bin_grouping_id,
                   |    ${dim_chinese_name_map(tuple._1)} AS first_dim_name,
                   |    ${tuple._1} AS first_dim_value,
                   |    ${dim_chinese_name_map(tuple._2)} AS second_dim_name,
                   |    ${tuple._2} AS second_dim_value,
                   |    ${dim_chinese_name_map(tuple._3)} AS third_dim_name,
                   |    ${tuple._3} AS third_dim_value,
                   |    this_base_value, -- 本期值
                   |    last_base_value,  -- 上期值
                   |    offset, -- 偏移量（本期值-上期值）
                   |    fluctuate_rate -- 波动率((本期值-上期值)/上期值)
                   |FROM ${tab_name}
                   |WHERE get_all_used_dim_sum(${filter_dim_size}, bin_grouping_id) = 2
                   |  AND SUBSTR(bin_grouping_id, ${group_dims.indexOf(threeLevelsDimName._1) + 1}, 1) = '1'
                   |  AND SUBSTR(bin_grouping_id, ${group_dims.indexOf(threeLevelsDimName._2) + 1}, 1) = '1'
                   |""".stripMargin

      case 3 => s"""
                   |SELECT
                   |    ${group_dims.take(filter_dim_size).mkString(",")},  --截取前filter_dim_size个维度
                   |    grouping_id,
                   |    bin_grouping_id,
                   |    ${dim_chinese_name_map(tuple._1)} AS first_dim_name,
                   |    ${tuple._1} AS first_dim_value,
                   |    ${dim_chinese_name_map(tuple._2)} AS second_dim_name,
                   |    ${tuple._2} AS second_dim_value,
                   |    ${dim_chinese_name_map(tuple._3)} AS third_dim_name,
                   |    ${tuple._3} AS third_dim_value,
                   |    this_base_value, -- 本期值
                   |    last_base_value,  -- 上期值
                   |    offset, -- 偏移量（本期值-上期值）
                   |    fluctuate_rate -- 波动率((本期值-上期值)/上期值)
                   |FROM ${tab_name}
                   |WHERE get_all_used_dim_sum(${filter_dim_size}, bin_grouping_id) = 3
                   |  AND SUBSTR(bin_grouping_id, ${group_dims.indexOf(threeLevelsDimName._1) + 1}, 1) = '1'
                   |  AND SUBSTR(bin_grouping_id, ${group_dims.indexOf(threeLevelsDimName._2) + 1}, 1) = '1'
                   |  AND SUBSTR(bin_grouping_id, ${group_dims.indexOf(threeLevelsDimName._3) + 1}, 1) = '1'
                   |""".stripMargin
    }
  }

  def main(args: Array[String]): Unit = {
//    println(getAllUsedDimSum(2, "111101100001"))

    val l1 = List("source", "author_type", "author_category")
    val l2 = List("source", "author_type", "author_category", "fans_level", "active_period_type", "is_mcn")
    val l3 = List("author_type", "author_category", "fans_level", "active_period_type", "is_mcn",
      "is_wind_plan_sup_author", "is_yinhuo_dapan_author", "news_overall_level", "video_overall_level", "dynamic_overall_level")

    val group_dims = Array("is_cheat_author", "source", "author_type", "author_category", "fans_level", "active_period_type", "is_mcn",
        "is_wind_plan_sup_author", "is_yinhuo_dapan_author", "news_overall_level", "video_overall_level", "dynamic_overall_level")

    getAllUsedDimName(1, "011000000100", group_dims).sortBy(dim_name => group_dims.indexOf(dim_name)).foreach(println)

    println(getThreeLevelsDimName(1, "000000000000", group_dims))

    val i = 1
    println((1, 2, 3).toString())

  }
}
