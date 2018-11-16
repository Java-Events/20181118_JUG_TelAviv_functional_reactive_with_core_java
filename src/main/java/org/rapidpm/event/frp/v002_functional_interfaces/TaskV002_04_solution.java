package org.rapidpm.event.frp.v002_functional_interfaces;

import static java.lang.System.out;

import java.util.function.Function;

public class TaskV002_04_solution {

  public static void main(String[] args) {
    Function<Integer, Integer> adder02 = null;
    Function<Integer, Integer> adder05 = null;

    adder02 = adder02();
    adder05 = adder05();

    out.println(adder02.apply(0));
    out.println(adder05.apply(0));


    out.println(adder02().apply(0));
    out.println(adder05().apply(0));

  }

  private static Function<Integer, Integer> adder05() {
    return (value) -> value  + 5;
  }

  private static Function<Integer, Integer> adder02() {
    return (value) -> value  + 2;
  }


}
