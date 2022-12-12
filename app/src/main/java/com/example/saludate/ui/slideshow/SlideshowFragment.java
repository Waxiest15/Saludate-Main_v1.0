package com.example.saludate.ui.slideshow;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.saludate.MainActivity;
import com.example.saludate.R;
import com.example.saludate.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final MainActivity ma = (MainActivity) getActivity();
        SharedPreferences sp = ma.getSharedPreferences("SP", ma.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        final Switch swi = (Switch) root.findViewById(R.id.switchTema);

        int theme = sp.getInt("Theme", 1);
        if (theme==1){
            swi.setChecked(false);
        }else{
            swi.setChecked(true);
        }

        swi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swi.isChecked()){
                    editor.putInt("Theme",0);
                }else{
                    editor.putInt("Theme",1);
                }
                editor.commit();
                ma.setDayNight();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}