package org.rapidpm.event.frp.v110_completable_future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskV110_01_solution {


  public static void main(String[] args) {

    ExecutorService gangOfFour = Executors.newFixedThreadPool(4);

    String join = CompletableFuture
        .supplyAsync(() -> "hello" , gangOfFour)
        .join();
    System.out.println("join = " + join);

    gangOfFour.shutdownNow();


  }
}
