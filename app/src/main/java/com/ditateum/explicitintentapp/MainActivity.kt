package com.ditateum.explicitintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ditateum.explicitintentapp.model.Person

class MainActivity : AppCompatActivity() {
    private lateinit var btnMoveActivity : Button
    private lateinit var btnMoveActivityWithData : Button
    private lateinit var btnMoveActivityWithObject : Button

    val person = Person(
        name="Dita Permata Putra",
        age = 27,
        city = "Blitar",
        email = "ditateum@gmail.com"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityWithObject = findViewById(R.id.btn_move_activity_object)

        // Pindah Activity tanpa Data dengan Intent
        btnMoveActivity.setOnClickListener {
            val moveIntent = Intent(this, MoveActivity::class.java)
            startActivity(moveIntent)
        }

        // Pindah Acitivty dengan Data with Intent
        btnMoveActivityWithData.setOnClickListener {
            val moveWithDataIntent = Intent(this, MoveWithDataActivity::class.java)
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Dita Permata Putra")
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 27)
            startActivity(moveWithDataIntent)
        }



        // Pindah Acitivty dengan Object with Intent
        btnMoveActivityWithObject.setOnClickListener {
            val moveWithObjectIntent = Intent(this, MoveWithObjectActivity::class.java)
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
            startActivity(moveWithObjectIntent)

        }
    }
}