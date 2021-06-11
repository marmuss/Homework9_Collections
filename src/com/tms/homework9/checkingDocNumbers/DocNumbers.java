package com.tms.homework9.checkingDocNumbers;

import java.io.*;
import java.util.*;

/**
 * Программа получает на вход список файлов с номерами документов,
 * которые нужно проверить и создать отчет о валидности этих номеров.
 * Путь к файлу монжно ввести в формате : /test/test/doc.txt или test/test doc.txt
 * Пути файлов записываются в ArrayList
 * Номера документов в HashSet
 * Проверенные номера в HashMap, а затем в файл VerifiedDocNumbers.txt
 */
public class DocNumbers {
    public static void main(String[] args) {

        System.out.println("Введите путь к файлу и имя файла через пробел или /");
        System.out.println("Для завершения введите 0");
        Scanner scanner = new Scanner(System.in);

        List<String> pathList = new ArrayList<>();
        String path = "";
        while(!path.equals("0"))
        {
            path = scanner.nextLine();
            if(!path.equals("0"))
                pathList.add(path.replace(" ", "/"));
        }

        File file;
        FileReader docNumReader = null;
        Set<String> docNumSet = new HashSet<>();
        for (String pathItem : pathList){
            file = new File(pathItem);
            if (file.exists()){
                try {
                    docNumReader = new FileReader(file);
                    Scanner docNumScanner = new Scanner(docNumReader);
                    while (docNumScanner.hasNextLine()){
                        docNumSet.add(docNumScanner.nextLine());
                    }
                    docNumScanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        docNumReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Неверное имя файла или путь");
            }
        }

        Map<String, String> docNumMap = new HashMap<>();
        for (String docNumItem : docNumSet) {
            if ((docNumItem.indexOf("docnum") == 0) || (docNumItem.indexOf("kontract") == 0)) {
                if (docNumItem.length() == 15) {
                    docNumMap.put(docNumItem, "Номер верный");
                } else {
                    docNumMap.put(docNumItem, "В номере документа не 15 символов");
                }
            } else {
                if (docNumItem.length() == 15) {
                    docNumMap.put(docNumItem, "Номер документа не начинается с docnum или kontract");
                } else {
                    docNumMap.put(docNumItem, "В номере документа не 15 символов и не начинается с docnum или kontract");
                }
            }
        }

        FileWriter DocNumWriter = null;
        try {
            DocNumWriter = new FileWriter("VerifiedDocNumbers.txt");
            for (String key : docNumMap.keySet()){
                DocNumWriter.write(key + " - " + docNumMap.get(key) + "\n");
            }
            System.out.println("Смотрите файл VerifiedDocNumbers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                DocNumWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
