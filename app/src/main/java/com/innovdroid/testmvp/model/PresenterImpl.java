package com.innovdroid.testmvp.model;

import android.text.TextUtils;

import com.innovdroid.testmvp.presenter.LoginPresenter;
import com.innovdroid.testmvp.view.LoginView;

/**
 * Created by mahmo on 4/23/2018.
 */

public class PresenterImpl implements LoginPresenter {

    LoginView mLoginView;

    public PresenterImpl(LoginView loginView) {
        this.mLoginView = loginView;
    }

    @Override
    public void performLogin(String email, String password) {

        if (TextUtils.isEmpty(email)|| TextUtils.isEmpty(password)){

            mLoginView.loginValidations();
        }
        else {

            if(email.equals("mahmoud") &&password.equals("8t8")){


                mLoginView.loginSuccess();
            }
            else {

                mLoginView.loginError();
            }
        }
    }
}
