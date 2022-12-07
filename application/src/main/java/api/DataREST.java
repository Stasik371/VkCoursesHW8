package api;

import com.google.inject.Inject;
import datamanagers.RequestsWithDataBase;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.apache.http.HttpHeaders.CACHE_CONTROL;

@Path("/prod")
public class DataREST {

    private RequestsWithDataBase requestsWithDataBase;

    @Inject
    public DataREST(RequestsWithDataBase requestsWithDataBase) {
        this.requestsWithDataBase = requestsWithDataBase;
    }

    @GET
    @Path("/allProducts")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllProducts() {
        return Response
                .ok(requestsWithDataBase.getAllProductsFromDateBase())
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .header("injected", "true")
                .build();
    }

    @POST
    @Path("/addProduct/{product}")
    public Response saveProduct(@PathParam("product") String product) {
        return Response
                .ok(requestsWithDataBase.saveToDataBaseFromURL(product))
                .header(CACHE_CONTROL, "no-cache")
                .header("injected", true)
                .build();
    }

    @POST
    @Path("/deleteProduct/{name}")
    public Response deleteProduct(@PathParam("name") String name) {
        boolean isDelete = requestsWithDataBase.findAndDeleteProductFromDataBase(name);
        if (isDelete) {
            return Response.ok()
                    .header(CACHE_CONTROL, "no-cache")
                    .header("injected", true)
                    .build();
        } else {
            return Response.status(404)
                    .header(CACHE_CONTROL, "no-cache")
                    .header("injected", true)
                    .build();
        }
    }

    @GET
    @Path("/ProductsWithRightOrganization/{organization}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getProductsWithRightOrganization(@PathParam("organization") String organization){
        return Response
                .ok(requestsWithDataBase.getProductsWithRightOrg(organization))
                .header(CACHE_CONTROL, "no-cache")
                .header("injected", true)
                .build();
    }
}
