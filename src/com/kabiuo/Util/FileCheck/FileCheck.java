package com.kabiuo.Util.FileCheck;

import java.io.File;
import java.io.IOException;

public class FileCheck {
    public boolean FileChecks(String path){
        File file = new File(path);		//获取其file对象
        if (file.exists()) {
            return true;
        }else {
            return false;
        }
    }
}
