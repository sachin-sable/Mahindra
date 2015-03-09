package com.ex.mahindratractor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class CreateEnquiryProfileFragment extends Fragment {
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	
	
	public CreateEnquiryProfileFragment(DrawerLayout mdrawer,ListView list){
		mDrawerLayout=mdrawer;
		mDrawerList=list;
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.create_enquiry_profile, container, false);
        
        ImageView img=(ImageView)rootView.findViewById(R.id.home);
      
        
        img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(mDrawerList);
			}
		});
        
        
        return rootView;
    }
}