package com.spark.rddTest
import org.apache.spark.{SparkContext, SparkConf}

object rddTest {
  def main(args: Array[String]) {
    var conf = new SparkConf().setMaster("local").setAppName("testRddMethod")
    val sc = new SparkContext(conf)
    //val arr = sc.parallelize(Array(1,2,3,4,5,6),2)
    val arr = sc.parallelize(Array("abc","b","c","d","e","f"))
    //val result = arr.aggregate(0)(math.max(_, _), _ + _)
    //val result = arr.aggregate("")((value, word) => value + word, _+_)
    //println(result)
    println(arr)
    println("---------------")
    println(arr.cache())
    arr.foreach(println)
  }
}
