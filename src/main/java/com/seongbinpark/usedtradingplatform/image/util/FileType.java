package com.seongbinpark.usedtradingplatform.image.util;

public enum FileType {

    PNG("png"),
    JPEG("JPEG"),
    JPG("JPG"),
    GIF("GIF");


    private final String extension;

    FileType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
