package org.rapidpm.event.frp.v002_functional_interfaces;

import java.util.Objects;
import java.util.function.Function;

public class TaskV002_06_solution {

  //  @FunctionalInterface
//  public interface BiFunction<T, U, R> {
//    R apply(T t, U u);
//    default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
//      Objects.requireNonNull(after);
//      return (T t, U u) -> after.apply(apply(t, u));
//    }
//  }

  @FunctionalInterface
  public interface TriFunction<T1, T2, T3, R> {
    R apply(T1 t1 , T2 t2 , T3 t3);

    default <V> TriFunction<T1, T2, T3, V> andThen(Function<? super R, ? extends V> after) {
      Objects.requireNonNull(after);
      return (T1 t1 , T2 t2 , T3 t3) -> after.apply(apply(t1 , t2 , t3));
    }
  }


  public static void main(String[] args) {
    TriFunction<Integer, Integer, Integer, Integer> triFunc = (a , b , c) -> a + b + c;
    System.out.println(triFunc.apply(1 , 2 , 3));
  }

}
