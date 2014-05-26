package jtechlog.hamcrest;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static jtechlog.hamcrest.HasAddressWithZip.hasAddressWithZip;
import static jtechlog.hamcrest.HasNameMatcher.hasName;
import static jtechlog.hamcrest.HasZipMatcher.hasZip;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MatchersTest {

    private Bank bank;

    @Before
    public void init() {
        bank = new Bank(1l, "CIB BANK");

        bank.setCards(Arrays.asList("CIB VISA Inspire", "CIB MasterCard Gold", "CIB Visa Internetkártya"));

        bank.addAddress(new Address(AddressType.OFFICE, "1117", "Budapest", "Október 23.−a utca 6−8."));
        bank.addAddress(new Address(AddressType.OFFICE, "1087", "Budapest", "Kerepesi út 9."));
        bank.addAddress(new Address(AddressType.OFFICE, "5600", "Békéscsaba", "Andrássy út 2."));
        bank.addAddress(new Address(AddressType.ATM, "5600", "Békéscsaba", "H-Békéscsaba, Bartók Béla út 19."));
    }

    @Test
    public void testStringEqualsWithAssert() {
        assert(bank.getName().equals("CIB BANK"));
    }

    @Test
    public void testStringEqualsWithJunitAssert() {
        assertEquals("CIB BANK", bank.getName());
    }

    @Test
    public void testStringEqualsWithHamcrest() {
        assertThat(bank.getName(), is(equalTo("CIB BANK")));
    }

    @Test
    public void testContainsWithAssert() {
        assert(bank.getName().contains("CIB") || bank.getName().contains("BANK"));
    }

    @Test
    public void testContainsWithJunit() {
        assertTrue(bank.getName().contains("CIB") || bank.getName().contains("BANK"));
    }

    @Test
    public void testContainsWithHamcrest() {
        assertTrue(bank.getName().contains("CIB") || bank.getName().contains("BANK"));
    }

    @Test
    public void testContainsWithHamcrestWithMessage() {
        assertThat("name", bank.getName(), either(containsString("CIB")).or(containsString("BANK")));
    }

    @Test
    public void testCollectionsNotContains() {
        assertThat(bank.getCards(), not(contains("CIB VISA Inspire")));
    }

    @Test
    public void testCollectionsContainsInvalidOrder() {
        assertThat(bank.getCards(), not(contains("CIB MasterCard Gold", "CIB VISA Inspire", "CIB Visa Internetkártya")));
    }

    @Test
    public void testCollectionsContainsTrue() {
        assertThat(bank.getCards(), contains("CIB VISA Inspire", "CIB MasterCard Gold", "CIB Visa Internetkártya"));
    }

    @Test
    public void testCollectionsContainsInAnyOrder() {
        assertThat(bank.getCards(), containsInAnyOrder("CIB MasterCard Gold", "CIB VISA Inspire", "CIB Visa Internetkártya"));
    }

    @Test
    public void testCollectionsHasItem() {
        assertThat(bank.getCards(), hasItem("CIB MasterCard Gold"));
    }

    @Test
    public void testCollectionsHasItems() {
        assertThat(bank.getCards(), hasItems("CIB VISA Inspire", "CIB MasterCard Gold"));
    }

    @Test
    public void testCollectionsIsIn() {
        assertThat("CIB MasterCard Gold", isIn(bank.getCards()));
    }


    @Test
    public void testHasProperty() {
        assertThat(bank, hasProperty("name", equalTo("CIB BANK")));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testHasPropertyWithCollections() {
        assertThat((List<Object>)(List)bank.getAddresses(), hasItem(hasProperty("zip", equalTo("5600"))));
    }

    @Test
    public void testBankNameWithFeatureMatcher() {
        assertThat(bank, hasName(equalTo("CIB BANK")));
    }

    @Test
    public void testZipAddressWithFeatureMatcher() {
        assertThat(bank.getAddresses(), hasItem(hasZip(equalTo("5600"))));
    }

    @Test
    public void testZipAddressWithTypeSafeDiagnosingMatcher() {
        assertThat(bank, hasAddressWithZip(equalTo("5600")));
    }


    @Test
    public void testMismatchDescription() {
        // JUnit 4.10 esetén még a hibaüzenet Long.class Integer.class-ra írva:
        // Expected: an instance of java.lang.Integer
        // got: <1L>
        //
        // De a 4.11 esetén
        // Expected: an instance of java.lang.Integer
        // but: <1L> is a java.lang.Long

        assertThat(bank.getId(), instanceOf(Long.class));
    }

}
