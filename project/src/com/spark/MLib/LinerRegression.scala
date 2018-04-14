package com.spark.MLib

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint,LinearRegressionWithSGD}
import org.apache.spark.{SparkConf, SparkContext}

object LinerRegression {
val conf = new SparkConf().setMaster("local").setAppName("linerregression")
  val sc = new SparkContext(conf)

  def main(args: Array[String]){
    val data = sc.textFile("e://Learning.spark/lpsa2.data")
    val parsedData = data.map{ line =>
      val parts = line.split(',')
      LabeledPoint(parts(0).toDouble,Vectors.dense(parts(1).split(' ').map(_.toDouble)))
    }.cache()

    val model = LinearRegressionWithSGD.train(parsedData, 100, 0.1)
    val result = model.predict(Vectors.dense(2))
    println(result)
  }
}
