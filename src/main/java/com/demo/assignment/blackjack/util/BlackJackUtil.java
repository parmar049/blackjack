package com.demo.assignment.blackjack.util;

import com.demo.assignment.blackjack.constants.Constants;
import lombok.experimental.UtilityClass;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

@UtilityClass
public class BlackJackUtil {

    public String readInput(String filePath) {
        if (filePath == null) {
            return null;
        }
        String content = null;
        try {
            File file = ResourceUtils.getFile(filePath);
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (FileNotFoundException e) {
            System.out.println(Constants.FILE_MISSING_MSG + filePath);
        } catch (IOException e) {
            System.out.println(Constants.FILE_READ_MSG + filePath);
        }
        return content;
    }

}
