package com.evavrynchuk.converter.util;

public enum ExcelExtensions {
    xls,
    xlt,
    xlm,
    xlsx,
    xltx;

    public static boolean containsExtension(String ext) {
        for (ExcelExtensions excelExtensions : ExcelExtensions.values()) {
            if (excelExtensions.name().equals(ext)) {
                return true;
            }
        }

        return false;
    }

}
