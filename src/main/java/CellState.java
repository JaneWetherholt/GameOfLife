public enum CellState {
    DEAD(0),
    LIVE(1);

    public final int value;

    CellState(int value) {
        this.value = value;
    }
}
