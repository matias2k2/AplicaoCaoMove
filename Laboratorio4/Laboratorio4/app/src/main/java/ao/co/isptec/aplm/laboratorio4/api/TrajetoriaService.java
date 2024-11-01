package ao.co.isptec.aplm.laboratorio4.api;

import java.util.List;
import ao.co.isptec.aplm.laboratorio4.model.Trajetoria;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TrajetoriaService {
    @GET("api/trajetorias")
    Call<List<Trajetoria>> getAllTrajetorias();

    @GET("api/trajetorias/{id}")
    default Call<Trajetoria> getTrajetoriaById(int i) {
        return getTrajetoriaById(0);
    }

    /*@GET("api/trajetorias/{id}")
    Call<Trajetoria> getTrajetoriaById(@Path("id") int id);*/
}
