/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperigeek.gtsp.geo.gmaps;

import com.aperigeek.gtsp.geo.Location;
import com.aperigeek.gtsp.geo.MapProvider;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author viv
 */
public class GMapsMapProvider implements MapProvider {

    public static final String BASE_URL = "http://maps.google.com/maps/api/staticmap?sensor=false";

    @Override
    public Image getMap(Location location) {
        return getMap(location, 512, 512);
    }

    @Override
    public Image getMap(Location location, int width, int height) {
        String url = BASE_URL + "&center=" +
                location.getLatitude() + "," +
                location.getLongitude();
        url += "&zoom=13&size=" + width + "x" + height;
        url += "&markers=color:red|" +
                location.getLatitude() + "," +
                location.getLongitude();
        try {
            BufferedImage image = ImageIO.read(new URL(url).openStream());
            return image;
        } catch (IOException ex) {
            throw new RuntimeException("Unable to get image", ex);
        }
    }

}
