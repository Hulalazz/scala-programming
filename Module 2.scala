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


