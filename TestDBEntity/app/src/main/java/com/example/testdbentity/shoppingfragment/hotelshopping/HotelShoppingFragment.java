package com.example.testdbentity.shoppingfragment.hotelshopping;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testdbentity.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;

public class HotelShoppingFragment extends Fragment {

    public HotelShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotel_shopping, container, false);

        return view;
    }
    private List<PhotoAuto> getListPhotoAuto()
    {
        List<PhotoAuto> photoAutoList = new ArrayList<>();
        photoAutoList.add(new PhotoAuto(R.drawable.travel_bg));
        photoAutoList.add(new PhotoAuto(R.drawable.travel_bg));
        photoAutoList.add(new PhotoAuto(R.drawable.travel_bg));
        photoAutoList.add(new PhotoAuto(R.drawable.travel_bg));
        photoAutoList.add(new PhotoAuto(R.drawable.travel_bg));

        return photoAutoList;
    }

}