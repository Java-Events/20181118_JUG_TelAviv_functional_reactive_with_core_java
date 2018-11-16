package org.rapidpm.event.frp.v002_functional_interfaces;

import static java.lang.System.out;

import java.util.function.Function;

public class TaskV002_02_solution {

  //solution with own interface
  @FunctionalInterface
  public interface ConstAdder {
    Integer addConst(Integer value);
  }

  private static final ConstAdder constAdder02 = (value) -> value + 2;
  private static final ConstAdder constAdder05 = (value) -> value + 5;

  // Solution with JDK Interfaces
  private static final Function<Integer, Integer> add02 = (value) -> value + 2;
  private static final Function<Integer, Integer> add05 = (value) -> value + 5;

  public static void main(String[] args) {

    out.println(constAdder02.addConst(0));
    out.println(constAdder02.addConst(constAdder05.addConst(0)));

    out.println(add02.apply(0));
    out.println(add02.apply(add05.apply(0)));

    Function<Integer, Integer> andThen07 = add02.andThen(add05);
    Function<Integer, Integer> combine07 = add02.compose(add05);

    out.println(andThen07.apply(0));
    out.println(combine07.apply(0));
  }


}
