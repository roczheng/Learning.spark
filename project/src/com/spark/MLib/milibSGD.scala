package com.spark.MLib

import scala.collection.mutable.HashMap

object milibSGD {
  val data = HashMap[Int, Int]()
  def getData():HashMap[Int, Int] = {
    for(i <- 1 to 50){
      data += (i -> (12*i))
    }
    data
  }

  var thta:Double = 0
  var alph:Double = 0.1

  def sgd(x:Double,y:Double)={
    thta = thta - alph * ((thta*x) - y)
  }

  def main(args: Array[String]): Unit ={
    val dataSource = getData()
    dataSource.foreach(myMap =>{
      sgd(myMap._1,myMap._2)
    })
    println("最终结果thta:"+thta)
  }
}
