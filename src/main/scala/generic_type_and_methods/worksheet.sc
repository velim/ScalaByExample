import generic_type_and_methods._

def isPrefix[A](p: Stack[A], s : Stack[A]): Boolean =
  p.isEmpty ||
  p.top == s.top && isPrefix(p.pop, s.pop)


val stack = new EmptyStack[Int]

stack.isEmpty
stack.push(1).top
stack.push(1).push(2).top
stack.push(1).push(2).pop.pop.isEmpty

val stringStack = new EmptyStack[String]
stringStack.isEmpty
stringStack.push("a").top
stringStack.push("a").push("b").top
stringStack.push("a").push("b").pop.pop.isEmpty


isPrefix(new EmptyStack[Int].push(1).push(2), new NonEmptyStack[Int](1, new EmptyStack[Int]))


