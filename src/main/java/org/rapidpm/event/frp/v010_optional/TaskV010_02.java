package org.rapidpm.event.frp.v010_optional;


import java.util.Optional;

public class TaskV010_02 {

  public static void main(String[] args) {
    Optional<String> first = Optional.ofNullable("1");
    Optional<String> second = Optional.ofNullable(null);
    Optional<String> third = Optional.ofNullable("3");

    //Write on Screen all values that are not null, concatenated with #
    // result here would be 1#3


  }


}
