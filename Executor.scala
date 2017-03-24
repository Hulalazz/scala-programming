object firstName {
  def main(args: Array[String]) {
 
    println("Apply method : " + apply("Awantik", "Das"));
    println("Unapply method : " + unapply("Awantik Das"));
    println("Unapply method : " + unapply("Rob"));
 
  }
 
  def apply(fname: String, lname: String) = {
    fname + " " + lname
  }
 
  def unapply(s: String): Option[(String, String)] = {
    val pts = s split " "
    if (pts.length == 2) {
      Some(pts(0), pts(1))
    } else {
      None
    }
  }
}