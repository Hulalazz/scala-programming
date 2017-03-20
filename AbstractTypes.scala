abstract class Base(a:Int){
	val b:Int = 20
	val c:Int = 30
	def func()
}

class Serived(a:Int) extends Base(a){
	def func(){
		println("Running Derived")
	}
}

object MainObjectClass extends App{

	val d = new Serived(10)
	d.func()
	println(d.b)

}