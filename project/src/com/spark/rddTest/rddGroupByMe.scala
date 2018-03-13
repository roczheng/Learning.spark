package com.spark.rddTest

import org.apache.spark.{SparkConf, SparkContext}

object rddGroupByMe {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("MyApp")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(1,2,3,4,5,6))
    arr.groupBy(myFilter(_), 1)
    arr.groupBy(myFilter2(_), 2)
  }

  def myFilter(num: Int): Unit = {
    num >= 3
  }

  def myFilter2(num: Int) : Unit = {
    num < 3
  }
}
