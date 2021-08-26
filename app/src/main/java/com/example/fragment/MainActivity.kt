package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Pojo.Prsn_Model

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.prsn_rv)

        val adapter = Adapter_prsn()

        val lm = LinearLayoutManager(this)

        rv.layoutManager = lm

        val array_prsn = arrayListOf<Prsn_Model>()

        array_prsn.add(Prsn_Model("Mohamed","Mezenner",19))

        array_prsn.add(Prsn_Model("Monir","hmida",18))

        array_prsn.add(Prsn_Model("Jmal","boznor",20))

        array_prsn.add(Prsn_Model("Amin","hmroch",17))

        adapter.setList(array_prsn)

        rv.adapter = adapter

        val fm = supportFragmentManager

        var ft = fm.beginTransaction()

        ft.add(R.id.fr_container,prsn_fragment())


        ft.commit()

        adapter.set_listener(object :SetOnClickListener{
            override fun OnItemClick(prsn: Prsn_Model) {

                ft = fm.beginTransaction()

                val bundle = Bundle()

                val fragment = prsn_fragment()

                bundle.putString("prsn_name",prsn.name)
                bundle.putString("prsn_prnm",prsn.prnm)
                bundle.putInt("prsn_age",prsn.age)

                fragment.arguments = bundle


                ft.replace(R.id.fr_container,fragment)

                ft.commit()
            }

        })


    }
}