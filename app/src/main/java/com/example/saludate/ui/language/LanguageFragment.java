package com.example.saludate.ui.language;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.saludate.LanguageManager;
import com.example.saludate.R;
import com.example.saludate.databinding.FragmentLanguageBinding;

public class LanguageFragment extends Fragment {

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageButton en = getActivity().findViewById(R.id.btn_selectEnglishh);
        ImageButton spa = getActivity().findViewById(R.id.btn_selectSpanishh);
        ImageButton fr = getActivity().findViewById(R.id.btn_selectFrenchh);
        ImageButton kr = getActivity().findViewById(R.id.btn_selectKoreanh);
        LanguageManager lang = new LanguageManager(this.getActivity());

        en.setOnClickListener(view -> {
            lang.updateResource("en");
            getActivity().recreate();
        });
        spa.setOnClickListener(view -> {
            lang.updateResource("es");
            getActivity().recreate();
        });
        fr.setOnClickListener(view -> {
            lang.updateResource("fr");
            getActivity().recreate();
        });
        kr.setOnClickListener(view -> {
            lang.updateResource("ko");
            getActivity().recreate();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}