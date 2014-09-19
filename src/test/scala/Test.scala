import cz.mvelek.test._
import org.scalatest.FunSuite

class IntegerT extends FunSuite {
  val p1 = new Succ(Zero)
  val p2 = new Succ(p1)
  val p3 = new Succ(p2)
  val p4 = new Succ(p3)

  val n1 = new Pred(Zero)
  val n2 = new Pred(n1)
  val n3 = new Pred(n2)
  val n4 = new Pred(n3)


  test("testing \"-\"") {
    assert((n1 + p1) == Zero)
    assert((n2 + p2) == Zero)
    assert((p1 + n1) == Zero)
    assert((p2 + n2) == Zero)
    assert((p2 + n1) == p1)
    assert((p1 + n2) == n1)
    assert((n1 - n1) == Zero)

    assert((n1 - p2) == n3)
    assert((n2 - p2) == n4)

    assert((p2 + n4) == n2)

    assert((p1 + n4) == n3)

    assert(p1.negate.isPositive == false)
    assert(p1.negate + p1 == Zero)
  }

}
