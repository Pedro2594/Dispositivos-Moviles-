package reyes.pedro.pedroponce_apidog_2019120106

import android.app.Activity.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import reyes.pedro.pedroponce_apidog_2019120106.databinding.ActivityRegistrarDogBinding
import reyes.pedro.pedroponce_apidog_2019120106.datos.conexion
import java.sql.PreparedStatement
import java.sql.SQLException

class RegistrarDog : AppCompatActivity() {
    private  lateinit var binding: ActivityRegistrarDogBinding
    private var connectsql= conexion()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarDogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnregistrar.setOnClickListener{
            agregarPerro()
            binding.edtgenero.text.clear()
            binding.edtraza.text.clear()
            binding.edtnombre.text.clear()
        }
    }
    fun agregarPerro(){
        try {
            val perro: PreparedStatement = connectsql.bdconexion()?.prepareStatement("insert into perros values (?,?,?)")!!
            perro.setString(1,binding.edtgenero.text.toString())
            perro.setString(2,binding.edtraza.text.toString())
            perro.setString(3,binding.edtnombre.text.toString())
            perro.executeUpdate();
            Toast.makeText(this,"Registrado Correctamente", Toast.LENGTH_SHORT).show()
        } catch (ex: SQLException){
            Toast.makeText(this,"No se ha podido registrar al Perro", Toast.LENGTH_SHORT).show()
        }
    }
    }
