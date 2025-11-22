
public interface Raclette {
    int getCalories();
    String getIngredients();

    default String toStringRepresentation() {
        return getIngredients() + " pour " + getCalories() + " calories";
    }

    // @Override
    // default String toString() {
    //     return toStringRepresentation();
    // }
}
