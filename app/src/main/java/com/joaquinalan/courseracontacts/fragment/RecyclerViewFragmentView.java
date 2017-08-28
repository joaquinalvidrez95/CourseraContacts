package com.joaquinalan.courseracontacts.fragment;

import com.joaquinalan.courseracontacts.adapter.ContactAdapter;
import com.joaquinalan.courseracontacts.pojo.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaquinalan on 04/02/2017.
 */

public interface RecyclerViewFragmentView {
    void createVerticalLinearLayout();

    ContactAdapter getAdapter(List<Contact> contacts);

    void initiateRecyclerViewAdapter(ContactAdapter contactAdapter);

    void startContactDetailActivicty(Contact contact);
}
