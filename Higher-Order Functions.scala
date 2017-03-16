// Databricks notebook source
//These are functions that take other functions as parameters

def app(f: (Int) => String, num: Int) = f(num)

// COMMAND ----------

app((x:Int)=> "Number", 10)

// COMMAND ----------

class Design(left:String, right:String){
  def surround[A](x:A) = left + x.toString() + right
}

object FunTest extends App{
  def apply(f:Int => String, v:Int) = f(v)
  
  val fullData = new Design("*","#")
  println(apply(fullData.surround, 100))
}
