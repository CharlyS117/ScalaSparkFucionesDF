package com.compiled

object Constants {

  val filedsTable = Seq("campo1","campo2","campo3")

  val adiccionalFields = Seq("pk1")

  val renameFieldsTable = Seq("LocationID","Borough","Zone","service_zone")

  val conditions = Seq(claseWhen(Seq(("pk1_", "Boro Zone")), "Boro"),
    claseWhen(Seq(("pk1_", "Yellow Zone")), "Yellow"))
}
