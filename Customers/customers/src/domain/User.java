package domain;

import java.util.List;

public record User(String name, int age, SexEnum sex, List<Contact> contacts) {

}
