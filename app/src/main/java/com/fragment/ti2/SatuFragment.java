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

public class SatuFragment extends Fragment {
    @BindView(R.id.et_fr1_nama)
    EditText etFr1Nama;
    @BindView(R.id.et_fr1_npm)
    EditText etFr1NPM;

    //Tugasnya:
    //1. menarik data dari bundle yang dikirimkan melalui acivity sebelumnya
    //2. mengirimkan data ke fragment kedua.

    private Unbinder unbinder;

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //cara binding butter knife pada fragment
        View v =  inflater.inflate(R.layout.fragment_satu, container, false);
        unbinder = ButterKnife.bind(this, v);

        //tangkap data dari activity
        Bundle bundle = getArguments();

        if(bundle != null){
            etFr1Nama.setText(getArguments().getString("bNama"));
            etFr1NPM.setText(getArguments().getString("bNPM"));
        }

        return v;
    }

    @OnClick(R.id.bt_fr1_set) void set(){
        //kirim nilai ke fragment dua, sekaligus menampilkan fragment tersebut

        //set bundle
        Bundle bundle = new Bundle();
        bundle.putString("bNama",etFr1Nama.getText().toString());
        bundle.putString("bNPM",etFr1NPM.getText().toString());

        //tampilkan fragment dua
        DuaFragment duaFragment = new DuaFragment();
        duaFragment.setArguments(bundle);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,duaFragment).commit();
    }
}
