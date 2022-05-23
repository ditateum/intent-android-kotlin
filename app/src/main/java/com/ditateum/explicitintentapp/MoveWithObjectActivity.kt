package com.ditateum.explicitintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ditateum.explicitintentapp.model.Person

class MoveWithObjectActivity : AppCompatActivity() {
    private lateinit var tvObjectReceived : TextView

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        tvObjectReceived = findViewById(R.id.tv_object_received)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person;

        val text = """
            Name: ${person.name},
            Email: ${person.email},
            Age: ${person.age},
            City: ${person.city}
        """.trimIndent()

        tvObjectReceived.text = text
    }
}