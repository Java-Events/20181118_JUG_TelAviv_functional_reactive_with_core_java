package org.rapidpm.event.frp.v001_functional_basics;

import static java.lang.System.out;

public class TaskV001_02 {

  public interface InterfaceA {
    default void doSomething(){
      step01();
      step02();
    }
    private void step01() {out.println("01A");}
    default void step02() {out.println("02A");}
  }

  public interface InterfaceB extends InterfaceA {
    default void step01() {out.println("01B");} //no info from compiler, but now public
    default void step02() {out.println("02B");}
  }

  public interface InterfaceC extends InterfaceA {
    private void step01() {out.println("01C");} //regular
    default void step02() {out.println("02C");}
  }

  public interface InterfaceD extends InterfaceA {
    default void doSomething(){
      step01();
      step02();
    }
    private void step01() {out.println("01D");}
  }

  public interface InterfaceE extends InterfaceA, InterfaceB {
    default void doSomething(){
      step01();
      step02();
    }
    //not possible anymore
    //private void step01() {out.println("01E");}
  }




  public static void main(String[] args) {

    var a = new InterfaceA(){};
    var b = new InterfaceA(){};
    boolean equals = a.getClass().equals(b.getClass());
    out.println("equals = " + equals);

//    a.doSomething();

    new InterfaceA(){}.doSomething();
    new InterfaceB(){}.doSomething();
    new InterfaceC(){}.doSomething();
    new InterfaceD(){}.doSomething();

  }

}
