import cz.mvelek.test._

val t1: Test = new Test1(1)
val t2: Test = new Test2(2)

t1.f1

t2.f1


def process(input : Test) = input match {
  case Test1(a : Int) => println("test 1")
  case Test2(a : Int) => println("test 2")
}


val p1 = new Succ(Zero)
val p2 = new Succ(p1)
val p3 = new Succ(p2)
val p4 = new Succ(p3)

val n1 = new Pred(Zero)
val n2 = new Pred(n1)
val n3 = new Pred(n2)
val n4 = new Pred(n3)


(n1 - p2)
(n1 - p2).successor
(n1 - p2).successor.successor
(n1 - p2).successor.successor.successor
(n1 - p2).successor.successor.successor.successor

(n1 - p2).successor.successor
n3.successor.successor

val i1 = (Zero - p2).successor
val i2 = n2.successor

i1 equals i2

val j1 = (p2 + n1).successor
val j2 = p1.successor

j1 eq   j2



