package com.ex.views;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;

import com.ex.mahindratractor.R;

public class MenuDropDown extends ImageButton {

    private ListPopupWindow mListDropDownWindow;
    private int mDropDownAnchorId;
    private ListAdapter mAdapter;
    private DropDownOnClickListener mDropDownOnClickListener;
    private OnItemClickListener mOnItemClickListener;

    public MenuDropDown(Context context, AttributeSet attrs) {
        this(context, attrs,R.attr.menuDropDown);
    }

    public MenuDropDown(Context context) {
        this(context, null);
    }

    public MenuDropDown(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mListDropDownWindow = new ListPopupWindow(context);

        mListDropDownWindow
                .setPromptPosition(ListPopupWindow.POSITION_PROMPT_BELOW);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MenuDropDown, defStyle, 0);

        mDropDownAnchorId = a.getResourceId(
                R.styleable.MenuDropDown_dropDownAnchor,
                View.NO_ID);
        mListDropDownWindow
                .setOnItemClickListener(new DropDownItemClickListener());
        mListDropDownWindow.setModal(true);
        a.recycle();
        setFocusable(true);


        mDropDownOnClickListener = new DropDownOnClickListener();
        super.setOnClickListener(mDropDownOnClickListener);
    }


    private class DropDownItemClickListener implements
            AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position,
                long id) {

            dissmissDropDown();
            if(mOnItemClickListener != null){
                mOnItemClickListener.onItemClick(parent, v, position, id);
            }
        }
    }

    private class DropDownOnClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            showDropDown();
        }
    }

    private void dissmissDropDown() {
        mListDropDownWindow.dismiss();

    }

    public <T extends ListAdapter> void setAdapter(T adapter) {
        mAdapter = adapter;
        mListDropDownWindow.setAdapter(mAdapter);
    }

    public boolean isPopupShowing() {
        return mListDropDownWindow.isShowing();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener){
        mOnItemClickListener = listener;
    }

    private void showDropDown() {
        if (mListDropDownWindow.getAnchorView() == null) {
            if (mDropDownAnchorId != View.NO_ID) {
                mListDropDownWindow.setAnchorView(getRootView().findViewById(
                        mDropDownAnchorId));
            } else {
                mListDropDownWindow.setAnchorView(this);
            }
        }
        mListDropDownWindow.show();
        if (VERSION.SDK_INT >= 9) {
            mListDropDownWindow.getListView().setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        }

    }

    public ListAdapter getAdapter() {
        return mAdapter;
    }
}