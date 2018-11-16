package org.rapidpm.event.frp.v002_functional_interfaces;


/**
 * refactoring into a LegacyAdder version 
 * that could be combined into a new version of an adder 
 * that will add 7 to every input
 */
public class TaskV002_01 {

  public static class LegacyAdder {

    public Integer add02(Integer value) {
      return value + 2;
    }

    public Integer add05(Integer value) {
      return value + 5;
    }

  }

  
  
  public static void main(String[] args) {

    final LegacyAdder adder = new LegacyAdder();

    Integer a = adder.add02(0);
    Integer b = adder.add02(adder.add05(0));

  }


}
