package com.spark.MLib
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils

object mllibLabel2 {
  def main(args: Array[String]){
    var conf = new SparkConf().setMaster("local").setAppName("testRddMethod")
    val sc = new SparkContext(conf)

    val mu = MLUtils.loadLibSVMFile(sc, "E://Learning.spark/a.txt")
    mu.foreach(println)
  }
}
