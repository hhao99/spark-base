package com.vgc

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._  

object App {
    def main(args: Array[String]) {
        val spark = SparkSession
          .builder()
          .appName("Spark SQL basic example")
          .config("spark.some.config.option", "some-value")
          .master("local")
          .getOrCreate()

        val sc = spark.sparkContext

    }
}