package com.kabiuo.MineClearance;

import com.kabiuo.Util.Chronoscope.Timer;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ShowMoreInfoPanel extends JPanel {
    public ShowMoreInfoPanel(){
        this.setBorder(new EtchedBorder());
        this.setPreferredSize(new Dimension(160,120));
        this.add(new Timer());
    }
}
