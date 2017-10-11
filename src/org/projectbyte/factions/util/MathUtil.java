package org.projectbyte.factions.util;

public class MathUtil {
	
	public static boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
