public enum CellState {
    DEAD(0),
    LIVE(1);

    public final int value;

    private CellState(int value) {
        this.value = value;
    }
}
