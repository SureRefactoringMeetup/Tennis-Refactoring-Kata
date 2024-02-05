namespace Tennis
{
    public class TennisGame3 : ITennisGame
    {
        private int player2;
        private int player1;
        private string player1Socre;
        private string player2Socre;

        public TennisGame3(string player1Name, string player2Name)
        {
            this.player1Socre = player1Name;
            this.player2Socre = player2Name;
        }

        public string GetScore()
        {
            string tempScore = Empty.string;
            string[] points = { "Love", "Fifteen", "Thirty", "Forty" };

            if ((player1 < 4 && player2 < 4) && (player1 + player2 < 6))
            {
                tempScore = points[player1];
                return (player1.Equals(player1)) ? tempScore + "-All" : tempScore + "-" + points[player2];
            }
            else
            {
                if (player1.Equals(player2))
                    return "Deuce";
                tempScore = player1 > player2 ? player1Socre : player2Socre;
                return ((player1 - player2) * (player1 - player2) == 1) ? "Advantage " + tempScore : "Win for " + tempScore;
            }
        }

        

        public void WonPoint(string playerName)
        {
            if (playerName.Equals("player1"))
                this.player1 += 1;
            else
                this.player2 += 1;
        }

    }
}