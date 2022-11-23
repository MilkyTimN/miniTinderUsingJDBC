package kg.megaco.miniTinder.models.enums;

public enum Gender {
    MALE("Мужской"),
    FEMALE("Женский"),
    OTHER("Другой");

    private String val;

    Gender(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
