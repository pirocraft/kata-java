package org.ssg.prossato.kata.fizzbuzz;

import java.util.HashMap;
import java.util.Map;

public class ChiffreEnLettres {
    private static final Map<Integer, String> mappingNombreEnMot;
    private static final String SEPARATEUR = "-";

    static {
        mappingNombreEnMot = new HashMap<>(100);
        mappingNombreEnMot.put(1, "un");
        mappingNombreEnMot.put(2, "deux");
        mappingNombreEnMot.put(3, "trois");
        mappingNombreEnMot.put(4, "quatre");
        mappingNombreEnMot.put(5, "cinq");
        mappingNombreEnMot.put(6, "six");
        mappingNombreEnMot.put(7, "sept");
        mappingNombreEnMot.put(8, "huit");
        mappingNombreEnMot.put(9, "neuf");
        mappingNombreEnMot.put(10, "dix");
        mappingNombreEnMot.put(11, "onze");
        mappingNombreEnMot.put(12, "douze");
        mappingNombreEnMot.put(13, "treize");
        mappingNombreEnMot.put(14, "quatorze");
        mappingNombreEnMot.put(15, "quinze");
        mappingNombreEnMot.put(16, "seize");
    }

    public String enLettres(int nombre) {
        if (nombreSimpleEnMots(nombre) != null)
            return nombreSimpleEnMots(nombre);

        return nombreComplexeEnMots(nombre);
    }

    private String nombreSimpleEnMots(int nombre) {
        return mappingNombreEnMot.get(nombre);
    }

    private String nombreComplexeEnMots(int nombre) {
        return nombreSimpleEnMots(Integer.parseInt(String.valueOf(nombre).charAt(0) + "0"))
                + SEPARATEUR + nombreSimpleEnMots(Integer.parseInt(String.valueOf(nombre).substring(1)));
    }
}
