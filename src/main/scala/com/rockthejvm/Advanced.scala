package com.rockthejvm

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}


object Advanced extends App {

  /**
   * lazy evaluation
   */
  lazy val lazyValue = 2
  lazy val lazyValueWithSideEffects = {
    println("I am so very lazy!")
    43
  }
  val eagerValue = lazyValueWithSideEffects + 1
  //useful in infinite collections

  None

  /**
   * "pseudo-collections": Option, Try
   */
  def methodWhichCanReturnNull(): String = {
    "Hello Scala"
  }

  val option = Option(methodWhichCanReturnNull()) //Some("Hello Scala")
  //option = "collection" of one element at most: Some(value) or None

  val stringProcessing: String = option match {
    case Some(str) => s"I have obtained a valid string: $str"
    case None => "I obtained nothing"
  }
  //map, flatmap, filter

  def methodThatCanThrowException(): String = throw new RuntimeException()
  val aTry = Try(methodThatCanThrowException())
  //Try = "collection" with either a value if code went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(value) => s"I have obtained a valid string: $value"
    case Failure(exception) => s"I have obtained an exception: $exception"
  }

  //both Try and Option have map, flatmap, filter and other composition functions

  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   */
  val future = Future({
    println("loading")
    Thread.sleep(1000)
    println("i have computed a value.")
    67
  })
  Thread.sleep(1500)
  // Future is a "collection" which contains a value when it's evaluated
  // future is composable with map, flatmap, and filter
  // monads

  /**
   * Implicits
   */
  // Use cases:

  // 1# implicit arguments
  def methodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt: Int = 46
  println(methodWithImplicitArgs)

  // 1# implicit conversion
  implicit class MyRichInteger(n: Int) {
    def isEven: Boolean = n % 2 == 0
  }

  println(24.isEven)  //even thought the isEven method doesn't belong to the Int class
  //use this very carefully

}
