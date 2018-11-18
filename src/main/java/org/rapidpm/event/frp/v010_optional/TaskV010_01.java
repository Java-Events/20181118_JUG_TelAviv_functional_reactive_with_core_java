package org.rapidpm.event.frp.v010_optional;


import java.util.Optional;

public class TaskV010_01 {


  public static void main(String[] args) {
    Optional
        .of("1")
        .map(v -> v + "_mapped")
        .ifPresentOrElse(
            System.out::println ,
            () -> {/* nothing*/}
        );
  }


}
