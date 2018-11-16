package org.rapidpm.event.frp.v002_functional_interfaces;

import static java.lang.System.out;

import java.util.function.Function;

public class TaskV002_05_solution {


  public static void main(String[] args) {

    Function<Integer, Integer> adder02;
    Function<Integer, Integer> adder05;
    Function<Integer, Integer> adder07;

    adder02 = createAdder(2);
    adder05 = createAdder(5);
    adder07 = createAdder(7);

    out.println(adder02.apply(0));
    out.println(adder05.apply(0));
    out.println(adder07.apply(0));


    Function<Integer, Function<Integer, Integer>> adderFunc = null;

    adderFunc = createAdderFunc();

    out.println(adderFunc.apply(2).apply(0));
    out.println(adderFunc.apply(5).apply(0));
    out.println(adderFunc.apply(7).apply(0));

  }

  private static Function<Integer, Function<Integer, Integer>> createAdderFunc() {
    return (constValue) -> (value) -> value + constValue;
  }

  private static Function<Integer, Integer> createAdder(int constValue) {
    return (value) -> value + constValue;
  }
}
