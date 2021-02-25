package jimenez.diana.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class HotActivity : AppCompatActivity() {
    var hotDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        agregaProductos()

        var listV: ListView = findViewById(R.id.listView) as ListView

        var adaptadorH: AdaptadorProductos= AdaptadorProductos(this,hotDrinks)

        listV.adapter=adaptadorH;

    }

    fun agregaProductos(){
        hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.00))
        hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.00))
        hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.00))
        hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.00))
        hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.00))
        hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.00))
    }

    private class AdaptadorProductos: BaseAdapter {
        var productos= ArrayList<Product>()
        var contexto: Context?=null

        constructor(context: Context, productos: ArrayList<Product>){
            this.productos=productos
            this.contexto=context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod=productos.get(position)
            var inflador= LayoutInflater.from(contexto)
            var vista= inflador.inflate(R.layout.producto_view,null)

            var imagen= vista.findViewById(R.id.producto_img) as ImageView
            var nombre= vista.findViewById(R.id.producto_nombre) as TextView
            var desc= vista.findViewById(R.id.producto_desc) as TextView
            var precio= vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")

            return vista
        }

        override fun getItem(position: Int): Any {
            return productos.get(position)
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return productos.size
        }


    }
}