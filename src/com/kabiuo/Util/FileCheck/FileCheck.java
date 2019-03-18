package com.kabiuo.Util.FileCheck;

import java.io.File;
import java.io.IOException;

public class FileCheck {
    public boolean FileChecks(String path){
        File file = new File(path);		//获取其file对象
//        System.out.println(file.exists());
        if (file.exists()) {
//            System.out.println("y");
            return true;
        }else {
            return false;
        }
    }
}
