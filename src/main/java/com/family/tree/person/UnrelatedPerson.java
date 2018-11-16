package com.family.tree.person;

import com.family.tree.util.Either;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import static com.family.tree.person.Person.*;

public abstract class UnrelatedPerson {

    private static final Pattern INTEGER_PATTERN = Pattern.compile("\\d+");
    public final boolean isAdopted;
    public final String firstName;
    public final String lastName;
    public final Integer birthYear;
    protected final Integer deathYear;

    public UnrelatedPerson(boolean isAdopted, String firstName, String lastName, Integer birthYear, Integer deathYear) {
        this.isAdopted = isAdopted;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public static Either<String, UnrelatedPerson> fromMap(Map<String, String> pairs) {
        if (arePairsValid(pairs)) {
            UnrelatedPerson person;
            boolean isAdopted = Boolean.parseBoolean(pairs.get(IS_ADOPTED).toLowerCase());
            String firstName = pairs.get(FIRST_NAME);
            String lastName = pairs.get(LAST_NAME);
            int birthYear = Integer.parseInt(pairs.get(BIRTH_YEAR));
            String serializedDeathYear = pairs.get(DEATH_YEAR);
            Integer deathYear = isInteger(serializedDeathYear) ? Integer.parseInt(serializedDeathYear) : null;
            if (MALE.equals(pairs.get(GENDER))) {
                person = new UnrelatedMale(isAdopted, firstName, lastName, birthYear, deathYear);
            } else {
                person = new UnrelatedFemale(isAdopted, firstName, lastName, birthYear, deathYear);
            }
            return Either.right(person);
        } else {
            return Either.left("Does not contain person");
        }
    }

    private static boolean arePairsValid(Map<String, String> pairs) {
        return null != pairs &&
                containsAllMandatoryFields(pairs) &&
                isInteger(pairs.get(BIRTH_YEAR)) &&
                genderWithinBounds(pairs.get(GENDER)) &&
                adoptionWithinBounds(pairs.get(IS_ADOPTED));
    }

    private static boolean isInteger(String maybeSerializedInt) {
        return INTEGER_PATTERN.matcher(maybeSerializedInt).matches();
    }

    private static boolean containsAllMandatoryFields(Map<String, String> pairs) {
        return pairs.keySet().containsAll(Arrays.asList(FIRST_NAME, LAST_NAME, IS_ADOPTED, GENDER, BORN_IN, BIRTH_YEAR, DEATH_YEAR));
    }

    private static boolean genderWithinBounds(String serializedGender) {
        return MALE.equals(serializedGender) || FEMALE.equals(serializedGender);
    }

    private static boolean adoptionWithinBounds(String serializedAdoption) {
        return Boolean.TRUE.toString().equalsIgnoreCase(serializedAdoption) ||
                Boolean.FALSE.toString().equalsIgnoreCase(serializedAdoption);
    }

    public Optional<Integer> deathYear() {
        return Optional.ofNullable(deathYear);
    }

    public abstract boolean isMale();

    public abstract boolean isFemale();
}
