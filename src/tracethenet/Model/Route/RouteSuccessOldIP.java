/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Model.Route;

/**
 * Class which implements Route
 * Time if the IP alreaddy exists
 * @author Thibault
 */
public class RouteSuccessOldIP implements Route{
    private final String time;
    
    /**
     * Constructor
     * @param newTime 
     */
    public RouteSuccessOldIP(String newTime)
    {
        time = newTime;
    }
    
    /**
     * Get the time if this route
     * @return The time
     */
    public String getTime()
    {
        return time;
    }
}
