package com.ex.mahindratractor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ex.slidingmenu.model.DropDownItem;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ClosureEnquiry1Fragment extends Fragment {
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	View rootView;
	private TextView enquiryDate;
	public ClosureEnquiry1Fragment(DrawerLayout mdrawer,ListView list){
		mDrawerLayout=mdrawer;
		mDrawerList=list;
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        rootView = inflater.inflate(R.layout.enquiry_closure, container, false);
        enquiryDate=(TextView) rootView.findViewById(R.id.enquiryDate);
        enquiryDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Calendar calendar=Calendar.getInstance();
				DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new OnDateSetListener() {
					
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						
							
						
							enquiryDate.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
						
						
					}
				},calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
				datePickerDialog.show();
				
			}
		});
        ImageView img=(ImageView)rootView.findViewById(R.id.home);
        ImageButton next_btn=(ImageButton)rootView.findViewById(R.id.nextButton);
        
        img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(mDrawerList);
			}
		});
        createModelDropdown();
        next_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*Fragment fragment = new ClosureEnquiry2Fragment(mDrawerLayout,mDrawerList);
		        //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
				fragmentTransaction.replace(R.id.frame_container, fragment, "FragmentProductDetails");
				//fragmentTransaction.addToBackStack(null);
			    fragmentTransaction.commit();*/
			}
		});
        
        return rootView;
    }
	private void createModelDropdown() {
		View view = rootView.findViewById(R.id.selectClosureReason);
		final List<DropDownItem> selectTehsilSet = new ArrayList<DropDownItem>();
		final RadioGroup selectVillageList = (RadioGroup) view
				.findViewById(R.id.dropDownList);
		ImageView selectVillageIcon = (ImageView) view
				.findViewById(R.id.titleImage);
		selectVillageIcon.setVisibility(View.GONE);
		final EditText selectVillageText = (EditText) view
				.findViewById(R.id.headerText);
		selectVillageText.setFocusable(false);
		selectVillageText.setClickable(true);
		selectVillageText.setHint("Select Closure Reason");
		for (int i = 0; i < 3; i++) {
			DropDownItem downItem = new DropDownItem();
			downItem.id = i;
			if(i==0){
			downItem.text = "Cancel";
			}
			else if(i==1){
				downItem.text = "Win";
			}
			else if(i==2){
				downItem.text = "Lost";
			}
			downItem.checked = false;
			selectTehsilSet.add(downItem);
			RadioButton radioView = (RadioButton) LayoutInflater.from(
					getActivity()).inflate(R.layout.drop_down_list_item, null);
			radioView.setText(downItem.text);
			radioView.setId(i);
			LayoutParams layoutParams = new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			selectVillageList.addView(radioView, layoutParams);
		}
		view.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (selectVillageList.getVisibility() == View.VISIBLE) {
					selectVillageList.setVisibility(View.GONE);
				} else {
					selectVillageList.setVisibility(View.VISIBLE);
				}
			}
		});
		selectVillageList.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (selectVillageList.getVisibility() == View.VISIBLE) {
					selectVillageList.setVisibility(View.GONE);
				} else {
					selectVillageList.setVisibility(View.VISIBLE);
				}
				selectVillageText.setText(selectTehsilSet.get(checkedId).text);
				
			}
		});
	
	}
}
