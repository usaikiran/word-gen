package xyz.randomwords.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.randomwords.app.entites.RequestObject;
import xyz.randomwords.app.entites.ResponseObject;
import xyz.randomwords.app.serive.RandomWordGenerator;

@RestController
@RequestMapping("/generate")
@CrossOrigin("*")
public class AppController {

    @Autowired
    RandomWordGenerator randomWordGenerator;

    @PostMapping( "" )
    public ResponseEntity<ResponseObject> genertaeWord( @ModelAttribute RequestObject requestObject ){

        ResponseObject response = randomWordGenerator.generate( requestObject.getBeginningWith(), requestObject.getWordLength() );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
