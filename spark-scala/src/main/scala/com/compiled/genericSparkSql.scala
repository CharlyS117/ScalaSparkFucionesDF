package com.compiled

import com.compiled.Constants.conditions
import org.apache.spark.sql.{Column, DataFrame, functions => f}

object genericSparkSql {

  /***
   * Funcion que desencadena la llamada a las funiones que generan los case when dinamicos
   * @param fields
   *  Parametro que contiene una coleccion de tipo Column, recibe los select dinamicos.
   * @param dfSecun
   *  Parametro que recibe un data frame
   */
  def genericExtraction(fields: Seq[Column],dfSecun: DataFrame):Unit = {
    val dfSelec = dfSecun.select(fields:_*)

    val whenCondition = whenDinamics(conditions)

    /***Nota importante, el whitcolumn contiene el nombre de una nueva columna, guardando en ella
     * el resultado en funcion de la evaluacion del case when a un campo en especifico.
     */
    val result = whenCondition.map(cond => dfSelec.withColumn("Zona",cond)).getOrElse(dfSelec)
    result.show(false)
  }

  /** Funcion recursiva que concatena los case when, recorriendo el parametro Seq
   * @param chain
   *  Parametro de tipo columna que almacena el case when expresado en scala
   * @param remaining
   *  Parametro de tipo Seq que contiene un dato de tipo columna y dato de tipo Any
   * @return chain
   */
  private def chaining(chain: Column, remaining: Seq[(Column,Any)]): Column = {
    remaining match {
      case Nil => chain
      case head:: tail => chaining(chain.when(head._1,head._2),tail)
    }
  }

  /** Funcion que inicia la concatenacion de los case when alacenados en una variable de
   * tipo Seq que almacena datos de tipo claseWhen
   * @param conditionsP
   *  Parametro de tipo Seq, una coleccion que almacena valores de tipo claseWhen.
   * @return Some
   */
  private def whenDinamics(conditionsP: Seq[claseWhen]): Option[Column] = {
    val conditions = conditionsP.map(condiP => {
      val condition = condiP.valuesToCheck.map(con => f.col(con._1) === con._2)
        .reduce(_ && _)
      (condition,condiP.valuesOfMatches)
    })

    println(conditions)

    conditions match {
      case Nil => None
      case head :: tail => Some(chaining(f.when(head._1,head._2),tail))
    }
  }

  /** Funcion recursiva que genera un select dinamico de acuerdo a un conjuntos de colecciones
   * de tipo Seq.
   * @param esqGeneral
   *  Parametro que recibe una coleccion Seq que almacena valores de tipo String, contiene los campos de la tabla a ingestar
   * @param tableFields
   *  Parametro que recibe una coleccion Seq que almacena valores de tipo String, contiene los campos de la tabla insumo
   * @param SelecCol
   *  Parametro que recibe una coleccion Seq que almacena valores de tipo Column, contiene la concatenacion de los
   *  selects dinamicos.
   * @param layer
   *  Parametro que rebice un string, contiene el nombre de la capa o tabla.
  * */
  def generateSelection(esqGeneral: Seq[String], tableFields: Seq[String], SelecCol: Seq[Column], layer: String): Seq[Column] = {
    if (esqGeneral.drop(1).iterator.hasNext) {
      val tmpSeleccion = SelecCol ++ Seq(f.col(tableFields(0)).as(esqGeneral(0) + "_" + layer))
      generateSelection(esqGeneral.drop(1), tableFields.drop(1), tmpSeleccion, layer)
    }
    else {
      SelecCol ++ Seq(f.col(tableFields(0)).as(esqGeneral(0) + "_" + layer))

    }
  }
  
}
