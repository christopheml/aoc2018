# Advent of Code 2018 in Kotlin

This year I decided to spice things up a bit and give Kotlin a try.

## Progress log

### Project Setup

I created the project using the Maven archetype `kotlin-archetype-jvm` from IntelliJ. Needed to update the Kotlin IDE
plugin to match the Kotlin version from the archetype (`1.3.10`).

I added my usual testing dependencies, `junit` and `assertJ`. 

### Day 1

I expected day 1 to be rough because my knowledge of Kotlin at that point is super limited. Fortunately, online 
documentation is pretty good. I'm still thinking like I was programming in Java though, which means that I write code
that is not idiomatic to Kotlin in a lot of places.

Overall language seems nice and very expressive. String interpolation is awesome, using `if` for ternaries is nice and 
the `when` construct is great too.

### Day 2

Getting more comfortable with Kotlin features, the two most prominent being looping over ranges 
(`for (j in i + 1 until words.size)`) and extra API on collections, that allow incredible expressivity over Java 
(see [WordDifferences](src/main/kotlin/com/github/christopheml/day02/WordDifferences.kt)).

### Day 3

This one required more Kotlin collection stuff and an extensive use of `Pair<A, B>`, even if that kind of structure is
usually and indication you need a dedicated class for the job. I didn't really focus on efficiency, trying to get 
readable code and reworking it only if performance seems to be an issue.
