package com.telegrafo.service;

import com.telegrafo.model.Binary;
import com.telegrafo.model.Status;
import com.telegrafo.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Service
public class  TelegrafoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TelegrafoService.class);

    private HashMap<String, String>  translateMorseToHuman= new HashMap<String, String>();
    private HashMap<Character, String>  translateHumanToMorse= new HashMap<Character, String>();

    public void loadtranslateHumanToMorse() {
        translateHumanToMorse.put('A', ".- ");
        translateHumanToMorse.put('B', "-... ");
        translateHumanToMorse.put('C', "-.-. ");
        translateHumanToMorse.put('D', "-.. ");
        translateHumanToMorse.put('E', ". ");
        translateHumanToMorse.put('F', "..-. ");
        translateHumanToMorse.put('G', "--. ");
        translateHumanToMorse.put('H', ".... ");
        translateHumanToMorse.put('I', ".. ");
        translateHumanToMorse.put('J', ".--- ");
        translateHumanToMorse.put('K', "-.- ");
        translateHumanToMorse.put('L', ".-.. ");
        translateHumanToMorse.put('M', "-- ");
        translateHumanToMorse.put('N', "-. ");
        translateHumanToMorse.put('O', "--- ");
        translateHumanToMorse.put('P', ".--. ");
        translateHumanToMorse.put('Q', "--.- ");
        translateHumanToMorse.put('R', ".-. ");
        translateHumanToMorse.put('S', "... ");
        translateHumanToMorse.put('T', "- ");
        translateHumanToMorse.put('U', "..- ");
        translateHumanToMorse.put('V', "...- ");
        translateHumanToMorse.put('W', ".-- ");
        translateHumanToMorse.put('X', "-..- ");
        translateHumanToMorse.put('Y', "-.-- ");
        translateHumanToMorse.put('Z', "--.. ");
        translateHumanToMorse.put('0', "----- ");
        translateHumanToMorse.put('1', ".---- ");
        translateHumanToMorse.put('2', "..--- ");
        translateHumanToMorse.put('3', "...-- ");
        translateHumanToMorse.put('4', "....- ");
        translateHumanToMorse.put('5', "..... ");
        translateHumanToMorse.put('6', "-.... ");
        translateHumanToMorse.put('7', "--... ");
        translateHumanToMorse.put('8', "---.. ");
        translateHumanToMorse.put('9', "----. ");
        translateHumanToMorse.put('.', ".-.-.- ");
        translateHumanToMorse.put(' ', "  ");
    };

    private void loadtranslateMorseToHuman(){
        translateMorseToHuman.put("", " ");
        translateMorseToHuman.put(" ", " ");
        translateMorseToHuman.put(".-", "A");
        translateMorseToHuman.put("-...", "B");
        translateMorseToHuman.put("-.-.", "C");
        translateMorseToHuman.put("-..", "D");
        translateMorseToHuman.put(".", "E");
        translateMorseToHuman.put("..-.", "F");
        translateMorseToHuman.put("--.", "G");
        translateMorseToHuman.put("....", "H");
        translateMorseToHuman.put("..", "I");
        translateMorseToHuman.put(".---", "J");
        translateMorseToHuman.put("-.-", "K");
        translateMorseToHuman.put(".-..", "L");
        translateMorseToHuman.put("--", "M");
        translateMorseToHuman.put("-.", "N");
        translateMorseToHuman.put("---", "O");
        translateMorseToHuman.put(".--.", "P");
        translateMorseToHuman.put("--.-", "Q");
        translateMorseToHuman.put(".-.", "R");
        translateMorseToHuman.put("...", "S");
        translateMorseToHuman.put("-", "T");
        translateMorseToHuman.put("..-", "U");
        translateMorseToHuman.put("...-", "V");
        translateMorseToHuman.put(".--", "W");
        translateMorseToHuman.put("-..-", "X");
        translateMorseToHuman.put("-.--", "Y");
        translateMorseToHuman.put("--..", "Z");
        translateMorseToHuman.put("-----", "0");
        translateMorseToHuman.put(".----", "1");
        translateMorseToHuman.put("..---", "2");
        translateMorseToHuman.put("...--", "3");
        translateMorseToHuman.put("....-", "4");
        translateMorseToHuman.put(".....", "5");
        translateMorseToHuman.put("-....", "6");
        translateMorseToHuman.put("--...", "7");
        translateMorseToHuman.put("---..", "8");
        translateMorseToHuman.put("----.", "9");
    }

    public TelegrafoService() {
        loadtranslateMorseToHuman();
        loadtranslateHumanToMorse();
    }

    public ResponseWrapper<String> translate2Human(String morse){
        final String result= "";
        ResponseWrapper<String> resp;

        try {
            String res= Arrays.stream(morse.split(" "))
                    .map(s ->translateMorseToHuman.get(s))
                    .collect(Collectors.joining());

            resp = ResponseWrapper.builder().setStatus(Status.OK)
                    .setData(res)
                    .build();

        }catch (Exception e){
            resp = ResponseWrapper.builder().setStatus(Status.ERROR)
                    .setData(e.getMessage())
                    .build();
        }

        return resp;
    }

    public ResponseWrapper<String> translate2Morse(String human){
        String res= "";
        ResponseWrapper<String> resp;

        try {
            for (Character c: human.toCharArray()){
                if (c == 32){
                    res += " ";
                }else {
                    res += translateHumanToMorse.get(c);
                }
            }

            res = res.substring(0, res.length()-1);  // quito el ultimo espacio

            resp = ResponseWrapper.builder().setStatus(Status.OK)
                    .setData(res)
                    .build();

        }catch (Exception e){
            resp = ResponseWrapper.builder().setStatus(Status.ERROR)
                    .setData(e.getMessage())
                    .build();
        }

        return resp;
    }

    private String deleteZerosToBegin(String text){
        if (text.startsWith("0")){
            int starOne= text.indexOf("1");

            text= text.substring(starOne, text.length());
        }
        return text;
    }

    public ResponseWrapper<String> decodeBits2Morse(String text) {
        ResponseWrapper<String> resp;
        text= deleteZerosToBegin(text);

        Binary bin = this.calculateCantZerosAndOne(text);
        String stringMorse= translateToMorse(bin);

        resp = ResponseWrapper.builder().setStatus(Status.OK)
                .setData(stringMorse)
                .build();

        return resp;
    }

    /**
     * Calculo la cantidad de 0 y 1
     */
    public Binary calculateCantZerosAndOne(String text) {
        List<String> zeros = new ArrayList<>(
                Arrays.asList(text.replaceAll("(1+)", " ").trim().split(" "))
        );

        List<String> ones =  new ArrayList<>(
                Arrays.asList(text.replaceAll("(0+)", " ").trim().split(" "))
        );

        String finalBit = "";
        if (!zeros.isEmpty()) {
            List<String> zeroPulsesCopy = new ArrayList<>(zeros);
            zeros.remove(zeroPulsesCopy.get((zeroPulsesCopy.size() - 1)));
            finalBit = zeroPulsesCopy.get((zeroPulsesCopy.size() - 1));
        }

        Binary binary = new Binary();

        binary.setMaxOneValue(ones.stream().map(String::length).max(Integer::compareTo).get());
        binary.setMinOneValue(ones.stream().map(String::length).min(Integer::compareTo).get());
        binary.setMaxZeroValue(zeros.stream().map(String::length).max(Integer::compareTo).get());
        binary.setMinZeroValue(zeros.stream().map(String::length).min(Integer::compareTo).get());

        binary.setEndValue(finalBit.length());
        binary.setSegments( this.binParseToList(text));

        return binary;
    }

    public List<String> binParseToList(String message) {
        List<String> binaryParsedMessage = new ArrayList<>();
        Matcher m = Pattern.compile("(0+|1+)").matcher(message);

        while(m.find()) {
            binaryParsedMessage.add(m.group(1));
        }

        return binaryParsedMessage;
    }

    public Integer evaluateSegments(String segments, int maxOneValue, int maxZeroValue, int minOneValue, int minZeroValue, int finalValue) {
        Integer valueSegment = null;

        if (segments != null && segments.length() > 0) {
            Character pulseType = segments.charAt(0);

            if (pulseType.equals('1')) {
                if (segments.length() < ((maxOneValue + minOneValue) / 2)) {
                    valueSegment = Binary.PulseTypes.SHORT_ONE.getValue();
                } else {
                    valueSegment = Binary.PulseTypes.LONG_ONE.getValue();
                }
            } else if (pulseType.equals('0')) {
                if (segments.length() < ((maxZeroValue + minZeroValue) / 2)) {
                    valueSegment = Binary.PulseTypes.SHORT_ZERO.getValue();
                } else if (segments.length() == finalValue) {
                    valueSegment = Binary.PulseTypes.END.getValue();
                } else {
                    valueSegment = Binary.PulseTypes.LONG_ZERO.getValue();
                }
            }
        }

        return valueSegment;
    }

    public String translateToMorse(Binary binary) {
        String translate = "";

        for (String seg : binary.getSegments()) {
            Integer evaluatedPulse = this.evaluateSegments(seg, binary.getMaxOneValue(),
                                    binary.getMaxZeroValue(), binary.getMinOneValue(),
                                    binary.getMinZeroValue(), binary.getEndValue() );

            switch (evaluatedPulse) {
                case 0:
                case 4:
                    translate = translate.concat("");
                    break;
                case 1:
                    translate = translate.concat(" ");
                    break;
                case 2:
                    translate = translate.concat(".");
                    break;
                case 3:
                    translate = translate.concat("-");
                    break;
            }
        }

        return translate;
    }


}
