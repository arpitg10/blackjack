#Blackjack

This is a console application to play blackjack game with a single deck of cards. This game is played by a single player against the dealer.

##Stack

- [JDK 17](https://openjdk.org/projects/jdk/17/)
- [Kotlin](https://kotlinlang.org/docs/home.html)
- [Gradle](https://gradle.org/)
- [Junit 5](https://junit.org/junit5/)
- [Kotest](https://kotest.io/)

##Build
```bash
gradle build
```

##Run
If you want to play game with a new shuffled deck of 52 cards.
```bash
gradle run
```

If you want to play game by providing your deck, first add the file in [required format](#file-format) to [resources](/src/main/resources) folder.
```bash
gradle run --args=$fileName
```

##File format
File should contain deck of 52 unique cards separated by comma.

Example: `CA, D4, H7, SJ,..., S5, S9, D10`

##Example
Deck of cards: `CA, D5, H9, HQ, S8 ...`

<b>Output</b>
```
sam
sam: [CA, H9]
dealer: [D5, HQ, S8]
```

####Best of luck !!!
