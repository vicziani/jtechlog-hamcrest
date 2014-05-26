package jtechlog.hamcrest;

import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

public class HasNameMatcher extends FeatureMatcher<Bank, String> {

    @Factory
    public static HasNameMatcher hasName(Matcher<? super String> matcher) {
        return new HasNameMatcher(matcher, "name", "name");
    }

    public HasNameMatcher(Matcher<? super String> subMatcher, String featureDescription, String featureName) {
        super(subMatcher, featureDescription, featureName);
    }

    @Override
    protected String featureValueOf(Bank bank) {
        return bank.getName();
    }
}
