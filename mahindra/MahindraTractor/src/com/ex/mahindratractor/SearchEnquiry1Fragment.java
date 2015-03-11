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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SearchEnquiry1Fragment extends Fragment {
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	
	private View rootView;
	public SearchEnquiry1Fragment(DrawerLayout mdrawer,ListView list){
		mDrawerLayout=mdrawer;
		mDrawerList=list;
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
         rootView = inflater.inflate(R.layout.enquiry_search_1, container, false);
        
        ImageView img=(ImageView)rootView.findViewById(R.id.home);
        ImageButton searchButton=(ImageButton)rootView.findViewById(R.id.searchButton);
        img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(mDrawerList);
			}
		});
        searchButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Fragment fragment = new SearchEnquiry2Fragment(mDrawerLayout,
						mDrawerList);
				// FragmentManager fragmentManager =
				// getActivity().getSupportFragmentManager();
				FragmentTransaction fragmentTransaction = getFragmentManager()
						.beginTransaction();
				fragmentTransaction.replace(R.id.frame_container, fragment,
						"FragmentSearch2");
				// fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();
			}
		});
         createTehsilDropdown();
         createVillageDropdown();
        
        return rootView;
    }
	private void createTehsilDropdown() {
		View view = rootView.findViewById(R.id.selectTehsil);
		final List<DropDownItem> selectTehsilSet = new ArrayList<DropDownItem>();
		final RadioGroup selectTehsilList = (RadioGroup) view
				.findViewById(R.id.dropDownList);
		ImageView selectTehsilIcon = (ImageView) view
				.findViewById(R.id.titleImage);
		selectTehsilIcon.setImageResource(R.drawable.select_tehsil);
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
}
