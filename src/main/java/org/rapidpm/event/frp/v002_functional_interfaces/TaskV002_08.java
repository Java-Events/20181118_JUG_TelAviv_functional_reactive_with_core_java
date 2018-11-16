package org.rapidpm.event.frp.v002_functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskV002_08 {

  public static void main(String[] args) {

    List<String> inputData = Arrays.asList("PO784510435" ,
                                           "PO789630435" ,
                                           "PO784538641" ,
                                           "PO765400435");

    final List<String> resultDataA = new ArrayList<>();
    final List<String> resultDataB = new ArrayList<>();

    for (final String value : inputData) {
      if (value.contains("963")) {
        resultDataA.add(value);
      }
      if (value.contains("54")) {
        resultDataB.add(value);
      }
    }

    for (String v : resultDataA) {
      System.out.println(v);
    }
    for (String v : resultDataB) {
      System.out.println(v);
    }
  }
}
