package com.allianz.example.controller;

import com.allianz.example.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("example")
public class ExampleController {


    //endpoint->son nokta-bitis noktası

    //localhost:8080/example


    @GetMapping("hello-world")
    public ResponseEntity<String> helloWorldApi() {


        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }


    @GetMapping("person")
    public ResponseEntity<Person> personApi() {

        Person person = new Person();
        person.setName("Furkan");
        person.setSurname("Yalçındağ");
        person.setBirthYear(1992);
        person.setTc("kosdkshdjks");

        return new ResponseEntity<>(person, HttpStatus.OK);
    }


    //pathVariable localhost:8080/person/12


    @GetMapping("person/{personId}")
    public ResponseEntity<Person> personGetByPersonIdApi(@PathVariable int personId) {
        Person person = new Person();
        if (personId == 1) {
            person.setName("Furkan");
            person.setSurname("Yalçındağ");
            person.setBirthYear(1992);
            person.setTc("kosdkshdjks");
        } else {
            person.setName("Gizem");
            person.setSurname("Kısa");
            person.setBirthYear(1992);
            person.setTc("jkfdkjghjkdfhgd");
        }


        return new ResponseEntity<>(person, HttpStatus.OK);
    }


    @GetMapping("person-list")
    public ResponseEntity<List<Person>> getPersonList() {

        List<Person> list = new ArrayList<>();

        Person person = new Person();
        person.setName("Furkan");
        person.setSurname("Yalçındağ");
        person.setBirthYear(1992);
        person.setTc("kosdkshdjks");

        list.add(person);

        Person person2 = new Person();
        person2.setName("Gizem");
        person2.setSurname("Kısa");
        person2.setBirthYear(1992);
        person2.setTc("jkfdkjghjkdfhgd");

        list.add(person2);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("person-by-request-param")
    public ResponseEntity<Person> personGetByPersonIdRequestParamApi(@RequestParam int personId, @RequestParam String tc) {

        System.out.println(tc);
        Person person = new Person();
        if (personId == 1) {
            person.setName("Furkan");
            person.setSurname("Yalçındağ");
            person.setBirthYear(1992);
            person.setTc("kosdkshdjks");
        } else {
            person.setName("Gizem");
            person.setSurname("Kısa");
            person.setBirthYear(1992);
            person.setTc("jkfdkjghjkdfhgd");
        }


        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {


        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }


    @PutMapping("person/{tc}")
    public ResponseEntity<Person> createPerson(@RequestBody Person person, @PathVariable String tc) {

        List<Person> personList = new ArrayList<>();

        Person personExist = new Person();

        UUID uuid = UUID.randomUUID();

        personExist.setTc("99999999999");
        personExist.setName("Furkan");
        personExist.setSurname("Yalçındağ");
        personExist.setBirthYear(1992);
        personExist.setUuid(uuid);
        personList.add(personExist);


        for (Person p : personList) {
            if (p.getTc().equals(tc)) {
                p.setTc(person.getTc());
                p.setName(person.getName());
                p.setBirthYear(person.getBirthYear());
                p.setSurname(person.getSurname());
                return new ResponseEntity<>(p, HttpStatus.OK);
            }

        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }




    @DeleteMapping("person/{tc}")
    public ResponseEntity<Person> deletePerson(@PathVariable String tc) {

        List<Person> personList = new ArrayList<>();

        Person personExist = new Person();

        UUID uuid = UUID.randomUUID();

        personExist.setTc("99999999999");
        personExist.setName("Furkan");
        personExist.setSurname("Yalçındağ");
        personExist.setBirthYear(1992);
        personExist.setUuid(uuid);
        personList.add(personExist);


        for (Person p : personList) {
            if (p.getTc().equals(tc)) {
               personList.remove(p);
               return new ResponseEntity<>(p, HttpStatus.OK);
            }

        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
