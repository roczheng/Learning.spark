package com.spark.MLib

import org.apache.spark.mllib.linalg.{Vector, Vectors}

object mlibVector {
  def main(args: Array[String]): Unit ={
    val vd : Vector = Vectors.dense(1,0,6)
    println(vd(2))
    val vs : Vector = Vectors.sparse(4,Array(0,1,2,3),Array(9,5,2,7))
    println(vs(2))
  }
}
