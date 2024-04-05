package reyes.pedro.pedroponce_apidog_2019120106

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import reyes.pedro.pedroponce_apidog_2019120106.model.Perros

class PerrosAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<PerrosViewHolder>() {

    private val datos= mutableListOf<Perros>()

    fun enlazarDato(datosNuevos : List<Perros>){
        datos.clear()
        datos.addAll(datosNuevos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PerrosViewHolder {
        val view = layoutInflater.inflate(R.layout.item_perros,parent,false)
        return PerrosViewHolder(view,imageLoader)
    }

    override fun onBindViewHolder(holder: PerrosViewHolder, position: Int) {
       holder.enlazarDatos(datos[position])
    }

    override fun getItemCount(): Int {
        return datos.size
    }
}