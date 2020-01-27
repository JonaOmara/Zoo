package com.app.invitech.zoo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_tickect.view.*

class MainActivity : AppCompatActivity() {
var animalList = ArrayList<Animal>()
    var adapter:animalAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animalList.add(Animal("Baboon","Baboons live in thick forests of African",R.drawable.baboon,false))
        animalList.add(Animal("Bulldog","Bulldogs are domestic animals kept at home",R.drawable.bulldog,false))
        animalList.add(Animal("Panda","Pandas live in cold areas in the west ",R.drawable.panda,true))
        animalList.add(Animal("Swallow","Swallow birds live on trees",R.drawable.swallow_bird,false))
        animalList.add(Animal("White tiger","White tigers live in Asia",R.drawable.white_tiger,true))
        animalList.add(Animal("Zebra","Zebras live in the green savannah of African",R.drawable.zebra,false))
        adapter = animalAdapter(animalList)
        listviewticket.adapter=adapter
    }
    inner  class animalAdapter:BaseAdapter{
        var animalList =ArrayList<Animal>()
        constructor(animalList:ArrayList<Animal>):super(){
            this.animalList =animalList

        }
        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var animal = animalList[position]
            if (animal.killer==true){
                var myview = layoutInflater.inflate(R.layout.animal_ticketkiller,null)
                myview.tvName.text=animal.name
                myview.tvDes.text=animal.des
                myview.tvImage.setImageResource(animal.image!!)
                myview.setOnClickListener{
                    var intent = Intent(applicationContext,Animal_info::class.java)
                    intent.putExtra("name",animal.name)
                    intent.putExtra("des",animal.des)
                    intent.putExtra("image",animal.image!!)
                    startActivity(intent)
                }
                return myview
            }else{
            var myview = layoutInflater.inflate(R.layout.animal_tickect,null)
            myview.tvName.text=animal.name
            myview.tvDes.text=animal.des
            myview.tvImage.setImageResource(animal.image!!)
            return myview
            }
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return animalList.size
        }

    }
}
