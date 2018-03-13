package com.spark.rddTest

import org.apache.spark.{SparkConf, SparkContext}

object rddFilterMe {
  def main(args: Array[String]){
    var conf = new SparkConf().setMaster("local").setAppName("testRddMethod")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(1,2,3,4,5,6,2,1,1))
    val result = arr.filter(_ >= 3)
    result.foreach(println)
  }
}
