package generic_type_and_methods

/**
 * Created by mvelek on 9/14/2014.
 */
abstract class Stack[A] {
  def push(x: A): Stack[A] = new NonEmptyStack[A](x, this)

  def isEmpty: Boolean

  def top: A

  def pop: Stack[A]
}

class EmptyStack[A] extends Stack[A] {
  def isEmpty = true

  def top = sys.error("EmptyStack.top")

  def pop = sys.error("EmptyStack.pop")
}

class NonEmptyStack[A](elem: A, rest: Stack[A]) extends Stack[A] {
  def isEmpty = false

  def top = elem

  def pop = rest
}
