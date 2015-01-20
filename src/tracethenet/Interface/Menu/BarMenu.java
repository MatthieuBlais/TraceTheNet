/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.Menu;

import javax.swing.*;
import tracethenet.Interface.Frame;

/**
 *
 * @author Matthieu Blais
 */
public class BarMenu extends JMenuBar {
    
    private final String MENU1 = "File";
    private final String MENU2 = "Options";
    private final String MENU3 = "Help";
            
            
    public BarMenu(Frame window){
        super();
        
        JMenu menu1 = new JMenu(MENU1);
        JMenuItem load = new JMenuItem(new LoadAction(window, "Load"));
        menu1.add(load);
        JMenuItem save = new JMenuItem(new SaveAction(window, "Save"));
        menu1.add(save);
        JMenuItem leave = new JMenuItem(new LeaveAction(window, "Leave"));
        menu1.add(leave);
        add(menu1);
        
        JMenu menu2 = new JMenu(MENU2);
        JMenuItem timeout = new JMenuItem(new TimeoutAction(window, "Timeout"));
        menu2.add(timeout);
        JMenuItem maxHost = new JMenuItem(new maxHostAction(window, "Max Hosts"));
        menu2.add(maxHost);
        JMenuItem os = new JMenuItem(new OSAction(window, "OS"));
        menu2.add(os);
        JCheckBoxMenuItem ssh = new JCheckBoxMenuItem(new SSH(window, "SSH"));
        menu2.add(ssh);
        add(menu2);
        
        JMenu menu3 = new JMenu(MENU3);
        JMenuItem about = new JMenuItem(new AboutAction(window, "About"));
        menu3.add(about);
        add(menu3);
        
    }
    
}
