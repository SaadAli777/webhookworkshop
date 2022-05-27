package com.example.Swagger;


import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
@Api(value = "Api For Locks")
public class AddressBookResource {
    ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap();

    @GetMapping("/get-contact/{id}")
    @ApiOperation(value = "Get Contact", notes = "This Api is used to Get specific Contact Using Contact Id", response = Contact.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message = "Successful"),
            @ApiResponse(code=404,message = "Bad Request")
    })
    public Contact getContact(@ApiParam(value = "You have to provide all fields to add contact", required = true) @PathVariable String id){
        return contacts.get(id);
    }

    @GetMapping("/get-all-contact")
    public List<Contact> getAllContacts(){
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/add-contact")
    @ApiOperation(value = "Add Contact", notes = "This Api is used to Add new Contact", response = Contact.class)
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(),contact);
        return contact;
    }
}
