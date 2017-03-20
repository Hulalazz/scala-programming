class MyFunc{
    def sayHi(){
        println("Hello")
    }
}

object MyFunc{
	def sayHi(){
		println("Hii")
	}
}

var aMain : MyFunc = new MyFunc()

aMain.sayHi()

MyFunc.sayHi()