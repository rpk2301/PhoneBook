package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook =map;
    }

    public PhoneBook() {
        phonebook = new LinkedHashMap<>();

    }

    public void add(String name, String phoneNumber) {
        //This line is going to make a list (just like the PhoneBook contstructor wants.
        //Its going to look and say IF the name is present(as a key), return the values.
        //otherwise. Create a new arraylist. Next we add phonenumber to either the
        //new list OR the old list with the key. Put those numbers back into phonebook.
        List<String> numbers = phonebook.getOrDefault(name,new ArrayList<>());
        numbers.add(phoneNumber);
        phonebook.put(name,numbers);


    }

    public void addAll(String name, String... phoneNumbers)
    {
        List<String> numbers = phonebook.getOrDefault(name,new ArrayList<>());
        for(String x : phoneNumbers)
        {
            numbers.add(x);
        }
        phonebook.put(name,numbers);
    }

    public void remove(String name) {
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String number)
    {
        return phonebook.containsKey(name)&& phonebook.get(name).contains(number);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> ret = new ArrayList<>();
        for(String x : phonebook.keySet())
        {
            ret.add(x);

        }


        return ret;

    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
