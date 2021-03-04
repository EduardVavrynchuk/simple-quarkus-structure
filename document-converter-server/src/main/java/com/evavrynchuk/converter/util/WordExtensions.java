package com.evavrynchuk.converter.util;

public enum WordExtensions {
    doc,
    dot,
    wbk,
    docx,
    docm,
    dotx,
    dotm,
    docb;


    public static boolean containsExtension(String ext) {
        for (WordExtensions wordExtensions : WordExtensions.values()) {
            if (wordExtensions.name().equals(ext)) {
                return true;
            }
        }

        return false;
    }
}
