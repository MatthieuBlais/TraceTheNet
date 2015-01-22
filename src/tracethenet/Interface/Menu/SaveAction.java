/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.Menu;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import tracethenet.Interface.DAGArea.MainPanel;
import tracethenet.Interface.Frame;

/**
 *
 * @author Matthieu Blais
 */
public class SaveAction extends AbstractAction {
    private static Object ScreenImage;
	private final Frame window;
        private final MainPanel panel;
 
	public SaveAction(Frame window, String texte, MainPanel panel){
		super(texte);
                this.panel = panel;
		this.window = window;
	}
 
        @Override
	public void actionPerformed(ActionEvent e) { 
		
                writeImage(createImage(panel));
	}
        
        public BufferedImage createImage(JComponent component)
	{
		Dimension d = component.getSize();

                d = component.getPreferredSize();
		component.setSize( d );

		Rectangle region = new Rectangle(0, 0, d.width, d.height);
		return createImage(component, region);
	}
        
        public BufferedImage createImage(JComponent component, Rectangle region)
	{
		BufferedImage image = new BufferedImage(region.width, region.height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();

                g2d.setColor( component.getBackground() );
                g2d.fillRect(region.x, region.y, region.width, region.height);

		g2d.translate(-region.x, -region.y);
		component.paint( g2d );
		g2d.dispose();
		return image;
	}
        
        public void writeImage(BufferedImage image)
	{
                JFileChooser jfc = new JFileChooser();
                int retVal = jfc.showSaveDialog(null);
                if(retVal==JFileChooser.APPROVE_OPTION){
                File selectedFile = jfc.getSelectedFile();
                    try {
                        String test = selectedFile.getAbsolutePath();
                        int ext = test.lastIndexOf( "." );
                        if(ext==-1)
                            test = test + ".jpg";
                        ImageIO.write(image, "png", new File(test) );
                    } catch (IOException ex) {
                        Logger.getLogger(SaveAction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
		

	}

        
}