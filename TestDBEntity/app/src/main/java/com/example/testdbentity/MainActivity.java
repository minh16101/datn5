package com.example.testdbentity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.testdbentity.homefragment.bookingcar.BookingCarEntity;
import com.example.testdbentity.homefragment.bookingcar.BookingSeatEntity;
import com.example.testdbentity.homefragment.bookingcar.viewmodel.BookingCarViewModel;
import com.example.testdbentity.homefragment.bookinghotel.BookingHotelEntity;
import com.example.testdbentity.homefragment.bookinghotel.BookingRoomEntity;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageHotel;
import com.example.testdbentity.homefragment.bookinghotel.image.ImageRoom;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.homefragment.weather.WeatherMainActivity;
import com.example.testdbentity.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BookingHotelViewModel bookingHotelViewModel;
    private BookingCarViewModel bookingCarViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);
        bookingCarViewModel = new ViewModelProvider(this).get(BookingCarViewModel.class);
        initdata();
//        Intent intent = new Intent(MainActivity.this, DisplayHotelActivity.class);
//        startActivity(intent);
//        List<InformationPeopleWithBookingHotel> informationPeopleWithBookingHotel = bookingHotelViewModel.getAllHotelOfUserWithIdUser(1);
//        Intent intent = new Intent(MainActivity.this, DisplayCarActivity.class);
//        startActivity(intent);


//        Intent intent = new Intent(MainActivity.this, MainPageActivity.class);
//        startActivity(intent);

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void initdata() {

        insertHotel();
        insertRoom();

        insertImageHotel();
        insertImageRoom();

//        insertInformation();

        insertBookingCar();
        insertBookingSeat();
    }
    private void insertBookingCar() {
        List<BookingCarEntity> bookingCarEntities = new ArrayList<>();
        bookingCarEntities.add(new BookingCarEntity("Xe hien dai1", "Ha Noi", "Nghe An", "BX My Dinh", "BX Nghe An", 31, 12, 2022, 45));
        bookingCarEntities.add(new BookingCarEntity("Xe hien dai2", "Ha Noi", "Nghe An", "BX My Dinh", "BX Nghe An", 31, 12, 2022, 45));
        bookingCarEntities.add(new BookingCarEntity("Xe hien dai3", "Ha Noi", "Nghe An", "BX My Dinh", "BX Nghe An", 30, 12, 2022, 45));
        bookingCarEntities.add(new BookingCarEntity("Xe hien dai4", "Ha Noi", "Nghe An", "BX My Dinh", "BX Nghe An", 30, 12, 2022, 45));

        bookingCarEntities.add(new BookingCarEntity("Xe truyen thong1", "Ha Noi", "Thanh Hoa", "BX My Dinh", "BX Nghe An", 31, 12, 2022, 45));
        bookingCarEntities.add(new BookingCarEntity("Xe truyen thong2", "Ha Noi", "Thanh Hoa", "BX My Dinh", "BX Nghe An", 31, 12, 2022, 45));
        bookingCarEntities.add(new BookingCarEntity("Xe truyen thong3", "Ha Noi", "Thanh Hoa", "BX My Dinh", "BX Nghe An", 30, 12, 2022, 45));
        bookingCarEntities.add(new BookingCarEntity("Xe truyen thong4", "Ha Noi", "Thanh Hoa", "BX My Dinh", "BX Nghe An", 30, 12, 2022, 45));

        bookingCarViewModel.insertBookingCar(bookingCarEntities);

    }
    private void insertBookingSeat(){
        List<BookingSeatEntity> bookingSeatEntityList = new ArrayList<>();

        bookingSeatEntityList.add(new BookingSeatEntity("A1",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A2",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A3",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A4",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A5",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A6",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A7",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A8",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A9",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A10",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A11",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A12",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A13",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A14",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A15",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A16",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A17",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A18",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A19",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A20",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A21",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A22",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A23",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A24",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A25",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A26",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A27",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A28",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A29",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A30",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A31",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A32",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A33",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A34",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A35",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A36",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A37",1, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A38",1, 200000));

        bookingSeatEntityList.add(new BookingSeatEntity("A1",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A2",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A3",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A4",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A5",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A6",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A7",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A8",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A9",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A10",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A11",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A12",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A13",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A14",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A15",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A16",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A17",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A18",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A19",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A20",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A21",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A22",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A23",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A24",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A25",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A26",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A27",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A28",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A29",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A30",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A31",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A32",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A33",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A34",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A35",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A36",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A37",2, 200000));
        bookingSeatEntityList.add(new BookingSeatEntity("A38",2, 200000));

        bookingCarViewModel.insertBookingSeat(bookingSeatEntityList);
    }
    private void insertInformation()
    {
        List<InformationEntity> informationEntities = new ArrayList<>();
        informationEntities.add(new InformationEntity("Minh", "Hoang", "09123", 1,"minh.hn123"));
        informationEntities.add(new InformationEntity("Yen", "Nguyen", "09123", 2,"yen.ng123"));
        bookingHotelViewModel.insertInformation(informationEntities);
    }
    private void insertImageHotel()
    {
        List<ImageHotel> imageHotels = new ArrayList<>();
        imageHotels.add(new ImageHotel(R.drawable.hotelvinhome,1));
        imageHotels.add(new ImageHotel(R.drawable.roomvinhome2,1));
        imageHotels.add(new ImageHotel(R.drawable.hotelnhatrang,1));
        imageHotels.add(new ImageHotel(R.drawable.roomvinhome2,1));
        imageHotels.add(new ImageHotel(R.drawable.roomvinhome3,1));

        imageHotels.add(new ImageHotel(R.drawable.hotelnhatrang, 2));
        bookingHotelViewModel.insertImageHotel(imageHotels);
    }
    private void insertImageRoom()
    {
        List<ImageRoom> imageRooms = new ArrayList<>();
        imageRooms.add(new ImageRoom(R.drawable.roomvinhome1, 1));
        imageRooms.add(new ImageRoom(R.drawable.roomvinhome2, 1));
        imageRooms.add(new ImageRoom(R.drawable.roomvinhome3, 1));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang1, 1));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang2, 1));



        imageRooms.add(new ImageRoom(R.drawable.roomvinhome2,2));
        imageRooms.add(new ImageRoom(R.drawable.roomvinhome3,3));

        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang1,4));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang2,5));
        imageRooms.add(new ImageRoom(R.drawable.roomnhatrang3,6));
        bookingHotelViewModel.insertImageRoom(imageRooms);
    }

    private void insertHotel() {
        List<BookingHotelEntity> bookingHotelEntity = new ArrayList<>();
        bookingHotelEntity.add(new BookingHotelEntity("VinHome Ocean Park", 10, "Gia Lam", "10 Gia Lam Ha Noi", "Khach san co dich vu tuyet voi", "Ha Noi"));
        bookingHotelEntity.add(new BookingHotelEntity("Ninh Van Bay", 10, "Nha Trang", "10 Nha Trang Khanh Hoa", "Khach san co dich vu tuyet voi", "Khanh Hoa"));
        bookingHotelViewModel.insertHotel(bookingHotelEntity);
    }

    private void insertRoom(){
        List<BookingRoomEntity> bookingRoomEntities = new ArrayList<>();
        bookingRoomEntities.add(new BookingRoomEntity("Room Vin 1", 2, "5.000.000 VND", "Booking noti", 0, 1));
        bookingRoomEntities.add(new BookingRoomEntity("Room Vin 2", 2, "5.000.000 VND", "Booking noti", 0, 1));
        bookingRoomEntities.add(new BookingRoomEntity("Room Vin 3", 2, "5.000.000 VND", "Booking noti", 0, 1));

        bookingRoomEntities.add(new BookingRoomEntity("Room Nha Trang 1", 2, "5.000.000 VND", "Booking noti", 0, 2));
        bookingRoomEntities.add(new BookingRoomEntity("Room Nha Trang 2", 2, "5.000.000 VND", "Booking noti", 0, 2));
        bookingRoomEntities.add(new BookingRoomEntity("Room Nha Trang 3", 2, "5.000.000 VND", "Booking noti", 0, 2));

        bookingHotelViewModel.insertRoom(bookingRoomEntities);
    }
}
