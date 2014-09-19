package cz.mvelek.inttest

/**
 * Created by mvelek on 9/19/2014.
 */
abstract class GenericSet[A <% Ordered[A]] {
  def incl(x: A): GenericSet[A]

  def contains(x: A): Boolean

  def union(x: GenericSet[A]): GenericSet[A]

  def intersection(x: GenericSet[A]): GenericSet[A]

  def excl(x: A): GenericSet[A]

  def isEmpty: Boolean

  override def toString: String

}

class EmptySet[A <% Ordered[A]] extends GenericSet[A] {
  def contains(x: A): Boolean = false

  def incl(x: A): GenericSet[A] = new NonEmptySet[A](x, new EmptySet[A], new EmptySet[A])

  def union(that: GenericSet[A]): GenericSet[A] = that

  def intersection(that: GenericSet[A]): GenericSet[A] = this

  def excl(x: A): GenericSet[A] = this

  def isEmpty: Boolean = true

  override def toString: String = ""
}

class NonEmptySet[A <% Ordered[A]](elem: A, left: GenericSet[A], right: GenericSet[A]) extends GenericSet[A] {
  def contains(x: A): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: A) = {
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
  }

  def union(that: GenericSet[A]): GenericSet[A] = {
    this.excl(elem).union(that.incl(elem))
  }

  def intersection(that: GenericSet[A]): GenericSet[A] = {
    if (that.contains(elem)) new NonEmptySet(elem, new EmptySet[A], new EmptySet[A])
      .union(left intersection that)
      .union(right intersection that)
    else new EmptySet[A]()
      .union(left intersection that)
      .union(right intersection that)
  }

  def excl(x: A): GenericSet[A] = {
    if (x < elem) new NonEmptySet(elem, left excl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right excl x)
    else if (left.isEmpty && right.isEmpty) new EmptySet
    else if (left.isEmpty) right
    else if (right.isEmpty) left
    else new EmptySet[A] union left union right

  }

  def isEmpty: Boolean = false

  override def toString: String = "" + left + elem + ", " + right
}
