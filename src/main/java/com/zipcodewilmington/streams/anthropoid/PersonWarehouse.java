package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/29/17.
 * The warehouse is responsible for storing, retrieving, and filtering personSequence
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonWarehouse implements Iterable<Person> {
    private final LoggerHandler loggerHandler = LoggerWarehouse.getLogger(PersonWarehouse.class);
    private final List<Person> people = new ArrayList<>();

    /**
     * @param person the Person object to add to the warehouse
     * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this method
     */
    public void addPerson(Person person) {
        loggerHandler.disbalePrinting();
        loggerHandler.info("Registering a new person object to the person warehouse...");
        loggerHandler.info(ReflectionUtils.getFieldMap(person).toString());
        people.add(person);
    }

    /**
     * @return list of names of Person objects
     */ // TODO
    public List<String> getNames() {
        return people.stream()
                .map(person -> person.getName())
                .collect(Collectors.toList());
    }


    /**
     * @return list of uniquely named Person objects
     *
     * Create a HashSet
     * Create a stream from people and use the filter() method to add each person in the HashSet based on their name.
     * Because you use HashSet it will only have unique names of each person
     *
     */ //TODO
    public Stream<Person> getUniquelyNamedPeople() {
        Set<String> setOfUniqueNames = new HashSet<>();
        return people.stream()
                .filter(person -> setOfUniqueNames.add(person.getName()));
    }

    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     *
     * Follow same patch as getUniquelyNamedPeople() method.
     * Filter out the each person based on the character the user inputs.
     * Filter the stream again ad add the people to the HashSet.
     * Because you use a Hashset it onl will have unique names.
     *
     */ //TODO
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {
        Set<String> setOfUniqueNames = new HashSet<>();
        return people.stream()
                .filter(person -> person.getName().charAt(0) == character)
                .filter(person -> setOfUniqueNames.add(person.getName()));
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     *
     * Apply a limit of n on the getUniquelyNamedPeople() method
     *
     */ //TODO
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {
        return this.people.stream().limit(n);
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    public Map<Long, String> getIdToNameMap() {
        return this.people.stream()
                .collect(Collectors.toMap(
                        (person -> person.getPersonalId()),
                        (person -> person.getName())));
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public Stream<Stream<String>> getNestedAliases() {
        return null;
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public Stream<String> getAllAliases() {
        return this.people.stream()
                .map(person -> person.getAliases().toString());
    }

    // DO NOT MODIFY
    public Boolean contains(Person p) {
        return people.contains(p);
    }

    // DO NOT MODIFY
    public void clear() {
        people.clear();
    }

    // DO NOT MODIFY
    public int size() {
        return people.size();
    }

    @Override // DO NOT MODIFY
    public Iterator<Person> iterator() {
        return people.iterator();
    }
}
