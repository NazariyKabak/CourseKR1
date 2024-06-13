//package org.example.kr1.controllers;
//
//import jakarta.inject.Inject;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//import org.example.kr1.model.Manufacturer;
//import org.example.kr1.model.Souvenir;
//import org.example.kr1.service.ManufacturerService;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Path("/manufacturers")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class ManufacturerController {
//
//    private ManufacturerService manufacturerService;
//
//    public ManufacturerController(ManufacturerService manufacturerService) {
//        this.manufacturerService = manufacturerService;
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Manufacturer> getAllManufacturers() {
//        return manufacturerService.getAllManufacturers();
//    }
//
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getManufacturerById(@PathParam("id") Long id) {
//        return manufacturerService.getManufacturerById(id)
//                .map(manufacturer -> Response.ok(manufacturer).build())
//                .orElse(Response.status(Response.Status.NOT_FOUND).build());
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response addManufacturer(Manufacturer manufacturer) {
//        manufacturerService.addManufacturer(manufacturer);
//        return Response.status(Response.Status.CREATED).entity(manufacturer).build();
//    }
//
//    @PUT
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateManufacturer(@PathParam("id") Long id, Manufacturer manufacturer) {
//        manufacturer.setId(id);
//        manufacturerService.updateManufacturer(manufacturer);
//        return Response.ok(manufacturer).build();
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response deleteManufacturer(@PathParam("id") Long id) {
//        manufacturerService.deleteManufacturer(id);
//        return Response.noContent().build();
//    }
//
//    @GET
//    @Path("/{id}/souvenirs")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Souvenir> getSouvenirsByManufacturer(@PathParam("id") Long id) {
//        return manufacturerService.getSouvenirsByManufacturer(id);
//    }
//}
//
