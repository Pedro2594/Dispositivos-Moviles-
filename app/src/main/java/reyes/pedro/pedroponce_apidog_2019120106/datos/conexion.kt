package reyes.pedro.pedroponce_apidog_2019120106.datos

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


class conexion {
    private val ip = "192.168.1.12:1433";
    private val bd = "Snoop Dog";
    private val username = "sa"
    private val password = "123456"

    fun bdconexion(): Connection? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn:Connection? = null;
        val connString:String
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
            connString="jdbc:jtds:sqlserver://$ip;databaseName=$bd;user=$username;password=$password"
            conn=DriverManager.getConnection(connString)
        } catch (ex:SQLException){
            Log.e("Error:",ex.message!!)
        }
        catch (ex1:SQLException){
            Log.e("Error:",ex1.message!!)
        }
        catch (ex2:SQLException){
            Log.e("Error:",ex2.message!!)
        }
        return conn
    }
}