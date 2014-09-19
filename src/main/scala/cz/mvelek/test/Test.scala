package cz.mvelek.test {

abstract class Test {
  def f1: Int
}

case class Test1(value : Int) extends Test {
  override def f1: Int = value
}

case class Test2(value : Int) extends Test {
  override def f1: Int = value
}

}
