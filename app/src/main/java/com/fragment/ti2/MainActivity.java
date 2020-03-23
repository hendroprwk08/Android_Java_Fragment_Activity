package com.fragment.ti2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.et_nama)
    EditText etNama;
    @BindView(R.id.et_npm)
    EditText etNPM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_set) void Set(){
        //suatu class yang berfungsi menampung data, untuk dikirimkan pada
        //fragment atau activity lain
        Bundle bundle= new Bundle();
        bundle.putString("bNama", etNama.getText().toString());
        bundle.putString("bNPM", etNPM.getText().toString());

        SatuFragment satuFragment = new SatuFragment();
        satuFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,satuFragment).commit();
    }
}
