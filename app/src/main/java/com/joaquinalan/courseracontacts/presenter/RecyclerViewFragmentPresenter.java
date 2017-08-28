package com.joaquinalan.courseracontacts.presenter;

import android.content.Context;

import com.joaquinalan.courseracontacts.adapter.ContactAdapter;
import com.joaquinalan.courseracontacts.data.ContactConstructor;
import com.joaquinalan.courseracontacts.fragment.RecyclerViewFragmentView;
import com.joaquinalan.courseracontacts.pojo.Contact;

import java.util.List;

/**
 * Created by joaquinalan on 04/02/2017.
 */

public class RecyclerViewFragmentPresenter implements RecyclerViewFragmentListener {
    private RecyclerViewFragmentView mViewable;
    private Context mContext;
    private ContactConstructor mContactConstructor;
    private List<Contact> mContacts;

    public RecyclerViewFragmentPresenter(RecyclerViewFragmentView recyclerViewFragmentView, Context context) {
        mViewable = recyclerViewFragmentView;
        mContext = context;
        initiateContacts();
    }

    @Override
    public void initiateContacts() {
        mContactConstructor = new ContactConstructor(mContext);
        mContacts = mContactConstructor.getContacts();
        createRecyclerViewContacts();
    }

    @Override
    public void createRecyclerViewContacts() {
        ContactAdapter adapter = mViewable.getAdapter(mContacts);
        mViewable.initiateRecyclerViewAdapter(adapter);
        mViewable.createVerticalLinearLayout();
    }

    @Override
    public void onContactCardViewClicked(Contact contact) {
        mViewable.startContactDetailActivicty(contact);
    }
}
