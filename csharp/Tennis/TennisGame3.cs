using System.Collections.Generic;

namespace Tennis
{
    public class TennisGame3 : Player, ITennisGame
    {
        Player player1 = new();
        Player player2 = new();

        List<string> GameStatus = new List<string>
        {
            "Deuce",
            "Advantage",
            "Win for"
        };

        List<string> TennisScoreString = new List<string>
        {
            "Love",
            "Fifteen",
            "Thirty",
            "Forty"
        };

        public string GetScore()
        {
            if (IsGameProgress(player1.Score, player2.Score))
            {
                if(IsSameScore(player1.Score, player2.Score))
                {
                    return TennisScoreString[player1.Score] + "-All";
                }
                else
                {
                    return TennisScoreString[player1.Score] + "-" + TennisScoreString[player2.Score];
                }
            }
            else
            {
                if (IsSameScore(player1.Score, player2.Score))
                {
                    return GameStatus[0];
                }

                string leadingPlayer = GetLeadingPlayer(player1, player2);
                if(IsAbsoluteValue(player1.Score, player2.Score))
                {
                    return GameStatus[1] + leadingPlayer;
                }
                else
                {
                    return GameStatus[2] + leadingPlayer;
                }
            }
        }

        public void WonPoint(string playerName)
        {
            if (playerName == player1.Name)
                player1.Score += 1;
            else
                player2.Score += 1;
        }
        
        public bool IsGameProgress(int player1score, int player2score)
        {
            if(player1score < 4 && player2score <4 && player1score + player2score < 6)
            {
                return true;
            }
            return false;
        }
        
        public bool IsSameScore(int player1Score , int player2Score)
        {
            if (player1Score == player2Score)
            {
                return true;
            }
            return false;
        }

        public string GetLeadingPlayer(Player player1, Player player2)
        {
            if (player1.Score > player2.Score)
            {
                return player1.Name;
            }
            return player2.Name;
        }
        public bool IsAbsoluteValue(int player1, int player2)
        {
            if((player1-player2) * (player1-player2) == 1)
            {
                return true;
            }
            return false;
        }
    }
}