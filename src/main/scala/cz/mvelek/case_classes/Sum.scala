package cz.mvelek.case_classes

/**
 * Created by mvelek on 9/8/2014.
 */
abstract class Expr {
  def isNumber: Boolean

  def isSum: Boolean

  def isSub: Boolean

  def numValue: Int

  def leftOp: Expr

  def rightOp: Expr
}

case class CNumber(n: Int) extends Expr {
  def isNumber: Boolean = true

  def isSum: Boolean = false

  def isSub: Boolean = false

  def numValue: Int = n

  def leftOp: Expr = sys.error("Number.leftOp")

  def rightOp: Expr = sys.error("Number.rightOp")

}

class Number(n: Int) extends Expr {
  def isNumber: Boolean = true

  def isSum: Boolean = false

  def isSub: Boolean = false

  def numValue: Int = n

  def leftOp: Expr = sys.error("Number.leftOp")

  def rightOp: Expr = sys.error("Number.rightOp")

}

case class CSum(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false

  def isSum: Boolean = true

  def isSub: Boolean = false

  def numValue: Int = sys.error("Sum.numValue")

  def leftOp: Expr = e1

  def rightOp: Expr = e2
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false

  def isSum: Boolean = true

  def isSub: Boolean = false

  def numValue: Int = sys.error("Sum.numValue")

  def leftOp: Expr = e1

  def rightOp: Expr = e2
}

case class CSub(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false

  def isSum: Boolean = false

  def isSub: Boolean = true

  def numValue: Int = sys.error("Sub.numValue")

  def leftOp: Expr = e1

  def rightOp: Expr = e2
}

class Sub(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false

  def isSum: Boolean = false

  def isSub: Boolean = true

  def numValue: Int = sys.error("Sub.numValue")

  def leftOp: Expr = e1

  def rightOp: Expr = e2
}