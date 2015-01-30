/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.InteractionArea;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Matthieu Blais
 */
public class HostnamePanel extends JPanel{
    
    private FlowLayout Layout;
    private JLabel hostname;
    private JTextField textip;
    private JButton btn;
    
    public HostnamePanel(){
        
        Layout = new FlowLayout();
        setLayout(Layout);
        setBackground(new Color(0,0,0,30));
        
        hostname = new JLabel("Hostname | IP : ");
        hostname.setFont(new Font("Arial",Font.BOLD, 16));
        hostname.setForeground(Color.WHITE);
        
        add(hostname);
        
        textip = new JTextField();
	textip.setColumns(10);
        
        add(textip);
        
        btn = new JButton(new RandomIpAction("Random", textip));
        
        add(btn);
        
    }
    
    public JTextField getTextField(){
        return textip;
    }
    
    
}
