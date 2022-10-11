package enums;

public enum PlayerState {

    InPlay("In Play"),
    Ejected("Ejected");

    private String title;

    private PlayerState(String title) {
        this.title = title;
    }
}
