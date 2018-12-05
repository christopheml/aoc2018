# Advent of Code 2018 in Kotlin

This year I decided to spice things up a bit and give Kotlin a try.

:warning: **Spoilers ahead!**

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

### Day 4

First real difficult step of the 2018 calendar and the return of an all time favorite: input parsing!

Everything that could go wrong here went wrong: I overengineered part of the logic and ended up with tons of useless
complexity. To make things worse, my initial design wasn't flexible enough and I ran into a corner case that forced me
into a ugly hack.

This is definitely an implementation I need to rework when I get a clearer view of what idiomatic Kotlin is.

### Day 5

Back to a simple problem with another regular twist from advent of code: the performance issue in part 2. 

I started with a very straightforward implementation with - hold your breath - a massive regular expression. 
Since I was too lazy to write it by hand, I generated it and repeatedly removed the first match from the chain 
until the chain didn't change in size, which was super efficient in developer time and super inefficient in cpu time.

I was pretty sure that could hit me in the face for part 2 and sure enough I got slapped, with the implementation 
running for several minutes before spitting out a fortunately correct result.

Taking time to really think about the problem in a more subtle way, I ended up with a stack-based implementation that
runs at a satisfying speed. 
