case class Student(name: String, address: Seq[Address])
case class Address(city: String, state: String)
 
object City {
  def unapply(s: Student): Option[Seq[String]] = {
    println("Great")
    Some(
      for (c <- s.address)
        yield c.state)
  }
}
 
class StringSeqContains(value: String) {
  def unapply(in: Seq[String]): Boolean =
    in contains value
}
 
object PatternMatch {
  def main(args: Array[String]) {
 
    val stud = List(Student("Harriya", List(Address("Mumbai", "Bangalore"))),
      Student("Reena", List(Address("Awi", "Tezpur"))),
      Student("Rob", List(Address("Bwi", "Tezpur"))),
      Student("Chris", List(Address("Jacksonville", "Florida"))))
 
    val Texas = new StringSeqContains("Tezpur")

    val students = stud collect {
      case student @ City( Texas()) => student.name
    }
    println(students)
  }
}