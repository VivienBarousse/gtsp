/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperigeek.gtsp;

import com.aperigeek.gtsp.beans.Address;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author viv
 */
public class AddressesDAO {

    private File file;

    public AddressesDAO(File file) {
        this.file = file;
    }

    public List<Address> loadAddresses() throws IOException {
        FileInputStream in = new FileInputStream(file);
        ObjectInputStream reader = new ObjectInputStream(in);

        List<Address> addresses;
        try {
            addresses = (List<Address>) reader.readObject();
        } catch (ClassNotFoundException ex) {
            throw new IOException("Incorrect file type", ex);
        }

        reader.close();
        in.close();

        return addresses;
    }

    public void saveAddresses(List<Address> addresses) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(out);

        writer.writeObject(addresses);

        writer.close();
        out.close();
    }

}
