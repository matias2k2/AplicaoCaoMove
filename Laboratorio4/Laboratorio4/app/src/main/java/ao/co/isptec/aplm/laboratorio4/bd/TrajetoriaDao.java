package ao.co.isptec.aplm.laboratorio4.bd;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

import ao.co.isptec.aplm.laboratorio4.model.Trajetoria;

@Dao
public interface TrajetoriaDao {
    @Insert
    void insert(Trajetoria trajetoria);

    @Update
    void update(Trajetoria trajetoria);

    @Delete
    void delete(Trajetoria trajetoria);

    @Query("SELECT * FROM trajetoria")
    List<Trajetoria> getAllTrajetorias();

    @Query("SELECT * FROM trajetoria WHERE id = :id")
    Trajetoria getTrajetoriaById(int id);
}
