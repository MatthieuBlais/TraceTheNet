/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Interface.Menu;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import tracethenet.Interface.DAGArea.MainPanel;
import tracethenet.Interface.Frame;

/**
 *
 * @author Matthieu Blais
 */
public class LoadAction extends AbstractAction {

    private final Frame window;
    private MainPanel panel;
    private JScrollPane scroll;

    public LoadAction(Frame window, String texte, MainPanel panel, JScrollPane scroll) {
        super(texte);

        this.window = window;
        this.panel = panel;
        this.scroll = scroll;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        int retVal = jfc.showSaveDialog(null);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();

            String test = selectedFile.getAbsolutePath();
            String extension = test.split("\\.")[1];
            if (extension.equals("graph")) {
                repaint();
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(test));
                    try {
                        StringBuilder sb = new StringBuilder();
                        String line = br.readLine();
                        System.out.println(line);
                        reconstructGraph(line);
                    } catch (IOException ex) {
                        Logger.getLogger(LoadAction.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            br.close();
                        } catch (IOException ex) {
                            Logger.getLogger(LoadAction.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LoadAction.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(LoadAction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(window,"The file is not readable. Please to choose a .graph file",
    "Extension error",
    JOptionPane.ERROR_MESSAGE);
            }

        }
        
    }
    
    public void reconstructGraph(String str){
        String[] string = str.split("\\ ");
        System.out.println(string[0]);
        int compteur=0;
        int flag = 0;
        String nb="0";
        ArrayList<String> list = new ArrayList<String>();
        panel.getGraph().clearGraph();
        for (int i=1;i<string.length;i++){
            if (flag==0){
                i--;
                list.clear();
                nb = string[i].split("\\)")[0];
                list.add( string[i].split("\\)")[1]);
                flag = 1;
                System.out.println("ok3");
            }
            else{
                if(string[i].split("\\)")[0].equals(nb)){
                    System.out.println("ok");
                    int exist = 0;
                    for (int j=0; j<list.size();j++)
                        if (list.get(j).equals(string[i].split("\\)")[1]))
                            exist = 1;
                    if(exist==0)
                    list.add(string[i].split("\\)")[1]);
                }
                else{
                    System.out.println("ok2");
                    System.out.println(nb);
                    for (int j=0; j<list.size(); j++)
                        System.out.println(list.get(j));
                    panel.getGraph().constructGraph(list,0);
                    flag = 0;
                }
                
            }
  
        }
        System.out.println(nb);
                    for (int j=0; j<list.size(); j++)
                        System.out.println(list.get(j));
                 panel.getGraph().constructGraph(list,0);
                 scroll.repaint();
                scroll.validate();
        
    }
    
    public void repaint(){
        panel.getGraph().clearGraph();
                 panel.removeAll();
                 panel.add( panel.getGraph().constructGraph(new ArrayList<String>(),1));
                 scroll.repaint();
                scroll.validate();
    }
}
