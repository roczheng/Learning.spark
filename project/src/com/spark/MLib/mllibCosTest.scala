package com.spark.MLib

import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.Map

object mllibCosTest {
  val conf = new SparkConf().setMaster("local").setAppName("CollaborativeFileteringSpark")
  val sc = new SparkContext(conf)
  val users = sc.parallelize(Array("aaa","bbb","ccc","ddd","eee"))
  val films = sc.parallelize(Array("smzdm","ylxb","zfd","fdsf","hhgf"))

  val source = Map[String,Map[String, Int]]()
  val filmSource = Map[String, Int]()
  def getSource(): Map[String, Map[String,Int]] = {
    val user1FilmSource = Map("smzdm" -> 2, "ylxb" -> 3, "zfd" -> 1, "fdsf" -> 0, "hhgf" -> 1)
    val user2FilmSource = Map("smzdm" -> 1, "ylxb" -> 2, "zfd" -> 2, "fdsf" -> 1, "hhgf" -> 4)
    val user3FilmSource = Map("smzdm" -> 2, "ylxb" -> 1, "zfd" -> 0, "fdsf" -> 1, "hhgf" -> 4)
    val user4FilmSource = Map("smzdm" -> 3, "ylxb" -> 2, "zfd" -> 0, "fdsf" -> 5, "hhgf" -> 3)
    val user5FilmSource = Map("smzdm" -> 5, "ylxb" -> 3, "zfd" -> 1, "fdsf" -> 1, "hhgf" -> 2)
    source += ("aaa" -> user1FilmSource)
    source += ("bbb" -> user2FilmSource)
    source += ("ccc" -> user3FilmSource)
    source += ("ddd" -> user4FilmSource)
    source += ("eee" -> user5FilmSource)
    source
  }

  def getCollaborateSource(user1:String,user2:String):Double = {
    val user1FilmSource = source.get(user1).get.values.toVector
    val user2FilmSource = source.get(user2).get.values.toVector

    val member = user1FilmSource.zip(user2FilmSource).map(d => d._1 * d._2).reduce(_+_).toDouble
    val temp1 = math.sqrt(user1FilmSource.map(num => { math.pow(num,2)}).reduce(_ + _))
    val temp2 = math.sqrt(user2FilmSource.map(num => { math.pow(num,2)}).reduce(_ + _))
    val denominator = temp1 + temp2
    member / denominator
  }

  def main(args: Array[String]): Unit ={
    getSource()
    val name = "bbb"
    users.foreach(user =>{
      println(name + "相对于" + user + "的相似性分数是：" + getCollaborateSource(name,user))
    })
  }
}
