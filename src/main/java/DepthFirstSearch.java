import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class DepthFirstSearch {

    Rotations rotation = new Rotations();
    Cube cube = new Cube();
    Cube tempCube;
    Cube readyCube = new Cube();
    String goal;
    Goals goals = new Goals();
    private int maxDepth = 5;
    private String solution;
    String randomScrambleMoves;
    HashSet<String> solutionsSet = new HashSet<>();
    List<String> shortestSolutionsList = new ArrayList<>();



    public DepthFirstSearch(String randomScrambleMoves, Cube cube, String goal) {
        this.randomScrambleMoves = randomScrambleMoves;
        this.solution = "None";
        this.cube = cube;
        this.goal = goal;

    }


    public void search() {
        search(0, "");
    }

    private void search(int currentDepth, String moves) {

        char possibleMoves[] = {'L', 'l', 'R', 'r', 'U', 'u', 'D', 'd', 'F', 'f', 'B', 'b'};
        for (char c : possibleMoves) {
            if (currentDepth < maxDepth) {
                search(currentDepth + 1, moves.concat(Character.toString(c)));
            }

        }




        testSolver(moves, goal);

    }

    public void testSolver(String moves, String goal){
        //System.out.println("-------");
        //System.out.println(moves);
        tempCube = new Cube();

        rotation.movesTranslate(randomScrambleMoves, tempCube);
        //tempCube.print();


        rotation.movesTranslate(moves, tempCube);
        //tempCube.print();
        /*System.out.println("lepes" + moves);
        tempCube.print();
        cube.print();*/
        //System.out.println("-------");

        boolean goalBoolean;

        switch (goal) {
            case "whiteCross":
                goalBoolean = goals.whiteCrossIsSolved(tempCube);
                break;
            case "firstLayerCorner1":
                goalBoolean = goals.firstLayerCorner1(tempCube);
                break;
            case "fullCube":
                goalBoolean = goals.isSolved(tempCube);
                break;
            default:
                goalBoolean = false;
        }

        if (goalBoolean) {
            solution = moves;
            solutionsSet.add(solution);
        }
    }

    public List<String> shortestSolutions() {
        String shortest = "";
        List<String> solutionList = new ArrayList<String>(solutionsSet);
        String shortestSolution = solutionList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .findFirst()
                .orElse(null);

        for(String str : solutionList) {
            if(str.length() == shortestSolution.length()) {
                shortestSolutionsList.add(str);
            }
        }
        return shortestSolutionsList;
    }

}
