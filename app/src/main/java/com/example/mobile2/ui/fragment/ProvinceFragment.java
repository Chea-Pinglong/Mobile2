package com.example.mobile2.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mobile2.api.model.Province;
import com.example.mobile2.api.service.ApiService;
import com.example.mobile2.databinding.FragmentProvinceBinding;
import com.example.mobile2.ui.adapter.ProvincesAdapter;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProvinceFragment extends Fragment {
    private FragmentProvinceBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentProvinceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        load list provinces from server (api)
        loadProvinceListFromServer();
    }

    private void loadProvinceListFromServer() {

//        create retrofit client
        Retrofit httpClient = new Retrofit.Builder().
                baseUrl("https://tests3bk.s3.ap-southeast-1.amazonaws.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        create service obj
        ApiService apiService = httpClient.create(ApiService.class);

//        load province from server
        Call<List<Province>> task = apiService.loadProvinceList();
        task.enqueue(new Callback<List<Province>>() {
            @Override
            public void onResponse(Call<List<Province>> call, Response<List<Province>> response) {
                if (response.isSuccessful()) {
                    showProvinceList(response.body());
                } else {
                    Toast.makeText(getContext(), "Load province list Fail", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Province>> call, Throwable t) {
                Toast.makeText(getContext(), "Load province list Fail", Toast.LENGTH_LONG).show();
                Log.e("ProvinceFragment", "Load province fail: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void showProvinceList(List<Province> provinceList) {

//        create layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);

//        create adapter
        ProvincesAdapter adapter = new ProvincesAdapter();
        adapter.submitList(provinceList);
        binding.recyclerView.setAdapter(adapter);
    }
}
