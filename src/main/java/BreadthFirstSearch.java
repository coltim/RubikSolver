import java.util.*;

public class BreadthFirstSearch {

    Rotations rotation = new Rotations();
    Cube cube = new Cube();
    Scramble scramble;
    Cube tempCube = new Cube();
    private Queue<String> queue;
    //private int maxDepth = 1;
    int maxSteps = 6;
    private String solution;
    String randomScrambleMoves;
    /*List<String> solutionsList = new ArrayList<>();
    List<String> shortestSolutionsList = new ArrayList<>();*/
    HashSet<String> solutionsSet = new HashSet<>();
    List<String> shortestSolutionsList = new ArrayList<>();
    private int queueSize;


    public BreadthFirstSearch(String randomScrambleMoves, Cube cube) {
        this.randomScrambleMoves = randomScrambleMoves;
        this.solution = "None";
        this.cube = cube;
        queue = new LinkedList<>(Arrays.asList("L", "l", "R", "r", "U", "u", "D", "d", "F", "f", "B", "b"));
    }


    public void search() {

        String retVal = "";
        String moves = "";
        int count = 0;

        ArrayList<String> nextMoves = new ArrayList<>();
        nextMoves.addAll(Arrays.asList("L", "l", "R", "r", "U", "u", "D", "d", "F", "f", "B", "b"));

        while (!queue.isEmpty()) {

            //nextMoves.clear();
            //nextMoves.addAll(Arrays.asList("F", "f", "B", "b", "L", "l", "R", "r", "U", "u", "D", "d"));
            // Get next moves
            moves = queue.remove();
            //int maxSteps = 6;

//            if (moves.length() > maxSteps)
//                continue;

            // Add all children to the queue
            if (moves.length() < maxSteps) {
                for (String move : nextMoves) {
                    queue.add(moves.concat(move));
                }
                //System.out.println(queue.size());
            }

            // Test possible solution
            tempCube = new Cube();
            rotation.movesTranslate(randomScrambleMoves, tempCube);
            rotation.movesTranslate(moves, tempCube);
            //System.out.println(moves);

//            System.out.println("Total Memory (in bytes): " + Runtime.getRuntime().totalMemory());
//            System.out.println("Free Memory (in bytes): " + Runtime.getRuntime().freeMemory());
//            System.out.println("Max Memory (in bytes): " + Runtime.getRuntime().maxMemory());

            if (tempCube.isSolved(tempCube)) {
                retVal = moves;
                solutionsSet.add(retVal);
                //tempCube.print();
               // System.out.println("megoldas: " + retVal);
                //queueSize = queue.size();

            }
            //count++;
            //System.out.println(count);
            //System.out.println(queue.size());

            if (count > 500000){
                System.gc();
                count = 0;
            }


        }
    }

    public List<String> shortestSolutions() {
        String shortest = "";

        List<String> solutionList = new ArrayList<String>(solutionsSet);

        String shortestSolution = solutionList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .findFirst()
                .orElse(null);

        //shortestSolutionsList.add(shortestSolution);

        for (String str : solutionList) {
            if (str.length() == shortestSolution.length()) {
                shortestSolutionsList.add(str);
            }
        }

        /*for (String str : solutionsSet) {
            if (str.length() < maxDepth) {
                shortest = str;
            }
        }
        for (String str : solutionsSet) {
            if (str.length() == shortest.length()) {
                shortestSolutionsList.add(str);

            }
        }*/
        return shortestSolutionsList;
    }
}
