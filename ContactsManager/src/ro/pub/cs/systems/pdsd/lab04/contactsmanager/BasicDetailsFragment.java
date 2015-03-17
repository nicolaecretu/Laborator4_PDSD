package ro.pub.cs.systems.pdsd.lab04.contactsmanager;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BasicDetailsFragment extends Fragment
{
	
	@Override
	public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle state) 
	{
	    return layoutInflater.inflate(R.layout.fragment_file, container, false);
	}
	
	 @Override
	 public void onActivityCreated(Bundle savedInstanceState) 
	 {
	    super.onActivityCreated(savedInstanceState);
	    Button btn_showadditional = (Button)getActivity().findViewById(R.id.button1);
	    
	    
	    Button btn_save = (Button)getActivity().findViewById(R.id.button2);
	    Button btn_cancel = (Button)getActivity().findViewById(R.id.button3);
	    
	    getActivity().findViewById(R.id.action_settings);
	 }
}
