package alvarez.wilfredo.contenful.deliveries;

import com.contentful.java.cda.CDAArray;
import com.contentful.java.cda.CDAClient;
import com.contentful.java.cda.CDAEntry;
import alvarez.wilfredo.contenful.config.ContentConfig;
import alvarez.wilfredo.contenful.models.PeliculaEntryModel;
import org.springframework.stereotype.Service;

@Service
public class ContenfulDelivery {
    private final CDAClient cliente;

    public ContenfulDelivery(ContentConfig config) {
        this.cliente = CDAClient
                .builder()
                .setToken(config.getToken()) // required
                .setSpace(config.getSpace()) // required
                .setEnvironment(config.getEnvironment()) // optional, defaults to `master`
                .build();
    }

    public CDAArray all() {
        return this.cliente
                .fetch(CDAEntry.class)
                .all();
    }

    public PeliculaEntryModel one(String id) {
        return this.cliente
                .observeAndTransform(PeliculaEntryModel.class)
                .one(id)
                .blockingFirst();
    }
}
