package com.kabiuo.Util.BGM;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;


public class BackgroundGameMusic {
    //播放方法
    public void play(String file) {
        com.sun.javafx.application.PlatformImpl.startup(()->{
            try{
                // 程序外的本地文件应该使用URI地址
                File f = new File(file);
                Media media = new Media(f.toURI().toString());
                // 必须有这一行，并且要在MediaPlayer创建之前
                final JFXPanel fxPanel = new JFXPanel();
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }catch (Exception e){
                System.out.println("文件路径无效");
            }
        });
    }
}
