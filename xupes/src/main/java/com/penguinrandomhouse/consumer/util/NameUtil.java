package com.penguinrandomhouse.consumer.util;


import java.util.HashSet;
import java.util.Set;

import org.apache.commons.text.WordUtils;

/**
 * Utility for converting name of person.
 *
 * @author Karar
 * @since 2020-01-20
 */
public class NameUtil {

    /**
     * If the input name is in format [lastName, firstName], convert it into [firstName lastName] format.
     * For example, "Howell, Dan" becomes "Dan Howell".
     *
     * @param name input name
     * @return formatted name
     */
    public static Set<String> convert(Set<String> names) {
    	Set<String> set = new HashSet<>();
    	for(String name: names) {
        int commaIndex = name.indexOf(',');
        if (commaIndex == -1) {
           set.add(name);
           continue;
        }

        String lastName = name.substring(0, commaIndex).trim();
        String firstName = name.substring(commaIndex + 1).trim();

        String fullName = String.format("%s %s", firstName, lastName);
        set.add(WordUtils.capitalizeFully(fullName));
    }		
        return set;
    }
}
