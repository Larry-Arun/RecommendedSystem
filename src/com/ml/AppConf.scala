package www.dajiangtai.com.ml

import org.apache.spark._
import org.apache.spark.rdd._
import org.apache.spark.sql._
import org.apache.spark.sql.hive._

trait AppConf {
    val localClusterURL = "local[2]"
    val clusterMasterURL = "spark://master:7077"
    val conf = new SparkConf().setMaster(clusterMasterURL)
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val hc = new HiveContext(sc)
}