package org.rapidpm.event.frp.v020_exceptions;


import static java.lang.System.err;
import static java.lang.System.out;
import static java.util.Arrays.asList;

import java.util.function.Function;

import org.rapidpm.frp.model.Result;

public class TaskV020_02_solution {

  public interface Convert extends Function<String, Result<Integer>> {
    @Override
    default Result<Integer> apply(String input){
      try {
        return Result.success(applyWithException(input));
      } catch (Exception e) {
        return Result.failure(e.getMessage());
      }
    }
    Integer applyWithException(String input) throws Exception;
  }

  //with Lambdas
  private static Convert convertUnsigned = (v) -> Integer.parseUnsignedInt(v);
  private static Convert convertSigned = (v) -> Integer.parseInt(v);

  //with Method references
//  private static Convert convertUnsigned = Integer::parseUnsignedInt;
//  private static Convert convertSigned = Integer::parseInt;

  public static void main(String[] args) {
    asList("1" , "2" , "3" , null , "5" , "-6" , "" , "7" , "8" , "  " , "ups" , "11")
        .forEach(inputDatum -> convertUnsigned
            .apply(inputDatum)
            .ifPresent(unsignedInt -> out.println("unsignedInt = " + unsignedInt))
            .ifFailed((f) -> convertSigned
                .apply(inputDatum)
                .ifPresent(anInt -> out.println("signedInt = " + anInt))
                .ifFailed(err::println)));
  }
}
