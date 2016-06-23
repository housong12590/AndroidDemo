package com.iiseeu.demo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iiseeu.demo.utils.ColorUtils;

/**
 * Author: housong
 * Date: 2016/6/23 16:50
 */
public class CardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        tv.setTextColor(ColorUtils.getRandomColor());
        tv.setText(this.toString());
        return tv;
    }
}
