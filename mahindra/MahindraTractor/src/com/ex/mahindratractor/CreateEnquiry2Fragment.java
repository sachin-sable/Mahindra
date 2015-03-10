package com.ex.mahindratractor;

import java.util.ArrayList;
import java.util.List;

import com.ex.slidingmenu.model.DropDownItem;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class CreateEnquiry2Fragment extends Fragment {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;

	public CreateEnquiry2Fragment(DrawerLayout mdrawer, ListView list) {
		mDrawerLayout = mdrawer;
		mDrawerList = list;

	}

	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater
				.inflate(R.layout.create_enquiry_2, container, false);

		ImageView img = (ImageView) rootView.findViewById(R.id.home);

		ImageButton next_btn = (ImageButton) rootView
				.findViewById(R.id.nextButton);

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
				Fragment fragment = new CreateEnquiry3Fragment(mDrawerLayout,
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
		createModelDropdown();
		fillCheckboxLayout();
		return rootView;
	}

	private void fillCheckboxLayout() {
		LinearLayout linearLayout=(LinearLayout) rootView.findViewById(R.id.checkBoxLayout);
		for (int i = 0; i < 3; i++) {
			View checkboxLayout=LayoutInflater.from(getActivity()).inflate(R.layout.checkbox_layout, null);
			TextView checkText=(TextView) checkboxLayout.findViewById(R.id.checkText);
			checkText.setText("Crop "+(i+1));
			linearLayout.addView(checkboxLayout);
		}
	}

	private void createModelDropdown() {
		View view = rootView.findViewById(R.id.selectBuyer);
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
		selectVillageText.setHint("Select Buyer Type");
		for (int i = 0; i < 3; i++) {
			DropDownItem downItem = new DropDownItem();
			downItem.id = i;
			if (i == 0) {
				downItem.text = "First Time Buyer";
			} else if (i == 1) {
				downItem.text = "Repeat Buyer";
			}
			if (i == 2) {
				downItem.text = "Exchange Buyer";
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
		selectVillageList
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (selectVillageList.getVisibility() == View.VISIBLE) {
							selectVillageList.setVisibility(View.GONE);
						} else {
							selectVillageList.setVisibility(View.VISIBLE);
						}
						selectVillageText.setText(selectTehsilSet
								.get(checkedId).text);

					}
				});

	}
}