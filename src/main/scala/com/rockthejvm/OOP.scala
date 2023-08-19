package com.rockthejvm

object OOP extends App {

  //class and instance
  class Animal {
    //def fields
    val age: Int = 0
    def eat(): Unit = println("i'm eating")
  }
  val animal = new Animal

  //inheritance
//  class Dog(name: String) extends Animal{ //cant reach name
  class Dog(val name: String) extends Animal{ //constructor definition

  }

  val dog = new Dog("Lessie ")

//  constructor argument are NOT fields. need to put val before the constructor argument
  dog.name

  //subtype polymorphism
  val declaredAnimal: Animal = new Dog("Hachico")
  declaredAnimal.eat() //the most derived method will be called at runtime

  //abstract class
  abstract class WalkingAnimal {
    protected val hasLegs = true //by default public
    def walk(): Unit
  }

  //interface = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit
  }

  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("i'm eating you  animal")

    override def ?!(thought: String): Unit = println(s"i was thinking a thought $thought")
  }

  val croc = new Crocodile
  croc.eat(dog)
  croc eat dog//infix notation = object method argument, only available for methods with ONE argument
  croc ?! "what if we could fly"

  //operators in Scala a actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) //equivale

  //anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("i am a dinosaur so i can eat pretty much everything")
  }

  //Singleton object
  object MySingleton {  //the only instance of the MySingleton type
    val mySpecialValue = 23452
    def mySpecialMethod(): Int = 2102
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) //equivalent MySingleton.apply(65)

   object Animal { //companions. companion object with Animal class. could be also applied to traits
     // companions can access each other's private fields/methods
     //
     val canLiveIndefinitely = false
   }

  val animalsCanLiveForever = Animal.canLiveIndefinitely //static fields/methods
  /*
  - case classes = lightweight data structures with some boilerplate
  - sensible equals and hashcode
  - serializations (akka)
  - companion with apply
  - pattern matching
  */
  case class Person(name: String, age: Int)

//  val bob = new Person("Bob", 54)

  //may be constructed without new
  val bob = Person("Bob", 54) //we can omit a "new" keyword cause case class has companion object with a apply method

  //exceptions
   try {
     //code
     val x: String = null
     x.length
   } catch {
     case e: Exception => "some faulty error message"
   } finally {

   }

  //generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  val list: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = list.head
  val last = list.head
  val stringList = List("Hello", "Scala")
  val firstString = stringList.head

  //Point #1 in Scala we operate with IMMUTABLE values/objects
  //Any modification to an object should return NEW object
  /*
  Benefits:
  1) works miracles in multithreading/distributed env
  2) helps making sense of a code ("reasoning about")
   */
  val reversedList = list.reverse //returns NEW list

  //Point #2 Scala is closest to OOP ideal
}



















