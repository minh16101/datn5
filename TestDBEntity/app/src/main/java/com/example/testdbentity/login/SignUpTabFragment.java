package com.example.testdbentity.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.MainPageActivity;
import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.login.database.LoginEntity;
import com.example.testdbentity.login.database.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

public class SignUpTabFragment extends Fragment {
    private LoginViewModel loginViewModel;
    private BookingHotelViewModel bookingHotelViewModel;
    boolean checkAdd;
    public SignUpTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up_tab, container, false);
        EditText email = view.findViewById(R.id.sign_up_tab_email);
        EditText pass = view.findViewById(R.id.sign_up_tab_password);
        EditText repass = view.findViewById(R.id.sign_up_tab_re_password);
        EditText phonenumber = view.findViewById(R.id.sign_up_tab_phone);
        EditText firstname = view.findViewById(R.id.sign_up_tab_first_name);
        EditText lastname = view.findViewById(R.id.sign_up_tab_last_name);
        Button signUp = view.findViewById(R.id.button_sign_up);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);
        checkAdd = false;

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailS = email.getText().toString();
                String passS = pass.getText().toString();
                String repassS = repass.getText().toString();
                String firstnameS = firstname.getText().toString();
                String lastnameS = lastname.getText().toString();
                String phonenumberS = phonenumber.getText().toString();
                //lay dia chi email trong table xem da co chua
                loginViewModel.getAccountSameEmail(emailS).observe(getActivity(), new Observer<LoginEntity>() {
                    @Override
                    public void onChanged(LoginEntity loginEntity) {
                        if(loginEntity != null && !checkAdd)
                        {
                            //neu co roi
                            Toast.makeText(getContext(), "Tai khoan da ton tai!", Toast.LENGTH_SHORT).show();
                        }
                        else if(loginEntity != null && checkAdd)
                        {
                            List<InformationEntity> informationEntities = new ArrayList<>();
                            //add thong tin nguoi dung moi
                            InformationEntity informationEntity = new InformationEntity(firstnameS, lastnameS, phonenumberS, 1, emailS);
                            informationEntity.foreignKeyInformationUser = loginEntity.idAccount;
                            informationEntities.add(informationEntity);
                            bookingHotelViewModel.insertInformation(informationEntities);
                            Toast.makeText(getContext(), "Dang ky thanh cong:" + String.valueOf(loginEntity.idAccount), Toast.LENGTH_SHORT).show();

                            //check null
                            bookingHotelViewModel.getInformationOneUser(loginEntity.idAccount).observe(getActivity(), new Observer<InformationEntity>() {
                                @Override
                                public void onChanged(InformationEntity informationEntity) {
                                    Intent intent = new Intent(getActivity(), MainPageActivity.class);
                                    if(informationEntity != null)
                                    {
                                        intent.putExtra("idUserInformation", informationEntity.idInformationUser);
                                        startActivity(intent);
                                        Toast.makeText(getContext(), "Dang ky thanh cong:" + String.valueOf(informationEntity.idInformationUser), Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(getContext(), "Dang ky khong thanh cong", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                        else if(!passS.equals(repassS))
                        {
                            //check pass xem trung nhau chua
                            Toast.makeText(getContext(), "Khong hop le!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            //neu email chua ton tai va pass hop le
                            loginEntity = new LoginEntity(firstnameS, lastnameS, emailS, passS, phonenumberS);
                            loginViewModel.createAccount(loginEntity);
                            checkAdd = true;
                            //loginEntity nay la cai de add. Sau khi add se co idAccount khac. Nen sau khi add no se quay lai ham observe
                            //boi vi no da add nen coi nhu thay doi

                        }
                    }
                });

            }
        });
        return view;
    }
}