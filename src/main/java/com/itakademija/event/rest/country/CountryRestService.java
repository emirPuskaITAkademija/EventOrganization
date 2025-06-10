package com.itakademija.event.rest.country;

import com.itakademija.event.ejb.country.Country;
import com.itakademija.event.ejb.country.CountryServiceLocal;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

/**
 * ENDPOINT -> URL
 */
@Path("/country")
public class CountryRestService {

    @Inject
    private CountryServiceLocal countryService;


    @GET
    public List<Country> getAll() {
        return countryService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Country getById(@PathParam("id") Integer id) {
        return countryService.find(id);
    }

    @POST
    public Country create(Country country) {
        countryService.create(country);
        return country;
    }

    @PUT
    @Path("{id}")
    public Country update(@PathParam("id") Integer id, Country country) {
        country.setId(id);
        countryService.edit(country);
        return country;
    }

    @DELETE
    @Path("{id}")
    public Country delete(@PathParam("id") Integer id) {
        Country country = countryService.find(id);
        countryService.remove(country);
        return country;
    }
}
