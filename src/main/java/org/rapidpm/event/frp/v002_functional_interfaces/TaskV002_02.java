package org.rapidpm.event.frp.v002_functional_interfaces;

import static java.lang.System.out;

public class TaskV002_02 {

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
    out.println(adder.add02(0));
    out.println(adder.add02(adder.add05(0)));
  }

}
