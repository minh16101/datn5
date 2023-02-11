package com.example.testdbentity.homefragment.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.adapter.ItemHAdapter;
import com.example.testdbentity.homefragment.bookinghotel.adapter.ItemSAdapter;
import com.example.testdbentity.homefragment.bookinghotel.adapter.OnClickHotel;
import com.example.testdbentity.homefragment.bookinghotel.adapter.OnclickToDetail;
import com.example.testdbentity.homefragment.bookinghotel.adapter.RecentsAdapter;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.homefragment.bookinghotel.image.hotelandimg.HotelWithImage;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;

import java.util.ArrayList;
import java.util.List;

public class DisplayHotelActivity extends AppCompatActivity {
    BookingHotelViewModel bookingHotelViewModel;
    ItemHAdapter itemHAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_hotel);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);
        int idInformationUser = getIntent().getIntExtra("idInformationUser",0);
        recyclerViewSave(idInformationUser);


        RecyclerView recyclerView = findViewById(R.id.recycler_h);
        LiveData<List<HotelWithImage>> imageHotelList;
        String city = "";
        city = getIntent().getStringExtra("cityHotel");
        if(city == null)
        {
            //start 1 activity pick room
        }
        if(city.equals(""))
        {
            imageHotelList = bookingHotelViewModel.getAllImageOfHotel();
        }
        else
        {
            imageHotelList = bookingHotelViewModel.getAllImageOfHotelWithDistrict(city);
        }
        itemHAdapter = new ItemHAdapter(new ArrayList<>());
        imageHotelList.observe(this, imHotel -> {
            itemHAdapter.setData(imHotel);
            itemHAdapter.notifyDataSetChanged();
        });
        itemHAdapter.setOnClickHotel(new OnClickHotel() {
            @Override
            public void onClickAHotel(int idHotel) {
                Intent intent = new Intent(DisplayHotelActivity.this, DisplayRoomActivity.class);
                intent.putExtra("idHotel", idHotel);
                intent.putExtra("idInformationUser", idInformationUser);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemHAdapter);
    }
    private void recyclerViewSave(int idInformationUser)
    {
        RecentsAdapter recentsAdapter = new RecentsAdapter(new ArrayList<>());
        recentsAdapter.setOnclickToDetail(new OnclickToDetail() {
            @Override
            public void OnClick(int idRoom) {

            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerView_recent);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(recentsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        LiveData<List<RoomWithImage>> roomWithImageList = bookingHotelViewModel.getRoomWithUserId(idInformationUser);
        roomWithImageList.observe(this, new Observer<List<RoomWithImage>>() {
            @Override
            public void onChanged(List<RoomWithImage> roomWithImages) {
                recentsAdapter.setRoomWithImageList(roomWithImages);
                recentsAdapter.notifyDataSetChanged();
            }
        });
    }
}
