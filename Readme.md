Rock, Paper, Scissors Game.

This game has two version of implementation: Standalong mode and client-server mode.

- To use standalong mode use RockPaperScissors class from core packege:
```
mvn exec:java -Dcore
```
- To use client-server mode use Server and Client classes from correspond packages:
```
mvn exec:java -Dserver
mvn exec:java -Dclient
```
- To run tests use RockPaperScissorsTest class:
```
mvn test
```
- To generate code coverage report use:
```
mvn clean cobertura:cobertura
```