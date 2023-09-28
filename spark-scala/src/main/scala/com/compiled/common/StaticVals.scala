package com.compiled.common

/*
* Dentro de este .scala lo que se hace es poner aquellos valores
* que son constantes o estaticos pero no contiene valores muy grandes o mensajes de logs
* pueden definirse varios case objects
* */
object StaticVals {
  
  case object CourseConfigConstants {
    /*
    *In this case object can put info "val´s" that uses in the variables configs
    */
  }
  
  case object NumericsConstants{
    /*
    *In this case object can put info "val´s" that uses in the variables in many
    *methods
    */
    val Zero = 0
  }
  
  case object AlfanumericConstanst{
    /*
    *In this case object can put info "val´s" that uses in the variables in many
    *methods
    */
    val Comma = ","
  }
  
  case object Messages {
    /*
    *In this case object can put info "val´s" that uses in the variables in many
    *methods when want send a messagge on a log.
    */
    val WelcomeMessage: String => String = {
      (devName: String) => s"-----------------------$devName-------------------------------"
    }
  }
  
  case object JoinTypes {
    /*
    *In this case object can put info "val´s" that uses in the variables in many
    *methods when want use a join in a two DF
    */
    val LeftJoin: String = "left"
    val OuterJoin: String = "outer"
    val Inner: String = "inner"
    val LeftAnti: String = "leftanti"
  }
  
  case object MessageExpections {
    /*
    *In this case object can put info "val´s" that uses in the variables in many
    *methods when send a messagge on a exception.
    */
    val JoinExceptionColumns: Array[String] => String ={ (columns: Array[String]) => s"Los campos [${columns.mkString(", ")}] no se encontraron"}
  }
}
