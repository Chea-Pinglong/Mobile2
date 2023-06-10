package com.example.mobile2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mobile2.databinding.FragmentProvinceBinding;

public class ProvinceFragment extends Fragment {
    private FragmentProvinceBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentProvinceBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
