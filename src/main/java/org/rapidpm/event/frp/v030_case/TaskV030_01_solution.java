package org.rapidpm.event.frp.v030_case;


import static java.lang.System.out;
import static java.util.stream.Collectors.toList;
import static org.rapidpm.frp.matcher.Case.match;
import static org.rapidpm.frp.matcher.Case.matchCase;
import static org.rapidpm.frp.model.Result.success;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.rapidpm.frp.model.Pair;
import org.rapidpm.frp.model.Result;

public class TaskV030_01_solution {


  public static Function<Integer, Result<Pair<Integer, Integer>>> calc() {
    return (i) -> {
      Integer tempA = - 4;
      return match(
          matchCase(() -> success(tempA)) ,
          matchCase(() -> i == 2 , () -> success(tempA + 2)) ,
          matchCase(() -> i == 3 , () -> success(2)) ,
          matchCase(() -> i == - 1 , () -> success(tempA - 3))
      )
          .flatMap(a -> {
            Integer b = (i <= - 2) ? 5 : 2;
            return success(Pair.next(i , a + b));
          });
    };
  }

  public static void main(String[] args) {
    List<Integer> integerList = IntStream
        .range(- 5 , 6)
        .boxed()
        .collect(toList());

    integerList
        .stream()
        .map(i -> ((i > - 3) && (i < 4))
                  ? calc().apply(i)
                  : success(Pair.next(i , - 1)))
        .forEach(r -> r
            .ifPresent(p -> out.println("## result[" + p.getT1() + "] = "
                                        + p.getT2())));


//    for (Integer i : integerList) {
//      Integer result = - 1;
//      if (i > - 3 && i < 4) {
//        Integer tempA = - 4;
//        if (i == 2) { tempA = tempA + 2;}
//        else if (i == 3) { tempA = 2; }
//        else if (i == - 1) { tempA = tempA - 3;}
//        Integer tempB = (i <= - 2) ? 5 : 2;
//        result = tempA + tempB;
//      }
//      out.println("result[" + i + "] = " + result);
//    }
  }
}
