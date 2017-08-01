// Databricks notebook source
// MAGIC %md
// MAGIC <h2>Introduction</h2>
// MAGIC 
// MAGIC * Modern programming language, object oriented & functional languages
// MAGIC * Type-safe, extendable, shorter code
// MAGIC 
// MAGIC <h3>Object Oriented</h3>
// MAGIC * Pure-objevt-oriented language - everything is an object
// MAGIC 
// MAGIC <h3>Functional</h3>
// MAGIC * Every function is a value
// MAGIC * light-weight syntex for defining anyomous function
// MAGIC 
// MAGIC <h3>Statically typed</h3>
// MAGIC * generic classes
// MAGIC * upper bounds & lower bounds
// MAGIC 
// MAGIC <h3>SCala is extensible</h3>
// MAGIC * Scala provides a unique combination of language mechanisms that make it easy to add new language constructs to form libraries

// COMMAND ----------

//val - immutable
val x = 1 + 1

// COMMAND ----------

println(x)

// COMMAND ----------

println("Hello World")

// COMMAND ----------

//a is immutable
val a = 10

// COMMAND ----------

//var - mutable
//based on value assigned, it identifies it as an integer
var b = 88

// COMMAND ----------

b = 889

// COMMAND ----------

b

// COMMAND ----------

//code inside println
println({
  val x = 1 + 1
  x + 1 //This is returned
})

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Functions</h3>

// COMMAND ----------

// func takes int & returns one more than that
// function1 - function taking 1 arg
val f = (x :Int) => x + 1

// COMMAND ----------

f(10)

// COMMAND ----------

//Function defination of multiple lines
val f1 =  (x:Int, y:Int) => {
  println(x+y)
  x+y
}
val x = 18

// COMMAND ----------

f1(2,4)

// COMMAND ----------

val g = (x : Int, y : Int) => x + y

// COMMAND ----------

g(6,7)

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Methods</h3>
// MAGIC * Methods are defined with def keyword

// COMMAND ----------

//Method takes double arg & returns String
def getSquareString(input: Double): String = {
  val sq = input * input
  sq.toString
}

// COMMAND ----------

getSquareString(55)

// COMMAND ----------

//Scala Classes
class MyClass {
  var info : Int = 0;
  
  //Constructors
  def this(value : Int) = {
    this();
    this.info = value
  }
  
  //methods
  def getMyInfo() : Int = {
    return this.info
  }
  
  def addMyInfo(value : Int) {
    this.info += value
  } 
}

// COMMAND ----------

val m = new MyClass(77)
val n = new MyClass(88)

// COMMAND ----------

m.info

// COMMAND ----------

m.getMyInfo()
n.addMyInfo(22)

// COMMAND ----------

// SCala Singleton & Companion Objects

// COMMAND ----------

//Defines a singleton object Main
object Main {
  def sayHi() {
    println("Hi!")
  }
}

// COMMAND ----------

Main.sayHi()

// COMMAND ----------

//Companion Objects
class Main {
  def sayHelloWorld() {
    println("Hello World")
  }
}

object Main {
  def sayHi() {
    println("Hiii")
  }
}

// COMMAND ----------

var a : Main = new Main();
a.sayHelloWorld()
Main.sayHi()

// COMMAND ----------

// Arrays
var myArray : Array[String] = new Array[String](10)

// COMMAND ----------

myArray(0) = "Hello"

// COMMAND ----------

for( i <- 0 until myArray.length ){
  println(myArray(i))
}

// COMMAND ----------

for(st <- myArray){
  println(st)
}

// COMMAND ----------

//Conditional statements
var myInt : Int = 1;
if(myInt == 0){
  println("myInt == 0")
} else {
  println("myInt != 0")
}

// COMMAND ----------

var myText : String = 
    if(myInt == 0) "my-Int == 0"
    else           "my-Int != 0"

println(myText)

// COMMAND ----------


