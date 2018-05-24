package www.dajiangtai.com.ml

import www.dajiangtai.com.conf.AppConf

import org.apache.spark.mllib.recommendation._

object RecommendForAllUsers extends AppConf {
  def main(args: Array[String]) {
    val users = hc.sql("select distinct(userId) from trainingData order by userId asc")
    val allusers = users.rdd.map(_.getInt(0)).toLocalIterator

    //方法1，可行，但是效率不高
    val modelpath = "/tmp/bestmodel/0.8215454233270015"
    val model = MatrixFactorizationModel.load(sc, modelpath)
    while (allusers.hasNext) {
      val rec = model.recommendProducts(allusers.next(), 5)
      //作业：把推荐结果写入到MYSQL
//      writeRecResultToMysql(rec)
    }
    
    //方法2，不可行
    val recResult = model.recommendProductsForUsers(5)
//    writeRecResultToMysql(recResult)
    
    
    def writeRecResultToMysql(uid:Array[Rating]){
      //
    }

  }
}