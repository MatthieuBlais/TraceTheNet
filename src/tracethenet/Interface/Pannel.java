/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface;

import java.awt.*;
import javax.swing.*;
import tracethenet.Interface.DAGArea.MainPanel;
import tracethenet.Interface.DAGArea.ScrollArea;
import tracethenet.Interface.InteractionArea.*;

/**
 *
 * @author Matthieu Blais
 */
public class Pannel extends JPanel{
    
    private GridBagConstraints gbc;
    private final String PATH_BACKGROUND = "images/background.jpg";
    private JLabel background;
    private InteractionPanel inter;
    private ScrollArea scroll;
    
    public Pannel(){
       super();
        
       scroll = new ScrollArea();
       inter = new InteractionPanel(scroll.getGraph(),scroll.getScroll());
       
       setSize(1024,720);
       setLayout(new BorderLayout());
       background = new JLabel(new ImageIcon(PATH_BACKGROUND));
       add(background);

       background.setLayout(new GridBagLayout());
       
       //constraint creation
        gbc = new GridBagConstraints();
        
        //(0,0)
        gbc.gridx = 0;
        gbc.gridy = 0;

        //Seul élément sur la ligne 0 donc le dernier également
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        //Occuper seulement une ligne
        gbc.gridheight = 1; 

        //Poids de l'élément : 1 en x car seul élément
        gbc.weightx = 1;
        //en y : 0.15 car c'est juste un bandeau. Ne doit pas occuper le meme espace que la page principale
        gbc.weighty = 0.01;

        //Position de l'élément dans sa case : On commence au début de la case
        gbc.anchor = GridBagConstraints.LINE_START;
        //On étend le pannel sur toute la case et l'espace libre 
        gbc.fill = GridBagConstraints.BOTH;
        //Marge en haut, à gauche, en bas et à droite : 10
        gbc.insets = new Insets(10, 10, 10, 10); 
        //On ajoute au fond d'écran
        background.add(inter, gbc);
        
        //(0,0)
        gbc.gridx = 0;
        gbc.gridy = 1;

        //Seul élément sur la ligne 0 donc le dernier également
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        //Occuper seulement une ligne
        gbc.gridheight = GridBagConstraints.REMAINDER; 

        //Poids de l'élément : 1 en x car seul élément
        gbc.weightx = 1;
        //en y : 0.15 car c'est juste un bandeau. Ne doit pas occuper le meme espace que la page principale
        gbc.weighty = 0.99;

        //On ajoute au fond d'écran
        background.add(scroll.getScroll(), gbc);
        
        
       
    }
    
    public MainPanel getMainPanel(){
        return scroll.getGraph();
    }
}
