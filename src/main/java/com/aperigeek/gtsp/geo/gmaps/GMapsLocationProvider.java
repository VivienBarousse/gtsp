/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperigeek.gtsp.geo.gmaps;

import com.aperigeek.gtsp.geo.Location;
import com.aperigeek.gtsp.geo.LocationProvider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author viv
 */
public class GMapsLocationProvider implements LocationProvider {

    public static final String BASE_URL = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false";

    @Override
    public Location getLocation(String address) {
        try {
            address = URLEncoder.encode(address, "UTF-8");
            String url = BASE_URL + "&address=" + address;

            InputStream in = new URL(url).openStream();
            InputStreamReader reader = new InputStreamReader(in);

            JSONTokener tokener = new JSONTokener(reader);
            JSONObject root = (JSONObject) tokener.nextValue();
            JSONObject loc = root.getJSONArray("results")
                    .getJSONObject(0)
                    .getJSONObject("geometry")
                    .getJSONObject("location");

            return new Location(loc.getDouble("lat"), loc.getDouble("lng"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GMapsLocationProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Unable to retrieve location", ex);
        } catch (IOException ex) {
            throw new RuntimeException("Unable to retrieve location", ex);
        } catch (JSONException ex) {
            throw new RuntimeException("Unable to retrieve location", ex);
        }
    }

}
