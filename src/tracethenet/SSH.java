/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * Create a SSH connection and execute a command
 * @author Thibault
 */
public class SSH {
    
    private final String hostname;
    private final String username;
    private final String password;
    private final Connection conn;
    
    /**
     * Constructor
     * @param hos host of the SSH server
     * @param user User of the SSH server
     * @param pass Password of the SSH server
     */
    public SSH(String hos, String user, String pass)
    {
        hostname = hos;
        username = user;
        password = pass;
        
        /* Create a connection instance */
        conn = new Connection(hostname);
        try
        {
            /* Now connect */
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(username, password);

            if (isAuthenticated == false)
		throw new IOException("Authentication failed.");
        }
	catch (IOException e)
	{
            e.printStackTrace(System.err);
            System.exit(2);
	}
    }
    
    /**
     * Check if the server is okay
     * @return true if okay, false elseif
     */
    public boolean checkServer()
    {
        if(ConnectionCheck.checkPing(hostname))
            return true;
        else
            System.out.println("Error : the remote server in SSH doesn't answer :(");
        return false;
        
    }
    
    /**
     * Execute a command in the SSH conenction
     * @param cmd The command
     * @return The result of the command
     */
    public ArrayList<String> executeCmd(String cmd)
    {
        ArrayList<String> resultArray = new ArrayList<>();
	try
	{
            /* Create a session */
            Session sess = conn.openSession();
            sess.execCommand(cmd);

            /* 
            * This basic example does not handle stderr, which is sometimes dangerous
            * (please read the FAQ).
            */

            InputStream stdout = new StreamGobbler(sess.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            
            while (true)
            {
		String line = br.readLine();
		if (line == null)
                    break;
                resultArray.add(line);
            }

            /* Show exit status, if available (otherwise "null") */
            System.out.println("ExitCode: " + sess.getExitStatus());

            /* Close this session */
            sess.close();
	}
	catch (IOException e)
	{
            e.printStackTrace(System.err);
            System.exit(2);
	}
        return resultArray;
    }
    
    /**
     * Close SSH Connection
     */
    public void closeSSH()
    {
        /* Close the connection */
        conn.close();
    }
}
