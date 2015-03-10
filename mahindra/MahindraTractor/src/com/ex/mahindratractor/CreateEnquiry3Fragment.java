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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class CreateEnquiry3Fragment extends Fragment {
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private View rootView;
	private ImageView calendar;
	private EditText purchaseYear;
	public CreateEnquiry3Fragment(DrawerLayout mdrawer,ListView list){
		mDrawerLayout=mdrawer;
		mDrawerList=list;
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        rootView = inflater.inflate(R.layout.create_enquiry_3, container, false);
        purchaseYear=(EditText) rootView.findViewById(R.id.purchaseYear);
        ImageView img=(ImageView)rootView.findViewById(R.id.home);
       
        img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(mDrawerList);
			}
		});
        createModelDropdown();
        createMakeDropdown();
        calendar=(ImageView)rootView.findViewById(R.id.calendar);
        calendar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Calendar calendar=Calendar.getInstance();
				DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new OnDateSetListener() {
					
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						
						purchaseYear.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
						
						
					}
				},calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
				datePickerDialog.show();
				
			}
		});
        return rootView;
    }
	private void createModelDropdown() {
		View view = rootView.findViewById(R.id.selectExistingModel);
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
		selectVillageText.setHint("Select Existing Model");
		for (int i = 0; i < 4; i++) {
			DropDownItem downItem = new DropDownItem();
			downItem.id = i;
			downItem.text = "Model " + (i + 1);
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

	private void createMakeDropdown() {
		View view = rootView.findViewById(R.id.selectExisitingMake);
		final List<DropDownItem> selectTehsilSet = new ArrayList<DropDownItem>();
		final RadioGroup selectTehsilList = (RadioGroup) view
				.findViewById(R.id.dropDownList);
		ImageView selectTehsilIcon = (ImageView) view
				.findViewById(R.id.titleImage);
		selectTehsilIcon.setVisibility(View.GONE);
		final EditText selectTehsilText = (EditText) view
				.findViewById(R.id.headerText);
		selectTehsilText.setHint("Select Existing Make");
		selectTehsilText.setFocusable(false);
		selectTehsilText.setClickable(true);
		for (int i = 0; i < 4; i++) {
			DropDownItem downItem = new DropDownItem();
			downItem.id = i;
			downItem.text = "Make " + (i + 1);
			downItem.checked = false;
			selectTehsilSet.add(downItem);
			RadioButton radioView = (RadioButton) LayoutInflater.from(
					getActivity()).inflate(R.layout.drop_down_list_item, null);
			radioView.setText(downItem.text);
			radioView.setId(i);
			LayoutParams layoutParams = new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			selectTehsilList.addView(radioView, layoutParams);
		}
		view.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (selectTehsilList.getVisibility() == View.VISIBLE) {
					selectTehsilList.setVisibility(View.GONE);
				} else {
					selectTehsilList.setVisibility(View.VISIBLE);
				}
			}
		});
		selectTehsilList.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (selectTehsilList.getVisibility() == View.VISIBLE) {
					selectTehsilList.setVisibility(View.GONE);
				} else {
					selectTehsilList.setVisibility(View.VISIBLE);
				}
				selectTehsilText.setText(selectTehsilSet.get(checkedId).text);
				
			}
		});
	}

}
