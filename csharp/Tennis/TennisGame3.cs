using System;

namespace Tennis
{
    public class TennisGame3 : ITennisGame
    {
        private int p1Score;
        private int p2Score;
        private readonly string p1Name;
        private readonly string p2Name;
        private static readonly string[] scoreNames = { "Love", "Fifteen", "Thirty", "Forty" };
        private const int EarlyGameScoreLimit = 4;
        private const int MaxPreDeuceScoreSum = 6;

        public TennisGame3(string player1Name, string player2Name)
        {
            this.p1Name = player1Name;
            this.p2Name = player2Name;
        }

        public string GetScore()
        {
            if (IsEarlyGame())
                return EarlyGameScore();
            return EndGameScore();
        }

        private bool IsEarlyGame() => p1Score < EarlyGameScoreLimit && p2Score < EarlyGameScoreLimit && p1Score + p2Score < MaxPreDeuceScoreSum;

        private string EarlyGameScore()
        {
            if (p1Score == p2Score)
                return scoreNames[p1Score] + "-All";
            return scoreNames[p1Score] + "-" + scoreNames[p2Score];
        }

        private string EndGameScore()
        {
            var scoreDifference = Math.Abs(p1Score - p2Score);
            var leaderName = p1Score > p2Score ? p1Name : p2Name;
            return scoreDifference switch
            {
                1 => $"Advantage {leaderName}",
                _ => $"Win for {leaderName}",
            };
        }
        public void WonPoint(string playerName)
        {
            if (playerName == p1Name)
                p1Score++;
            else
                p2Score++;
        }
    }
}