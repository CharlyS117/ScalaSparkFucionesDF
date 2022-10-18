package com.compiled


/**
 * case clase, recibe argumentos para busqueda de patrones al momento de pasarle los
 * case when que se debe de almacenar en una sequecian y el valor que debe de tomar.
 *
 * @param  valuesToCheck
 *  Almacena las reglas, el campo a evaluar y contra que se va a evaluar
 * @param valuesOfMatches
 *  Almacena el valor que se debe de poner al evaluar el case when
 */
case class claseWhen(valuesToCheck: Seq [(String, Any)],valuesOfMatches: Any)
