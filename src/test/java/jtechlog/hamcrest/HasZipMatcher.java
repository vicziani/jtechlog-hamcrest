package jtechlog.hamcrest;

import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

public class HasZipMatcher extends FeatureMatcher<Address, String> {

    @Factory
    public static HasZipMatcher hasZip(Matcher<? super String> matcher) {
        return new HasZipMatcher(matcher, "zip", "zip");
    }

    public HasZipMatcher(Matcher<? super String> subMatcher, String featureDescription, String featureName) {
        super(subMatcher, featureDescription, featureName);
    }

    @Override
    protected String featureValueOf(Address address) {
        return address.getZip();
    }
}
