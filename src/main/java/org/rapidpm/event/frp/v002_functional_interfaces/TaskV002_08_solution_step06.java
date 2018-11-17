package org.rapidpm.event.frp.v002_functional_interfaces;

import static java.lang.System.out;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class TaskV002_08_solution_step06 {

  public static void main(String[] args) {

    List<String> inputData = Arrays.asList("PO784510435" ,
                                           "PO789630435" ,
                                           "PO784538641" ,
                                           "PO765400435");
    inputData
        .parallelStream()
        .filter(v -> v.contains("963") || v.contains("54"))
        .collect(groupingByConcurrent(v -> {
          if(v.contains("963")) return "963";
          if(v.contains("54")) return "54";
          return ""; //BUG !
        } , toList()))
    .forEach((k,v) -> v.forEach(out::println));
  }
}
