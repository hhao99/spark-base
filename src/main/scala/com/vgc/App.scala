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

        val file="file:///d:/data/bank-full.csv"
        
        log2(" spark " + spark.version)
    
        val bank = spark.read
            .option("delimiter",";")
            .option("header",true)
            .option("inferSchema", "true")
            .csv(file)
        
        log2("total count: " +bank.count())
        
        import spark.implicits._

        val bank2 = bank

      spark.stop()
    }

    def log2(msg: String) {
        println("===============")
        println(msg)
        println("===============")
    }
}