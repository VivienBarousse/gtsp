/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperigeek.gtsp.ui;

import com.aperigeek.gtsp.beans.Address;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author viv
 */
public class AddressListModel extends AbstractListModel {

    private List<Address> addresses = new ArrayList<Address>();

    public AddressListModel() {
    }

    public AddressListModel(List<Address> addresses) {
        addresses.addAll(addresses);
    }

    public void addAddress(Address address) {
        int newIndex = addresses.size();
        addresses.add(address);
        fireIntervalAdded(this, newIndex, newIndex);
    }

    public void removeAddress(Address address) {
        int oldInterval = addresses.indexOf(address);
        addresses.remove(address);
        fireIntervalRemoved(this, oldInterval, oldInterval);
    }

    @Override
    public int getSize() {
        return addresses.size();
    }

    @Override
    public Object getElementAt(int i) {
        return addresses.get(i);
    }

}
