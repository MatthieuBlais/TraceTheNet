/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.InteractionArea;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import tracethenet.Interface.DAGArea.GraphDAG;
import tracethenet.Interface.DAGArea.MainPanel;

/**
 *
 * @author Matthieu Blais
 */
public class CleanAction extends AbstractAction {
	
        private MainPanel graph;
        private JScrollPane scroll;
        
        
	public CleanAction(String texte, MainPanel graph, JScrollPane scroll){
		super(texte);
                this.graph=graph;
                this.scroll=scroll;
	}
 
        @Override
	public void actionPerformed(ActionEvent e) { 
		graph.getGraph().clearGraph();
                graph.removeAll();
                graph.add(graph.getGraph().constructGraph(new ArrayList<String>()));
                scroll.repaint();
                scroll.validate();
	}
}
