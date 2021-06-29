package com.example.RestApp.MindsApp;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class BusinessClass {
    public List<String> getinfo(String searchcode) throws FileNotFoundException {

            if(searchcode.equals(null)) {
                return null;
            }
                FileInputStream files = new FileInputStream("C:\\Users\\DIAB\\Desktop\\BDT.txt");
                Scanner sc = new Scanner(files);
                ArrayList<String> results = new ArrayList<String>();

                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String code = line.substring(0, 7);
                    if (code.equals(searchcode)) {
                        results.add(line.substring(7));
                    }
                }

                sc.close();

        return results;
    }

}
