package com.compiled

import com.compiled.Constants._
import com.compiled.jobEjecution.triggerSelectDynamic
import org.apache.spark.sql.SparkSession

/**
 * @author Carlos Rendon Deaquino
 */
object App {

  /***
   * Funcion principal, donde se mandaran a llamar las demas funciones a ejecutar
   * @param args
   */
  def main(args : Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("DataFrames")
      .config("spark.testing.memory", "471859200")
      .master("local[2]")
      .getOrCreate()

    val csvDF = spark.read
      .format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load("spark-scala/src/main/scala/resources/taxi_zones.csv")

    triggerSelectDynamic(selectFields = (filedsTable++adiccionalFields),renameFields = renameFieldsTable,dataF = csvDF)
  }

}
