package com.evavrynchuk.converter.util;

import javax.ws.rs.BadRequestException;
import java.io.File;

public class ExtensionValidator {

    static final String PDF_EXT = "pdf";

    public static void validateWordDocuments(File file) {
        String fileExtension = getExtension(file);

        if (! WordExtensions.containsExtension(fileExtension.toLowerCase())) {
            throw new BadRequestException("The document has the wrong extension");
        }

    }

    public static void validateExcelDocuments(File file) {
        String fileExtension = getExtension(file);

        if (! ExcelExtensions.containsExtension(fileExtension.toLowerCase())) {
            throw new BadRequestException("The document has the wrong extension");
        }
    }

    public static void validateImageDocuments(File file) {
        String fileExtension = getExtension(file);

        if (! ImageExtensions.containsExtension(fileExtension.toLowerCase())) {
            throw new BadRequestException("The document has the wrong extension");
        }
    }

    public static void validatePDFDocuments(File file) {
        String fileExtension = getExtension(file);

        if (! PDF_EXT.equals(fileExtension)) {
            throw new BadRequestException("The document has the wrong extension");
        }
    }


    private static String getExtension(File file) {
        String fileName = file.getName();

        String[] name = fileName.split("\\.");

        return name[name.length - 1];
    }
}
