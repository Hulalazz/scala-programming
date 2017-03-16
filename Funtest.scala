class Design(left:String, right:String){
  def surround[A](x:A) = left + x.toString() + right
}

object FunTest extends App{
  def apply(f:Int => String, v:Int) = f(v)
  
  val fullData = new Design("*","#")
  println(apply(fullData.surround, 100))
}