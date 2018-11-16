package org.rapidpm.event.frp.v002_functional_interfaces;


/**
 * Solution with a builder and fully oo-style
 */
public class TaskV002_01_solution {

  public interface ConstAdder {
    Integer addConst(Integer value);
  }

  public static class Add02 implements ConstAdder {
    @Override
    public Integer addConst(Integer value) {
      return value + 2;
    }
  }

  public static class Add05 implements ConstAdder {
    @Override
    public Integer addConst(Integer value) {
      return value + 5;
    }
  }


  public static class Builder {
    private ConstAdder adder;

    private Builder(ConstAdder adder) {
      this.adder = adder;
    }

    public static Builder newInst() {
      return new Builder(new ConstAdder() {
        @Override
        public Integer addConst(Integer value) {
          return value;
        }
      });
    }

    public Builder combine(ConstAdder next) {

      return new Builder(new ConstAdder() {
        @Override
        public Integer addConst(Integer value) {
          return adder.addConst(next.addConst(value));
        }
      });
    }

    public ConstAdder build() { return adder; }

  }


  public static void main(String[] args) {

    Integer a = new Add02().addConst(0);
    Integer b = new Add02().addConst(new Add05().addConst(0));

    ConstAdder adder07 = Builder
        .newInst()
        .combine(new Add02())
        .combine(new Add05())
        .build();
    System.out.println("adder07 = " + adder07.addConst(0));

  }
}
