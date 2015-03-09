package com.ex.mahindratractor;

import java.util.List;

import com.ex.views.MenuDropDown;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class CreateEnquire1Fragment extends Fragment {
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	//private MenuDropDown dropDown;
	
	public CreateEnquire1Fragment(DrawerLayout mdrawer,ListView list){
		mDrawerLayout=mdrawer;
		mDrawerList=list;
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.create_enquiry_1, container, false);
       /* dropDown=(MenuDropDown) rootView.findViewById(R.id.customSpinner);
        String[] state={"Sachin", "Maya", "Raya"};
        ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(getActivity(),  android.R.layout.simple_spinner_item, state);
        dropDown.setAdapter(adapter_state);*/
        ImageView img=(ImageView)rootView.findViewById(R.id.home);
        Button next_btn=(Button)rootView.findViewById(R.id.cq_next_btn);
        
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
				Fragment fragment = new CreateEnquiry3Fragment(mDrawerLayout,mDrawerList);
		        //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
				fragmentTransaction.replace(R.id.frame_container, fragment, "FragmentProductDetails");
				//fragmentTransaction.addToBackStack(null);
			    fragmentTransaction.commit();
			}
		});
        
        return rootView;
    }
	
	
	private class Ad extends ArrayAdapter<String>{

		public Ad(Context context, int resource, List<String> objects) {
			super(context, resource, objects);
			
		}

		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			return super.getView(position, convertView, parent);
		}
		
	}
}
