package com.example.mobile2.ui.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.mobile2.R;
import com.example.mobile2.databinding.ActivityMainBinding;
import com.example.mobile2.ui.fragment.HomeFragment;
import com.example.mobile2.ui.fragment.MoreFragment;
import com.example.mobile2.ui.fragment.ProfileFragment;
import com.example.mobile2.ui.fragment.ProvinceFragment;
import com.example.mobile2.ui.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showFragment(new HomeFragment());

        binding.buttomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.mnuHome){
                showFragment(new HomeFragment());
            }else if (item.getItemId() == R.id.mnuProvince){
                showFragment(new ProvinceFragment());
            }else if (item.getItemId() == R.id.mnuSearch) {
                showFragment(new SearchFragment());
            }else if (item.getItemId() == R.id.mnuProfile) {
                showFragment(new ProfileFragment());
            }else if (item.getItemId() == R.id.mnuMore) {
                showFragment(new MoreFragment());
            }

            return true;

        });
    }

    private void showFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.lytFragment,fragment);

        fragmentTransaction.commit();

    }
    private void showHomeFragment(){
//        FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

//        FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//        Create fragment obj
        HomeFragment homeFragment = new HomeFragment();

//        Replace HomeFragment to lytFragment
        fragmentTransaction.replace(R.id.lytFragment,homeFragment);

//        commit transaction
        fragmentTransaction.commit();
    }



    private void showProvinceFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ProvinceFragment provinceFragment = new ProvinceFragment();

        fragmentTransaction.replace(R.id.lytFragment,provinceFragment);

        fragmentTransaction.commit();
    }

    private void showProfileFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ProfileFragment profileFragment = new ProfileFragment();

        fragmentTransaction.replace(R.id.lytFragment,profileFragment);

        fragmentTransaction.commit();
    }



    private void showSearchFragment(){

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SearchFragment searchFragment = new SearchFragment();

        fragmentTransaction.replace(R.id.lytFragment,searchFragment);

        fragmentTransaction.commit();
    }

    private void showMoreFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MoreFragment moreFragment = new MoreFragment();

        fragmentTransaction.replace(R.id.lytFragment,moreFragment);

        fragmentTransaction.commit();
    }



}

