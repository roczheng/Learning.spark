package com.spark.rddTest

import org.apache.spark.{SparkConf, SparkContext}

object rddCountByKey {
  def main(args: Array[String]){
    var conf = new SparkConf().setMaster("local").setAppName("testRddMethod")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array((1,"cool"),(2,"good"),(1,"fine")))
    val result = arr.countByKey()
    result.foreach(println)
  }
}
