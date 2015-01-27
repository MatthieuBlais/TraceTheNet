/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Model.OS;

/**
 * Allows the program to get the OS of the current user
 * @author Thibault
 */
public class OS {
   /**
   * detect the operating system
   * the result
   * 
   * @returns - the operating system detected
   */
    public static String getOperatingSystemType() 
    {
        String OS = System.getProperty("os.name").toLowerCase();
        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) 
        {
            return "mac";
        }
        else if (OS.indexOf("win") >= 0) 
        {
            return "windows";
        }
        else 
            return "linux";
        }
}
