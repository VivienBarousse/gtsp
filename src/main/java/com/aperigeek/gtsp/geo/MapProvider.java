/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperigeek.gtsp.geo;

import java.awt.Image;

/**
 *
 * @author viv
 */
public interface MapProvider {

    public Image getMap(Location location);

    public Image getMap(Location location, int width, int height);

}
