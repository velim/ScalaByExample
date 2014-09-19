val p: Array[Int] = Array(1, 5, 2, 3, 4)

p.filter(_ > 2).length
p.filter(_ > 2).head

def sum(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)

def sum1(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumF(a + 1, b)
  sumF
}


sum1(x => x * x)(1, 4)
sum1(x => x)(1, 4)

def sumOfSquares(a: Int, b: Int) = sum(x => x * x)(a, b)
def sumOfInts(a: Int, b: Int) = sum(x => x)(a, b)

sumOfSquares(1, 4)
sumOfInts(1, 4)


1 + 1


def f1(f: Int => Int, v : Int): Int = f(v)

def f2(v: Int): Int = f1({
  case 1 => 1000
  case 2 => 2 * 2
  case 3 => 3 * 3 * 3
},v)


f2(1)
f2(2)