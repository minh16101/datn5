
package com.example.testdbentity.accountfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testdbentity.R;
import com.example.testdbentity.accountfragment.activity.QuanLyAccountActivity;
import com.example.testdbentity.discoverfragment.DiscoveryFragment;

public class AccountFragment extends Fragment {

    public AccountFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        Button btnQLTK = view.findViewById(R.id.quan_ly_tai_khoan);
        btnQLTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QuanLyAccountActivity.class);
                startActivity(intent);
            }
        });

        Button saved = view.findViewById(R.id.account_saved);
        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiscoveryFragment fragment = new DiscoveryFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainerView, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
    private void clickButtonQLTK(View view)
    {

    }
}