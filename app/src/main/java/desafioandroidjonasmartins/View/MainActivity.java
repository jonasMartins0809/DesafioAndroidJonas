package desafioandroidjonasmartins.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.desafioandroidjonasmartins.R;

import java.util.ArrayList;
import java.util.List;

import br.digitalhouse.desafioandroidlucaspereira.Adapter.RestauranteAdapter;
import br.digitalhouse.desafioandroidlucaspereira.Interface.OnclickRecyclerRes;
import br.digitalhouse.desafioandroidlucaspereira.Model.Prato;
import br.digitalhouse.desafioandroidlucaspereira.Model.Restaurante;
import br.digitalhouse.desafioandroidlucaspereira.R;
import desafioandroidjonasmartins.Adapter.RestauranteAdapter;
import desafioandroidjonasmartins.Model.Prato;
import desafioandroidjonasmartins.Model.Restaurante;

public class MainActivity extends AppCompatActivity implements OnclickRecyclerRes {
    private RecyclerView recycler;
    private RestauranteAdapter adaptador;
    private List<Restaurante> listarestaurantes = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recicladorRestaurante);
        adaptador = new RestauranteAdapter(retornarListaRestaurantes(), this);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(this));

    }


    public List<Restaurante> retornarListaRestaurantes(){

        List<Prato> pratoRestaurante = new ArrayList<>();
        pratoRestaurante.add(new Prato("Massa", "Boa pra xuxu", R.drawable.calzone));
        listarestaurantes.add(new Restaurante("Bar do Zé", "Fecha as 20h" + "\t" + " (Exceto feriados) ", "Rua Canto da volta 123", R.drawable.restaurante, prato));
        listarestaurantes.add(new Restaurante("Churrascaria dos irmãos ", "Fecha as 18h", "Rua da ferradura 342", R.drawable.restaurante1, pratoRestaurante));
        listarestaurantes.add(new Restaurante("Casa do Gorila", "Fecha as 19h", "Av faria lima  222", R.drawable.restaurante2, pratoRestaurante));
        listarestaurantes.add(new Restaurante("Outback" , "Fecha as 00h", "Avenida Arruda 232", R.drawable.restaurante3, pratoRestaurante));



        return listarestaurantes;
    }


    @Override
    public void clicarRestautante(Restaurante restaurante) {
        Intent intent = new Intent(MainActivity.this, ListaPratoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESTAURANTE", restaurante);
        intent.putExtras(bundle);
        startActivity(intent);


    }
}
