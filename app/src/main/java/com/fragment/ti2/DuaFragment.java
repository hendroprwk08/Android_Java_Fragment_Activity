package com.fragment.ti2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DuaFragment extends Fragment {
    @BindView(R.id.et_fr2_nama)
    EditText etFr2Nama;
    @BindView(R.id.et_fr2_npm)
    EditText etFr2NPM;

    private Unbinder unbinder;

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //cara binding butter knife pada fragment
        View v =  inflater.inflate(R.layout.fragment_dua, container, false);
        unbinder = ButterKnife.bind(this, v);

        //tangkap data dari activity
        Bundle bundle = getArguments();

        if(bundle != null){
            etFr2Nama.setText(getArguments().getString("bNama"));
            etFr2NPM.setText(getArguments().getString("bNPM"));
        }

        return v;
    }

    @OnClick(R.id.bt_fr2_set) void set(){
        MainActivity mainActivity=(MainActivity)getActivity();
        mainActivity.etNama.setText(etFr2Nama.getText().toString());
        mainActivity.etNPM.setText(etFr2NPM.getText().toString());
    }
}
