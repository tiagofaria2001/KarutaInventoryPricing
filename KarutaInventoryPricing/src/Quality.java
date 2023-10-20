public enum Quality {
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR;

    @Override
    public String toString() {
        switch (this){
            case ZERO -> {
                return "☆☆☆☆";
            }
            case ONE -> {
                return "★☆☆☆";
            }
            case TWO -> {
                return "★★☆☆";
            }
            case THREE -> {
                return "★★★☆";
            }
            case FOUR -> {
                return "★★★★";
            }
        }
        return "★★★★";
    }
}
