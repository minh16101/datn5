package com.example.testdbentity.accountfragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookingcar.database.BookingCarDatabase;
import com.example.testdbentity.homefragment.bookingcar.viewmodel.BookingCarViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class QuanLyAccountActivity extends AppCompatActivity {

    private BookingCarViewModel bookingCarViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_account);
        bookingCarViewModel = new ViewModelProvider(this).get(BookingCarViewModel.class);

        TextInputEditText hoAccount = findViewById(R.id.ho_account);
        TextInputEditText tenAccount = findViewById(R.id.ten_account);
        TextInputEditText emailAccount = findViewById(R.id.email_account);
        TextInputEditText sdtAccount = findViewById(R.id.sdt_account);
        TextInputEditText dobAccount = findViewById(R.id.dob_account);
        TextInputEditText cityAccount = findViewById(R.id.city_account);
        TextInputEditText addressAccount = findViewById(R.id.address_account);

        String hoA = hoAccount.toString();
        String tenA = tenAccount.toString();
        String emailA = emailAccount.toString();
        String sdtA = sdtAccount.toString();
        String dobA = dobAccount.toString();
        String addressA = addressAccount.toString() + ", " + cityAccount.toString();


//        InformationEntity informationEntity = bookingCarViewModel.getInformationUser(1);
//        informationEntity.lastNaeInformationUser = tenA;
//        informationEntity.firstNaeInformationUser = hoA;
//        informationEntity.emailInformationUser = emailA;
//        informationEntity.addressInformationUser = addressA;
//        informationEntity.numberInformationUser = sdtA;
//        bookingCarViewModel.updateInformationUser(informationEntity);
    }
}
