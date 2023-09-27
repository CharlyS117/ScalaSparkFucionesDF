package com.compiled.fields

import org.apache.spark.sql.Column
import org.apache.spark.sql.functions.col

//Trait that can be inherited for use the attributes.
trait Field {

  val name: String
  //A lazy is a val that will assess only when call it
  lazy val column: Column = col(name)
}
