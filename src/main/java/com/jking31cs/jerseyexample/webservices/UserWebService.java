package com.jking31cs.jerseyexample.webservices;

import com.jking31cs.jerseyexample.objects.User;
import com.jking31cs.jerseyexample.stores.UserStore;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by jking31cs on 10/21/15.
 */
@Path("api/users")
public class UserWebService {
    private final UserStore userStore;

    @Inject
    public UserWebService(UserStore userStore) {
        this.userStore = userStore;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userStore.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        return userStore.save(user);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User updateUser(User user) {
        return userStore.save(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User getUser(@PathParam("id") Long id) {
        return userStore.get(id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User deleteUser(@PathParam("id") Long id) {
        User user = userStore.get(id);
        return userStore.delete(user);
    }
}