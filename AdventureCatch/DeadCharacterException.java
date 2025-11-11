public class DeadCharacterException extends Exception {
    private Character character;

    public DeadCharacterException(Character character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        String type;

        // Determine the type of character
        if (character instanceof Monster) {
            type = "monster";
        } else if (character instanceof Templar) {
            type = "templar";
        } else if (character instanceof Sorcerer) {
            type = "sorcerer";
        } else {
            type = "character";
        }

        return "The " + type + " " + character.getName() + " is dead.";
    }
}
