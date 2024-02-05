import java.security.InvalidParameterException;

public class TennisGame3 implements TennisGame {

    public final static String DASH = "-";

    public final static String ALL = "All";

    public final static String DEUCE = "Deuce";

    public final static String WIN_FOR = "Win for ";

    public final static String ADVANTAGE = "Advantage ";

    public final static int MINIMUM_GAP_TO_WIN = 2;

    private final Player player1;

    private final Player player2;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 0);
        this.player2 = new Player(player2Name, 0);
    }

    public String getScore() {
        String s;

        if (inPlayAndNotDeuce()) {
            s = Score.getNameByNumber(player1.getScore());
            return (isTied()) ? s + DASH + ALL : s + DASH + Score.getNameByNumber(player2.getScore());
        } else {
            if (isTied()) {
                return DEUCE;
            }

            s = findLead().getName();
            return (advantage()) ? ADVANTAGE + s : WIN_FOR + s;
        }
    }

    /**
     * @return 경기가 2점차 이상으로 이겼으면 advantage가 아니므로, false 리턴
     */
    private boolean advantage() {
        return MINIMUM_GAP_TO_WIN > Math.abs(player1.getScore() - player2.getScore());
    }

    /**
     * @return 두 플레이어가 동점이면 true 리턴
     */
    private boolean isTied() {
        return player1.getScore() == player2.getScore();
    }

    /**
     * @return 게임이 진행중인데 듀스는 아닐 경우 true
     */
    private boolean inPlayAndNotDeuce() {
        return (player1.getScore() < 4 && player2.getScore() < 4)
                && !(player1.getScore() + player2.getScore() == 6);
    }

    /**
     * @return 이기고 있는 사람 리턴
     */
    private Player findLead() {
        return player1.getScore() > player2.getScore() ? player1 : player2;
    }

    /**
     * 주어진 플레이어 점수 올리기
     */
    public void wonPoint(String playerName) {
        getPlayerByName(playerName).wonPoint();
    }

    private Player getPlayerByName(String playerName) {
        if (player1.getName().equalsIgnoreCase(playerName)) {
            return player1;
        } else if (player2.getName().equalsIgnoreCase(playerName)) {
            return player2;
        }
        throw new InvalidParameterException("현재 플레이중이지 않은 이름입니다.");
    }

}
