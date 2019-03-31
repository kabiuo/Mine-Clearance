package com.kabiuo.Entity;

public class ConfigFileseEntity {
    private String defaultValue;
    private String saveName;
    private String downloadPath;
    private String savePath;
    private String md5;

    public ConfigFileseEntity() {
    }

    public ConfigFileseEntity(String defaultValue, String saveName, String downloadPath, String savePath, String md5) {
        this.defaultValue = defaultValue;
        this.saveName = saveName;
        this.downloadPath = downloadPath;
        this.savePath = savePath;
        this.md5 = md5;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
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
