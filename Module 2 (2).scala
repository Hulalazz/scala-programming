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

// MAGIC %md
// MAGIC <h3> Case Classes </h3>

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

// MAGIC %md
// MAGIC <h3>Pattern Matching</h3>

// COMMAND ----------

import scala.util.Random

val x: Int = Random.nextInt(3)

x match {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case _ => "many"
}

// COMMAND ----------

def matchTest(x: Int): String = x match {
  case 1 => "one"
  case 2 => "two"
  case _ => "many"
}
matchTest(3)  // many
matchTest(1)  // one

// COMMAND ----------

abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification



// COMMAND ----------

def showNotification(notification: Notification): String = {
  notification match {
    case Email(email, title, _) =>
      s"You got an email from $email with title: $title"
    case SMS(number, message) =>
      s"You got an SMS from $number! Message: $message"
    case VoiceRecording(name, link) =>
      s"you received a Voice Recording from $name! Click the link to hear it: $link"
  }
}

// COMMAND ----------

val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

// COMMAND ----------

println(showNotification(someSms))

// COMMAND ----------

abstract class Device

case class Phone(model: String) extends Device{
  def screenOff = "Turning screen off"
}

case class Computer(model: String) extends Device {
  def screenSaverOn = "Turning screen saver on..."
}

def goIdle(device: Device) = device match {
  case p: Phone => p.screenOff
  case c: Computer => c.screenSaverOn
}

// COMMAND ----------

goIdle(Phone("abc"))

// COMMAND ----------

// MAGIC %md
// MAGIC <h3> Sealed Classes </h3>
// MAGIC 
// MAGIC * All subtypes must b in same file

// COMMAND ----------

sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

def findPlaceToSit(piece: Furniture): String = piece match {
  case a: Couch => "Lie on the couch"
  case b: Chair => "Sit on the chair"
}

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Singleton Objects</h3>
// MAGIC * Creates one instance of class

// COMMAND ----------

object Blah {
  def sum(l : List[Int]) : Int = l.sum
}

// COMMAND ----------

Blah.sum(List(2,3,4,4))

// COMMAND ----------

// MAGIC %md
// MAGIC <h4>Companions</h4>
// MAGIC * most singleton classes don't stay alone, but instead are associated with a class  with same name
// MAGIC * Singletob obj is known as companion object & class is known as companion class

// COMMAND ----------

class IntPair(val x: Int, val y: Int)

object IntPair {
  
}

// COMMAND ----------

// MAGIC %md
// MAGIC <h5>For Comprehensions</h5>

// COMMAND ----------

case class User(val name: String, val age: Int)

val userBase = List(new User("Travis", 28),
  new User("Kelly", 33),
  new User("Jennifer", 44),
  new User("Dennis", 23))

val twentySomethings = for (user <- userBase if (user.age >=20 && user.age < 30))
  yield user.name  // i.e. add this to a list

twentySomethings.foreach(name => println(name))  // prints Travis Dennis

// COMMAND ----------

def foo(n: Int, v: Int) =
   for (i <- 0 until n;
        j <- i until n if i + j == v)
   yield (i, j)

foo(10, 10) .foreach {
  case (i, j) =>
    print(s"($i, $j) ")  // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
}

// COMMAND ----------

foo(5,5)

// COMMAND ----------

// MAGIC %md
// MAGIC <h4>Extractor Object</h4>
// MAGIC * Extractor object is an object with unapply method
// MAGIC * apply is like a const which takes argument & ctreates object

// COMMAND ----------

import scala.util.Random

object CustomerID {

  def apply(name: String) = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val name = customerID.split("--").head
    if (name.nonEmpty) Some(name) else None
  }
}

val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908 => CustomerID.apply("")

customer1ID match {
  case CustomerID(name) => println(name)  // prints Sukyoung
  case _ => println("Could not extract a CustomerID")
}

// COMMAND ----------

val customer2ID = CustomerID("Nico")
val CustomerID(name) = customer2ID
println(name)  // prints Nico

// COMMAND ----------

val name = CustomerID.unapply(customer2ID).get

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>SEQUENCE COMPREHENSIONS</h3>

// COMMAND ----------

object ComprehensionTest1 {
  def even(from: Int, to: Int): List[Int] =
    for (i <- List.range(from, to) if i % 2 == 0) yield i
  def main = println(even(0, 20))
}

// COMMAND ----------

ComprehensionTest1.main

// COMMAND ----------

// MAGIC %md
// MAGIC <h4>Generic Classs </h4>

// COMMAND ----------

class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A) { elements = x :: elements }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

// COMMAND ----------

val stack = new Stack[Int]
stack.push(1)
stack.push(2)
println(stack.pop)  // prints 2
println(stack.pop)  // prints 1

// COMMAND ----------

class Fruit
class Apple extends Fruit
class Banana extends Fruit

val stack = new Stack[Fruit]
val apple = new Apple
val banana = new Banana

stack.push(apple)
stack.push(banana)

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Inner Classes</h3>

// COMMAND ----------

class Graph {
  class Node {
    var connectedNodes: List[Node] = Nil
    def connectTo(node: Node) {
      if (connectedNodes.find(node.equals).isEmpty) {
        connectedNodes = node :: connectedNodes
      }
    }
  }
  var nodes: List[Node] = Nil
  def newNode: Node = {
    val res = new Node
    nodes = res :: nodes
    res
  }
}

// COMMAND ----------

val graph1: Graph = new Graph
val node1: graph1.Node = graph1.newNode
val node2: graph1.Node = graph1.newNode
val node3: graph1.Node = graph1.newNode
node1.connectTo(node2)
node3.connectTo(node1)

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Abstract Types</h3>

// COMMAND ----------

trait Buffer {
  type T
  val element: T
}

// COMMAND ----------

abstract class SeqBuffer extends Buffer {
  type U
  type T <: Seq[U]
  def length = element.length
}

// COMMAND ----------

abstract class IntSeqBuffer extends SeqBuffer {
  type U = Int
}


// COMMAND ----------

def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer =
  new IntSeqBuffer {
       type T = List[U]
       val element = List(elem1, elem2)
     }

// COMMAND ----------

val buf = newIntSeqBuf(7, 8)
println("length = " + buf.length)
println("content = " + buf.element)

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Self-Type</h3>
// MAGIC * Self-types are a way to declare that a trait must be mixed into another trait, even though it doesn’t directly extend it. That makes the members of the dependency available without imports.
// MAGIC 
// MAGIC * A self-type is a way to narrow the type of this or another identifier that aliases this. The syntax looks like normal function syntax but means something entirely different.

// COMMAND ----------

trait User {
  def username: String
}

// COMMAND ----------

trait Tweeter {
	this: User =>  // reassign this
	def tweet(tweetText: String) = println(s"$username: $tweetText")
}

// COMMAND ----------

class VerifiedTweeter(val username_ : String) extends Tweeter with User {  // We mixin User because Tweeter required it
	def username = s"real $username_"
}

// COMMAND ----------

val realBeyoncé = new VerifiedTweeter("Beyoncé")
realBeyoncé.tweet("Just spilled my glass of lemonade")

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Collections</h3>
// MAGIC * mutable
// MAGIC * immutable
// MAGIC * generic

// COMMAND ----------

import scala.collection.mutable

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Important Traits</h3>
// MAGIC * Trait Traversable - ++, map, conversions, copying operations, size info, element retrival, slicing, element tests, max, min, string
// MAGIC * Trait Iterable - iterator, other iterators, Sub-collections, zippers
// MAGIC * Seq Trait - indexing & length, index search operation, addition operations, update operations, sorting operations, reversal operations

// COMMAND ----------

// MAGIC %md
// MAGIC <h3>Buffers</h3>

// COMMAND ----------

import scala.collection.mutable.ListBuffer

// COMMAND ----------

val v = Buffer("abc","def","ghi")

// COMMAND ----------

v += "xyz"

// COMMAND ----------

v += ("tuv","ghy","kjl")

// COMMAND ----------

val y = Buffer("jkl", "ukl")

// COMMAND ----------

v ++= y

// COMMAND ----------

"jkl" +=:v

// COMMAND ----------

y ++=: v

// COMMAND ----------

val fruit = Set("apple", "orange", "peach", "banana")

// COMMAND ----------

fruit + "pineapple"

// COMMAND ----------

import scala.collection.mutable.Set

// COMMAND ----------

val s = Set("apple","orange")

// COMMAND ----------

s += "Good"

// COMMAND ----------

val m = Map(("a"->22),("b"->55))

// COMMAND ----------

m("a")

// COMMAND ----------

m + ("abc"->1099)

// COMMAND ----------


