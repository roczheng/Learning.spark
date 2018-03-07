import org.apache.spark.{SparkContext, SparkConf}

object wordCount {
  def main(args: Array[String]) {
    var conf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(conf)
    val data = sc.textFile("d://wc.txt")
    data.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)
  }
}