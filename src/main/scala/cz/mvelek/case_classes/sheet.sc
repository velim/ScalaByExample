import cz.mvelek.case_classes._

val sum1 = new Sub(new Sum(new Number(1), new Sum(new Number(3), new Number(7))), new Number(5))
val sum2 = new Sub(new Sum(new Number(1), new Sum(new Number(3), new Number(7))), new Number(5))
val sumc1 = CSub(CSum(CNumber(1), CSum(CNumber(3), CNumber(7))), CNumber(5))
val sumc2 = CSub(CSum(CNumber(1), CSum(CNumber(3), CNumber(7))), CNumber(5))

def eval(e: Expr): Int = {
  if (e.isNumber) e.numValue
  else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
  else if (e.isSub) eval(e.leftOp) - eval(e.rightOp)
  else sys.error("unrecognized expression kind")
}

def evalMatch(e: Expr): Int = e match {
  case CNumber(n) => n
  case CSum(l, r) => evalMatch(l) + evalMatch(r)
  case CSub(l, r) => evalMatch(l) - evalMatch(r)
}

sum1.toString
sum2.toString()
sumc1.toString()
sumc2.toString()

sum1.hashCode()
sum2.hashCode()
sumc1.hashCode()
sumc2.hashCode()

eval(sum1)
eval(sum2)

evalMatch(sumc1)
evalMatch(sumc2)


sum1 == sum2
sumc1 == sumc2
sum1.hashCode() == sum2.hashCode()
sumc1.hashCode() == sumc2.hashCode()
//new Number(1).n
CNumber(3).n