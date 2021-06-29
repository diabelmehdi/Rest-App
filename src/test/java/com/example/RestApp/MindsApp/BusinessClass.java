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


            FileInputStream fis=new FileInputStream("C:\\Users\\DIAB\\Desktop\\BDT.txt");
            Scanner sc=new Scanner(fis);
            ArrayList<String> results = new ArrayList<String>();

            while(sc.hasNextLine())
            {
                String line= sc.nextLine();
                String code = line.substring(0,7);
               if (code.equals(searchcode) )
               { results.add(line.substring(7)) ;}
            }
            sc.close();

        return results;
    }

}
