name := "SparkStreaming"

version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "2.3.1"

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "mysql" % "mysql-connector-java" % "5.1.6",
  "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
  "org.apache.spark" %% "spark-streaming-kafka" % "1.6.3"

)