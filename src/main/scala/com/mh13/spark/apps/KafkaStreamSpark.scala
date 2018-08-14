package com.mh13.spark.apps

import org.apache.spark.sql.SparkSession

/*
sample structured streaming app to read from one kafka topic and write to another kafka topic
spark-streaming doesn't support kafka 1.0 as of now
*/

object KafkaStreamSpark {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("KafkaStreamSpark")
      .master("local[1]")
      .getOrCreate()

    val df =
      spark
        .readStream
        .format("kafka")
        .option("kafka.bootstrap.servers", "127.0.0.1:9092")
        .option("subscribe", "K1")
        .option("startingOffsets", "latest")
        .load()

    import spark.implicits._
    df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
      .as[(String, String)]

    df.writeStream
      .format("kafka")
      .option("topic", "K3")
      .option("kafka.bootstrap.servers", "127.0.0.1:9092")
      .option("checkpointLocation", "/tmp")
      .start()
      .awaitTermination()

  }

}
