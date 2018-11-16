package org.rapidpm.event.frp.v002_functional_interfaces;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskV002_08_solution_step03 {

  public static void main(String[] args) {

    List<String> inputData = Arrays.asList("PO784510435" ,
                                           "PO789630435" ,
                                           "PO784538641" ,
                                           "PO765400435");

    final List<String> resultDataA = new ArrayList<>();
    final List<String> resultDataB = new ArrayList<>();

    inputData
        .stream()
        .filter(v -> v.contains("963") || v.contains("54"))
        .forEach(value -> {
          if (value.contains("963")) {
            resultDataA.add(value);
          }
          if (value.contains("54")) {
            resultDataB.add(value);
          }
        });

    resultDataA.forEach(out::println);
    resultDataB.forEach(out::println);

  }
}
