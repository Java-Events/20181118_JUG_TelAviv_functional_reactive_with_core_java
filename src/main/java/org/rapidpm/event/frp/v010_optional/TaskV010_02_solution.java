package org.rapidpm.event.frp.v010_optional;


import static java.lang.System.out;
import static java.util.stream.Collectors.joining;

import java.util.Optional;
import java.util.stream.Stream;

public class TaskV010_02_solution {

  public static void main(String[] args) {
    Optional<String> first = Optional.ofNullable("1");
    Optional<String> second = Optional.ofNullable(null);
    Optional<String> third = Optional.ofNullable("3");

    Stream.of(first , second , third)
          .filter(Optional::isPresent)
          .map(Optional::get)
          .filter(s -> ! s.isBlank())
          .reduce((v1 , v2) -> v1 + '#' + v2)
          .ifPresent(out::println);

    out.println(Stream
                    .of(first , second , third)
                    .flatMap(Optional::stream)
                    .filter(s -> ! s.isBlank())
                    .collect(joining("#")));

  }
}
