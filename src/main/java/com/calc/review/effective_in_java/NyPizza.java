package com.calc.review.effective_in_java;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/6
 */
public class NyPizza extends Pizza{

    public enum Size{SMALL,MEDIUM,LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = size;
        }

        public NyPizza build() {
            return new NyPizza(this);
        }

        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
