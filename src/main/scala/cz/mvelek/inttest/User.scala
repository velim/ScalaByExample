package cz.mvelek.inttest

/**
 * Created by mvelek on 9/19/2014.
 */
case class User(name : String) extends Ordered[User]{
  def compare(that: User): Int = name compare that.name
  override def toString = name
}
