# Live Football World Cup scoreboard coding exercise

## General Info
Library for managing a live football cup scoreboard.

Published under [MIT License][license].

This project uses [Semantic Versioning][semver] scheme.

## Installation

#### Requirements

To build the project you need the following installed and available in your `$PATH` variable:
- JDK 17
- [Apache Maven](https://maven.apache.org/download.cgi)

#### Building

Download source and build the project:

    $ git clone git@github.com:zigasever/live-football-scoreboard.git
    $ cd live-football-scoreboard
    $ mvn install       # Requires maven, download from https://maven.apache.org/download.html

#### Add dependency
    <dependencies>
    ...
    <dependency>
        <groupId>com.sever</groupId>
        <artifactId>live-football-scoreboard</artifactId>
        <version>${live-football-scoreboard.version}</version>
    </dependency>
    ...
    </dependencies>

## Usage

#### Features

The library supports the following actions:

- Start match and add it to scoreboard
- End match and remove it from scoreboard
- Retrieve match by id
- Return an ordered list of ongoing matches by total score descending and in case of ties also by start time

#### Create scoreboard

```java
    //Use instance of InMemoryMatchStorage in constructor or provide your own implementation of MatchDao
    WorldCupScoreboard scoreboard = new WorldCupScoreBoard(new InMemoryMatchStorage());
```
#### Start match

```java
    scoreboard.startMatch(1, new Team("Ecuador"), new Team("Colombia"));
```

#### Remove match

```java
    scoreboard.removeMatch(scoreboard.getMatch(matchId));
```

#### Get ordered summary of matches

```java
    Collection matchSummary = scoreboard.getMatchSummary();
```

[semver]: https://semver.org
[license]: LICENSE