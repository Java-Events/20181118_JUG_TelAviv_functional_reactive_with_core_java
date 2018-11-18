package org.rapidpm.event.frp.v110_completable_future;


import static java.lang.System.out;
import static java.util.concurrent.CompletableFuture.completedFuture;
import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TaskV110_02 {

  public static BiFunction<Integer, Integer, Integer> calcFuncA() {
    return (s1 , s2) -> s1 + s2;
  }

  public static Function<Integer, Integer> calcFuncB() {
    return (s1) -> s1 * 10;
  }

  public static final Consumer<Integer> println() {
    return out::println;
  }

  public static void main(String[] args) {

    ExecutorService gangOfFour = Executors.newFixedThreadPool(4);

    final Supplier<Integer> longRunningTaskA = () -> 1;
    final Supplier<Integer> longRunningTaskB = () -> 2;
    final Supplier<Integer> longRunningTaskC = () -> 3;

    CompletableFuture<Integer> cfA = supplyAsync(longRunningTaskA);
    CompletableFuture<Integer> cfB = supplyAsync(longRunningTaskB);
    CompletableFuture<Integer> cfC = supplyAsync(longRunningTaskC);

    cfA
        .thenCombineAsync(cfB , calcFuncA())
        .thenCombineAsync(cfC , calcFuncA())
        .thenCompose(s -> completedFuture(calcFuncB().apply(s)))
        .thenAcceptAsync(println())
        .join();

    gangOfFour.shutdownNow();


  }
}
