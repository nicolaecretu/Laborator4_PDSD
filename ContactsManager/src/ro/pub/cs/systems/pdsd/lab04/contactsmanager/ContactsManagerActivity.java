package ro.pub.cs.systems.pdsd.lab04.contactsmanager;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ContactsManagerActivity extends Activity {
	
	class ButtonListener implements View.OnClickListener{

		@Override
		public void onClick(View arg0) 
		{
			// TODO Auto-generated method stub
			Button v = (Button)arg0;
			FragmentManager fragmentManager = ContactsManagerActivity.this.getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			Fragment additionalDetailsFragment = (Fragment)fragmentManager.findFragmentById(R.id.fragment_aditional_file);
			if (additionalDetailsFragment == null) 
			{
			  fragmentTransaction.add(R.id.fragment_aditional_file, new AdditionalDetailsFragment());
			  ((Button)v).setText(ContactsManagerActivity.this.getResources().getString(R.string.hide_Aditional_Fields));
			  fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
			} 
			else				
			{
			  fragmentTransaction.remove(additionalDetailsFragment);
			  ((Button)v).setText(ContactsManagerActivity.this.getResources().getString(R.string.show_Aditional_Fields));
			  fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_EXIT_MASK);
			}
			fragmentTransaction.commit();
			
									
			
			
			Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
			intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
			TextView name = (TextView)ContactsManagerActivity.this.findViewById(R.id.editText1);
			
			TextView phone = (TextView)ContactsManagerActivity.this.findViewById(R.id.editText2);
			TextView email = (TextView)ContactsManagerActivity.this.findViewById(R.id.editText3);
			TextView address = (TextView)ContactsManagerActivity.this.findViewById(R.id.editText4);
			TextView jobTitle = (TextView)ContactsManagerActivity.this.findViewById(R.id.editText5);
			TextView company = (TextView)ContactsManagerActivity.this.findViewById(R.id.editText6);
			TextView website = (TextView)ContactsManagerActivity.this.findViewById(R.id.editText7);
			TextView im = (TextView)ContactsManagerActivity.this.findViewById(R.id.editText8);
			
			
			if (name != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.NAME, name.getText());
			}
			if (phone != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone.getText());
			}
			if (email != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email.getText());
			}
			if (address != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.POSTAL, address.getText());
			}
			if (jobTitle != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, jobTitle.getText());
			}
			if (company != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.COMPANY, company.getText());
			}
			ArrayList<ContentValues> contactData = new ArrayList<ContentValues>();
			if (website != null) {
			  ContentValues websiteRow = new ContentValues();
			  websiteRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE);
			  websiteRow.put(ContactsContract.CommonDataKinds.Website.URL, website.getText().toString());
			  contactData.add(websiteRow);
			}
			if (im != null) {
			  ContentValues imRow = new ContentValues();
			  imRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE);
			  imRow.put(ContactsContract.CommonDataKinds.Im.DATA, im.getText().toString());
			  contactData.add(imRow);
			}
			intent.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, contactData);
			ContactsManagerActivity.this.startActivity(intent);
			
			//pt butonul finish
			//getActivity().finish();
			
		}
		
	}
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_manager);
        
    
		android.app.FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.action_settings, new BasicDetailsFragment());
		fragmentTransaction.commit();
		
        
    	
    }
    public void 
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contacts_manager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
   
    
    
}
