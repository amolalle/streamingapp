import kafka.serializer.StringDecoder
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingApp {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setAppName("StreamingApp")
    sparkConf.setIfMissing("spark.master", "local[5]")
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
