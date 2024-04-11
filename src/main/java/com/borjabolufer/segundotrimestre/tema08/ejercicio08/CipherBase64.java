package com.borjabolufer.segundotrimestre.tema08.ejercicio08;

import java.util.Base64;

public class CipherBase64 {
    public String encode(String text) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encoded = encoder.encode(text.getBytes());
        return new String(encoded);
    }
    public String decode(String str){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decoded = decoder.decode(str);
        return new String(decoded);
    }

}
