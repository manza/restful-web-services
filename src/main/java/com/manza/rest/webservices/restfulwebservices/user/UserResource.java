package com.manza.rest.webservices.restfulwebservices.user;

import com.manza.rest.webservices.restfulwebservices.user.exception.UserInvalidException;
import com.manza.rest.webservices.restfulwebservices.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> findAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{userId}")
    public Resource<User> findOneUser(@PathVariable int userId) {
        User user = userDaoService.findOne(userId);

        if (user == null) {
            throw new UserNotFoundException("id-" + userId);
        }

        // HATEOAS
        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder allUsersLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAllUsers());
        resource.add(allUsersLink.withRel("all-users"));

        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        if ((user.getName().equals("")) || (user.getBirthDate() == null)) {
            throw new UserInvalidException("User name or Birth Date is invalid");
        }

        User savedUser = userDaoService.save(user);

        // Return the URI of new created User
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        User user = userDaoService.deleteUser(userId);

        if (user == null)
            throw new UserNotFoundException("id - " + userId);
    }
}
