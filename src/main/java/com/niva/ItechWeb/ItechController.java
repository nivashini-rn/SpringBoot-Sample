package com.niva.ItechWeb;

import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ItechController {
    @RequestMapping(value = "/test")
    public String test()
    {
        return "Hello world!";
    }

    @RequestMapping(value = "/test-json")
    public Map testJson(){
        Map<String, Object >map = new HashMap<>();
        map.put("id","2");
        map.put("name","Niva");
        map.put("place","Thanjavur");
        map.put("gender","female");
        map.put("education","Btech");
        return map;
    }

    @RequestMapping(value = "/niva")
    public com.niva.ItechWeb.Person getNiva()
    {
       com.niva.ItechWeb.Address address = new com.niva.ItechWeb.Address();
        address.city = "Thanjavur";
        address.state = "Tamilnadu";
        address.pincode = 614508;

        List<String> languages = new ArrayList<>();
        languages.add("ta");
        languages.add("en");
        languages.add("hi");

        com.niva.ItechWeb.Person person = new com.niva.ItechWeb.Person();
        person.id = "2";
        person.name = "Niva";
        person.address = address;
        person.gender = "female";
        person.education = "Btech";
        return person;
    }


}
