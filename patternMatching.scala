// object MyPatternMatch extends App{
// 	def matchTest(x:Int): String = 
// 	x match {
// 		case 1 => "One"
// 		case 2 => "Two"
// 		case _ => "Others"
// 	}

// 	println(matchTest(2))
// 	println(matchTest(5))
// }

object MyPatternMatch extends App{
	def matchTest(x:Any): Any = 
	x match {
		case 1 => "One"
		case "two" => 2
		case _ => "Others"
	}

	println(matchTest("two"))
	println(matchTest(1))
}