package com.spark.MLib

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.{SparkConf, SparkContext}

object mllibRowMatric {
  def main(args : Array[String]) {
    var conf = new SparkConf().setMaster("local").setAppName("testRddMethod")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(
      Array(
        Array(1.0, 7.0, 0, 0),
        Array(0, 2.0, 8.0, 0),
        Array(5.0, 0, 3.0, 9.0)
      )
    ).map(f => Vectors.dense(f))
    //创建RowMatrix
    //http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.mllib.linalg.distributed.RowMatrix
    val rowMatrix = new RowMatrix(rdd1)
    println(rowMatrix.numCols())
    println(rowMatrix.numRows())
  }
}
