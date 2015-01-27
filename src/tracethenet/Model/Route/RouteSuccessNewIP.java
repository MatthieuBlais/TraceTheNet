/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Model.Route;

/**
 * Route with an IP and/or a hostname
 * @author Thibault
 */
public class RouteSuccessNewIP  implements Route {
    private final String time;
    private String ip;
    private String hostname;
    
    /**
     * Constructor
     * @param newTime New time of the route 
     */
    public RouteSuccessNewIP(String newTime)
    {
        time = newTime;
        ip = new String();
        hostname = new String();
    }
    
    /**
     * Change the IP
     * @param newIP The new IP
     */
    public void setIP(String newIP)
    {
        ip = newIP;
    }
    
    /**
     * Change Hostname of the route
     * @param newHostname The new hostname
     */
    public void setHostname(String newHostname)
    {
        hostname = newHostname;
    }
    
    /**
     * Get the IP of the route
     * @return The IP
     */
    public String getIP()
    {
       return ip;
    }
    
    /**
     * Get the hostname of the route
     * @return The hostname
     */
    public String getHostname()
    {
        return hostname;
    }
    
    /**
     * Get the time of the route
     * @return The time
     */
    public String getTime()
    {
        return time;
    }
}
