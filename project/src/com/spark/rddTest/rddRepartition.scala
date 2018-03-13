package com.spark.rddTest

import org.apache.spark.{SparkConf, SparkContext}

object rddRepartition {
  def main(args: Array[String]){
    var conf = new SparkConf().setMaster("local").setAppName("testRddMethod")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(1,2,3,4,5,6))
    val arr2 = arr.repartition(3)
    println(arr2.partitions.length)
  }
}
