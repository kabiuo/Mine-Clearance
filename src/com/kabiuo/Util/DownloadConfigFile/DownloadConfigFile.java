package com.kabiuo.Util.DownloadConfigFile;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 使用NIO2下载文件， 需要 jdk 1.7+
 */
public class DownloadConfigFile {
    public static void  downLoadFromUrl(String url,String fileName,String savePath) {
        try (InputStream ins = new URL(url).openStream()) {
            Path target = Paths.get(savePath, fileName);
            Files.createDirectories(target.getParent());
            Files.copy(ins, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
