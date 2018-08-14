package com.mh13.spark.apps

import kafka.serializer.StringDecoder
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

object KafkaSparkStreamingApp {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setAppName("KafkaSparkStreamingApp")
    sparkConf.setIfMissing("spark.master", "local[*]")

    val ssc = new StreamingContext(sparkConf, Seconds(5))

    val topicsToListen = Set[String] {
      "my_topic"
    }
    val kafkaParams = Map[String, String]("metadata.broker.list" -> "127.0.01:9092")

    val kafkaStream = KafkaUtils.createDirectStream[String,String,StringDecoder,StringDecoder](ssc,kafkaParams,topicsToListen)

    kafkaStream.print
    ssc.start()
    ssc.awaitTermination()

  }
}
