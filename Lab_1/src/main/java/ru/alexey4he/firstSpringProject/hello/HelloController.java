package ru.alexey4he.firstSpringProject.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {

    private ArrayList<String> someArray;
    private HashMap<String, String> someHashMap;
    private int i; // переменая которая отвечает за генерацию ключа в хешмапе.

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
    defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "arrayElement",
    defaultValue = "none") String arrayElement){
        if (someArray == null){
            someArray = new ArrayList<>();
            return "ArrayList<String> - создан";
        }
        else {
            someArray.add(arrayElement);
            return arrayElement + " - записан в ArrayList";
        }
    }

    @GetMapping("/show-array")
    Iterable<String> showArrayList(){
        return someArray;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "hashMapElement",
    defaultValue = "none") String hashMapElement){
        if (someHashMap == null){
            someHashMap = new HashMap<>();
            i = 0;
            return "HashMap(String, String) - создана";
        }
        else {
            i = i + 1;
            someHashMap.put(Integer.toString(i), hashMapElement);
            return hashMapElement + " - записан в hashMap";
        }
    }

    @GetMapping("show-map")
    public String showHashMap() {
        String resultString = "HashMap - не создана";
        if (someHashMap != null) {
            resultString = someHashMap.toString();
        }
        return resultString;
    }

    @GetMapping("show-all-lenght")
    public String showAllLenght(){
        String arrayLenght = "ArrayList не создан.<br>";
        String hashMapLenght = "HashMap не создана.";
        if (someArray != null){
            arrayLenght = "ArrayList содержит " + someArray.size() + " элемента.<br>";
        }
        if (someHashMap != null){
            hashMapLenght = "HashMap содержит " + someHashMap.size() + " элемента.";
        }

        return (arrayLenght + hashMapLenght);
    }
}
