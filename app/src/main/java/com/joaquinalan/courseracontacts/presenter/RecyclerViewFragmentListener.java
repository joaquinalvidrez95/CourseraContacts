package com.joaquinalan.courseracontacts.presenter;

import com.joaquinalan.courseracontacts.pojo.Contact;

/**
 * Created by joaquinalan on 04/02/2017.
 */

public interface RecyclerViewFragmentListener {
    void initiateContacts();

    void createRecyclerViewContacts();

    void onContactCardViewClicked(Contact contact);
}
