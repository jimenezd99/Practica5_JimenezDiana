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

class SweetActivity : AppCompatActivity() {
    var sweets = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        agregaProductos()

        var listV: ListView = findViewById(R.id.listView) as ListView

        var adaptadorSW: AdaptadorProductos= AdaptadorProductos(this,sweets)

        listV.adapter=adaptadorSW;

    }

    fun agregaProductos(){
        sweets.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.00))
        sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.00))
        sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.00))
        sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.00))
        sweets.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.00))
        sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.00))

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