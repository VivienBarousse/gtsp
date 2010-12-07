package com.aperigeek.gtsp;

import com.aperigeek.gtsp.geo.gmaps.GMapsLocationProvider;
import com.aperigeek.gtsp.geo.gmaps.GMapsMapProvider;
import com.aperigeek.gtsp.ui.GtspFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                GtspFrame frame = new GtspFrame();

                frame.setMapProvider(new GMapsMapProvider());
                frame.setLocationProvider(new GMapsLocationProvider());

                frame.setVisible(true);
            }

        });
    }

}
