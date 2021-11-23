package com.calc.review.effective_in_java;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/8/6
 */
public class NutritionFacts {


    private final int servingSize;

    private final int servings;

    private final int calories;

    private final int fat;

    private final int sodium;

    private final int carbohydrate;

//    public NutritionFacts(int servingSize, int servings) {
//        this(servingSize,servings,0);
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories) {
//        this(servingSize,servings,calories,0);
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
//        this(servingSize,servings,calories,fat,0);
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
//        this(servingSize,servings,calories,fat,sodium,0);
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//        this.fat = fat;
//        this.sodium = sodium;
//        this.carbohydrate = carbohydrate;
//    }

    public static class Builder {

        private final int servingSize;

        private final int servings;

        private int calories = 0;

        private int fat = 0;

        private int sodium = 0;

        private int carbohydrate = 0;

        private Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        private Builder calories(int val) {

            calories = val;
            return this;
        }

        private Builder fat(int val) {
            fat = val;
            return this;
        }

        private Builder sodium(int val) {
            sodium = val;
            return this;
        }

        private Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        private NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {

        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {

        NutritionFacts cocaCola  = new Builder(240,8).calories(100).sodium(35).carbohydrate(27).build();

        NutritionFacts cocaCola2 = new Builder(240,8).carbohydrate(27).build();

        System.out.println(cocaCola);

        System.out.println(cocaCola2);
    }

}
