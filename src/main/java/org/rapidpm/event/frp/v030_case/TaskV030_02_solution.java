package org.rapidpm.event.frp.v030_case;

import static java.lang.System.err;
import static java.lang.System.out;
import static java.util.Objects.isNull;
import static org.rapidpm.frp.matcher.Case.match;
import static org.rapidpm.frp.matcher.Case.matchCase;
import static org.rapidpm.frp.model.Result.failure;
import static org.rapidpm.frp.model.Result.success;

import java.util.function.Function;
import java.util.stream.Stream;

import org.rapidpm.frp.model.Result;


public class TaskV030_02_solution {
  public interface Convert extends Function<String, Result<Integer>> {
    @Override
    default Result<Integer> apply(String input) {
      try {
        return success(applyWithException(input));
      } catch (Exception e) {
        return failure(e.getMessage());
      }
    }

    Integer applyWithException(String input) throws Exception;
  }

  private static Convert convertUnsigned = Integer::parseUnsignedInt;


  public static void main(String[] args) {

    // for Each needs something != null
    Stream.of("1" , "2" , "3" , null , "5" , "-6" , "" , "7" , "8" , "  " , "ups" , "11")
          .map(inputDatum -> match(
              matchCase(() -> success(inputDatum)) ,
              matchCase(() -> isNull(inputDatum) ,
                        () -> failure("value is null")) ,
              matchCase(() -> inputDatum.isEmpty() ,   // NPE ;-) inputDatum::isEmpty; -> why?
                        () -> failure("value is an empty String")) ,
              matchCase(() -> inputDatum.isBlank() ,   // NPE ;-) inputDatum::isBlank;
                        () -> failure("value is a String filled with white spaces"))
               )
          )
          .forEach(result -> result
              .ifFailed(out::println)
              .ifPresent(
                  str -> {
                    convertUnsigned
                        .apply(str)
                        .ifFailed(failed -> err.println("shit happened.. " + failed))
                        .ifPresent(unsignedInt -> out.println("finally an unsigned int found .. " + unsignedInt));
                  })

          );
  }
}
