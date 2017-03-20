//def func(s1:Int)(s2:Int) = s1 + s2

//def fun1( f: (Int) => Int, d:Int) : Int = f(d)

//func(5) will generate partial function
//println(fun1(func(5), 10))

def func(s1:Int)(s2:Int)(s3:Int) = s1 + s2 + s3

def fun1( f: (Int) => ( Int => Int ), d:Int, e:Int) : Int = f(d)(e)

println(fun1(func(5), 10, 20))

// def func(s1:Int)(s2:Int)(s3:Int) = s1 + s2 + s3

// def fun1( f: (Int,Int) => Int, d:Int, e:Int) : Int = f(d)(e)

// println(fun1(func(5), 10, 20))