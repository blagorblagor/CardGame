# CardGame

1. HOW TO COMPILE THIS APPLICATION
- Needed console tools:
  javac
  jar
  Note: Both console tools are standard part of JDK.
        In fact, JDK must be properly installed in order to compile this application
- Remove all from folder:
  classes
  Important: Do not remove folder classes. It must exist for compilation.
- On console, enter root folder od the project,
  then enter folder:
  sources
- On console, from folder:
  sources run:
  javac @sources.list -d ../classes
  Note: Now, *.class files are compiled and can be found in folder:
        classes
        on the root of project
- Remove all from folder:
  distribution
  Important: Do not remove folder distribution. It must exist for compilation.x
- On console, from folder:
  sources
  run:
  javac @sources.list -d ../classes
  Note: Now, *.class files are compiled and can be found in folder:
        classes
        on the root of project
- On console, enter root folder od the project,
  then enter folder:
  classes
- On console, from folder:
  classes
  run:
  jar cvfe ../distribution/CardGame.jar rs.egzebajt.cardgame.Main -C . .
  Note: Now, archive file CardGame.jar is created can be found in folder:
        distribution
        on the root of project
        This file is final product of the process of compiling.
        
2. HOW TO RUN THIS APPLICATION
- Needed console tool:
  java
  Note: This console tool is a standard part of both JDK and JRE.
        In fact, JDK or JRE must be properly installed in order to run this application.
- Copy archive file CardGame.jar on wichever soma path
- On console, enter folder containing archive file CardGame.jar
  and execute:
  java -jar CardGame.jar -simplegame

3. GAMES ROULES
- Roules could be read in file:
  CardGame.pdf
  which can ve found in folder:
  PDFs
  
2020-09-23
  
        

        






