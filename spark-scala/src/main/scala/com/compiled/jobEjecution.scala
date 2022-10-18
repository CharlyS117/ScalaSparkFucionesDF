package com.compiled

import com.compiled.genericSparkSql.{generateSelection, genericExtraction}
import org.apache.spark.sql.{Column, DataFrame}

object jobEjecution {

  /***
   * Funcion que detona las generacion de los select y when dinamicos.
   * @param selectFields
   *  Parametro que contiene una coleccion de tipo Seq, esta almacena datos de tipo String, siendo el nombre de los campos
   *  a seleccionar
   * @param renameFields
   *  Parametro que contiene una coleccion de tipo Seq, esta alacena datos de tipo String, siendo el renombramiento de los campos
   * @param layer
   *  Si se requiere agregarle un sufijo adicional al renombramiento
   * @param dataF
   *  DataFrame con la data a filtrar
   */
  def triggerSelectDynamic(selectFields: Seq[String],renameFields: Seq[String],layer: String = "", dataF : DataFrame):Unit = {
    genericExtraction(generateSelection(selectFields,renameFields,Seq[Column](),layer),dataF)
  }
}
