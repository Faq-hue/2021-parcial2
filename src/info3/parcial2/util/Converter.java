package info3.parcial2.util;

import info3.parcial2.Email;

public class Converter {
  public static Email converted(String unConverted) {
    Email converted = new Email();
    // Recuperamos Fecha unicamente
    // System.out.println(unConverted.substring(6,6+16));

    /*
     * Hace lo mismo que arriba pero sin ser hardcodeado
     * System.out.println(unConverted.indexOf(" "));
     * System.out.println(unConverted.indexOf("\n"));
     * System.out.println(unConverted.substring(unConverted.indexOf(" ")+1,
     * unConverted.indexOf("\n")));
     */
    int prop = 0;

    while (converted.getContent() == null){
      
      if (converted.getSubject() == null) {
        int initialIndex = unConverted.indexOf(" ") + 1;
        int finalIndex = unConverted.indexOf("\n");
        String aux = unConverted.substring(initialIndex, finalIndex);

        switch (prop) {
          case 0:
            converted.setDate(aux);
            ++prop;
            break;
          case 1:
            converted.setFrom(aux);
            ++prop;
            break;
          case 2:
            converted.setTo(aux);
            ++prop;
            break;
          case 3:
            converted.setSubject(aux);
            ++prop;
            break;
        }

        //System.out.println(aux);
        unConverted = unConverted.substring(finalIndex + 1);
      }
      else
        converted.setContent(unConverted);
      

    }

    return converted;
  }
}
