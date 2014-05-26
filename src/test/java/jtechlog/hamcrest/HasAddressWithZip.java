package jtechlog.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.ArrayList;
import java.util.List;

public class HasAddressWithZip extends TypeSafeDiagnosingMatcher<Bank> {

    @Factory
    public static HasAddressWithZip hasAddressWithZip(Matcher<? super String> valueMatcher) {
        return new HasAddressWithZip(valueMatcher);
    }

    private Matcher<? super String> valueMatcher;


    public HasAddressWithZip(Matcher<? super String> valueMatcher) {
        this.valueMatcher = valueMatcher;
    }

    @Override
    protected boolean matchesSafely(Bank bank, Description description) {
        List<String> zips = new ArrayList<>();
        for (Address address: bank.getAddresses()) {
            if (valueMatcher.matches(address.getZip())) {
                return true;
            }
            zips.add(address.getZip());
        }
        description.appendText(" zip codes found: ").appendValueList("[", ",", "]", zips);
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(" address with zip code ").appendDescriptionOf(valueMatcher);
    }
}
