package jtechlog.hamcrest;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private Long id;

    private String name;

    private List<String> cards = new ArrayList<>();

    private List<Address> addresses = new ArrayList<>();

    public Bank(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCards() {
        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}
