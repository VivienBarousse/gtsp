/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aperigeek.gtsp.ui;

import com.aperigeek.gtsp.beans.Address;
import java.util.ArrayList;
import java.util.Collections;
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

    public void addAddresses(List<Address> addresses) {
        int firstNewIndex = addresses.size();
        this.addresses.addAll(addresses);
        fireIntervalAdded(this, firstNewIndex, firstNewIndex + addresses.size() - 1);
    }

    public void removeAddress(Address address) {
        int oldInterval = addresses.indexOf(address);
        addresses.remove(address);
        fireIntervalRemoved(this, oldInterval, oldInterval);
    }

    public void removeAllAddresses() {
        int oldSize = addresses.size();
        if (oldSize > 0) {
            addresses.clear();
            fireIntervalRemoved(this, 0, oldSize - 1);
        }
    }

    public List<Address> getAddresses() {
        return Collections.unmodifiableList(addresses);
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
