import java.util.HashMap;
import java.util.Map;

public enum Score {
    LOVE(0, "Love"),
    FIFTEEN(1, "Fifteen"),
    THIRTY(2, "Thirty"),
    FORTY(3, "Forty");

    private static final Map<Integer, Score> numberToNameMap = new HashMap<>();

    static {
        for (Score score : values()) {
            numberToNameMap.put(score.getNumber(), score);
        }
    }

    private final int number;
    private final String name;

    Score(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static String getNameByNumber(int number) {
        Score score = numberToNameMap.get(number);
        return (score != null) ? score.getName() : null;
    }
}
