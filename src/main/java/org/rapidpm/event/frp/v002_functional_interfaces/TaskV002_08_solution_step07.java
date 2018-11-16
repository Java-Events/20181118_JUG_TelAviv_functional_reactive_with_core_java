package org.rapidpm.event.frp.v002_functional_interfaces;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.System.out;
import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TaskV002_08_solution_step07 {

  public static void main(String[] args) {

    List<String> inputData = Arrays.asList("PO784510435" ,
                                           "PO789630435" ,
                                           "PO784538641" ,
                                           "PO765400435");

    List<String> filterElements = Arrays.asList("963" , "54");

    Function<List<String>, Predicate<String>> predicate =
        filterList -> (value) -> filterList
            .stream()
            .filter(value::contains)
            .findFirst()
            .map(v -> TRUE)
            .orElse(FALSE);

    inputData
        .parallelStream()
        .filter(predicate.apply(filterElements))
        .collect(groupingByConcurrent(v -> {
          return filterElements
              .stream()
              .filter(v::contains)
              .findFirst()
              .orElse("");//BUG !
        } , toList()))
        .forEach((k , v) -> v.forEach(out::println));
  }

}
