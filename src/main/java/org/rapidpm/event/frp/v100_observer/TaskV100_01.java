package org.rapidpm.event.frp.v100_observer;


import static java.lang.System.out;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class TaskV100_01 {

  public static class Observer<KEY, VALUE> {

    private final Map<KEY, Consumer<VALUE>> listeners = new ConcurrentHashMap<>();

    public Registration register(KEY key , Consumer<VALUE> consumer) {
      //TODO implement
      return null;
    }

    public void sendEvent(VALUE message) {
      //TODO implement
    }
  }

  public interface Registration {
    void remove();
  }


  public static void main(String[] args) {

    Observer<String, String> observer = new Observer<>();

    Registration a = observer
        .register("A" ,
                  s -> out.println("Key[A] - got event value " + s));
    Registration b = observer
        .register("B" ,
                  s -> out.println("Key[B] - got event value " + s));

    observer.sendEvent("Msg-01");
    a.remove();
    observer.sendEvent("Msg-02");

    //the output should be
//    Key[A] - got event value Msg-01
//    Key[B] - got event value Msg-01
//    Key[B] - got event value Msg-02

  }
}
