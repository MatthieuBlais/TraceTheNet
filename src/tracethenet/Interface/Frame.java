/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface;

import javax.swing.*;
import java.awt.*;
import tracethenet.Interface.Menu.*;
import java.io.IOException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Matthieu Blais
 */
public class Frame extends JFrame {
    
    private final int SIZEX = 1024;
    private final int SIZEY = 720;
    private final String TITLE = "TraceTheNet";
    
    public Frame() throws IOException {
        
        //Size and Title of the window
        setSize(SIZEX, SIZEY);
        setTitle(TITLE);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(new BarMenu(this));

        //Main Layout
        add(new Pannel());
        
        setVisible(true);
    }
    
    
}
