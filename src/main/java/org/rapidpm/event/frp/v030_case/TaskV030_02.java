package org.rapidpm.event.frp.v030_case;


import static java.lang.System.out;
import static java.util.Arrays.asList;

import java.util.List;

public class TaskV030_02 {


  public static void main(String[] args) {

    final List<String> inputData = asList("1" , "2" , "3" , null , "5" , "-6" , "" , "7" , "8", "  ", "ups", "11");

    for (var inputDatum : inputData) {
      if (inputDatum == null) {
        out.println("value is null");
      } else {
        if(inputDatum.isEmpty()){
          out.println("value is an empty String");
        } else if(inputDatum.isBlank()) {
          out.println("value is a String filled with white spaces");
        } else {
          try {
            int unsignedInt = Integer.parseUnsignedInt(inputDatum);
            out.println("finally an unsigned int found .. " + unsignedInt);
          } catch (Exception e){
            System.err.println("shit happened.. " + e);
          }
        }
      }
    }
  }
}
