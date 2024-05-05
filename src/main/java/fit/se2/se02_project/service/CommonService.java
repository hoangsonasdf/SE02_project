package fit.se2.se02_project.service;

import org.springframework.stereotype.Service;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Properties;
import java.util.Random;

@Service
public class CommonService {

    public String createRandomString(int length) {
        Random rng = new Random();
        StringBuilder rString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randomChar = (char) (rng.nextInt(26) + 'a');
            rString.append(randomChar);
        }

        return rString.toString();
    }

    public String hash(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            if (value == null) {
                return null;
            }
            byte[] bytes = digest.digest(value.getBytes());

            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                builder.append(String.format("%02x", b));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle exception or log error
            e.printStackTrace();
            return null;
        }
    }

    
}
