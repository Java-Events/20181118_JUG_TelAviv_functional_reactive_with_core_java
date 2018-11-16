package org.rapidpm.event.frp.v002_functional_interfaces;

import static java.lang.System.out;
import static java.util.List.of;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskV002_08_solution_step05 {

  public static void main(String[] args) {

    List<String> inputData = Arrays.asList("PO784510435" ,
                                           "PO789630435" ,
                                           "PO784538641" ,
                                           "PO765400435");
    inputData
        .stream()
        .filter(v -> v.contains("963") || v.contains("54"))
        .collect(groupingBy(v -> {
          if(v.contains("963")) return "963";
          if(v.contains("54")) return "54";
          return ""; //BUG !
        } , toList()))
    .forEach((k,v) -> v.forEach(out::println));

//    resultMap
//        .getOrDefault("963", of())
//        .forEach(System.out::println);
//    resultMap
//        .getOrDefault("54", of())
//        .forEach(System.out::println);

  }

}
