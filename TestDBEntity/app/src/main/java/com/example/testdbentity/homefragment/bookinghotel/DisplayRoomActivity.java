package com.example.testdbentity.homefragment.bookinghotel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.adapter.ItemImageAdapter;
import com.example.testdbentity.homefragment.bookinghotel.adapter.ItemRAdapter;
import com.example.testdbentity.homefragment.bookinghotel.adapter.ItemSAdapter;
import com.example.testdbentity.homefragment.bookinghotel.adapter.OnClickRoom;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.homefragment.bookinghotel.hotelandpeople.InformationPeopleWithBookingHotel;
import com.example.testdbentity.homefragment.bookinghotel.hotelandpeople.PeopleAndHotelRef;
import com.example.testdbentity.homefragment.bookinghotel.image.hotelandimg.HotelWithImage;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;
import com.example.testdbentity.homefragment.bookinghotel.roomandpeople.InformationPeopleWithBookingRoom;
import com.example.testdbentity.homefragment.bookinghotel.roomandpeople.PeopleAndRoomRef;

import java.util.ArrayList;
import java.util.List;

public class DisplayRoomActivity extends AppCompatActivity {
    BookingHotelViewModel bookingHotelViewModel;
    List<InformationPeopleWithBookingHotel> informationPeopleWithBookingHotel;
    List<InformationPeopleWithBookingRoom> informationPeopleWithBookingRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_room);

        RecyclerView recyclerView = findViewById(R.id.recycler_r);
        recyclerView.setNestedScrollingEnabled(false);
        int idHotel = getIntent().getIntExtra("idHotel", 1);
        int idInformationUser = getIntent().getIntExtra("idInformationUser",0);

        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);

        recyclerViewForDetailImage(idHotel);
        setNameHotel(idHotel);
        setDayBookHotel(idHotel);
        LiveData<List<RoomWithImage>> roomWithImageList = bookingHotelViewModel.getAllImageOfRoomWithIdHotel(idHotel);

        ItemRAdapter itemRAdapter = new ItemRAdapter(new ArrayList<>());
        roomWithImageList.observe(this, imRoom -> {
            itemRAdapter.setData(imRoom);
            itemRAdapter.notifyDataSetChanged();
        });

        itemRAdapter.setOnClickRoom(new OnClickRoom() {
            @Override
            public void onSaveRoom(int idRoom, int idHotel) {
                //Lay ra tat ca cac hotel cua nguoi dung. Neu nhu nguoi dung chua book hotel nao thi insert luon
                informationPeopleWithBookingHotel = bookingHotelViewModel.getAllHotelOfUserWithIdUser(idInformationUser);
                if (informationPeopleWithBookingHotel.get(0).bookingHotelEntities.size() == 0) {
                    bookingHotelViewModel.insertPeopleAndHotelREF(new PeopleAndHotelRef(idHotel, idInformationUser));
                    bookingHotelViewModel.insertPeopleAndRoomREF(new PeopleAndRoomRef(idRoom, idInformationUser));
                } else {
                    //check hotel xem hotel da duoc book chua. Neu nhu user chua save hotel thi insert hotel and
                    List<InformationPeopleWithBookingHotel> bookingHotelEntity = bookingHotelViewModel.getAllHotelOfUserWithIdUser(1);
                    boolean checkbookhotel = false;
                    for (BookingHotelEntity x : bookingHotelEntity.get(0).bookingHotelEntities) {
                        if (x.idBookingHotel == idHotel) {
                            checkbookhotel = true;
                            break;
                        }
                    }
                    if (!checkbookhotel) {
                        bookingHotelViewModel.insertPeopleAndRoomREF(new PeopleAndRoomRef(idRoom, idInformationUser));
                        bookingHotelViewModel.insertPeopleAndHotelREF(new PeopleAndHotelRef(idHotel, idInformationUser));
                    } else {
                        //check room xem book chua

                        List<BookingRoomEntity> bookingRoomEntities = bookingHotelViewModel.getRoomOfUserWithIdHotel(idHotel, idInformationUser);

                        boolean checkbookroom = false;
                        for (BookingRoomEntity x : bookingRoomEntities) {
                            if (x.idBookingRoom == idRoom) {
                                checkbookroom = true;
                                PeopleAndRoomRef peopleAndRoomRef = bookingHotelViewModel.getUserAndRoomREF(idInformationUser, x.idBookingRoom);
                                bookingHotelViewModel.deleteUserAndRoomREF(peopleAndRoomRef);
                                break;
                            }
                        }
                        if (!checkbookroom) {
                            bookingHotelViewModel.insertPeopleAndRoomREF(new PeopleAndRoomRef(idRoom, idInformationUser));
                        }
                        List<InformationPeopleWithBookingHotel> bookingHotelEntity1 = bookingHotelViewModel.getAllHotelOfUserWithIdUser(idInformationUser);

                        for (BookingHotelEntity x : bookingHotelEntity1.get(0).bookingHotelEntities) {
                            List<BookingRoomEntity> bookingRoomEntities1 = bookingHotelViewModel.getRoomOfUserWithIdHotel(x.idBookingHotel, idInformationUser);
                            if (bookingRoomEntities1.size() == 0) {
                                PeopleAndHotelRef peopleAndHotelRef = bookingHotelViewModel.getUserAndHotelREF(idInformationUser, x.idBookingHotel);
                                bookingHotelViewModel.deleteUserAndHotelREF(peopleAndHotelRef);
                            }
                        }
                    }
                }
                Toast.makeText(getApplicationContext(), "Da luu",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onBookRoom(int idRoom, int idHotel) {
                //Lay ra booking entity co id room


                InformationEntity informationEntity = bookingHotelViewModel.getBookingRoomUser(idInformationUser);
                if(informationEntity.isBookingroom == 1)
                {
                    Toast.makeText(getApplicationContext(), "Ban da Book phong roi", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(DisplayRoomActivity.this);
                    builder.setMessage("Booking");
                    builder.setTitle("Do you want to booking ?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {

                        BookingRoomEntity bookingRoomEntity1 = bookingHotelViewModel.getRoomById(idRoom);
                        bookingRoomEntity1.isBookingRoom = 1;
                        bookingRoomEntity1.idUserBookingRoom = 1;
                        bookingHotelViewModel.updateRoomToBooked(bookingRoomEntity1);
                        informationEntity.isBookingroom = 1;
                        bookingHotelViewModel.updateWasBookingRoomInUser(informationEntity);
                        //nay ra trang thong tin day du ve booking -> hoa don -> tran chu

                        String name = informationEntity.firstNaeInformationUser + informationEntity.lastNaeInformationUser;
                                //trang hoa don book phong se start activity ve home
                        Intent intent = new Intent(DisplayRoomActivity.this, DisplayPaymentHotelActivity.class);
                        intent.putExtra("userId", idInformationUser);
                        intent.putExtra("roomId", idRoom);
                        intent.putExtra("hotelId", idHotel);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Booking Done!", Toast.LENGTH_SHORT).show();
                    });

                    // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                    builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                        dialog.cancel();
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRAdapter);
    }
    private void recyclerViewForDetailImage(int idHotelT)
    {
        RecyclerView detailImageRecyclerView = findViewById(R.id.recycler_image_detail);
        detailImageRecyclerView.setNestedScrollingEnabled(false);
        ItemImageAdapter itemImageAdapter = new ItemImageAdapter();
        bookingHotelViewModel.getImageOfaHotel(idHotelT).observe(this, new Observer<HotelWithImage>() {
            @Override
            public void onChanged(HotelWithImage hotelWithImage) {
                itemImageAdapter.setListPathImage(hotelWithImage.imageHotelList);
                itemImageAdapter.notifyDataSetChanged();
            }
        });
        detailImageRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        detailImageRecyclerView.setAdapter(itemImageAdapter);
    }
    private void setNameHotel(int idHotelT)
    {
        TextView nameVnHotel = findViewById(R.id.name_vn_hotel_detail);
        TextView nameUkHotel = findViewById(R.id.name_uk_hotel_detail);

        BookingHotelEntity bookingHotelEntity = bookingHotelViewModel.getHotelById(idHotelT);
        String nameHotel = bookingHotelEntity.nameBookingHotel;
        String vnNameHotel = "Nhà trọ " + nameHotel;
        String ukNameHotel = nameHotel + " Motel";

        nameVnHotel.setText(vnNameHotel);
        nameUkHotel.setText(ukNameHotel);
    }
    private void setDayBookHotel(int idRoomT)
    {
        TextView startDay = findViewById(R.id.start_day_room_book);
        TextView endDay = findViewById(R.id.end_day_room_book);
        BookingRoomEntity bookingRoomEntity = bookingHotelViewModel.getRoomById(idRoomT);

        String startD = String.valueOf(bookingRoomEntity.day) + " tháng " + String.valueOf(bookingRoomEntity.month) + " năm " + String.valueOf(bookingRoomEntity.year);

        startDay.setText(startD);
        endDay.setText(startD);

    }
    private void showAllRoom()
    {
        Button buttonShowAllRoom = findViewById(R.id.button_show_all_room);
        buttonShowAllRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}