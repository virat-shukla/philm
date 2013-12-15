package app.philm.in.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.philm.in.R;
import app.philm.in.controllers.UserController;

public class LoginFragment extends Fragment implements UserController.UserUi {

    private UserController.UserUiCallbacks mCallbacks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((UserController.UserControllerProvider) getActivity()).getUserController().attachUi(this);
    }

    @Override
    public void onPause() {
        ((UserController.UserControllerProvider) getActivity()).getUserController().detachUi(this);
        super.onPause();
    }

    @Override
    public void setCallbacks(UserController.UserUiCallbacks callbacks) {
        mCallbacks = callbacks;
    }
}