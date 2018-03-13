package com.spark.rddTest

import org.apache.spark.{SparkConf, SparkContext}

object rddFlatMap {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("FlatMap")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(1,2,3,4,5,6,2,1,1))
    val result = arr.flatMap(x => List(x + 1)).collect()
    val result2 = arr.map(x => List(x + 1)).collect()
    result.foreach(println)
    println("================")
    result2.foreach(println)
  }
}
