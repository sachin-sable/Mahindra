package com.ex.mahindratractor;

import java.util.ArrayList;
import java.util.Random;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ex.slidingmenu.model.DashboardItem;

public class Followup1Fragment extends Fragment {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private View rootView;
	private ListView listView;
	private ArrayList<DashboardItem> arrayList = new ArrayList<DashboardItem>();

	public Followup1Fragment(DrawerLayout mdrawer, ListView list) {
		mDrawerLayout = mdrawer;
		mDrawerList = list;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.enquiry_follow_up_a, container,
				false);
		listView = (ListView) rootView.findViewById(R.id.followupList);
		ImageView img = (ImageView) rootView.findViewById(R.id.home);

		img.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(mDrawerList);
			}
		});
		fillFolloupList();
		return rootView;
	}

	private void fillFolloupList() {
		for (int i = 0; i < 20; i++) {
			DashboardItem dashboardItem = new DashboardItem();
			dashboardItem.tehsil = "Tehsil " + (i + 1);
			dashboardItem.village = "Village " + (i + 1);
			Random random = new Random();
			dashboardItem.count = random.nextInt(1000);
			arrayList.add(dashboardItem);
		}
		FolloupAdapter adapter = new FolloupAdapter();
		listView.setAdapter(adapter);
	}

	private class FolloupAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrayList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return arrayList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = getActivity().getLayoutInflater().inflate(
					R.layout.follow_up_1_row, null);

			DashboardItem dashboardItem = arrayList.get(position);
			TextView tehsilText = (TextView) view.findViewById(R.id.tehsilText);
			tehsilText.setText(dashboardItem.tehsil);

			TextView village = (TextView) view.findViewById(R.id.villageText);
			village.setText(dashboardItem.village);
			TextView count = (TextView) view.findViewById(R.id.countText);
			count.setText(dashboardItem.count + "");
			view.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Fragment fragment = new Followup2Fragment(mDrawerLayout,
							mDrawerList);
					// FragmentManager fragmentManager =
					// getActivity().getSupportFragmentManager();
					FragmentTransaction fragmentTransaction = getFragmentManager()
							.beginTransaction();
					fragmentTransaction.replace(R.id.frame_container, fragment,
							"FragmentFollowup2");
					// fragmentTransaction.addToBackStack(null);
					fragmentTransaction.commit();
					
				}
			});
			return view;
		}

	}
}
