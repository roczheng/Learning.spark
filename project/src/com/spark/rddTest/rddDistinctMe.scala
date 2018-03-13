package com.spark.rddTest

import org.apache.spark.{SparkConf, SparkContext}

object rddDistinctMe {
  def main(args: Array[String]): Unit ={
    var conf = new SparkConf().setMaster("local").setAppName("testRddMethod")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(("cool"),("good"),("good")))
    val result = arr.distinct()
    result.foreach(println)
  }
}
