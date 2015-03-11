package com.ex.mahindratractor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.ex.slidingmenu.model.DropDownItem;

public class ClosureEnquiry2Fragment extends Fragment implements OnClickListener{
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	
	private View rootView;
	private EditText purchaseDate;
	public ClosureEnquiry2Fragment(DrawerLayout mdrawer,ListView list){
		mDrawerLayout=mdrawer;
		mDrawerList=list;
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		rootView = inflater.inflate(R.layout.enquiry_closure_2, container, false);
		 purchaseDate=(EditText) rootView.findViewById(R.id.purchaseDate);
	       purchaseDate.setOnClickListener(this);
	       purchaseDate.setClickable(true);
	       purchaseDate.setFocusable(false);
        ImageView img=(ImageView)rootView.findViewById(R.id.home);
        ImageButton next_btn=(ImageButton)rootView.findViewById(R.id.submitButton);
        
        img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(mDrawerList);
			}
		});
       createMakeDropdown();
       createModelDropdown();
       fillCheckboxLayout1();
       fillCheckboxLayout2();
        return rootView;
    }
	private void createModelDropdown() {
		View view = rootView.findViewById(R.id.selectModel);
		final List<DropDownItem> selectTehsilSet = new ArrayList<DropDownItem>();
		final RadioGroup selectVillageList = (RadioGroup) view
				.findViewById(R.id.dropDownList);
		ImageView selectVillageIcon = (ImageView) view
				.findViewById(R.id.titleImage);
		selectVillageIcon.setImageResource(R.drawable.select_model);
		final EditText selectVillageText = (EditText) view
				.findViewById(R.id.headerText);
		selectVillageText.setFocusable(false);
		selectVillageText.setClickable(true);
		selectVillageText.setHint("Select Model");
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
		View view = rootView.findViewById(R.id.selectMake);
		final List<DropDownItem> selectTehsilSet = new ArrayList<DropDownItem>();
		final RadioGroup selectTehsilList = (RadioGroup) view
				.findViewById(R.id.dropDownList);
		ImageView selectTehsilIcon = (ImageView) view
				.findViewById(R.id.titleImage);
		selectTehsilIcon.setImageResource(R.drawable.select_model);
		final EditText selectTehsilText = (EditText) view
				.findViewById(R.id.headerText);
		selectTehsilText.setHint("Select Make - Non Mahindra");
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.purchaseDate:
			Calendar calendar=Calendar.getInstance();
			DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,
						int dayOfMonth) {
					
						purchaseDate.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
					
					
				}
			},calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
			datePickerDialog.show();
			
			break;

		default:
			break;
		}
		
	}
	
	private void fillCheckboxLayout1() {
		LinearLayout linearLayout=(LinearLayout) rootView.findViewById(R.id.checkBoxLayout1);
		for (int i = 0; i < 2; i++) {
			View checkboxLayout=LayoutInflater.from(getActivity()).inflate(R.layout.checkbox_layout, null);
			TextView checkText=(TextView) checkboxLayout.findViewById(R.id.checkText);
			checkText.setText("Commercial Reason "+(i+1));
			ImageView icon=(ImageView) checkboxLayout.findViewById(R.id.icon);
			icon.setImageResource(R.drawable.commercial);
			linearLayout.addView(checkboxLayout);
		}
	}
	private void fillCheckboxLayout2() {
		LinearLayout linearLayout=(LinearLayout) rootView.findViewById(R.id.checkBoxLayout2);
		for (int i = 0; i < 2; i++) {
			View checkboxLayout=LayoutInflater.from(getActivity()).inflate(R.layout.checkbox_layout, null);
			TextView checkText=(TextView) checkboxLayout.findViewById(R.id.checkText);
			checkText.setText("Non-Commercial Reason "+(i+1));
			ImageView icon=(ImageView) checkboxLayout.findViewById(R.id.icon);
			icon.setImageResource(R.drawable.commercial_1);
			linearLayout.addView(checkboxLayout);
		}
	}
	
}
