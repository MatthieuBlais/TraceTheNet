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
     * PArse traceroute result for winddows
     * @return true if okay, false if error occured
     */
    @Override
    public boolean parse()
    {
        if(input.isEmpty()) return false;
        
        int line = 0;
        
        for (int j = 1; j<input.size(); j++) 
        {
            int i =0;
            int step = 0;
            ArrayList<Route> tmpRoute = new ArrayList<>();
            boolean exit = false;
            String tmpIP1 = new String(), tmpIP2 = new String();
            while(i != input.get(j).length() && !exit )
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
                           if(tmp.toString().equals("*"))
                           {
                               step = 6;//No response
                           }
                           else
                            tmpIP1 = tmp.toString();
                           break;
                       case 2:
                            tmpIP2 = tmp.toString();
                            break;
                        case 3:
                            if(tmp.charAt(0) == '*')
                                tmpRoute.add(new RouteFail());
                            else
                                tmpRoute.add(new RouteSuccessNewIP(tmp.toString()));
                            break;
                       case 4:
                            if(tmp.charAt(0) == '*')
                                tmpRoute.add(new RouteFail());
                            else
                            {
                                if(tmpRoute.get(0) instanceof RouteSuccessNewIP)
                                    tmpRoute.add(new RouteSuccessOldIP(tmp.toString()));
                                else tmpRoute.add(new RouteSuccessNewIP(tmp.toString()));
                            }
                                
                           break;
                       case 5:
                            if(tmp.charAt(0) == '*')
                                tmpRoute.add(new RouteFail());
                            else
                                if(tmpRoute.get(0) instanceof RouteSuccessNewIP
                                        || tmpRoute.get(1) instanceof RouteSuccessNewIP)
                                    tmpRoute.add(new RouteSuccessOldIP(tmp.toString()));
                                else tmpRoute.add(new RouteSuccessNewIP(tmp.toString()));;
                           break;
                       case 6:
                           tmpRoute.add(new RouteFail());
                           tmpRoute.add(new RouteFail());
                           tmpRoute.add(new RouteFail());
                           exit = true;
                           break;
                                
                    }
                
                
                //If fail for all step we can exit the loop

                int IP;
                if(step==5)
                {
                    if(tmpRoute.get(0) instanceof RouteSuccessNewIP)
                        IP = 0;
                    else if(tmpRoute.get(1) instanceof RouteSuccessNewIP)
                        IP = 1;
                    else IP = 2;
 
                    tmpIP2=tmpIP2.replace("(", "");
                    tmpIP2=tmpIP2.replace(")", "");
                    ((RouteSuccessNewIP)tmpRoute.get(IP)).setIP(tmpIP2);
                    int a =0;
                            for (String list1 : list) {
                                if (list1.equals(tmpIP2)) {
                                    a=1;
                                }
                            }
                            if (a==0)
                            list.add(tmpIP2);
                    if(!tmpIP1.equals(tmpIP2))
                        ((RouteSuccessNewIP)tmpRoute.get(IP)).setHostname(tmpIP1);
                }
                

                if(!tmp.toString().equals("ms") && step!=6)
                    step++;
            }
            line++;
            resultRoute.add(tmpRoute);
        }
        
        return true;
    }
}
