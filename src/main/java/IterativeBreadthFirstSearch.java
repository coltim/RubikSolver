import java.util.*;

public class IterativeBreadthFirstSearch {

    Rotations rotation = new Rotations();
    Cube cube = new Cube();
    Cube tempCube;
    Cube readyCube = new Cube();
    String goal;
    Goals goals = new Goals();
    private final int maxDepth = 7;
    private String solution;
    String randomScrambleMoves;
    HashSet<String> solutionsSet = new HashSet<>();
    List<String> shortestSolutionsList = new ArrayList<>();
    List solvedF2l = new ArrayList<>();
    int count = 0;
    int count2 = 0;


    public IterativeBreadthFirstSearch(String randomScrambleMoves, Cube cube, String goal) {
        this.randomScrambleMoves = randomScrambleMoves;
        this.solution = "None";
        this.cube = cube;
        this.goal = goal;
    }

    public IterativeBreadthFirstSearch(String randomScrambleMoves, Cube cube, String goal, List solvedF2l) {
        this.randomScrambleMoves = randomScrambleMoves;
        this.solution = "None";
        this.cube = cube;
        this.goal = goal;
        this.solvedF2l = solvedF2l;
    }


    public void search() {
        List<Cube> pathList = new ArrayList<>();
        pathList.add(cube);
        for (int i = 0; i <= maxDepth; i++) {
            solution = search(i, "", pathList);
            if (solution != null) {
                //System.out.println("Legrövidebb megoldás: " + solution);
                break;
            }
        }
    }

    private String search(int currentDepth, String moves, List<Cube> path) {
        char[] possibleMoves = {'L', 'l', 'R', 'r', 'U', 'u', 'D', 'd', 'F', 'f', 'B', 'b'};
        if (currentDepth > 0) {
            for (char c : possibleMoves) {
                String movesConcat = moves.concat(Character.toString(c));
                tempCube = new Cube(cube);
                rotation.movesTranslate(movesConcat, tempCube);
                String result = null;
                if (!path.contains(tempCube)) {
                    path.add(tempCube);
                    result = search(currentDepth - 1, movesConcat, path);
                    path.remove(path.size() - 1);
                }
                if (result != null) {
                    return result;
                }
            }
        } else {
            if (testSolver(moves, goal)) {
                return moves;
            } else {
                return null;
            }
        }
        return null;
    }


    public boolean testSolver(String moves, String goal) {
        boolean goalBoolean;
        Cube staticCube = new Cube(cube);
        tempCube = staticCube;

        rotation.movesTranslate(moves, tempCube);

        switch (goal) {
            case "whiteCross":
                goalBoolean = goals.whiteCrossIsSolved(tempCube);
                break;
            case "firstLayerCorner1":
                goalBoolean = goals.firstLayerCorner1(tempCube);
                break;
            case "firstLayerCorner2":
                goalBoolean = goals.firstLayerCorner2(tempCube);
                break;
            case "firstLayerCorner3":
                goalBoolean = goals.firstLayerCorner3(tempCube);
                break;
            case "firstLayerCorner4":
                goalBoolean = goals.firstLayerCorner4(tempCube);
                break;
            case "firstLayerCorner1GoalUpdate":
                goalBoolean = goals.firstLayerCorner1GoalUpdate(tempCube, solvedF2l);
                break;
            case "firstLayerCorner2GoalUpdate":
                goalBoolean = goals.firstLayerCorner2GoalUpdate(tempCube, solvedF2l);
                break;
            case "firstLayerCorner3GoalUpdate":
                goalBoolean = goals.firstLayerCorner3GoalUpdate(tempCube, solvedF2l);
                break;
            case "firstLayerCorner4GoalUpdate":
                goalBoolean = goals.firstLayerCorner4GoalUpdate(tempCube, solvedF2l);
                break;
            case "secondLayerEdge1":
                goalBoolean = goals.secondLayerEdge1(tempCube);
                break;
            case "secondLayerEdge2":
                goalBoolean = goals.secondLayerEdge2(tempCube);
                break;
            case "secondLayerEdge3":
                goalBoolean = goals.secondLayerEdge3(tempCube);
                break;
            case "secondLayerEdge4":
                goalBoolean = goals.secondLayerEdge4(tempCube);
                break;
            case "secondLayerEdge1GoalUpdate":
                goalBoolean = goals.secondLayerEdge1GoalUpdate(tempCube, solvedF2l);
                break;
            case "secondLayerEdge2GoalUpdate":
                goalBoolean = goals.secondLayerEdge2GoalUpdate(tempCube, solvedF2l);
                break;
            case "secondLayerEdge3GoalUpdate":
                goalBoolean = goals.secondLayerEdge3GoalUpdate(tempCube, solvedF2l);
                break;
            case "secondLayerEdge4GoalUpdate":
                goalBoolean = goals.secondLayerEdge4GoalUpdate(tempCube, solvedF2l);
                break;
            case "f2l1":
                goalBoolean = goals.f2l1(tempCube);
                break;
            case "f2l2":
                goalBoolean = goals.f2l2(tempCube);
                break;
            case "f2l3":
                goalBoolean = goals.f2l3(tempCube);
                break;
            case "f2l4":
                goalBoolean = goals.f2l4(tempCube);
                break;
            case "firstLayer":
                goalBoolean = goals.firstLayer(tempCube);
                break;
            case "f2l1GoalUpdate":
                goalBoolean = goals.f2l1GoalUpdate(tempCube, solvedF2l);
                break;
            case "f2l2GoalUpdate":
                goalBoolean = goals.f2l2GoalUpdate(tempCube, solvedF2l);
                break;
            case "f2l3GoalUpdate":
                goalBoolean = goals.f2l3GoalUpdate(tempCube, solvedF2l);
                break;
            case "f2l4GoalUpdate":
                goalBoolean = goals.f2l4GoalUpdate(tempCube, solvedF2l);
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

        return goalBoolean;
    }

    public String getSolution() {
        return solution;
    }

    public List<String> shortestSolutions() {
        String shortest = "";

        String shortestSolution;
        List<String> solutionList = new ArrayList<String>(solutionsSet);

        shortestSolution = solutionList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .findFirst()
                .orElse(null);


        solutionList.forEach((n) -> {
            if (shortestSolution != null && n.length() == shortestSolution.length()) {
                shortestSolutionsList.add(n);
            }
        });

        return shortestSolutionsList;
    }

}
