package api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Path("/")
public class InfoREST {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public InputStream getHelper() {
        return InfoREST.class.getResourceAsStream("/static/helper.html");
    }
}
