package com.telkomuniversity.iflab.spriflab.Activity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.telkomuniversity.iflab.spriflab.ApiUtils.APIProperties;
import com.telkomuniversity.iflab.spriflab.ApiUtils.UserService;
import com.telkomuniversity.iflab.spriflab.Model.BookingInfo;
import com.telkomuniversity.iflab.spriflab.R;

import java.util.Calendar;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormRuanganActivity extends AppCompatActivity implements View.OnClickListener{

    // item dari layout
    private EditText etNama, etNIM, etAlamat,etHP, etAlasan, etDosen, etOrganisasi;
    private EditText etDate; // not editable
    private Spinner spinnerRuangan, spinnerWaktuMulai, spinnerWaktuSelesai;
    private Button btnDate, btnSubmit;
    private ProgressBar progressBar;
    private ScrollView scrollViewForm;

    // isi spinner
    private static final String[] itemSpinnerRuangan = {"IFLAB1", "IFLAB2", "IFLAB3",
            "IFLAB4", "IFLAB5", "IKLAB1", "IKLAB2",};
    private static final String[] itemSpinnerWaktuMulai = {"--Waktu Mulai--", "18:00:00", "18:30:00", "19:00:00",
            "19:30:00", "20:00:00", "20:30:00", "21:00:00", "21:30:00", "22:00:00"};
    private static final String[] itemSpinnerWaktuSelesai = {"--Waktu Selesai--", "18:00:00", "18:30:00", "19:00:00",
            "19:30:00", "20:00:00", "20:30:00", "21:00:00", "21:30:00", "22:00:00"};

    // datepicker variabel
    private DatePickerDialog.OnDateSetListener dateListener;

    // api properties
    public static final int CODE_GET_REQUEST = 1024;
    public static final int CODE_POST_REQUEST = 1025;
    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ruangan);

        scrollViewForm = findViewById(R.id.scrollViewForm);

        setTitle("Booking Form");

        userService = APIProperties.getUserService();

        progressBar = findViewById(R.id.progressBar);

        etNama = findViewById(R.id.etNama);
        etNIM = findViewById(R.id.etNIM);
        etAlamat = findViewById(R.id.etAlamat);
        etHP = findViewById(R.id.etHP);
        etAlasan = findViewById(R.id.etAlasan);
        etDosen = findViewById(R.id.etDosen);
        etOrganisasi = findViewById(R.id.etOrganisasi);

        etDate = findViewById(R.id.etDate);

        btnDate = findViewById(R.id.btnDate);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnDate.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        spinnerRuangan = findViewById(R.id.spinnerRuangan);
        ArrayAdapter<String> arrayAdpt =  new ArrayAdapter<String>(FormRuanganActivity.this,
                android.R.layout.simple_spinner_item, itemSpinnerRuangan);
        arrayAdpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRuangan.setAdapter(arrayAdpt);
        spinnerRuangan.setSelection(0);
        spinnerRuangan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // on progress
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // on progress
            }
        });

        spinnerWaktuMulai = findViewById(R.id.spinnerWaktuMulai);
        ArrayAdapter<String> arrayAdptMulai = new ArrayAdapter<String>(FormRuanganActivity.this,
                android.R.layout.simple_spinner_item, itemSpinnerWaktuMulai);
        arrayAdptMulai.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWaktuMulai.setAdapter(arrayAdptMulai);
        spinnerWaktuMulai.setSelection(0);
        spinnerWaktuMulai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //on progress
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //on progress
            }
        });

        spinnerWaktuSelesai = findViewById(R.id.spinnerWaktuSelesai);
        ArrayAdapter<String> arrayAdptSelesai = new ArrayAdapter<String>(FormRuanganActivity.this,
                android.R.layout.simple_spinner_item, itemSpinnerWaktuSelesai);
        arrayAdptSelesai.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWaktuSelesai.setAdapter(arrayAdptSelesai);
        spinnerWaktuSelesai.setSelection(0);
        spinnerWaktuSelesai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //on progress
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //on progress
            }
        });

        dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                try {
                    month = month + 1;
                    String date = day + "-" + month + "-" + year;

                    etDate.setText(date);
                }
                catch(Exception e){
                    Toast.makeText(FormRuanganActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }
        };


    }


    @Override
    public void onClick(View view) {
        if(view == btnSubmit){
            try {
                //Toast.makeText(FormRuanganActivity.this, "Under Maintenance", Toast.LENGTH_SHORT).show();
                createBooking();

            } catch(Exception e){
                e.printStackTrace();
                Toast.makeText(FormRuanganActivity.this, "Exception detected" , Toast.LENGTH_SHORT).show();
            }
        }
        else if(view == btnDate){
            try {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(FormRuanganActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            } catch (Exception e){
                Toast.makeText(FormRuanganActivity.this, "Exception detected!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void createBooking(){
        String name = etNama.getText().toString().trim();
        String nim = etNIM.getText().toString().trim();
        String alamat = etAlamat.getText().toString().trim();
        String hp = etHP.getText().toString().trim();
        String alasan = etAlasan.getText().toString().trim();
        String dosen = etDosen.getText().toString().trim();
        String organisasi = etOrganisasi.getText().toString().trim();

        String ruang = spinnerRuangan.getSelectedItem().toString();
        String waktuMulai = spinnerWaktuMulai.getSelectedItem().toString();
        String waktuSelesai = spinnerWaktuSelesai.getSelectedItem().toString();

        String tanggal = etDate.getText().toString().trim();

        int spn1 = spinnerWaktuMulai.getSelectedItemPosition();
        int spn2 = spinnerWaktuSelesai.getSelectedItemPosition();

        if(TextUtils.isEmpty(name)){
            etNama.setError("Silahkan masukkan nama anda.");
            etNama.requestFocus();
            return;
        }
        else if(TextUtils.isEmpty(nim)){
            etNIM.setError("Silahkan masukkan NIM anda.");
            etNIM.requestFocus();
            return;
        }
        else if(TextUtils.isEmpty(alamat)){
            etAlamat.setError("Silahkan masukkan alamat anda.");
            etAlamat.requestFocus();
            return;
        }
        else if(TextUtils.isEmpty(hp)){
            etHP.setError("Silahkan masukkan Nomor HP anda.");
            etHP.requestFocus();
            return;
        }
        else if(TextUtils.isEmpty(alasan)){
            etAlasan.setError("Silahkan masukkan alasannya.");
            etAlasan.requestFocus();
            return;
        }
        else if(TextUtils.isEmpty(dosen)){
            etDosen.setError("Silahkan masukkan nama dosen penanggung jawabnya.");
            etDosen.requestFocus();
            return;
        }
        else if(TextUtils.isEmpty(organisasi)){
            etOrganisasi.setError("Silahkan masukkan nama organisasi anda.");
            etOrganisasi.requestFocus();
            return;
        }
        else if(TextUtils.isEmpty(tanggal)){
            etDate.setError("Silahkan masukkan tanggal peminjaman.");
            etDate.requestFocus();
            return;
        }
        else if(spn1 == 0){
            Toast.makeText(FormRuanganActivity.this, "Waktu Mulai harap diisi", Toast.LENGTH_SHORT).show();
            spinnerWaktuMulai.requestFocus();
        }
        else if(spn2 == 0){
            Toast.makeText(FormRuanganActivity.this, "Waktu Selesai harap diisi", Toast.LENGTH_SHORT).show();
            spinnerWaktuSelesai.requestFocus();
        }

        // tanggal start sama end nya masih fix di tanggal ini belom dirubah jadi editable
        HashMap<String, String> params = new HashMap<>();
        params.put("title", nim);
        params.put("start", "10/16/2018");
        params.put("end", "10/17/2018");
        params.put("nama", name);
        params.put("alamat", alamat);
        params.put("nohp", hp);
        params.put("image", "test.jpg");
        params.put("dosen", dosen);
        params.put("ruang", ruang);
        params.put("organisasi", organisasi);
        params.put("alasan", alasan);
        params.put("mulai", waktuMulai);
        params.put("selesai", waktuSelesai);

        addBooking(params);

    }


    private void addBooking(HashMap<String, String> booking){
        Call<BookingInfo> call = userService.addBooking(booking);
        call.enqueue(new Callback<BookingInfo>() {
            @Override
            public void onResponse(Call<BookingInfo> call, Response<BookingInfo> response) {
                Log.i("RESPONSE", response.toString());
                if(response.isSuccessful()){
                    //Toast.makeText(FormRuanganActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                    Log.i("API RESPONSE", response.body().toString());
                    Snackbar.make(scrollViewForm, "Data successfully inputted", Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BookingInfo> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
                Toast.makeText(FormRuanganActivity.this, "ERROR: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
