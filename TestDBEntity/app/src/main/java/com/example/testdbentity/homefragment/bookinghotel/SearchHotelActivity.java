package com.example.testdbentity.homefragment.bookinghotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.example.testdbentity.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SearchHotelActivity extends AppCompatActivity {

    private static final String[] cityNames = new String[]{
            "Ha Noi", "Nghệ An", "Bắc Ninh", "Bắc Giang",
            "Phú Thọ", "Quảng Ninh", "Hải Phòng", "Thanh Hóa"
    };
    String place = "";
    private int fromYear, toYear;
    private int fromMonth, toMonth;
    private int fromDay, toDay;
    private int checkTime;
    private EditText edtFromDay, edtToDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hotel);
        int idInformationUser = getIntent().getIntExtra("idInformationUser", 1);
        showCalendar();
        AutoCompleteTextView searchCity = findViewById(R.id.location_hotel_search);
        fromYear = toYear = 5000;
        fromMonth = toMonth = 50;
        fromDay = toDay = 50;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cityNames);
        searchCity.setAdapter(adapter);
        searchCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                place = adapterView.getItemAtPosition(i).toString();
            }
        });
        Button btnSearch = findViewById(R.id.search_hotel);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchHotelActivity.this, DisplayHotelActivity.class);
                intent.putExtra("cityHotel", place);

                intent.putExtra("idInformationUser", idInformationUser);
                startActivity(intent);
            }
        });
    }
    private void showCalendar()
    {
        edtFromDay = findViewById(R.id.from_book_day);
        edtToDay = findViewById(R.id.to_book_day);

        checkTime = 0;

        edtFromDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetFrom();
            }
        });

        edtToDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetTo();
            }
        });

    }

    private void showBottomSheetFrom() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout);

        CalendarView calendarView = bottomSheetDialog.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if (year > toYear) {
                    fromDay = toDay;
                    fromMonth = toMonth;
                    fromYear = toYear;

                    toDay = dayOfMonth;
                    toMonth = month + 1;
                    toYear = year;
                } else {
                    if (month + 1 > toMonth) {
                        fromDay = toDay;
                        fromMonth = toMonth;
                        fromYear = toYear;

                        toDay = dayOfMonth;
                        toMonth = month + 1;
                        toYear = year;
                    } else {
                        if (dayOfMonth > toDay) {
                            fromDay = toDay;
                            fromMonth = toMonth;
                            fromYear = toYear;

                            toDay = dayOfMonth;
                            toMonth = month + 1;
                            toYear = year;
                        }
                        else
                        {
                            fromDay = dayOfMonth;
                            fromMonth = month + 1;
                            fromYear = year;
                        }
                    }
                }
                String date = fromDay + "-" + fromMonth + "-" + fromYear;
                edtFromDay.setText(date);
            }
        });
        bottomSheetDialog.show();
    }
    private void showBottomSheetTo() {
        final BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(this);
        bottomSheetDialog1.setContentView(R.layout.bottom_sheet_dialog_layout);

        CalendarView calendarView = bottomSheetDialog1.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                if(year < fromYear)
                {
                    toDay = fromDay;
                    toMonth = fromMonth;
                    toYear = fromYear;

                    fromDay = dayOfMonth;
                    fromMonth = month + 1;
                    fromYear = year;
                }
                else {
                    if (month + 1 < fromMonth) {
                        toDay = fromDay;
                        toMonth = fromMonth;
                        toYear = fromYear;

                        fromDay = dayOfMonth;
                        fromMonth = month + 1;
                        fromYear = year;
                    } else {
                        if (dayOfMonth < fromDay) {
                            toDay = fromDay;
                            toMonth = fromMonth;
                            toYear = fromYear;

                            fromDay = dayOfMonth;
                            fromMonth = month + 1;
                            fromYear = year;
                        }
                        else
                        {
                            toDay = dayOfMonth;
                            toMonth = month + 1;
                            toYear = year;
                        }
                    }
                }
                String date = toDay + "-" + toMonth + "-" + toYear;
                edtToDay.setText(date);
            }

        });
        bottomSheetDialog1.show();
    }

}