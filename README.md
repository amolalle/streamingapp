# streamingapp

A sample spark streaming app

* Used homebrew to install zookeeper and kafka

* https://spark.apache.org/docs/2.2.0/streaming-kafka-integration.html
* https://spark.apache.org/docs/2.1.0/structured-streaming-kafka-integration.html

install kafka

brew install kafka

this will run ZK and kafka as services

brew services start zookeeper
brew services start kafka

If you want to stop Kafka, just run the brew services commands in reverse:

brew services stop kafka
brew services stop zookeeper
