package org.rapidpm.event.frp.v001_functional_basics;


/**
 *
 */
public class TaskV001_01 {

  public interface InterfaceA {
    public default Integer doSomething(Integer i) {
      return i + 10;
    }
  }

  public interface InterfaceB extends InterfaceA {
    public default Integer doSomething(Integer i) {
      return i + 100;
    }
  }

  public interface InterfaceC {
    public default Integer doSomething(Integer i) {
      return i - 1;
    }
  }


//  public static class Version_A implements InterfaceA {
//
//  }

//  public static class Version_B implements InterfaceB {
//
//  }

//  public static class Version_C implements InterfaceC {
//
//  }

//  public static class Version_D implements InterfaceA, InterfaceB {
//
//  }

//  public static class Version_E implements InterfaceA , InterfaceC {
//
//  }

  public static void main(String[] args) {
//    System.out.println(new Version_A().doSomething(0));
//    System.out.println(new Version_B().doSomething(0));
//    System.out.println(new Version_C().doSomething(0));
//    System.out.println(new Version_D().doSomething(0));
//    System.out.println(new Version_E().doSomething(0));
  }


}
