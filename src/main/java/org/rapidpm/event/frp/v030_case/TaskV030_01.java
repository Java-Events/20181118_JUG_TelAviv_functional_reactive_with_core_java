package org.rapidpm.event.frp.v030_case;


import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class TaskV030_01 {


  public static void main(String[] args) {
    List<Integer> integerList = IntStream
        .range(- 5 , 6)
        .boxed()
        .collect(toList());

    for (Integer i : integerList) {
      Integer result = - 1;
      if (i > - 3 && i < 4) {
        Integer tempA = - 4;
        if (i == 2) { tempA = tempA + 2;}
        if (i == 3) { tempA = 2; }
        if (i == - 1) { tempA = tempA - 3;}
        Integer tempB = (i <= - 2) ? 5 : 2;
        result = tempA + tempB;
      }
      System.out.println("result[" + i + "] = " + result);
    }
  }
}
