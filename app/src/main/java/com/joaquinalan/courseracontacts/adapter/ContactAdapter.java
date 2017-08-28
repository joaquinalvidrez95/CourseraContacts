package com.joaquinalan.courseracontacts.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaquinalan.courseracontacts.R;
import com.joaquinalan.courseracontacts.activity.ContactDetailActivity;
import com.joaquinalan.courseracontacts.data.ContactConstructor;
import com.joaquinalan.courseracontacts.pojo.Contact;

import java.util.List;

/**
 * Created by joaquinalan on 26/01/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private List<Contact> mContacts;
    private Activity mActivity;
    private ContactAdapterListener mContactAdapterListener;

    public ContactAdapter(List<Contact> contacts, ContactAdapterListener contactAdapterListener, Activity activity) {
        this.mContacts = contacts;
        this.mActivity = activity;
        this.mContactAdapterListener = contactAdapterListener;
    }

    // It inflates layout and passes viewHolder to get the views
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.view_contactadapter_contactcardview, parent, false);
        return new ContactViewHolder(view);
    }

    // Matches each element from the list each view
    @Override
    public void onBindViewHolder(final ContactViewHolder holder, int position) {
        final Contact mContact = mContacts.get(position);

        holder.mImageViewImage.setImageResource(mContact.getImage());
        holder.mTextViewName.setText(mContact.getName());
        holder.mTextViewPhone.setText(mContact.getPhone());
        holder.mTextViewNumberOfLikes.setText(String.valueOf(mContact.getNumberOfLikes()));
    }

    @Override
    public int getItemCount() { // Number of elements that my List has.
        return mContacts.size();
    }

    public interface ContactAdapterListener {
        void onContactCardViewClicked(Contact contact);
        void onThumbUpClicked(Contact contact);
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView mImageViewImage;
        private final TextView mTextViewName;
        private final TextView mTextViewPhone;
        private final ImageButton mButtonThumbUp;
        private final TextView mTextViewNumberOfLikes;

        public ContactViewHolder(View itemView) {
            super(itemView);
            mImageViewImage = (ImageView) itemView.findViewById(R.id.imageview_contactcardview_image);
            mTextViewName = (TextView) itemView.findViewById(R.id.textview_contactcardview_name);
            mTextViewPhone = (TextView) itemView.findViewById(R.id.textview_contactcardview_phone);
            mTextViewNumberOfLikes = (TextView) itemView.findViewById(R.id.textview_contactcardview_numberoflikes);
            mButtonThumbUp = (ImageButton) itemView.findViewById(R.id.button_contactcardview_thumbup);

            mImageViewImage.setOnClickListener(this);
            mButtonThumbUp.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int contactPosition = getAdapterPosition();
            final Contact contact = mContacts.get(contactPosition);
            switch (view.getId()) {
                case R.id.imageview_contactcardview_image:
//                    Snackbar.make(view, contact.getName(), Snackbar.LENGTH_SHORT).show();
//                    Intent intent = new Intent(mActivity, ContactDetailActivity.class);
//                    intent.putExtra(mActivity.getString(R.string.contactadapter_extracontactname), contact.getName());
//                    intent.putExtra(mActivity.getString(R.string.contactadapter_extracontactphone), contact.getPhone());
//                    intent.putExtra(mActivity.getString(R.string.contactadapter_extracontactemail), contact.getEmail());
//                    mActivity.startActivity(intent);
                    mContactAdapterListener.onContactCardViewClicked(contact);
                    break;
                case R.id.button_contactcardview_thumbup:
//                    Snackbar.make(view, mActivity.getString(R.string.contactcardview_thumbupmessage)
//                            + contact.getName(), Snackbar.LENGTH_SHORT).show();
//                    ContactConstructor contactConstructor = new ContactConstructor(mActivity);
//                    contactConstructor.likeContact(contact);
//                    int numberLikes = contactConstructor.getContactLikes(contact);
//                    mTextViewNumberOfLikes.setText(String.valueOf(numberLikes));
                    mContactAdapterListener.onThumbUpClicked(contact);
                    break;
            }
        }
    }
}
