package com.calc.review.effective_in_java;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/6
 */
public abstract class Pizza {

    public enum Topping {HAM,MUSHROOM,ONION,PEPPER,SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {

            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder<?> builder) {

        toppings = builder.toppings.clone();
    }

}
