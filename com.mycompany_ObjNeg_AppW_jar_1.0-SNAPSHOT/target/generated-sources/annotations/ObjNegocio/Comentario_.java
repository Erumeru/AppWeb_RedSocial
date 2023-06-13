package ObjNegocio;

import ObjNegocio.Comentario;
import ObjNegocio.Comun;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-12T11:52:46", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, String> contenido;
    public static volatile SingularAttribute<Comentario, Calendar> fechaHora;
    public static volatile SingularAttribute<Comentario, Long> id;
    public static volatile SingularAttribute<Comentario, Comentario> comentario;
    public static volatile SingularAttribute<Comentario, Comun> comun;
    public static volatile ListAttribute<Comentario, Comentario> comentarios;

}