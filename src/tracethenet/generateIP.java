/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

import java.util.Random;

/**
 *
 * @author Thibault
 */
public class generateIP {
    public static String generate()
    {
        Random r = new Random();
        return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
    }
}
