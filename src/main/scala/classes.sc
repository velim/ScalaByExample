
import cz.mvelek.inttest.{User, NonEmptySet, EmptySet}

val set1 = new EmptySet[Int]().incl(1).incl(3).incl(4)
val set2 = new EmptySet[Int]().incl(2).incl(3).incl(4)

val setStr = new EmptySet[String].incl("a").incl("c").incl("b")
val setStr2 = new NonEmptySet("d",new EmptySet[String],new EmptySet[String])

println(set1 union set2)
println(set1 intersection set2)
println(setStr)
println(setStr2.union(setStr).incl("A").excl("a"))
val users = new EmptySet[User]().incl(new User("mike")).incl(User("cilka")).incl(new User("aja"))
println(users)
