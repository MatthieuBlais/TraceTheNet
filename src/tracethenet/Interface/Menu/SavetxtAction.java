/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Interface.Menu;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import tracethenet.Interface.DAGArea.Link;
import tracethenet.Interface.DAGArea.MainPanel;
import tracethenet.Interface.Frame;

/**
 *
 * @author Matthieu Blais
 */
class SavetxtAction extends AbstractAction{

   private Frame window;
   private MainPanel panel;
    
    
    
    public SavetxtAction(Frame window, String save_Graph, MainPanel panel) {
        super(save_Graph);
        this.window = window;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Link> link = panel.getGraph().getAllLink();
        ArrayList<String> list = new ArrayList<String>();
        
        for (int i=0; i<link.size(); i++){
            list.add(link.get(i).getCycle()+link.get(i).getFirstNode().toString());
            list.add(link.get(i).getCycle()+link.get(i).getSecondNode().toString());
        }
        
        JFileChooser jfc = new JFileChooser();
        int retVal = jfc.showSaveDialog(null);
        if(retVal==JFileChooser.APPROVE_OPTION){
                File selectedFile = jfc.getSelectedFile();
                    
                   String test = selectedFile.getAbsolutePath();
                        int ext = test.lastIndexOf( "." );
                        if(ext==-1)
                            test = test + ".graph";
                    
                   FileWriter fileWriter = null;
        try {
           
            File newTextFile = new File(test);
            fileWriter = new FileWriter(newTextFile);
            for (int i=0; i<list.size();i++)
            fileWriter.write(list.get(i)+" ");
            fileWriter.close();
        } catch (IOException ex) {
    
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
             
            }
        }
    }
			
        
        }
    }
    
    
    

