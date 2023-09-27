
package object transformation {

  implicit class CustomTransformations(df: DataFrame) {

    case class ReplaceColumnException(message: String, columnName: String, column: Array[String])
      extends Exception(message)

    *** This method get a type column parameter and add the column to dataframe
    def AddColumn(newColumn: Column): DataFrame = {
      try {
        val columns: Array[Column] = df.columns.map(col) :+ newColumn
        df.select(columns:_*)
      }catch{
        case exception: Exception => throw exception
      }
    }

    ***This method get a type Column parameter and evaluated if exist the column and its not equals remplace the name column
    @throws[ReplaceColumnException]
    def ReplaceColumn(field: Column): DataFrame = {
      val columnName: String = field.exp.asInstanceOf[NamedExpression].name
      if(df.columns.contains(columnName)) {
        val columns: Array [Column] = df.columns.map {
          case name: String if name == columnName => field
          case _@name => col(name)
        }
        df.select(columns: _*)
      } else{
        val message: String = s"La columna $columnName no puede ser remplazada"
        throw ReplaceColumnException(message, columnName, df.columns)
      }
    }    
  }

  case class JoinException (expectedKeys: Array[String],
                          columns: Array[String],
                          location: String = "write the code direction",
                          message: String) extends Exception(message)

  
  implicit class MapToDataFrame(dfMap: Map[String,DataFrame]) {

  @throws[JoinException]
  def getFullDF(): DataFrame = {
    ///Define the DataFrames that uses

    ///Apply the join
    }
  }
}
