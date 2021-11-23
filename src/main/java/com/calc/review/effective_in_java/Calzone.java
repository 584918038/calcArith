package com.calc.review.effective_in_java;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/6
 */
public class Calzone extends Pizza {

    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInside = false;

        public Builder sauceInside() {

            sauceInside = true;
            return this;
        }

        public Calzone build() {

            return new Calzone(this);
        }

        protected Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {

        super(builder);
        sauceInside = builder.sauceInside;
    }

}
