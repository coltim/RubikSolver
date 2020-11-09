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
    private int maxDepth = 8;
    private String solution;
    String randomScrambleMoves;
    HashSet<String> solutionsSet = new HashSet<>();
    List<String> shortestSolutionsList = new ArrayList<>();
    List<String> solvedF2l = new ArrayList<>();
    int count = 0;
    int count2 = 0;


    public DepthFirstSearch(String randomScrambleMoves, Cube cube, String goal) {
        this.randomScrambleMoves = randomScrambleMoves;
        this.solution = "None";
        this.cube = cube;
        this.goal = goal;
    }

    public DepthFirstSearch(String randomScrambleMoves, Cube cube, String goal, List solvedF2l) {
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
            String temp = search(i, "", pathList);
            if (temp != null) {
                System.out.println("ez a temp--- " + temp + "  - " + i);
                break;
            }

        }

    }

    private String search(int currentDepth, String moves, List<Cube> path) {



        char possibleMoves[] = {'L', 'l', 'R', 'r', 'U', 'u', 'D', 'd', 'F', 'f', 'B', 'b'};
        if (currentDepth > 0 ) {
            for (char c : possibleMoves) {

                String movesConcat = moves.concat(Character.toString(c));
                Cube staticCube = new Cube(cube);
                tempCube = staticCube;
                rotation.movesTranslate(movesConcat, tempCube);
                if (tempCube.isEqual(cube)) {
                    count++;
                    //System.out.println(count+"[----" + movesConcat);
                }
                String temp = null;
                if (!path.contains(tempCube)){
                    path.add(tempCube);
                    temp = search(currentDepth - 1, movesConcat, path);
                    path.remove(path.size()-1);
                }

                /*if (!movesChecker(movesConcat)) {
                    //System.out.println(movesConcat);
                    temp = search(currentDepth - 1, movesConcat);
                }*/

                if (temp != null) {
                    return temp;
                }
            }
        } else {
           // System.out.println(moves + " letesztelt");
            if (testSolver(moves, goal)) {
                System.out.println("belulrol jon " + moves);

                return moves;
            } else {
                //System.out.println("nincs megoldas");
                return null;
            }

        }

        return null;
    }

    public boolean movesChecker(String moves) {
        Character c1;
        Character c2;
        boolean temp = false;
        if (moves.length() > 1) {
            for (int i = 0; i < moves.length() - 1; i++) {
                c1 = moves.charAt(i);
                c2 = Character.isUpperCase(moves.charAt(i + 1)) ? Character.toLowerCase(moves.charAt(i + 1)) : Character.toUpperCase(moves.charAt(i + 1));
                if (c1 == c2) {
                    //System.out.println("most-" + moves );
                    temp = true;
                }
            }
        }
        if (moves.length() > 3) {
            for (int i = 0; i < moves.length() - 3; i++) {
                if (moves.charAt(i) == (moves.charAt(i + 1) & moves.charAt(i + 2) & moves.charAt(i + 3))) {
                    temp = true;
                }
            }
        }


        return temp;
    }

    public boolean testSolver(String moves, String goal) {
        //System.out.println("-------");
        //System.out.println(moves);
        Cube staticCube = new Cube(cube);
        tempCube = staticCube;
//        System.out.println("tempcube");
//        tempCube.print();
//        System.out.println("cube");
//        bune.print();

        // rotation.movesTranslate(randomScrambleMoves, tempCube);
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
            case "firstLayerCorner2":
                goalBoolean = goals.firstLayerCorner2(tempCube);
                break;
            case "firstLayerCorner3":
                goalBoolean = goals.firstLayerCorner3(tempCube);
                break;
            case "firstLayerCorner4":
                goalBoolean = goals.firstLayerCorner4(tempCube);
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
            case "f2l":
                goalBoolean = goals.f2l(tempCube, solvedF2l);
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

    public List<String> shortestSolutions() {
        String shortest = "";
        List<String> solutionList = new ArrayList<String>(solutionsSet);
        //System.out.println(solutionList);
        String shortestSolution = solutionList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .findFirst()
                .orElse(null);

        for (String str : solutionList) {
            if (str.length() == shortestSolution.length()) {
                shortestSolutionsList.add(str);
            }
        }
        return shortestSolutionsList;
    }

}
