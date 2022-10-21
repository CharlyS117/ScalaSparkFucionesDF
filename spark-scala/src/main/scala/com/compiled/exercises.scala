package com.compiled

object exercises extends App {

  /***
   * Esta funcion retorna dos valores de un String, les aplica un split para depararlos mediante una expresion regular
   * los convierte en una lista de strings y genera una lista de ints para sacar el valor maximo y minimo mediante
   * las funciones min y max
   * @param numbers
   * @return
   */
  def high_and_low(numbers: String): String = {
    val x = (numbers.split(" ").toList).map(l => l.toInt)
    x.min + " " + x.max
  }
  println(high_and_low("-663 731 216 -455 182 -334 509 -162 839 -922 778 -676 -568 367 176"))

  /***
   * Esta funcion retorna el numero de años que tarda una poblacion en crecer cierta cantidad.
   * El problema es el siguiente dado un numero inicial de poblacion, dicha poblacion crece por año
   * cierto porcetanje, ademas que por año llegan cierta cantidad de personas a vivir en el pueblo/ciudad
   * se requiere saber cuantos años tardara en alcanzar una poblacion esperada
   * @param p0
   *  Este parametro recibe la poblacion incial
   * @param percen
   *  Este parametro recibe el porcertaje de crecimiento anual
   * @param aug
   *  Este parametro recibe la cantidad de personas que llegan por año a vivir
   * @param p
   *  Este parametro recibe la cantidad de poblacion esperada.
   * @return
   *  Los años que deben de pasar para llegar a la cantidad de poblacion esperada.
   */
  def nb_year(p0: Int, percen: Double, aug: Int, p: Int): Int = {
    /***
     * Funcion recursiba que calcula el numero de años que tomara llegar a la poblacion esperada
     * @param ipo
     *  Este parametro recibe la poblacion incial y se incrementa en funcion de los años
     * @param perc
     *  Este parametro recibe el porcertaje de crecimiento anual
     * @param ag
     *  Este parametro recibe la cantidad de personas que llegan por año a vivir
     * @param ep
     *  Este parametro recibe la cantidad de poblacion esperada.
     * @param c
     *  Este parametro funge como contador de años, se inicializa en 0, siendo incremental
     * @return
     *  Un entero que contiene el contador de años
     */
    def FR1(ipo: Int, perc: Double, ag: Int, ep: Int, c : Int = 0):Int =
    {if (ipo >= ep) c else  FR1((ipo + (ipo * perc) + ag).toInt, perc, ag, ep, (c + 1)) }

    FR1(p0, (percen/100), aug, p)
  }

  println(nb_year(1500000, 2.5, 10000, 2000000))
}
