package reyes.pedro.pedroponce_apidog_2019120106


import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import reyes.pedro.pedroponce_apidog_2019120106.datos.conexion
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registrar_dog.*
import kotlinx.android.synthetic.main.logging.*
import java.sql.*



class Logging: AppCompatActivity() {

    private var connectsql = conexion()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logging)

        btnComenzar.setOnClickListener {
            BuscarUsuario(txtNombre.text.toString(), txtContraseña.text.toString())
        }
        btnRegistrarPerro.setOnClickListener() {
            Registrar()
        }

    }

    private fun Iniciar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun Registrar() {
        val intent = Intent(this, RegistrarDog::class.java)
        startActivity(intent)
    }

    fun BuscarUsuario(usuarioP: String, contraseña: String) {
        try {
            val sql = "SELECT nombre,correo FROM usuario WHERE nombre = '$usuarioP' and  password = '$contraseña'"
            val usuario: Statement = connectsql.bdconexion()?.createStatement()!!
            val rs: ResultSet = usuario.executeQuery(sql)
            if (rs.next()) {
                Toast.makeText(this, "Bienvenido (a)", Toast.LENGTH_SHORT).show()
                Iniciar()
                txtNombre.text = null
                txtContraseña.text = null
            } else {
                Toast.makeText(this, "Error de Autenticacion", Toast.LENGTH_SHORT).show()

            }
            rs.close()
        } catch (e: SQLException) {
            throw SQLException(e.message)
        }
    }

}






