package org.rapidpm.event.frp.v002_functional_interfaces;

import java.util.function.Function;

public class TaskV002_03_solution {

  private static final Function<Integer, Integer> add02 = (value) -> value + 2;

  public static void main(String[] args) {
    System.out.println(add02
                           .andThen((value) -> value + 5)
                           .apply(0));


    // not nice; you will need to write the type infos (Function<Integer, Integer>)
    System.out.println(add02
                           .compose((Function<Integer, Integer>)(value) -> value + 5)
                           .apply(0));
  }

}
