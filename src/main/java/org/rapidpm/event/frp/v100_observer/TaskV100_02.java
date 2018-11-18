package org.rapidpm.event.frp.v100_observer;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class TaskV100_02 {

  public static class Observer<KEY, VALUE> {

    private final Map<KEY, Consumer<VALUE>> listeners = new ConcurrentHashMap<>();

    public Registration register(KEY key , Consumer<VALUE> consumer) {
      listeners.put(key , consumer);
      return () -> listeners.remove(key);
    }

    public void sendEvent(VALUE message) {
      listeners.forEach((k , v) -> v.accept(message));
    }
  }

  public interface Registration {
    void remove();
  }


  public static void main(String[] args) {

    Observer<String, String> observerA = new Observer<>();
    Observer<String, String> observerB = new Observer<>();

    Registration registrationA = observerA.register("A" , (event) -> {
      //TODO implement
    });

    observerA.sendEvent("msg-001");

    Registration registrationB = observerB.register("A" , (event) -> {
      //TODO implement
    });

    observerA.sendEvent("msg-002");
    observerB.sendEvent("msg-003");
    registrationB.remove();
    observerA.sendEvent("msg-004");
    //the output should be
//    Key[A] - got event value msg-001
//    Key[A] - got event value msg-002
//    Key[A] - got event value chained from A msg-002
//    Key[A] - got event value msg-003

  }
}
