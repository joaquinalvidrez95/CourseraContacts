package com.joaquinalan.courseracontacts.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaquinalan.courseracontacts.R;
import com.joaquinalan.courseracontacts.adapter.ContactAdapter;
import com.joaquinalan.courseracontacts.pojo.Contact;
import com.joaquinalan.courseracontacts.presenter.RecyclerViewFragmentListener;
import com.joaquinalan.courseracontacts.presenter.RecyclerViewFragmentPresenter;

import java.util.List;

/**
 * Created by joaquinalan on 29/01/2017.
 */

public class RecyclerViewFragment extends Fragment implements RecyclerViewFragmentView, ContactAdapter.ContactAdapterListener {
    private RecyclerView mRecyclerViewContacts;
    private RecyclerViewFragmentListener mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        mRecyclerViewContacts = (RecyclerView) view.findViewById(R.id.recyclerview_recyclerview_contacts);
        mPresenter = new RecyclerViewFragmentPresenter(this, getContext());
        return view;
    }

    @Override
    public void createVerticalLinearLayout() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewContacts.setLayoutManager(linearLayoutManager);
        mRecyclerViewContacts.setHasFixedSize(true);
    }

    @Override
    public ContactAdapter getAdapter(List<Contact> contacts) {
        ContactAdapter contactAdapter = new ContactAdapter(contacts, this, getActivity());
        return contactAdapter;
    }

    @Override
    public void initiateRecyclerViewAdapter(ContactAdapter contactAdapter) {
        mRecyclerViewContacts.setAdapter(contactAdapter);
    }

    @Override
    public void startContactDetailActivicty(Contact contact) {
        //Snackbar.make(view, contact.getName(), Snackbar.LENGTH_SHORT).show();
//        Toast.makeText(getContext(), contact.getName(), Toast.LENGTH_SHORT).show();
//        Activity activity = getActivity();
//        Intent intent = new Intent(activity, ContactDetailActivity.class);
//        intent.putExtra(activity.getString(R.string.contactadapter_extracontactname),
//                contact.getName());
//        intent.putExtra(activity.getString(R.string.contactadapter_extracontactphone),
//                contact.getPhone());
//        intent.putExtra(activity.getString(R.string.contactadapter_extracontactemail),
//                contact.getEmail());
//        activity.startActivity(intent);
    }

    @Override
    public void onContactCardViewClicked(Contact contact) {
        mPresenter.onContactCardViewClicked(contact);
    }

    @Override
    public void onThumbUpClicked(Contact contact) {

    }
}
