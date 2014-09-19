package cz.mvelek.test

/**
 * Created by mvelek on 9/7/2014.
 * desc
 */

abstract class Integer {
  def isZero: Boolean

  def isPositive: Boolean

  def negate: Integer

  def predecessor: Integer

  def successor: Integer

  def +(that: Integer): Integer

  def -(that: Integer): Integer
}

object Zero extends Integer {

  override def isZero: Boolean = true

  override def successor: Integer = new Succ(Zero)

  override def negate: Integer = Zero

  override def isPositive: Boolean = false

  override def +(that: Integer): Integer = that

  override def -(that: Integer): Integer = that.negate

  override def predecessor: Integer = new Pred(Zero)
}

case class Succ(x: Integer) extends Integer {

  override def isZero: Boolean = false

  override def successor: Integer = new Succ(this)

  override def negate: Integer = new Pred(x.negate)

  override def +(that: Integer): Integer =
     if (that.isZero) this
     else if (that.isPositive) x + that.successor
     else x + that.successor

  override def isPositive: Boolean = true

  override def -(that: Integer): Integer =
    if (that.isZero) this
    else if (that.isPositive) x - that.predecessor
    else x - that.successor

  override def predecessor: Integer = x
}

case class Pred(x: Integer) extends Integer {

  override def isZero: Boolean = false

  override def successor: Integer = x

  override def negate: Integer = new Succ(x.negate)

  override def +(that: Integer): Integer =
    if (that.isZero) this
    else if (that.isPositive) x + that.predecessor
    else x + that.successor

  override def isPositive: Boolean = false

  override def -(that: Integer): Integer =
    if (that.isZero) this
    else if (that.isPositive) x - that.successor
    else x - that.successor

  override def predecessor: Integer = new Pred(this)
}
