package chapter07

import scala.collection.mutable

object Test16_MergeMap {
  def main(args: Array[String]): Unit = {
    val map1 = Map("a" -> 1, "b" -> 3, "c" -> 6)
    val map2 = mutable.Map("a" -> 6, "b" -> 2, "c" -> 9, "d" -> 3)
    println(map1 ++ map2) //直接调用map2会覆盖map1的键值对

    //合并map1和map2，相同的key累加
    //def foldLeft[B](z: B)(op: (B, A) => B): B
    val map3: mutable.Map[String, Int] = map1.foldLeft(map2)(
      (mergedMap: mutable.Map[String, Int], kv: (String, Int)) => { //第二个参数是map1的键值对
        val key = kv._1
        val value = kv._2
        mergedMap(key) = mergedMap.getOrElse(key, 0) + value
        mergedMap
      }
    )
    println(map3)
  }
}
