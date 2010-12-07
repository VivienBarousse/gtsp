/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperigeek.gtsp.geo;

/**
 *
 * @author viv
 */
public interface LocationProvider {

    public Location getLocation(String address);

}
