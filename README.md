# Advent of Code 2018 in Kotlin

This year I decided to spice things up a bit and give Kotlin a try.

:warning: **Spoilers ahead!**

## Progress log

I went on a hiatus midway because problems became way too complicated for the time I could spend on them. I felt like I
hit a wall going into day 15, so I didn't try to work on it. This intuition was confirmed by the jump in time spent for
developers in the global leaderboard (best time for day 15 was around 36 minutes, which is 3x to 10x what was needed for
previous days)

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

Oh, and did I mention that [Kotlin Extensions](https://kotlinlang.org/docs/reference/extensions.html) are beautiful ?

```kotlin
    private fun Char.xorCase(other: Char): Boolean {
        return isLowerCase() && other.isUpperCase() || isUpperCase() && other.isLowerCase()
    }
    
    // Checking if characters a and b have mixed case
    if (a.xorCase(b)) {
        // ...
    }
```

### Day 6

TBD

### Day 7

TBD

### Day 8

This one has been one of the easiest so far. I suspected that I could hack my way through part 1 but it would not work
as well for part two so I build the tree and implementing tree traversal logic. I wrote a generic traversal function
hoping that would help finding an instant answer for part 2, but YAGNI is an important development guideline for a reason
and I couldn't use the generic function in the end. 

I rewrote part 1 to get rid of it and make the code simpler.

I also spent some time going back to previous days and improve existing implementations using my better knowledge of Kotlin. 

### Day 9

Operations on circular lists are another common subject in Advent of Code, and having solved several similar ones in
previous editions, I should have known better. And I botched up my implementation.

First thing that went wrong was the wording of the exercises, namely the end condition. Last marble being worth n points
meant that you had to play for `n` turns, not to play until score for a given turn was `n`.

Second thing that went wrong was not implementing a circular linked list right from the start. I struggled to no end to
pinpoint the exact logic working with an indexed list and while I provided me with the right answer for part one, it 
was way too slow for part 2. Plus the code was outright ugly, hard to understand with plenty of obscure calculations.

I rewrote everything using a [CircularList](src/main/kotlin/com/github/christopheml/day09/CircularList.kt) and things 
went super smoothly. Code was now super explicit and run speed was great.

I blew something like 4 hours to get to an elegant and fast solution, a "feat" I'm not particularly proud of.

### Day 10

TBD

### Day 11

This one involved grid calculations. As always, it's useful to ask yourself if materializing the grid is a good idea
or not. I decided to have the simplest implementation and have a function calculating the value at a given coordinate,
then iterate from here if needed.

Turned out that is was not necessary to materialize the grid at all and first part was quite straightforward.

I expected that the second part would make us explore a larger solution space and some optimization would be needed. And
it was right. Not satisfied with quite inelegant code, I ran it against acceptance tests and discovered two things:

* Execution was indeed slow, with only a few hypotheses tested every second

* Power values of cell grids seemed to peak and then dip lower forever, which means that the first local maximum I find 
is also a global maximum and is the solution I seek

With this simple optimization, execution completes in a timely manner. I thought about cell value memoization, tried it,
then scrapped it because it was not improving performance in any significant way.

I also added a [visual view of values on the grid](visualizations/day11.png), because why not?

### Day 12

I had my fair share of sweat and headaches for this one. I threw away two complete implementations because they were
garbage, and made so many mistakes everywhere for the next. Off-by-one errors by the dozen, padding errors, etc. The 
worst thing was several errors went under the radar as my acceptance test passed and I had no other reference to test
against. I used someone else's solution to make sure I didn't have buggy input data and compare outputs to see where
I screwed up.

Part 2 was as messy as part 1, with the same errors. I need some sleep...

The only thing I find pretty in my implementation is the final padding logic, with a lot of syntactic sugar:

```kotlin
    private fun expandIfNecessary() {
        val padding = PotContent.EMPTY.times(3)

        while (!pots.startsWith(padding)) {
            expandLeft()
        }

        while (!pots.endsWith(padding)) {
            expandRight()
        }
    }
```

Being able to extend `List` types with methods like `startsWith` or `endsWith` is really great for readability.

### Day 13

TDB

### Day 14 

TDB

### Day 25

I went back to AOC after the hiatus to see if some problems were back to a scale I could afford. The final day has a
part one that is quite easy to do, but requires a bit of thinking to get the algorithm as simple as can be. It was 
refreshing to once again have something that doesn't requires complicated boilerplate.

The second part is locked behind a count of 49 stars, which means I need to complete every previous day, and it's not
likely to happen soon.
