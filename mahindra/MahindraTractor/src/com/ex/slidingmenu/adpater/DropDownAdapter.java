package com.ex.slidingmenu.adpater;

import java.util.ArrayList;
import java.util.List;

import com.ex.mahindratractor.R;
import com.ex.slidingmenu.model.DropDownItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

public class DropDownAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<DropDownItem> objects = new ArrayList<DropDownItem>();
	private TextView headerText;

	public interface CloseDropdownListener {
		public void closeDropdown();
	}

	private CloseDropdownListener closeDropdownListener;

	public DropDownAdapter(Context context, int resource,
			List<DropDownItem> objects, TextView header,
			CloseDropdownListener closeDropdownListener) {

		this.context = context;
		this.objects = (ArrayList<DropDownItem>) objects;
		this.headerText = header;
		this.closeDropdownListener = closeDropdownListener;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final RadioButton view = (RadioButton) LayoutInflater.from(context)
				.inflate(R.layout.drop_down_list_item, null);
		final DropDownItem downItem = objects.get(position);
		if (downItem.checked) {
			view.setChecked(true);
		} else {
			view.setChecked(false);
		}

		view.setId(downItem.id);
		view.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				view.setChecked(true);
				headerText.setText(downItem.text);
				for (DropDownItem downItem : objects) {
					if (downItem.id == view.getId()) {
						downItem.checked = true;
					} else {
						downItem.checked = false;
					}
				}
				notifyDataSetChanged();

			}
		});
		return view;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return objects.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return objects.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
}
