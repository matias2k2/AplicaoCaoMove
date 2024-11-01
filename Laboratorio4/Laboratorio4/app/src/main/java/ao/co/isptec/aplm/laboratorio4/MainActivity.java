package ao.co.isptec.aplm.laboratorio4;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import ao.co.isptec.aplm.laboratorio4.bd.DatabaseHelper;
import ao.co.isptec.aplm.laboratorio4.model.Trajetoria;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        // Exemplo de inserção
        Trajetoria novaTrajetoria = new Trajetoria();
        novaTrajetoria.setName(123);
        novaTrajetoria.setDetails(456);
        databaseHelper.inserirTrajetoria(novaTrajetoria);

        // Exemplo de busca
        databaseHelper.buscarTrajetorias(new DatabaseHelper.DatabaseCallback<List<Trajetoria>>() {
            @Override
            public void onSuccess(List<Trajetoria> trajetorias) {
                // Aqui você pode atualizar sua UI com os dados
                for (Trajetoria t : trajetorias) {
                    Log.d("MainActivity", "Trajetoria: " + t.getName());
                }
            }
        });
    }
}
/*public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}*/