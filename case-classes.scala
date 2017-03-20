abstract class Human

case class Person(name:String, age:Int, location:String) extends Human

case class Student(name:String, course:String) extends Human

def showHuman(h: Human) : String = {
	h match {
		case Person(name,age, _) => "You are a Person"
		case Student(name,course) => "You are a Student"
	}
}

println(showHuman(Person("awi",55,"Bangalore")))
println(showHuman(Student("bwi","Scala")))