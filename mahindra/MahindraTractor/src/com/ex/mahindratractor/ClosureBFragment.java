package com.ex.mahindratractor;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class ClosureBFragment extends Fragment {
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	
	
	public ClosureBFragment(DrawerLayout mdrawer,ListView list){
		mDrawerLayout=mdrawer;
		mDrawerList=list;
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.enquiry_closure_b, container, false);
        
        ImageView img=(ImageView)rootView.findViewById(R.id.home);
        Button next_btn=(Button)rootView.findViewById(R.id.ce_sub_btn);
        
        img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(mDrawerList);
			}
		});
        next_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Fragment fragment = new CreateEnquiryFormFragment(mDrawerLayout,mDrawerList);
//		        //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//				FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
//				fragmentTransaction.replace(R.id.frame_container, fragment, "FragmentProductDetails");
//				//fragmentTransaction.addToBackStack(null);
//			    fragmentTransaction.commit();
			}
		});
        
        return rootView;
    }
}