public enum Edition {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX;

    @Override
    public String toString() {
        switch (this){
            case ONE -> {
                return "◈1";
            }
            case TWO -> {
                return "◈2";
            }
            case THREE -> {
                return "◈3";
            }
            case FOUR -> {
                return "◈4";
            }
            case FIVE -> {
                return "◈5";
            }
            case SIX -> {
                return "◈6";
            }
        }
        return "◈0";
    }
}
