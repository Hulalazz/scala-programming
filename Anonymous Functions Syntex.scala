// Databricks notebook source
//Here you are implementing trait Function1
(x:Int) => x + 1

// COMMAND ----------

//Implemented using functional interface compraed to Java
new Function1[Int,Int] {
  def apply(x:Int) : Int = x + 1
}

// COMMAND ----------


