object NestedFunctions extends App{
	def myfunc(x:Int,y:Int): Int = {
		def func1(a:Int) = 2 * a
        def func2(b:Int) = 3 * b

        func1(x) + func2(y)
	}
	
	println(myfunc(5,10))
}