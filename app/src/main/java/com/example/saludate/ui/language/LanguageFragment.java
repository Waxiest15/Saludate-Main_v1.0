package com.example.saludate.ui.language;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.saludate.LanguageManager;
import com.example.saludate.MainActivity;
import com.example.saludate.R;
import com.example.saludate.databinding.FragmentLanguageBinding;
import com.example.saludate.databinding.FragmentSlideshowBinding;
import com.example.saludate.ui.slideshow.SlideshowViewModel;

public class LanguageFragment extends Fragment {

    private FragmentLanguageBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LanguageViewModel slideshowViewModel =
                new ViewModelProvider(this).get(LanguageViewModel.class);

        binding = FragmentLanguageBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final MainActivity ma = (MainActivity) getActivity();
        SharedPreferences sp = ma.getSharedPreferences("SP", ma.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        final Switch swi = (Switch) root.findViewById(R.id.switchTema);

        ImageButton en = root.findViewById(R.id.btn_selectEnglishh);
        ImageButton spa = root.findViewById(R.id.btn_selectSpanishh);
        ImageButton fr = root.findViewById(R.id.btn_selectFrenchh);
        ImageButton kr = root.findViewById(R.id.btn_selectKoreanh);
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

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}