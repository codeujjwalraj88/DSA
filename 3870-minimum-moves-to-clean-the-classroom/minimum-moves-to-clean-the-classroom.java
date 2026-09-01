class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // litter cell ka index store karega
        int[][] litter = new int[m][n];

        int startRow = 0;
        int startCol = 0;
        int count = 0;

        // S aur L find karo
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startRow = i;
                    startCol = j;
                }

                else if (ch == 'L') {
                    litter[i][j] = count;
                    count++;
                }
            }
        }

        // Agar litter hi nahi hai
        if (count == 0) {
            return 0;
        }

        // visited[row][col][energy][mask]
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << count];

        // state = row, col, energy, mask
        Queue<int[]> q = new LinkedList<>();

        int initialMask = (1 << count) - 1;

        q.add(new int[] {
            startRow,
            startCol,
            energy,
            initialMask
        });

        visited[startRow][startCol][energy][initialMask] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // Current BFS level
            for (int i = 0; i < size; i++) {

                int[] curr = q.remove();

                int row = curr[0];
                int col = curr[1];
                int currEnergy = curr[2];
                int mask = curr[3];

                // Saara litter collect ho gaya
                if (mask == 0) {
                    return moves;
                }

                // Energy khatam hai
                if (currEnergy == 0) {
                    continue;
                }

                // 4 directions
                for (int d = 0; d < 4; d++) {

                    int nr = row + dr[d];
                    int nc = col + dc[d];

                    // Boundary check
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    char ch = classroom[nr].charAt(nc);

                    // Energy update
                    int newEnergy;

                    if (ch == 'R') {
                        newEnergy = energy;
                    } else {
                        newEnergy = currEnergy - 1;
                    }

                    // Mask same rahega initially
                    int newMask = mask;

                    // Agar litter hai
                    if (ch == 'L') {

                        int index = litter[nr][nc];

                        newMask &= ~(1 << index);
                    }

                    // Agar state pehle visit nahi hua
                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        q.add(new int[] {
                            nr,
                            nc,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}