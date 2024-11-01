package ao.co.isptec.aplm.laboratorio4.bd;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import ao.co.isptec.aplm.laboratorio4.model.Trajetoria;

public class DatabaseHelper {
    private final AppDatabase database;

    public DatabaseHelper(Context context) {
        database = AppDatabase.getInstance(context);
    }

    // Método para inserir uma trajetória
    public void inserirTrajetoria(Trajetoria trajetoria) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.trajetoriaDao().insert(trajetoria);
                return null;
            }
        }.execute();
    }

    // Método para buscar todas as trajetórias
    public void buscarTrajetorias(DatabaseCallback<List<Trajetoria>> callback) {
        new AsyncTask<Void, Void, List<Trajetoria>>() {
            @Override
            protected List<Trajetoria> doInBackground(Void... voids) {
                return database.trajetoriaDao().getAllTrajetorias();
            }

            @Override
            protected void onPostExecute(List<Trajetoria> trajetorias) {
                callback.onSuccess(trajetorias);
            }
        }.execute();
    }

    // Interface para callback
    public interface DatabaseCallback<T> {
        void onSuccess(T result);
    }
}
