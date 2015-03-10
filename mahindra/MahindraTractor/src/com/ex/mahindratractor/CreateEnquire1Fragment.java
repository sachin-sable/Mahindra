package com.ex.mahindratractor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import android.widget.TextView;

import com.ex.slidingmenu.model.DropDownItem;

public class CreateEnquire1Fragment extends Fragment implements OnClickListener{

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private TextView enquiryDate, expectedPurchaseDate;
	// private MenuDropDown dropDown;

	public CreateEnquire1Fragment(DrawerLayout mdrawer, ListView list) {
		mDrawerLayout = mdrawer;
		mDrawerList = list;

	}
	private View rootView; 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView= inflater.inflate(R.layout.create_enquiry_1, container,
				false);
		enquiryDate=(TextView) rootView.findViewById(R.id.enquiryDate);
		enquiryDate.setOnClickListener(this);
		ImageView img = (ImageView) rootView.findViewById(R.id.home);
		expectedPurchaseDate=(EditText)rootView.findViewById(R.id.purchaseDate);
		expectedPurchaseDate.setFocusable(false);
		expectedPurchaseDate.setClickable(true);
		expectedPurchaseDate.setOnClickListener(this);
		Button next_btn = (Button) rootView.findViewById(R.id.cq_next_btn);
		createTehsilDropdown();
		createVillageDropdown();
		createModelDropdown();
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
				Fragment fragment = new CreateEnquiry2Fragment(mDrawerLayout,
						mDrawerList);
				// FragmentManager fragmentManager =
				// getActivity().getSupportFragmentManager();
				FragmentTransaction fragmentTransaction = getFragmentManager()
						.beginTransaction();
				fragmentTransaction.replace(R.id.frame_container, fragment,
						"FragmentProductDetails");
				// fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();
			}
		});

		return rootView;
	}

	private void createModelDropdown() {
		View view = rootView.findViewById(R.id.selectModel);
		final List<DropDownItem> selectTehsilSet = new ArrayList<DropDownItem>();
		final RadioGroup selectVillageList = (RadioGroup) view
				.findViewById(R.id.dropDownList);
		ImageView selectVillageIcon = (ImageView) view
				.findViewById(R.id.titleImage);
		selectVillageIcon.setImageResource(R.drawable.select_village);
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

	private void createTehsilDropdown() {
		View view = rootView.findViewById(R.id.selectTehsil);
		final List<DropDownItem> selectTehsilSet = new ArrayList<DropDownItem>();
		final RadioGroup selectTehsilList = (RadioGroup) view
				.findViewById(R.id.dropDownList);
		ImageView selectTehsilIcon = (ImageView) view
				.findViewById(R.id.titleImage);
		selectTehsilIcon.setImageResource(R.drawable.tehsils_icon);
		final EditText selectTehsilText = (EditText) view
				.findViewById(R.id.headerText);
		selectTehsilText.setHint("Select Tehsil");
		selectTehsilText.setFocusable(false);
		selectTehsilText.setClickable(true);
		for (int i = 0; i < 4; i++) {
			DropDownItem downItem = new DropDownItem();
			downItem.id = i;
			downItem.text = "Tehsil " + (i + 1);
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

	private void createVillageDropdown(){
		
			View view = rootView.findViewById(R.id.selectVillage);
			final List<DropDownItem> selectTehsilSet = new ArrayList<DropDownItem>();
			final RadioGroup selectVillageList = (RadioGroup) view
					.findViewById(R.id.dropDownList);
			ImageView selectVillageIcon = (ImageView) view
					.findViewById(R.id.titleImage);
			selectVillageIcon.setImageResource(R.drawable.select_village);
			final EditText selectVillageText = (EditText) view
					.findViewById(R.id.headerText);
			selectVillageText.setHint("Select Village");
			selectVillageText.setFocusable(false);
			selectVillageText.setClickable(true);
			for (int i = 0; i < 4; i++) {
				DropDownItem downItem = new DropDownItem();
				downItem.id = i;
				downItem.text = "Village " + (i + 1);
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
	private void showDatePickerDialog(final int id){
		Calendar calendar=Calendar.getInstance();
		DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				if(id==R.id.purchaseDate){
					expectedPurchaseDate.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
				}
				else{
					enquiryDate.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
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
		case R.id.enquiryDate:
			showDatePickerDialog(R.id.enquiryDate);
			break;
		}
		
	}
}
