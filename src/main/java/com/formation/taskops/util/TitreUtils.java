package com.formation.taskops.util;
public final class TitreUtils {
    private TitreUtils() { }
    public static String normaliser(String titre) {
        if (titre == null || titre.isBlank()) return "";
        String nettoye = titre.trim().replaceAll("\\s+", " ");
        return nettoye.substring(0, 1).toUpperCase() + nettoye.substring(1);
    }
}
