package com.vn.green.common.utility;

public class StringHelper {

    private StringHelper() {
        // Hide constructor
    }

    public static String extractFilename(String fileUri) {

        int index = fileUri.indexOf('=') + 1;
        return fileUri.substring(index);
    }
}
