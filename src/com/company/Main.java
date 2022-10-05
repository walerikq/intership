package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Public\\intership\\city_ru.csv"));

        String line = null;
        Scanner sc = null;
        int index = 0;
        List<City> cityList = new ArrayList<>();

        while((line = reader.readLine()) != null){
            City city = new City();
            sc = new Scanner(line);
            sc.useDelimiter(";");
            while (sc.hasNext()){
                String data = sc.next();
                if(index == 0){
                    city.setId(Short.parseShort(data));
                }else if (index == 1){
                    city.setName(data);
                }else if (index == 2){
                    city.setRegion(data);
                }else if (index == 3){
                    city.setDistrict(data);
                }else if (index == 4){
                    city.setPopulation(Integer.parseInt(data));
                }else if (index == 5){
                    city.setFoundation(String.valueOf(data));
                }else
                    System.out.println("Некорректные данные" + data);
                index++;
            }
            index = 0;
            cityList.add(city);
        }

        reader.close();

        System.out.println(cityList);

    }
}
