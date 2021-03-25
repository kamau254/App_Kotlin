package com.example.nyumba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*
import kotlinx.android.synthetic.main.user_registration.email
import kotlinx.android.synthetic.main.user_registration.password_register



class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth - FirebaseAuth.getInstance()



    override fun onStart() {
            super.onStart()
            // Check if user is signed in (non-null) and update UI accordingly.
            val currentUser = auth.currentUser
            if(currentUser != null){
                reload()
            }
        }


    fun showRegistration(){
        registration_layout.visibility= View.VISIBLE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.GONE
    }

   fun showLogIN(){
        registration_layout.visibility= View.GONE
        login_layout.visibility=View.VISIBLE
        home_ll.visibility=View.GONE
    }

    fun showHome(){
        registration_layout.visibility= View.GONE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.VISIBLE
    }
}