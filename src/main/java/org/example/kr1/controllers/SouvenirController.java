//package org.example.kr1.controllers;
//
//import jakarta.inject.Inject;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//import org.example.kr1.model.Souvenir;
//import org.example.kr1.service.SouvenirService;
//
//import java.util.List;
//
//@Path("/souvenirs")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class SouvenirController {
//    private SouvenirService souvenirService;
//
//    public SouvenirController(SouvenirService souvenirService) {
//        this.souvenirService = souvenirService;
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Souvenir> getAllSouvenirs() {
//        return souvenirService.getAllSouvenirs();
//    }
//
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getSouvenirById(@PathParam("id") Long id) {
//        return souvenirService.getSouvenirById(id)
//                .map(souvenir -> Response.ok(souvenir).build())
//                .orElse(Response.status(Response.Status.NOT_FOUND).build());
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response addSouvenir(Souvenir souvenir) {
//        souvenirService.addSouvenir(souvenir);
//        return Response.status(Response.Status.CREATED).entity(souvenir).build();
//    }
//
//    @PUT
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateSouvenir(@PathParam("id") Long id, Souvenir souvenir) {
//        souvenir.setId(id);
//        souvenirService.updateSouvenir(souvenir);
//        return Response.ok(souvenir).build();
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response deleteSouvenir(@PathParam("id") Long id) {
//        souvenirService.deleteSouvenir(id);
//        return Response.noContent().build();
//    }
//}
