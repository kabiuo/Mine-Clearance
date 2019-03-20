package com.kabiuo.Entity;

public class ConfigFileseEntity {
    private String defaultValue;
    private String saveName;
    private String downloadPath;
    private String savePath;

    public ConfigFileseEntity() {
    }

    public ConfigFileseEntity(String defaultValue, String saveName, String downloadPath, String savePath) {
        this.defaultValue = defaultValue;
        this.saveName = saveName;
        this.downloadPath = downloadPath;
        this.savePath = savePath;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
