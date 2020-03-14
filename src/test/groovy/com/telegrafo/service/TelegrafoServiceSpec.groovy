package com.telegrafo.service


import spock.lang.Specification

class TelegrafoServiceSpec extends Specification{
    def telegrafoService=  new TelegrafoService()

    def "test method translate2Human"(){
        given:
        def String morse= ".... --- .-.. .-  -- . .-.. .."

        when:
        def result= telegrafoService.translate2Human(morse)

        then:
        result.getData() == "HOLA MELI"
    }

    def "test method decodeBits2Morse"(){
        given:
        def String msg = "0000000011011011001110000011111100011111100111111000000011101111111101110111000000011000111111" +
                         "00000111111001111110000000110000110111111110111011100000011011100000000000";

        when:
        def result= telegrafoService.decodeBits2Morse(msg)

        then:
        result.getData().equals(".... --- .-.. .- -- . .-.. ..");

    }

    def "test method translate2Morse"(){
        given:
        def String human= "HOLA MELI"

        when:
        def result= telegrafoService.translate2Morse(human)

        then:
        result.getData() == ".... --- .-.. .-  -- . .-.. .."
    }
}
