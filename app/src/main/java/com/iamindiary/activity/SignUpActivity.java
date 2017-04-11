package com.iamindiary.activity;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.iamindiary.R;
import com.iamindiary.utils.CustomEditTextRegular;
import com.iamindiary.utils.ProjectUtils;
import com.kyleduo.switchbutton.SwitchButton;

/**
 * Created by Amit on 11-04-2017.
 */

public class SignUpActivity extends Activity implements View.OnClickListener
{
    private TextInputLayout textinput_username, textinput_firstname,
            textinput_lastname, textinput_email, textinput_password;
    private CustomEditTextRegular edittext_username, edittext_firstname, edittext_lastname, edittext_email,
            edittext_password;
    private ImageView backIV;
    private TextView textview_signup;
    private SwitchButton switch_privateprofile;
    private ColorStateList colorStateList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_signup);

        initView();
    }
    public void initView() {

        backIV = (ImageView) findViewById(R.id.icon_backIV);
        backIV.setOnClickListener(this);
        textinput_username = (TextInputLayout) findViewById(R.id.textinput_username);
        textinput_firstname = (TextInputLayout) findViewById(R.id.textinput_firstname);
        textinput_lastname = (TextInputLayout) findViewById(R.id.textinput_lastname);
        textinput_email = (TextInputLayout) findViewById(R.id.textinput_email);
        textinput_password = (TextInputLayout) findViewById(R.id.textinput_password);

        edittext_username = (CustomEditTextRegular) findViewById(R.id.edittext_username);
        edittext_firstname = (CustomEditTextRegular) findViewById(R.id.edittext_firstname);
        edittext_lastname = (CustomEditTextRegular) findViewById(R.id.edittext_lastname);
        edittext_email = (CustomEditTextRegular) findViewById(R.id.edittext_email);
        edittext_password = (CustomEditTextRegular) findViewById(R.id.edittext_password);

        switch_privateprofile = (SwitchButton) findViewById(R.id.switch_privateprofile);
        switch_privateprofile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                }

            }
        });

        textview_signup = (TextView) findViewById(R.id.textview_signup);
        textview_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.textview_signup:
                submitForm();
                break;
        }

    }
    public void submitForm() {
        if (!validateFirstName()) {

            return;
        } else if (!validateLastName()) {

            return;
        } else if (!validateEmail()) {
            return;
        } else if (!validateUserName()) {
            return;
        } else if (!validatePassword()) {
            return;
        }
    }
    private boolean validatePassword() {
        if (!ProjectUtils.isPasswordValid(edittext_password.getText().toString().trim())) {
            textinput_password.setError(getString(R.string.password_validation));
            edittext_password.requestFocus();
            return false;
        } else {
            textinput_password.setErrorEnabled(false);
        }

        return true;
    }

    public boolean validateEmail() {
        if (!ProjectUtils.isEmailValid(edittext_email.getText().toString().trim())) {
            textinput_email.setError(getString(R.string.email_validation));
            edittext_email.requestFocus();
            return false;
        } else {
            textinput_email.setErrorEnabled(false);
            return true;
        }
    }

    public boolean validateFirstName() {
        if (edittext_firstname.getText().toString().trim().length() <= 0) {
            textinput_firstname.setError(getString(R.string.first_name_validation));
            edittext_firstname.requestFocus();
            return false;
        } else {
            textinput_firstname.setErrorEnabled(false);
            return true;
        }
    }

    public boolean validateLastName() {
        if (edittext_lastname.getText().toString().trim().length() <= 0) {
            textinput_lastname.setError(getString(R.string.last_name_validation));
            edittext_lastname.requestFocus();
            return false;
        } else {
            textinput_lastname.setErrorEnabled(false);
            return true;
        }
    }

    public boolean validateUserName() {
        if (edittext_username.getText().toString().trim().length() <=0) {
            textinput_username.setError(getString(R.string.phone_validation));
            edittext_username.requestFocus();
            return false;
        } else {
            textinput_username.setErrorEnabled(false);
            return true;
        }
    }

}
