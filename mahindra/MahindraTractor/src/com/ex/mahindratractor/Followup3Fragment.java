package com.ex.mahindratractor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ex.slidingmenu.model.DropDownItem;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Followup3Fragment extends Fragment implements OnClickListener{
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private EditText purchaseDate, nextVisitDate;
	private View rootView;
	public Followup3Fragment(DrawerLayout mdrawer,ListView list){
		mDrawerLayout=mdrawer;
		mDrawerList=list;
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        rootView = inflater.inflate(R.layout.enquiry_follow_up, container, false);
        purchaseDate=(EditText) rootView.findViewById(R.id.purchaseDate);
        purchaseDate.setOnClickListener(this);
        
        nextVisitDate=(EditText) rootView.findViewById(R.id.nextVisitDate);
        nextVisitDate.setOnClickListener(this);
        purchaseDate.setFocusable(false);
        purchaseDate.setClickable(true);
        nextVisitDate.setFocusable(false);
        nextVisitDate.setClickable(true);
        ImageView img=(ImageView)rootView.findViewById(R.id.home);
        
        img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(mDrawerList);
			}
		});
        createTehsilDropdown();
        
        return rootView;
    }

	private void createTehsilDropdown() {
		View view = rootView.findViewById(R.id.interestedModel);
		final List<DropDownItem> selectTehsilSet = new ArrayList<DropDownItem>();
		final RadioGroup selectTehsilList = (RadioGroup) view
				.findViewById(R.id.dropDownList);
		ImageView selectTehsilIcon = (ImageView) view
				.findViewById(R.id.titleImage);
		selectTehsilIcon.setImageResource(R.drawable.model);
		final EditText selectTehsilText = (EditText) view
				.findViewById(R.id.headerText);
		selectTehsilText.setHint("Interested Model");
		selectTehsilText.setFocusable(false);
		selectTehsilText.setClickable(true);
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
	private void showDatePickerDialog(final int id){
		Calendar calendar=Calendar.getInstance();
		DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				if(id==R.id.purchaseDate){
					purchaseDate.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
				}
				else{
					nextVisitDate.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
				}
				
			}
		},calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
		datePickerDialog.show();
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.purchaseDate:
			showDatePickerDialog(R.id.purchaseDate);
			break;
		case R.id.nextVisitDate:
			showDatePickerDialog(R.id.nextVisitDate);
			break;
		}
		
	}

}
