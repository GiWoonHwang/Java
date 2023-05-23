package item2.telescopingconstructor;

/*
생성자에 매개변수가 많다면 빌더를 고려하라.
 */
public class NutritionFacts {
    /*
    점층적 생성자 패턴
    매개변수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.
     */
    private final int servingSize; private final int servings; private final int calories; private final int fat;
    private final int sodium; private final int carbohydrate;
    // (ml, 1회 제공량) 필수 //(회,총n회제공량) 필수 // (1회 제공량당) 선택 // (g/1회 제공량) 선택 // (mg/1회 제공량) 선택 // (g/1회 제공량) 선택
    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0); }
    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0); }

    public NutritionFacts(int servingSize, int servings,int calories, int fat) {
        this(servingSize, servings, calories, fat, 0); }
    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0); }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

}




