# Functional Reactive with Core Java - the frameworkless way

## Teaser
In this workshop we will walk through building a 
functional reactive application w/o the aid of external frameworks, 
relying only on the capabilities of the JDK. 

The URL to the event is [Meetup JavaIL 255867803](https://www.meetup.com/de-DE/JavaIL/events/255867803/)

## Bird Eye View
What we want to learn is , how we can code in a functional and reactive way 
only using the JDK itself. So many different frameworks and libs are on the market.
Even functional languages taht are running on the JVM. But often you can not 
deal with a complete different Collections framework or language only to 
have a more functional or reactive approach.

We will have a look at possibilities to code pure java in a functional / reactive way.

We will start with the functional aspects to make the code 
stateless and compact. After we reached this goal, we are ready to make it reactive..


## Timeline

First we will have a 30min theoretical part of the 
content we want to work with during the Hands On Lab.
The slides are provided, plus ... 

//TODO

## The Functional Part
//TODO


### Java Basics - refreshing

* inheritance and default impl in combination
* private methods in interfaces
* 

#### TaskV001_01
Open the Class **TaskV001_01**
Question:
* is class Version_A a valid implementation?
* is class Version_B a valid implementation?
* is class Version_C a valid implementation?
* is class Version_D a valid implementation?
* is class Version_E a valid implementation?

If a class is not a valid implementation, fix it.
Check the result of each implementation 
and debug the execution to clearly understand why it is exactly so.

#### TaskV001_02
//TODO

#### TaskV001_03
//TODO


### Functional Interface
Now we want to implement a few functions.
Let´s assume we would have a class with a few methods..

```java
public static class LegacyAdder {
    public Integer add02(Integer value) {
      return value + 2;
    }
    public Integer add05(Integer value) {
      return value + 5;
    }
  }
```

#### TaskV002_01
* use the methods add02 / add05  to calculate the value 2 with 0 as input
* use the methods add02 / add05  to calculate the value 7 with 0 as input
* and create a method that is adding 7 to a value

#### TaskV002_02
* convert the methods to instances of Functions - using an interface 
    * create an Interface with the name ConstAdder and define a method signature for adding
    * define instances of ConstAdder for adding 2 and 5
    * calculate the value 2 and 7 with 0 as input
    
* convert your solution ; use the JDK Interface ```Function```
    * define instances of a Function for adding 2 and 5
    * calculate the value 2 and 7 with 0 as input
    * combining the Functions add01 and add05 with the method andThen(..)
    * combining the Functions add01 and add05 with the method compose(..)

#### TaskV002_03
* on the fly constructions
    * create an instance of the Function add02
    * use the method ```andThen()``` to add a lambda construct for to add the value 5
    * use the method ```compose()``` to add a lambda construct for to add the value 5
    
#### TaskV002_04
* make a method that will create an instance of the needed function
    * implement the methods ```adder02()``` and ```adder05()```

#### TaskV002_05
* make a generic function that will create a Adder Function
    * define a method that is able to create a adder Function based on the input value
    ```Function<Integer, Integer> createAdder(int constValue)```
    * define a Function that is able to create an instance of a Adder function
    based on the const value provided as input
    ```Function<Integer, Function<Integer, Integer>> createAdderFunc()```
    * create an instance of adder02 and adder05 and adder07

#### TaskV002_06
* extend the JDK to have a TriFunction
    * check how to BiFunction is implemented inside the JDK itself
    * copy the implementation into your TriFunction and extend it to be a TriFunction

#### TaskV002_07
* Streams Hello World

#### TaskV002_08
* refactoring, extracting repetitive code
    * convert the ```for (final String value : inputData)``` into 
      a **forEach(..)** solution on inputData.
    * convert both **println** of the values into a **forEach** solutions
    * filter the inputData Stream for the needed values before the **forEach**
    * remove the ```forEach``` and replace it 
    with a ```collect()``` using a **groupingBy** Collector. The result
    will be a  ```Map<String, List<String>> resultMap```
    The two ```List<String>``` (resultDataA/B) are now initialised with the Map Values
    * make static imports for
        * groupingBy
        * toList
        * and what ever you can find ;-)
    * remove the two result Lists and iterate once over the result Map
    
* only if you have to much time     
    * make a parallel Stream out of it and group by into a Concurrent Map
    * make the Predicate dynamic with a undefined list of key to group by
    

### Optionals or Dealing with null


#### TaskV010_01

#### TaskV010_02

### Result - the tuned Optional

#### TaskV011_01
* Basic usage of the Result
    * create a Result.success with the value **hello**
    * map the value to Uppercase
    * combine the Value with **world** - Result should be ```s1 + " - " + s2```
    * print the result into System.out, if there is an exception (failed) print this to System.err 


### Dealing with Exceptions
#### TaskV020_01
* extract the try catch blocks
    * create a Function ```Function<String, Result<Integer>> convertUnsigned()```
    * create a Function ```Function<String, Result<Integer>> convertSigned()```
    * replace the for loop with a stream
    
#### TaskV020_02
* create a checked Function
    * create an interface ```Convert extends Function<String, Result<Integer>>```
    * define a method  ```Integer applyWithException(String input)```  
    * override the method ```default Result<Integer> apply(String input)``` 
    with an default implementation that is using the method **applyWithException**
    and is holding the try catch block.
    * create an instance ```Convert convertUnsigned``` 
    * create an instance ```Convert convertSigned```
    * use the new two new Functions  
    
### One to Many - Ways

#### TaskV030_01
* convert the example into a linear list of decisions
    * extract the inner if statement block int a function
    ```Function<Integer, Result<Pair<Integer, Integer>>>```
    The class Pair is only a holder for two values.
    
#### TaskV030_02
* convert the if/else structure into a case structure





### Memoizing for a Function
refactor the implementation 
* slow method that is caching values in external Map
* transform to computeIfAbsence solution, asking the Map instead of the method
* extract a generic solution for an other type (Integer and String)
* functional memoizing solution
* for the fast: make it for a BiFunction / TriFunction - Currying



## The Reactive Part

### Core Observer / Registration Pattern
The first step t come to the reactive world is 
the switch from a direct value call to the observer pattern.

#### TaskV040_01
* implement the two methods 
    * register
    * sendEvent
    * check the output of your implementation -> see comments

#### TaskV040_02
* chaining Observers
    * implement the method marked with TODO
    * check the output of your implementation -> see comments

### Core CompletableFuture
#### Basic Functions
* Create an Instance
    * create an ExecutorPool with a fixed size of four threads - named **gangOfFour**
    * create a Supplier<String> that will produce the value **hello**
    * create an async ```CompletableFuture<String>``` based on the Supplier and work should be done by the GangOfFour
    * wait for the result and print it on Screen
    * shutdown the Executor Pool

#### 

### Pub/Sub

### CFQ


## Optionals for the fast

### TDD comparison
Test the OO oriented Code , refactor it into a functional/reactive version and compare
the possible line/branch/mutation coverage

### Memoizing
Transform a BiFunction into a curried function
Implement Memoizing
SpeedUp the legacy code/method without touching the legacy code itself
* remove the hashMap that is caching the values
* 


* Class with n methods that are throwing different exceptions
    * use this methods imperative
    * use this methods with a Stream
    * 
    
===========================
* refactor the Decorator Pattern Example

* ProxyBuilder - replace Factory and Strategy with Core Functional Interfaces
    * refactor different implementations to factory and Strategy
    * make a builder 
    * replace with Functional Interfaces from the JDK

indirect used 
* static methods to create functions -- Adder Example
