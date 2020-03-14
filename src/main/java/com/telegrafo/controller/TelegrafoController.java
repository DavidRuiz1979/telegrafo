package com.telegrafo.controller;

import com.telegrafo.model.ErrorResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.telegrafo.service.TelegrafoService;
import com.telegrafo.wrapper.ResponseWrapper;

import java.util.List;

@RestController
@RequestMapping("/telegrafo")
public class TelegrafoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TelegrafoController.class);

    @Autowired
    private TelegrafoService telegrafoService;


    @ApiOperation(value = "Transformacion de Código Morse a Lenguaje humano", response = ResponseWrapper.class)
    @ApiResponses( value = {
            @ApiResponse(code = 400, message = "Bad request" , response= ResponseWrapper.class),
            @ApiResponse(code = 401, message = "Unauthorized", response= ResponseWrapper.class),
            @ApiResponse(code = 404, message = "Resource not found", response= ErrorResponse.class),
            @ApiResponse(code = 422, message = "Unprocessable entity", response= ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response= ErrorResponse.class)
    })
    @GetMapping(value= "/translate2Human/{morse}")
    @ResponseBody
    public ResponseWrapper<String> translate2Human(@RequestBody String morse){
        LOGGER.info("Comienza el endpoint morseToHumanLanguaje");

        ResponseWrapper<String> response = telegrafoService.translate2Human(morse);

        LOGGER.info("finaliza el endpoint morseToHumanLanguaje");
        return response;
    }


    @ApiOperation(value = "Transformacion de Bits a Código Morse", response = ResponseWrapper.class)
    @ApiResponses( value = {
            @ApiResponse(code = 400, message = "Bad request" , response= ResponseWrapper.class),
            @ApiResponse(code = 401, message = "Unauthorized", response= ResponseWrapper.class),
            @ApiResponse(code = 404, message = "Resource not found", response= ErrorResponse.class),
            @ApiResponse(code = 422, message = "Unprocessable entity", response= ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response= ErrorResponse.class)
    })
    @GetMapping(value= "/decodeBits2Morse/{bits}")
    @ResponseBody
    public ResponseWrapper<String> decodeBits2Morse(@RequestBody String bits){
        LOGGER.info("Comienza el endpoint decodeBits2Morse");

        ResponseWrapper<String> response = telegrafoService.decodeBits2Morse(bits);

        LOGGER.info("finaliza el endpoint decodeBits2Morse");
        return response;
    }

    @ApiOperation(value = "Transformacion de Lenguaje humano a Código Morse", response = ResponseWrapper.class)
    @ApiResponses( value = {
            @ApiResponse(code = 400, message = "Bad request" , response= ResponseWrapper.class),
            @ApiResponse(code = 401, message = "Unauthorized", response= ResponseWrapper.class),
            @ApiResponse(code = 404, message = "Resource not found", response= ErrorResponse.class),
            @ApiResponse(code = 422, message = "Unprocessable entity", response= ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response= ErrorResponse.class)
    })
    @GetMapping(value= "/translate2Morse/{human}")
    @ResponseBody
    public ResponseWrapper<String> translate2Morse(@RequestBody String human){
        LOGGER.info("Comienza el endpoint translate2Morse");

        ResponseWrapper<String> response = telegrafoService.translate2Morse(human);

        LOGGER.info("finaliza el endpoint translate2Morse");
        return response;
    }

}
