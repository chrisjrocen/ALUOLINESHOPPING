package com.example.aluolineshopping

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.shopping_ticket.view.*

class MainActivity : AppCompatActivity() {

    var adapter:ShoppingAdapter?=null
    var listOfshopping =ArrayList<shopping>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loads shopping
        listOfshopping.add(shopping("Smart watch","Smart watch Series 3 (GPS,42mm) with Black Band. Price is 50,000/=",R.drawable.smartwatch))
        listOfshopping.add(shopping("WinovoPhone","Android 9.0 Tablet 8 inch WiFi PC Winovo T8 MTK MT81632GB 32GB ROM HD ISP 1280*800 2.0MP + 5.0MP Camera Dual Band WiFi Bluetooth GPPS FM, Price 10 Million only",R.drawable.winovophone))
        listOfshopping.add(shopping("Charger","iphone charger yungsong 3Pack 6FT  Nylon Braided lighting Cable charging cord USB Cable Compatible with iphone 11Pro Max XS XR * 87656 plus SE5S 5C 5ipad.  price 100,000/= ",R.drawable.charger))
        listOfshopping.add(shopping("Bags","Strong long lasting bags with 5 wheels at the bottom. Handler to ease pulling. Price vary by the sizes; Small 120,000/=,medium 180,000/=, and large 210,000/=",R.drawable.bags))
        listOfshopping.add(shopping("Drone","Holy stone HS700D FPV Drone with 2K FHD Camera Live Video and GPS Return Home, 5G WiFi Transfer Advanced Selfie.  price 9 Million only",R.drawable.drone))
        listOfshopping.add(shopping("Flash","This is durable and shining storage device.Price 25,000/=",R.drawable.flash))
        listOfshopping.add(shopping("Headphone","Bose sound link headphone Around Ear Wireless_connection. Price 40,000/=",R.drawable.headphone))
        listOfshopping.add(shopping("Make_costimetics","MAKE is soft focus powder foundation. Price 90,000/=",R.drawable.makecostimetics))

        adapter= ShoppingAdapter(this,listOfshopping )
        gv.adapter=adapter
    }

    class ShoppingAdapter:BaseAdapter {
        var listOfshopping= ArrayList<shopping>()
        var context:Context?=null
        constructor(context: Context,listOfshopping:ArrayList<shopping>):super(){
            this.context=context
            this.listOfshopping=listOfshopping
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val shopping=this.listOfshopping[position]
            var inflater =context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var shoppingView=inflater.inflate(R.layout.shopping_ticket,null)


            shoppingView.iv_image.setImageResource(shopping.image!!)


            shoppingView.iv_image.setOnClickListener {
                val intent = Intent(context,Product_Details::class.java)
                   intent.putExtra("name",shopping.name!!)
                   intent.putExtra("des",shopping.des!!)
                   intent.putExtra("image",shopping.image!!)
                context!!.startActivity(intent)
            }
            shoppingView.tv_name.text=shopping.name!!
            return shoppingView
        }

        override fun getItem(position: Int): Any {
           return listOfshopping [position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()

        }

        override fun getCount(): Int {
             return  listOfshopping.size
        }

    }
}
