package com.ditateum.explicitintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.ditateum.explicitintentapp.model.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity : Button
    private lateinit var btnMoveActivityWithData : Button
    private lateinit var btnMoveActivityWithObject : Button
    private lateinit var btnDialNumber : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityWithObject = findViewById(R.id.btn_move_activity_object)
        btnDialNumber = findViewById(R.id.btn_dial_number)

        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityWithData.setOnClickListener(this)
        btnMoveActivityWithObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                // Pindah Activity tanpa Data dengan Intent
                val moveIntent = Intent(this, MoveActivity::class.java)
                startActivity(moveIntent)

            }
            R.id.btn_move_activity_data -> {
                // Pindah Acitivty dengan Data with Intent
                val moveWithDataIntent = Intent(this, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Dita Permata Putra")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 27)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                // Pindah Acitivty dengan Object with Intent
                val person = Person(
                    name="Dita Permata Putra",
                    age = 27,
                    city = "Blitar",
                    email = "ditateum@gmail.com"
                )

                val moveWithObjectIntent = Intent(this, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)

            }
            R.id.btn_dial_number -> {
                val phoneNumber = "081210841382"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}