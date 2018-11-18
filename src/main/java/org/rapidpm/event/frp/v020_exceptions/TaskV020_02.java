package org.rapidpm.event.frp.v020_exceptions;


import static java.lang.System.err;
import static java.lang.System.out;
import static java.util.Arrays.asList;

import java.util.function.Function;

import org.rapidpm.frp.model.Result;

public class TaskV020_02 {

  public static Function<String, Result<Integer>> convertUnsigned() {
    return (input) -> {
      try {
        return Result.success(Integer.parseUnsignedInt(input));
      } catch (NumberFormatException e) {
        return Result.failure(e.getMessage());
      }
    };
  }

  public static Function<String, Result<Integer>> convertSigned() {
    return (input) -> {
      try {
        return Result.success(Integer.parseInt(input));
      } catch (NumberFormatException e) {
        return Result.failure(e.getMessage());
      }
    };
  }

  public static void main(String[] args) {
    asList("1" , "2" , "3" , null , "5" , "-6" , "" , "7" , "8" , "  " , "ups" , "11")
        .forEach(inputDatum -> convertUnsigned()
            .apply(inputDatum)
            .ifPresent(unsignedInt -> out.println("unsignedInt = " + unsignedInt))
            .ifFailed((f) -> convertSigned()
                .apply(inputDatum)
                .ifPresent(anInt -> out.println("signedInt = " + anInt))
                .ifFailed(err::println)));
  }
}
