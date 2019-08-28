package com.example.room;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {
    private EditText user_name, user_email, ed_user_id;
    private Button bnUser_save;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_add_user, container, false);

       user_name = view.findViewById(R.id.ed_user_name);
       user_email = view.findViewById(R.id.ed_user_email);
       ed_user_id = view.findViewById(R.id.ed_user_id);
       bnUser_save = view.findViewById(R.id.bn_save_user);

       bnUser_save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               int userid = Integer.parseInt(ed_user_id.getText().toString());
               String userame = user_name.getText().toString();
               String useremail= user_email.getText().toString();

               User user = new User();
               user.setId(userid);
               user.setName(userame);
               user.setEmail(useremail);


               MainActivity.appDatabase.dao().addUser(user);
               Toast.makeText(getActivity(), "user added successfully",
                       Toast.LENGTH_SHORT).show();

               ed_user_id.setText("");
               user_email.setText("");
               user_name.setText("");

           }
       });
       return view;
    }

}
