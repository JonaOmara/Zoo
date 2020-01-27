package com.app.invitech.zoo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*

class Animal_info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)
        val bundle:Bundle =intent.extras
       val name =  bundle.getString("name")
        val des = bundle.getString("des")
        val image =bundle.getInt("image")
        txdes.text=des
        txname.text=name
        ivImage.setImageResource(image)

    }
}
