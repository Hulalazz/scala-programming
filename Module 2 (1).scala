// Databricks notebook source
//Case Classes
//No need for new()
//equals 

case class Point(x:Int, y:Int){
  val age: Int = 0;
  val f = ()=>{}
  
  def getSquareString(input: Double): String = {
  val sq = input * input
  sq.toString
  }
}

// COMMAND ----------

val a = Point(1,2)

// COMMAND ----------

val b = Point(1,2)

// COMMAND ----------

a == b

// COMMAND ----------

class NewPoint( var x:Int, var y:Int){
  //Unit - void return
  def move(dx:Int, dy:Int): Unit = {
    x = x + dx
    y = y + dy
  }
}

// COMMAND ----------

val np1 = new NewPoint(2,3)

// COMMAND ----------

np1.x

// COMMAND ----------

np1.y

// COMMAND ----------

class NewPoint( var x:Int = 10, var y:Int = 20){
  //Unit - void return
  def move(dx:Int, dy:Int): Unit = {
    x = x + dx
    y = y + dy
  }
}

// COMMAND ----------

val np2 = new NewPoint()

// COMMAND ----------

np2.x

// COMMAND ----------

np2.y

// COMMAND ----------

// MAGIC %md
// MAGIC <h2>Private Members and Getter/Setter Syntex</h2>

// COMMAND ----------

class GoodPoint {
  private var _x = 0
  private var _y = 0
  private val bound = 100
  
  //Append _ after getter to create a setter
  
  def x = _x // accessing _x private variable
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }
  
  def y = _y // accessing _y private variable
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }
  private def printWarning = println("WARNING: Out of bounds")
}

// COMMAND ----------

val p1 = new GoodPoint

// COMMAND ----------

p1.x = 99
p1.y = 101

// COMMAND ----------

p1.x

// COMMAND ----------

// MAGIC %md
// MAGIC <h2>Traits</h2>

// COMMAND ----------

//whatever trait mandates,
trait Pet {
  val name: String
}

// COMMAND ----------

class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet

// COMMAND ----------

val cat = new Cat("Catty")
val dog = new Dog("Doggy")

// COMMAND ----------

import scala.collection.mutable.ArrayBuffer

val animals = ArrayBuffer.empty[Pet]
animals.append(cat)
animals.append(dog)

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Class Composition with Mixins</h3>

// COMMAND ----------

abstract class A {
  val message: String
}

class B extends A {
  val message = "I'm an instance of class B"
}

//mixin - trait extends class & member information of the class becomes available
trait C extends A {
  def loudMessage = message.toUpperCase()
}

class D extends B with C

// COMMAND ----------

val d = new D

// COMMAND ----------

d.message

// COMMAND ----------

d.loudMessage

// COMMAND ----------

//Higher Order Functions
//Takes other functions as parameters or result is a function.

// COMMAND ----------

def apply(f: Int => String, v: Int) = f(v)

// COMMAND ----------

apply((x:Int)=> "Hello", 6)

// COMMAND ----------

class Decorator(left: String, right: String) {
  def layout[A](x: A) = left + x.toString() + right
}


// COMMAND ----------

object FunTest{
  
  def apply(f: Int => String, v: Int) = f(v)
  
  val decorator = new Decorator("[", "]")
  
  def f =  println(apply(decorator.layout, 7))
}

// COMMAND ----------

FunTest.f

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Nested Methods</h3>

// COMMAND ----------

def factorial(x: Int): Int = {
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }  
    fact(x, 1)
 }


// COMMAND ----------

factorial(2)

// COMMAND ----------

factorial(3)

// COMMAND ----------

// MAGIC %md
// MAGIC <h2>Currying</h2>

// COMMAND ----------

object CurryTest {

  def filter(x: Int, p: Int => Int): Int =
    p(x)

  def modN(n: Int)(x: Int) = (n * x) 

  def main = {

    println(filter(10, modN(2))) 
    //modN2 - Returns a func that takes one arg & returns boolean
    println(filter(20, modN(3)))
  }
}

// COMMAND ----------

CurryTest.main

// COMMAND ----------

case class Book(isbn: String)

val frankenstein = Book("978-0486282114")

// COMMAND ----------

case class Message(var sender: String, recipient: String, body: String)
val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")

// COMMAND ----------

println(message1.sender)  // prints guillaume@quebec.ca
message1.sender = "travis@washington.us"  // this line does not compile

// COMMAND ----------

case class Message(sender: String, recipient: String, body: String)

val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")

val messagesAreTheSame = message2 == message3  // true

// COMMAND ----------

case class Message(sender: String, recipient: String, body: String)
val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
println(message5.sender)  // travis@washington.us
println(message5.recipient) // claire@bourgogne.fr
println(message5.body)  // "Me zo o komz gant ma amezeg"

// COMMAND ----------


