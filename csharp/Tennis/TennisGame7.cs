namespace Refactoring
{
    public static class Const
    {
        public enum Socre { Love, Fifteen, Thirty, Forty };
        public enum TieSocre { Love_All, Fifteen_All, Thirty_All, Deuce };
        //public static readonly string
    }

    public class TennisGame1 : ITennisGame
    {
        private int m_score1 = 0;
        private int m_score2 = 0;
        private string player1Name;
        private string player2Name;

        public TennisGame1(string player1Name, string player2Name)
        {
            this.player1Name = player1Name;
            this.player2Name = player2Name;
        }

        public string GetScore()
        {
            var score = string.Empty;
            if (m_score1.Equals(m_score2))
            {
                Tie(score);
            }
            else if (m_score1 >= 4 || m_score2 >= 4)
            {
                EndGame(score);
            }
            else
            {
                Scoring(score);
            }
            return score;
        }


        public void WonPoint(string playerName)
        {
            if (playerName.Equals("player1"))
                m_score1 += 1;
            else
                m_score2 += 1;
        }

        private void EndGame(string score)
        {
            var scoreDiff = m_score1 - m_score2;
            if (scoreDiff == 1) score = "Advantage player1";
            else if (scoreDiff == -1) score = "Advantage player2";
            else if (scoreDiff >= 2) score = "Win for player1";
            else score = "Win for player2";

        }

        private void Tie(string score)
        {
            switch (m_score1)
            {
                case 0:
                    score = Const.TieSocre.Love_All.ToString();
                    break;
                case 1:
                    score = Const.TieSocre.Fifteen_All.ToString();
                    break;
                case 2:
                    score = Const.TieSocre.Thirty_All.ToString();
                    break;
                default:
                    score = Const.TieSocre.Deuce.ToString();
                    break;

            }
        }

        private void Scoring(string score)
        {
            var tempScore = m_score1;
            for (var i = 1; i < 3; i++)
            {
                if (i == 1) tempScore = m_score1;
                else
                {
                    score += "-";
                    tempScore = m_score2;
                }
                switch (tempScore)
                {
                    case 0:
                        score += Const.Socre.Love;
                        break;
                    case 1:
                        score += Const.Socre.Fifteen;
                        break;
                    case 2:
                        score += Const.Socre.Thirty;
                        break;
                    case 3:
                        score += Const.Socre.Forty;
                        break;
                }
            }
        }

    }
}