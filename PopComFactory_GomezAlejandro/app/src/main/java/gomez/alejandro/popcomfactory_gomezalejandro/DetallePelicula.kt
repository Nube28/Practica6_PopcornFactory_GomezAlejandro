package gomez.alejandro.popcomfactory_gomezalejandro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.detalle_pelicula)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var iv_imagen: ImageView = findViewById(R.id.iv_peliculaa) as ImageView
        var tv_titulo: TextView = findViewById(R.id.tv_tituloo) as TextView
        var tv_descripcion: TextView = findViewById(R.id.tv_descripcionn) as TextView
        var tv_seats: TextView = findViewById(R.id.seatsLeft) as TextView
        var btn_buyTicket: Button = findViewById(R.id.buyTikets) as Button


        val bundle = intent.extras
        var ns = 0

        if (bundle != null) {
            ns = bundle.getInt("numberSeats")

            iv_imagen.setImageResource(bundle.getInt("header"))
            tv_titulo.text = bundle.getString("nombre")
            tv_descripcion.text = bundle.getString("sinopsis")
            tv_seats.text = bundle.getString("$ns seats aviable")
        }

        if(ns == 0){
            btn_buyTicket.isActivated = false
        }else{
            btn_buyTicket.setOnClickListener{
                val intent: Intent = Intent(this, SeatSection::class.java)
            }
        }

    }


}