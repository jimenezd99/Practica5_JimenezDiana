package jimenez.diana.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnCold: Button=findViewById(R.id.btn_cold_drinks) as Button
        var btnHot: Button=findViewById(R.id.btn_hot_drinks) as Button
        var btnSweet: Button=findViewById(R.id.btn_sweets) as Button
        var btnSalty: Button=findViewById(R.id.btn_salties) as Button

        btnCold.setOnClickListener(){
            var intent: Intent= Intent(this, ProductosActivity::class.java)
            startActivity(intent)
        }

        btnHot.setOnClickListener(){
            var intent: Intent= Intent(this, HotActivity::class.java)
            startActivity(intent)
        }

        btnSweet.setOnClickListener(){
            var intent: Intent= Intent(this, SweetActivity::class.java)
            startActivity(intent)
        }

        btnSalty.setOnClickListener(){
            var intent: Intent= Intent(this, SaltyActivity::class.java)
            startActivity(intent)
        }




    }
}