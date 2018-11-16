package org.rapidpm.event.frp.v002_functional_interfaces;

import static java.lang.System.out;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TaskV002_08_solution {

  public static Stream<String> nextStream() {
    return Stream.of("PO784510435" ,
                     "PO789630435" ,
                     "PO784538641" ,
                     "PO765400435");
  }


  public static Function<String, Predicate<String>> predicate() {
    return (input) -> (constValue) -> constValue.contains(input);
  }

  public static Function<
      Predicate<String>,
      Function<Stream<String>, Stream<String>>> filteredStream() {
    return (predicate) -> (inputStream) -> inputStream.filter(predicate);
  }

//  public static Function<Stream<String>, List<String>> asList() {
//    return (stream) -> stream.collect(Collectors.<String>toList());
//  }

  public static BiFunction<Stream<String>, String, Stream<String>> toFilteredStream() {
    return (inputStream , filterValue) -> predicate()
        .andThen(filteredStream())
        .apply(filterValue)
        .apply(inputStream);
  }

  public static void main(String[] args) {

    //manual invocation
    predicate()
        .andThen(filteredStream())
        .apply("963")
        .apply(nextStream())
        .forEach(out::println);


    //as BiFunction
    toFilteredStream()
        .apply(nextStream() , "963")
        .forEach(out::println);

    //
    nextStream()
        .filter(predicate().apply("963"))
        .forEach(out::println);

    nextStream()
        .filter(predicate().apply("54"))
        .forEach(out::println);
  }


}
