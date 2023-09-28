package com.compiled.field

package object fields {
  //Case object que funciona como un inicializador de la variable name
  //Este al igual que los demas hereda razgos del traid Field.
  
  case object AvgGlobalSales extends Field {
    override val name: String = "AVG_GLOBAL_Sales"

    def apply(): Column = {
      val w: WindowSpec = Window
        .orderBy(VideoGId.column.desc)

      avg(GlobalSales.column) over w alias name
    }
  }
}
