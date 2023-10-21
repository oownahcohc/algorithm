package org.example.programmers.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 달리기_경주 {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int playerCounts = st.countTokens();
        String[] players = new String[playerCounts];
        for (int i = 0; i < playerCounts; i++) {
            players[i] = st.nextToken();
        }

        st = new StringTokenizer(bufferedReader.readLine());
        int callingCounts = st.countTokens();
        String[] callings = new String[callingCounts];
        for (int i = 0; i < callingCounts; i++) {
            callings[i] = st.nextToken();
        }

        System.out.println(Arrays.toString(solution(players, callings)));
    }

    private static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> mappedByPlayer = new HashMap<>();
        Map<Integer, String> mappedByRank = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            mappedByPlayer.put(players[i], i);
            mappedByRank.put(i, players[i]);
        }

        for (String calling : callings) {
            Integer rank = mappedByPlayer.get(calling);
            String overtakenPlayer = mappedByRank.get(rank - 1);
            mappedByPlayer.replace(overtakenPlayer, rank);
            mappedByPlayer.replace(calling, rank - 1);
            mappedByRank.replace(rank, overtakenPlayer);
            mappedByRank.replace(rank - 1, calling);
        }

        String[] result = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            result[i] = mappedByRank.get(i);
        }
        return result;
    }

    private static String[] timeOutSolution(String[] players, String[] callings) {
        for (String calling : callings) {
            for (int j = 0; j < players.length; j++) {
                if (Objects.equals(calling, players[j])) {
                    String overtaking = players[j];
                    players[j] = players[j - 1];
                    players[j - 1] = overtaking;
                }
            }
        }
        return players;
    }
}
