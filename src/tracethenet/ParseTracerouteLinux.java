/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

import java.util.ArrayList;

/**
 * Parse a traceroute command for linux
 * @author Thibault
 */
public class ParseTracerouteLinux extends ParseTraceroute{
        
    /**
     * Constructor wh called the uepr constructor
     * @param resultArray The array of string of traceroute result
     */
    public ParseTracerouteLinux(ArrayList<String> resultArray) 
    {
        super(resultArray);
    }
    
    /**
     * Parse for Linux
     * @return True if okay, false if error occured
     */
    @Override
    public boolean parse()
    {
        
        return true;
    }
}
