package com.rockthejvm

object Basics extends App {

  //defining a value
  val meaningOfLife: Int = 42

  //Int, Boolean, Double, Char, Double, Float, String
  val aBoolean = true //types is optional

  //string and string operations
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  //expressions = structures that can be reduces to a value
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  val chainedExpression = {
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0
  }

  //code blocks
  val aCodeBlock = {
    //definitions
    val aLocalValue =67
    //value of block is value of last expression
    aLocalValue+3
  }

  //define a function
  def myFunction(x: Int, y: String): String = y + " " + x

  //recursive function
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n-1)

  //in Scala we dont use iterations or loops. We use RECURSION

  //the Unit type = no meaning value === "void" in other languages
  //type of SIDE EFFECTS return Unit
  println("I love Scala")

  def myUnitReturnFunction(): Unit = {
    println("I don`t love returning Unit")
  }

  val theUnit = ()


}
