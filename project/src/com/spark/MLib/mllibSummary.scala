package com.spark.MLib

import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

object mllibSummary {
  def main(args:Array[String]) {
    var conf = new SparkConf().setMaster("local").setAppName("testRddMethod")
    val sc = new SparkContext(conf)
    val data = sc.textFile("e://Learning.spark/c.txt").map(_.split(' ').map(_.toDouble)).map(line => Vectors.dense(line))
    val summary = Statistics.colStats(data)
    println(summary.mean)
    println(summary.variance)
  }
}
