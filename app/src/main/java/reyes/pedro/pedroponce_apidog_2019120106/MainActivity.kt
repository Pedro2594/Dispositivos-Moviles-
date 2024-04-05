package reyes.pedro.pedroponce_apidog_2019120106

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import reyes.pedro.pedroponce_apidog_2019120106.model.Genero
import reyes.pedro.pedroponce_apidog_2019120106.model.Perros
import reyes.pedro.pedroponce_apidog_2019120106.model.Raza

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer:DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    private val recyclerView: RecyclerView by lazy{findViewById(R.id.rcvPerros)}
    private val adaptador: PerrosAdapter by lazy{
        PerrosAdapter(layoutInflater,GlideImageLoader(this))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar:Toolbar=findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView:NavigationView=findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)



        recyclerView.adapter = adaptador
        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL,false
        )

        adaptador.enlazarDato(
            listOf<Perros>(
                Perros(
                    Genero.Masculino,
                    Raza.BullDog,
                    "Thor",
                    "Asesino Mamado",
                    "https://cdn2.thedogapi.com/images/5hQo-doWf.jpg"

                )
            )
        )
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_item_one-> Toast.makeText(this, "Registrar Dog",Toast.LENGTH_SHORT).show()
            R.id.nav_item_two-> Toast.makeText(this, "Volver",Toast.LENGTH_SHORT).show()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onPostCreate(savedInstanceState: Bundle?){
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
