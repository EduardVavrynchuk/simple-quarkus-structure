package com.evavrynchuk.converter.util;

public enum ImageExtensions {
    gif,
    jpeg,
    png,
    svg,
    tiff;

    public static boolean containsExtension(String ext) {
        for (ImageExtensions imageExtensions : ImageExtensions.values()) {
            if (imageExtensions.name().equals(ext)) {
                return true;
            }
        }

        return false;
    }


}
