//1. Methods & values that are not associated with individual instances of a class belong to singleton objects
//2. singleton classes extend classes & traits

object Test extends App{
	var data = 10
	def testCode(l : List[Int]) : Int = l.sum

	//def main(arg: Array[String]): Unit = {

	println(testCode(List(1,2,3,4)))
		
	//}
}



// case class Func() // Internally this creats a singleton class

//Companions

//Most singleton objects donot stand alone, but instead are associated with a class of the same name