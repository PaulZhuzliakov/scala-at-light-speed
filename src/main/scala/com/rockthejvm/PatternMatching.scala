package com.rockthejvm

import scala.::

object PatternMatching extends App{
  //switch expression
  val integer =55
  val order = integer match {
    case 1 => "first"
    case 2 => "second"
    case 1 => "third"
    case _ => integer + "th"
  }
  println(order)
  //PM is expression, so it can be reduced to value

  //case class decomposition
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43)

  val personGreeting: String = bob match {
    case Person(n, a) => s"Hi my name is $n and I'am $a years old"
    case _ => "Something else"
  }
  println(personGreeting)

  //tuples deconstructions
  val tuple = ("bon Jovi", "Rock")
  val bandDescription = tuple match {
    case (band, genre) => s"$band belongs to genre $genre"
    case _ => "I don't know what a you talking about"
  }

  //decomposition lists
  val list: List[Int] = List(1, 2, 3)
  val listDescription =list match {
    case List(_, 2, _) => "List containing 2 on its second position"
    case _ => "unknown list"
  }

  //if PM doesn't match anything, it will throw MatchError




}
