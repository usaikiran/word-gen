package xyz.randomwords.app.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Generate random words of specified length and beginning keyword if provided otherwise random values are considered",
            response = ResponseObject.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully generated word"),
            @ApiResponse(code = 401, message = "You are not authorized to use the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @PostMapping("")
    public ResponseEntity<ResponseObject> genertaeWord(@ModelAttribute RequestObject requestObject) {

        ResponseObject response = randomWordGenerator.generate(requestObject.getBeginningWith(), requestObject.getWordLength());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
