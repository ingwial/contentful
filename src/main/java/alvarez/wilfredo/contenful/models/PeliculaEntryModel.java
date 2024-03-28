package alvarez.wilfredo.contenful.models;

import com.contentful.java.cda.TransformQuery;

@TransformQuery.ContentfulEntryModel("acceso")
public class PeliculaEntryModel {
    @TransformQuery.ContentfulSystemField("id")
    private String id;
    @TransformQuery.ContentfulField
    private String titulo;
    @TransformQuery.ContentfulField("titulo_original")
    private String tituloOriginal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }
}
