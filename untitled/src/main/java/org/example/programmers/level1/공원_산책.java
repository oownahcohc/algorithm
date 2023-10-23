package org.example.programmers.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 공원_산책 {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        String[] park = new String[st.countTokens()];
        for (int i = 0; i < park.length; i++) {
            park[i] = st.nextToken();
        }

        bufferedReader = new BufferedReader(inputStreamReader);
        String[] routes = bufferedReader.readLine().split(",");
        for (int i = 0; i < routes.length; i++) {
            routes[i] = routes[i].replaceAll("^\\s+", "");
        }
        int[] solution = solution(park, routes);

        System.out.println(Arrays.toString(solution));
    }

    private static int[] solution(String[] park, String[] routes) {
        int startRow = 0;
        int startColumn = 0;
        List<Position> immovablePositions = new ArrayList<>();
        for (int i = 0; i < park.length; i++) {
            String line = park[i];
            if (line.contains("S")) {
                startColumn = line.indexOf("S");
                startRow = i;
            }
            if (line.contains("X")) {
                String[] immovableLine = line.split("");
                for (int j = 0; j < immovableLine.length; j++) {
                    if (immovableLine[j].equals("X")) {
                        Position immovable = new Position(j, i);
                        immovablePositions.add(immovable);
                    }
                }
            }
        }

        Position startPosition = new Position(startColumn, startRow);
        ParkMap parkMap = new ParkMap(
                park[0].split("").length - 1,
                park.length - 1,
                immovablePositions
        );

        Position result = new Position(startPosition);
        for (String route : routes) {
            char direction = route.charAt(0);
            int count = Integer.parseInt(String.valueOf(route.charAt(2)));
            parkMap.move(direction, count, result);
        }

        return new int[] {result.row, result.column};
    }

    private static class Position {

        private int column;
        private int row;

        public Position(int column, int row) {
            this.column = column;
            this.row = row;
        }

        public Position(Position another) {
            this.column = another.column;
            this.row = another.row;
        }

        public void moveDown() {
            this.row++;
        }

        public void moveUp() {
            this.row--;
        }

        public void moveLeft() {
            this.column--;
        }

        public void moveRight() {
            this.column++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return column == position.column && row == position.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(column, row);
        }
    }

    private static class ParkMap {

        private static final int MIN_COLUMN = 0;
        private static final int MIN_ROW = 0;

        private final int maxColumn;
        private final int maxRow;
        private final List<Position> immovable;

        public ParkMap(int maxColumn, int maxRow, List<Position> immovable) {
            this.maxColumn = maxColumn;
            this.maxRow = maxRow;
            this.immovable = immovable;
        }

        public void move(char direction, int count, Position currentPosition) {
            Position tempPosition = new Position(currentPosition);
            boolean isMoved = moveIfPossible(direction, count, tempPosition);
            if (isMoved) {
                currentPosition.row = tempPosition.row;
                currentPosition.column = tempPosition.column;
            }
        }

        private boolean moveIfPossible(char direction, int count, Position tempPosition) {
            boolean canMove = false;
            for (int i = 0; i < count; i++) {
                switch (direction) {
                    case 'S' -> tempPosition.moveDown();
                    case 'N' -> tempPosition.moveUp();
                    case 'E' -> tempPosition.moveRight();
                    case 'W' -> tempPosition.moveLeft();
                }
                canMove = !immovable.contains(tempPosition);
                if (!canMove) {
                    break;
                }
                if (tempPosition.column > maxColumn || tempPosition.column < MIN_COLUMN) {
                    canMove = false;
                    break;
                }
                if (tempPosition.row > maxRow || tempPosition.row < MIN_ROW) {
                    canMove = false;
                    break;
                }
            }
            return canMove;
        }
    }

    private static int[] insufficientSolution(String[] park, String[] routes) {
        ArrayList<String[]>[] parkLists = new ArrayList[park.length];
        for (int i = 0; i < park.length; i++) {
            parkLists[i] = new ArrayList<>();
            parkLists[i].add(park[i].split(""));
        }
        int parkRows = parkLists.length - 1;
        int parkColumns = parkLists[0].get(0).length - 1;

        int[] start = new int[2];
        List<int[]> immovable = new ArrayList<>();
        for (int i = 0; i < parkLists.length; i++) {
            String[] strings = parkLists[i].get(0);
            for (int j = 0; j < strings.length; j++) {
                if (Objects.equals(strings[j], "S")) {
                    start[0] = i;
                    start[1] = j;
                }
                if (Objects.equals(strings[j], "X")) {
                    immovable.add(new int[]{i, j});
                }
            }
        }

        ArrayList<String[]>[] routesLists = new ArrayList[routes.length];
        for (int i = 0; i < routes.length; i++) {
            routesLists[i] = new ArrayList<>();
            routesLists[i].add(routes[i].split(""));
        }

        int[] answer = new int[2];
        for (ArrayList<String[]> routesList : routesLists) {
            String direction = routesList.get(0)[0];
            int count = Integer.parseInt(routesList.get(0)[1]);
            int rows = start[0];
            int columns = start[1];

            for (int c = 1; c <= count; c++) {
                int tempRow = rows;
                int tempColumns = columns;
                switch (direction) {
                    case "S" -> tempRow = start[0] + c;
                    case "N" -> tempRow = start[0] - c;
                    case "E" -> tempColumns = start[1] + c;
                    case "W" -> tempColumns = start[1] - c;
                    default -> {
                    }
                }

                int[] compares = {tempRow, tempColumns};
                boolean canMove = immovable.stream().noneMatch(v -> Arrays.equals(v, compares));
                if (canMove) {
                    rows = tempRow;
                    columns = tempColumns;
                } else {
                    rows = start[0];
                    columns = start[1];
                    break;
                }
                if (tempRow > parkRows) {
                    rows = tempRow - c;
                }
                if (tempColumns > parkColumns) {
                    columns = tempColumns - c;
                }
            }
            start[0] = rows;
            start[1] = columns;
            answer[0] = rows;
            answer[1] = columns;
        }

        return answer;
    }
}
