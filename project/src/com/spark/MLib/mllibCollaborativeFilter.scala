package com.spark.MLib


import org.apache.spark.mllib.recommendation.{ALS, Rating}
import org.apache.spark.{SparkConf, SparkContext}

object mllibCollaborativeFilter {
def main (args : Array[String]): Unit ={
  val conf = new SparkConf().setMaster("local").setAppName("MytestApp")
  val sc = new SparkContext(conf)
  val data = sc.textFile("e://Learning.spark/u1.txt")
  val ratings = data.map(_.split(' ') match{
    case Array(user, item, rate) =>
      Rating(user.toInt, item.toInt, rate.toDouble)
  } )
  val rank = 2
  val numIterations = 4
  val model = ALS.train(ratings, rank, numIterations, 0.01)
  val rs = model.recommendProducts(2, 1)
  rs.foreach(println)
}
}
