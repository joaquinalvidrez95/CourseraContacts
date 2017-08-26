package com.joaquinalan.courseracontacts.fragments;

import com.joaquinalan.courseracontacts.adapters.ContactAdapter;
import com.joaquinalan.courseracontacts.pojo.Contact;

import java.util.ArrayList;

/**
 * Created by joaquinalan on 04/02/2017.
 */

public interface RecyclerViewFragmentViewable {
    void createVerticalLinearLayout();

    ContactAdapter getAdapter(ArrayList<Contact> contacts);

    void initiateRecyclerViewAdapter(ContactAdapter contactAdapter);
}
