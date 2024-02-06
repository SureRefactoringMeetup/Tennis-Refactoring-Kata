#include <string>
#include <cmath>

const std::string SCORES[4] = {"Love", "Fifteen", "Thirty", "Forty"};

std::string tennis_score(int p1, int p2)
{
    auto resultForLeader = [](const std::string& leader, int scoreDifference) -> std::string {
        if (scoreDifference == 1)
        {
            return "Advantage " + leader;
        }
        else
        {
            return "Win for " + leader;
        }
    };

    if (p1 < 4 && p2 < 4 && (p1 + p2 < 6))
    {
        if (p1 == p2)
        {
            return SCORES[p1] + "-All";
        }
        else
        {
            return SCORES[p1] + "-" + SCORES[p2];
        }
    }
    else
    {
        if (p1 == p2)
            return "Deuce";
        std::string leader  = p1 > p2 ? "player1" : "player2";
        int  scoreDifference = std::abs(p1 - p2);
        return resultForLeader(leader, scoreDifference);
    }
}

