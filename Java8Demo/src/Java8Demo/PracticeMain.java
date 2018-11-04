package Java8Demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

import DishData.Dish;

import static DishData.Dish.menu;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class PracticeMain {


    public static void main(String...args){

    	List<String> words = Arrays.asList("Java8","Lambdas","In","Action"); 
    	List<Integer> wordLengths = 
    			words.stream() 
    				.map(String::length) 
    				.collect(toList());
    	wordLengths.forEach(System.out::println);
    	System.out.println("000000000000000000000000000000000000000000000");
    	
//    	List<String[]> dishNameLengths = 
//    			menu.stream() 
//    			.map(Dish::getName) 
//    			.map(str->str.split("")) 
//    			.distinct()
//    			.collect(toList());
//    This gives stream of string[]
    	
    	Optional<Dish> dishes = 
    			menu.stream() 
    				.filter(Dish::isVegetarian) 
    				.findAny();
    	System.out.println(dishes);
    	
    	List<String> uniqueCharacters = 
    			menu.stream() 
    				.map(Dish::getName) 
    				.map(w -> w.split(""))
    				.flatMap(str->Arrays.stream(str)) 
    				.distinct() 
    				.collect(Collectors.toList());
    	uniqueCharacters.forEach(System.out::println);
    	
}		

}