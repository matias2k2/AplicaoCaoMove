package ao.co.isptec.aplm.laboratorio4.bd;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
//import androidx.room.processor.Context;

import ao.co.isptec.aplm.laboratorio4.model.Trajetoria;
import ao.co.isptec.aplm.laboratorio4.bd.TrajetoriaDao;

@Database(entities = {Trajetoria.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract TrajetoriaDao trajetoriaDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "trajetoria_database"
                    )
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}