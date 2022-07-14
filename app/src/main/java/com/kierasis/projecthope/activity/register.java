package com.kierasis.projecthope.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kierasis.projecthope.EndPoints;
import com.kierasis.projecthope.R;
import com.kierasis.projecthope.my_singleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {
    FloatingActionButton back;

    TextInputEditText username, fname, lname, password;
    TextInputLayout til_username, til_fname, til_lname,  til_password;
    Button btn_signup;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z-.]+\\.+[a-z]+";

    public SharedPreferences device_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        device_info = getSharedPreferences("device-info", MODE_PRIVATE);

        back = findViewById(R.id.signup_back);
        username = findViewById(R.id.signup_tie_username);
        fname = findViewById(R.id.signup_tie_firstname);
        lname = findViewById(R.id.signup_tie_lastname);
        password = findViewById(R.id.signup_tie_password);

        til_username = findViewById(R.id.signup_til_username);
        til_fname = findViewById(R.id.signup_til_firstname);
        til_lname = findViewById(R.id.signup_til_lastname);
        til_password = findViewById(R.id.signup_til_password);

        btn_signup = findViewById(R.id.signup_button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        username.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                til_username.setErrorEnabled(false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        fname.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                til_fname.setErrorEnabled(false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        lname.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                til_lname.setErrorEnabled(false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        password.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                til_password.setErrorEnabled(false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int error = 0;
                String txt_username = username.getText().toString();
                String txt_fname = fname.getText().toString();
                String txt_lname = lname.getText().toString();
                String txt_password = password.getText().toString();

                if (TextUtils.isEmpty(txt_username)){
                    til_username.setError("You need to enter a srcode");
                    error += 1;
                }else if(txt_username.length()<8){
                    til_username.setError("Username is too short");
                    error += 1;
                }
                if (TextUtils.isEmpty(txt_fname)){
                    til_fname.setError("You need to enter a firstname");
                    error += 1;
                }
                if (TextUtils.isEmpty(txt_lname)){
                    til_lname.setError("You need to enter a lastname");
                    error += 1;
                }
                if  (TextUtils.isEmpty(txt_password)){
                    til_password.setError("You need to enter a password");
                    error += 1;
                }else if(txt_password.length()<6){
                    til_password.setError("Choose more secured password.");
                    error += 1;
                }
                if(error==0){
                    signingup(txt_username,txt_fname,txt_lname,txt_password);
                    hideKeybaord();
                }
            }
        });
    }

    private void signingup(String txt_username, String txt_fname, String txt_lname, String txt_password) {

        final ProgressDialog progressDialog = new ProgressDialog(register.this, R.style.default_dialog);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Signing Up");
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, EndPoints.REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("tag", "Response: "+response);
                JSONObject jsonObject = null;
                Boolean success;

                try {
                    progressDialog.dismiss();
                    jsonObject = new JSONObject(response.toString());
                    success = jsonObject.getBoolean("success");
                    if(success) {
                        Toast.makeText(register.this, "Sign Up Success", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }else{
                        if (jsonObject.has("username")) {
                            til_username.setError(jsonObject.getString("username"));
                        }
                        if (jsonObject.has("fname")) {
                            til_fname.setError(jsonObject.getString("fname"));
                        }
                        if (jsonObject.has("lname")) {
                            til_lname.setError(jsonObject.getString("lname"));
                        }
                        if (jsonObject.has("password")) {
                            til_password.setError(jsonObject.getString("password"));
                        }
                        if(jsonObject.has("error_desc")){
                            if(!jsonObject.getString("error_desc").equals("other_error")) {
                                Toast.makeText(register.this, jsonObject.getString("error_desc"), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                    Toast.makeText(register.this, "signingup: JSON Error", Toast.LENGTH_SHORT).show();
                    Log.d("tag", "onErrorResponse: " + response);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(register.this, "No Connection", Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String > param = new  HashMap<>();
                param.put("username", txt_username);
                param.put("fname", txt_fname);
                param.put("lname", txt_lname);
                param.put("password", txt_password);
                param.put("device_id", device_info.getString("device_id",""));
                return param;
            }

        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        my_singleton.getInstance(register.this).addToRequestQueue(request);

    }

    private void hideKeybaord() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager manager  = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}