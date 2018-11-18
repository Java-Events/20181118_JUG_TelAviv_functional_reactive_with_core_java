package org.rapidpm.event.frp.v011_result;


import static java.lang.System.err;
import static java.lang.System.out;

import java.util.function.Consumer;

import org.rapidpm.frp.model.Result;

public class TaskV011_01_solution {


  public static void main(String[] args) {
    Result
        .success("hello")
        .map(String::toUpperCase)
        .thenCombine("world" , (s1 , s2) -> Result.success(s1 + " - " + s2))
        .ifPresentOrElse(out::println, (Consumer<String>) err::println);

  }


}
