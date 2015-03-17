package ro.pub.cs.systems.pdsd.lab04.contactsmanager;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AdditionalDetailsFragment extends Fragment
{
	@Override
	public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle state) 
	{
	    return layoutInflater.inflate(R.layout.fragment_aditional_file, container, false);
	}
	
}
