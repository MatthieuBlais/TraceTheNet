/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

import java.util.ArrayList;

/**
 * Parse a traceroute for windows class
 * @author Thibault
 */
public class ParseTracerouteWindows extends ParseTraceroute {
    
    /**
     * Constructor who called the super constructtor
     * @param resultArray The arrray of string of result of traceroute command
     */
    public ParseTracerouteWindows(ArrayList<String> resultArray) 
    {
        super(resultArray);
    }

    /**
     * PArse traceroute result for winddows
     * @return true if okay, false if error occured
     */
    @Override
    public boolean parse()
    {
        if(input.isEmpty()) return false;
        
        int line = 0;
        
        for (int j = 4; j<input.size(); j++) 
        {
            int i =0;
            int step = 0;
            ArrayList<Route> tmpRoute = new ArrayList<>();
            boolean exit = false;
            String tmpIP1 = new String(), tmpIP2 = new String();
            while(i != input.get(j).length() && !exit)
            {
                StringBuffer tmp = new StringBuffer();
                while(i != input.get(j).length() && input.get(j).charAt(i) == ' ')
                {
                    i++;
                }
                while(i != input.get(j).length()&& input.get(j).charAt(i) != ' ')
                {
                    tmp.append(input.get(j).charAt(i));
                    i++;
                }
                if(!tmp.toString().equals("ms"))
                    switch(step)
                    {
                        case 0:
                            break;
                        case 1:
                            if(tmp.charAt(0) == '*')
                                tmpRoute.add(new RouteFail());
                            else
                                tmpRoute.add(new RouteSuccessNewIP(tmp.toString()));
                            break;
                       case 2:
                            if(tmp.charAt(0) == '*')
                                tmpRoute.add(new RouteFail());
                            else
                            {
                                if(tmpRoute.get(0) instanceof RouteSuccessNewIP)
                                    tmpRoute.add(new RouteSuccessOldIP(tmp.toString()));
                                else tmpRoute.add(new RouteSuccessNewIP(tmp.toString()));
                            }
                                
                           break;
                       case 3:
                            if(tmp.charAt(0) == '*')
                                tmpRoute.add(new RouteFail());
                            else
                                if(tmpRoute.get(0) instanceof RouteSuccessNewIP
                                        || tmpRoute.get(1) instanceof RouteSuccessNewIP)
                                    tmpRoute.add(new RouteSuccessOldIP(tmp.toString()));
                                else tmpRoute.add(new RouteSuccessNewIP(tmp.toString()));;
                           break;
                       case 4:
                            tmpIP1 = tmp.toString();
                           break;
                       case 5:
                            tmpIP2 = tmp.toString();
                            break;
                                
                    }
                
                
                //If fail for all step we can exit the loop
                if(step == 4 && tmpRoute.get(0) instanceof RouteFail
                        && tmpRoute.get(1) instanceof RouteFail
                        && tmpRoute.get(2) instanceof RouteFail)
                    exit = true;
                else
                {
                    int IP;
                    if(!tmpIP1.isEmpty())
                    {
                        if(tmpRoute.get(0) instanceof RouteSuccessNewIP)
                            IP = 0;
                        else if(tmpRoute.get(1) instanceof RouteSuccessNewIP)
                            IP = 1;
                        else IP = 2;
                        if(tmpIP2.isEmpty())
                        {
                            ((RouteSuccessNewIP)tmpRoute.get(IP)).setIP(tmpIP1);
                        }
                        else 
                        {
                            ((RouteSuccessNewIP)tmpRoute.get(IP)).setIP(tmpIP2);
                            ((RouteSuccessNewIP)tmpRoute.get(IP)).setHostname(tmpIP1);
                        }
                    }
                }

                if(!tmp.toString().equals("ms"))
                    step++;
            }
            line++;
            resultRoute.add(tmpRoute);
        }
        
        return true;
    }
}
