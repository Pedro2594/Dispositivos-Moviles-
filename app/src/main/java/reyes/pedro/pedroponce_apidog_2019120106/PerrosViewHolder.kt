package reyes.pedro.pedroponce_apidog_2019120106

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import reyes.pedro.pedroponce_apidog_2019120106.model.Genero
import reyes.pedro.pedroponce_apidog_2019120106.model.Perros
import reyes.pedro.pedroponce_apidog_2019120106.model.Raza

private val SIMB_FEM by lazy {
    HtmlCompat.fromHtml("&#9793;",HtmlCompat.FROM_HTML_MODE_LEGACY)
}

private val SIMB_MAS by lazy {
    HtmlCompat.fromHtml("&#9794;",HtmlCompat.FROM_HTML_MODE_LEGACY)
}

private const val SIMB_DESC = "?"

class PerrosViewHolder(itemView: View,
                       private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(itemView) {
    private val txtBiog : TextView by lazy { itemView.findViewById(R.id.txtBiog)}
    private val txtNombre:  TextView by lazy { itemView.findViewById(R.id.txtNombre)}
    private val txtGenero:  TextView by lazy { itemView.findViewById(R.id.txtGenero)}
    private val txtRaza:  TextView by lazy { itemView.findViewById(R.id.txtRaza)}
    private val imvFoto: ImageView by lazy { itemView.findViewById(R.id.imvPerros)}

    fun enlazarDatos(datos: Perros){
        imageLoader.loadImage(datos.urlImage, imvFoto)
        txtNombre.text = datos.nombre
        txtBiog.text = datos.biografia
        txtRaza.text = when(datos.raza){
            Raza.BullDog->"Bulldog"
            Raza.Chihuahua->"Chihuahua"
            Raza.PastorAleman->"Pastor Aleman"
            Raza.Salchicha->"Salchicha"
        }

        txtGenero.text = when(datos.genero){
            Genero.Femenino-> SIMB_FEM
            Genero.Masculino-> SIMB_MAS
            Genero.Desconocido -> SIMB_DESC
        }
    }

}