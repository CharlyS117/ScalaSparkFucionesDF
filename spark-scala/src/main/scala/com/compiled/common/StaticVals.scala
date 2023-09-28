package com.compiled.common

/*
* Dentro de este .scala lo que se hace es poner aquellos valores
* que son constantes o estaticos pero no contiene valores muy grandes o mensajes de logs
* pueden definirse varios case objects
* */
object StaticVals {
  
  case object CourseConfigConstants {
  }
  
  case object NumericsConstants{
    val Zero = 0
  }
  
  case object AlfanumericConstanst{
    val Comma = ","
  }
  
  case object Messages {
    val WelcomeMessage: String => String = {
      (devName: String) => s"-----------------------$devName-------------------------------"
    }
  }
  
  case object JoinTypes {
    val LeftJoin: String = "left"
    val OuterJoin: String = "outer"
    val Inner: String = "inner"
    val LeftAnti: String = "leftanti"
  }
  
  case object MessageExpections {
    val JoinExceptionColumns: Array[String] => String ={ (columns: Array[String]) => s"Los campos [${columns.mkString(", ")}] no se encontraron"}
  }
}
