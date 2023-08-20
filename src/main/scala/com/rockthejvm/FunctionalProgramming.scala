package com.rockthejvm

object FunctionalProgramming extends App {
  //Scala is OO
  class Person(name: String) {
    def apply(age: Int): Unit = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // invoking bob as a function === bob.apply(43)

  /*
  Scala runs on the JVM
  Functional programming:
  - compose functions
  - pass functions as args
  - return functions as result

  Conclution: FunctionX = Function1, Function2, ... Function22
   */

  val simpleInstrumenter = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleInstrumenter.apply(23)
  simpleInstrumenter(23) //simpleInstrumenter.apply(23)
  //we basically defined a function

  //ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FunctionX TYPES

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love ", "Scala")

  //syntax sugar
  //  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  //  val doubler: (Int) => Int = (x: Int) => 2 * x
  val doubler = (x: Int) => 2 * x
  println(doubler(4))

  //higher order functions: take functions as args OR return functions as result OR both
  val mappedList = List(1, 2, 3).map(x => x + 1)
  println(mappedList)

  //  val flatmappedList = List(1, 2, 3).flatMap(x => List(x, x + 1))
  val flatmappedList = List(1, 2, 3).flatMap { x => //alternative syntax
    List(x, x + 1)
  }
  println(flatmappedList)

  //  val filteredList = List(1, 2, 3, 4, 5).filter(x => x > 3)
  val filteredList = List(1, 2, 3, 4, 5).filter(_ > 3)
  println(filteredList)

  //all pairs between the numbers 1,2,3 and the letters 'a', 'b', 'c'
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairs)

  //for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  //equivalent to the map/flatMap chain above
  println(alternativePairs)

  /**
   * Collections
   */

  //list
  val list = List(1, 2, 3, 4, 5)
  val head: Int = list.head
  val tail = list.tail
  val prependedList = 0 :: list //(0, 1, 2, 3, 4, 5)
  val extendedList = 0 +: list :+ 6 //(0, 1, 2, 3, 4, 5, 6)
  println(prependedList)

  //sequences
  val sequences: Seq[Int] = Seq(1, 2, 3) //Seq.apply(1, 2, 3)
  val accessedElement: Int = sequences.apply(1) //element at index 1: 2

  //vectors: fast Seq implementation
  val vector: Vector[Int] = Vector(1, 2, 3, 4, 5)

  //sets
  val set = Set(1, 2, 3, 4, 1, 2, 3) //Set(1, 2, 3, 4)
  set.contains(5) //false
  val addedSet = set + 5 //Set(1, 2, 3, 4, 5)
  val removedSet = set - 5 //Set(1, 2, 4)

  //ranges
  val range = 1 to 10_000
  val twoByTwo = range.map(x => 2 * x).toList

  //tuples = groups of values under the same value
  val tuple = ("Bon Jovi", "Rock", 1982)

  //maps
  val map: Map[String, Int] = Map(
    ("Daniel", 456321),
    "Jane" -> 741258 //("Jane", 741258)
  )


}
