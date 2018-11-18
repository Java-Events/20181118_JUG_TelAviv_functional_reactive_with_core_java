package org.rapidpm.event.frp.v020_exceptions;


import static java.lang.System.err;
import static java.lang.System.out;
import static java.util.Arrays.asList;

import java.util.List;

public class TaskV020_01 {


  public static void main(String[] args) {

    final List<String> inputData = asList("1" , "2" , "3" , null , "5" , "-6" , "" , "7" , "8", "  ", "ups", "11");

    for (var inputDatum : inputData) {
        try {
          int unsignedInt = Integer.parseUnsignedInt(inputDatum);
          out.println("unsignedInt = " + unsignedInt);
        } catch (NumberFormatException e) {
          err.println(e);
          try {
            int anInt = Integer.parseInt(inputDatum);
            out.println("signedInt = " + anInt);
          } catch (NumberFormatException e1) {
            err.println(e);
          }
        }
    }
  }
}
