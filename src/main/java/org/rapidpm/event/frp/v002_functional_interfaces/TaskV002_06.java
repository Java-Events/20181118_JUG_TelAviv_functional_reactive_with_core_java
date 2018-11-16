package org.rapidpm.event.frp.v002_functional_interfaces;

import static java.lang.System.out;

import java.util.function.Function;

public class TaskV002_06 {

  public static void main(String[] args) {
    Function<Integer, Function<Integer, Integer>> adderFuncInt = null;

//    adderFuncInt = TaskV002_06.<Integer>createAdderFunc();

    out.println(adderFuncInt.apply(2).apply(0));
    out.println(adderFuncInt.apply(5).apply(0));
    out.println(adderFuncInt.apply(7).apply(0));

    Function<Float, Function<Float, Float>> adderFuncFloat = null;

//    adderFuncFloat = TaskV002_06.<Float>createAdderFunc();

    out.println(adderFuncFloat.apply(2f).apply(0f));
    out.println(adderFuncFloat.apply(5f).apply(0f));
    out.println(adderFuncFloat.apply(7f).apply(0f));

  }

//  private static <T extends Number> Function<T, Function<T, T>> createAdderFunc(T constValue) {
//
//    return t -> null
//
//    if(constValue instanceof Double) {
//      return (value) -> constValue.doubleValue() + value.doubleValue();
//    } else if(constValue instanceof Float) {
//      return constValue.floatValue() + value.floatValue();
//    } else if(constValue instanceof Long) {
//      return constValue.longValue() + value.longValue();
//    } else {
//      return constValue.intValue() + value.intValue();
//    }
//
//
//    return (value) -> {
//      if(constValue instanceof Double) {
//        return constValue.doubleValue() + value.doubleValue();
//      } else if(constValue instanceof Float) {
//        return constValue.floatValue() + value.floatValue();
//      } else if(constValue instanceof Long) {
//        return constValue.longValue() + value.longValue();
//      } else {
//        return constValue.intValue() + value.intValue();
//      }
//    };
//  }


}
