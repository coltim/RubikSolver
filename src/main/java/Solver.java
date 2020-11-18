import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    public Solver() {
    }

    public void solver() {
        Cube cube = new Cube();
        List<String> shortestSolutionsList = new ArrayList<>();
        Rotations rotation = new Rotations();
        DepthFirstSearch dfs;
        Goals goals = new Goals();
        cube.print();

        Scramble scramble = new Scramble(30, cube);
        scramble.getRandomMoves();
        cube.print();

        String randomScrambleMoves = scramble.getRandomMoves();

        goalSolver(cube, "whiteCross");
        /*readyF2l(cube);
        goalSolver(cube, shortestF2l(cube).get(1), readyF2l(cube));
        cube.print();
        System.out.println("masodik************************************************************");
        System.out.println(readyF2l(cube));
        goalSolver(cube, shortestF2l(cube).get(1), readyF2l(cube));
        cube.print();
        System.out.println("harom************************************************************");
        System.out.println(readyF2l(cube));
        goalSolver(cube, shortestF2l(cube).get(1), readyF2l(cube));
        cube.print();
        System.out.println("negy************************************************************");
        System.out.println(readyF2l(cube));
        goalSolver(cube, shortestF2l(cube).get(1), readyF2l(cube));
        cube.print();*/


        /*goalSolver(cube, shortestFirstLayerCorner(cube).get(1), readyfirstLayerCorner(cube));
        cube.print();
        System.out.println("-------************************************************************");
        System.out.println(readyfirstLayerCorner(cube));*/
        while (!goals.firstLayer(cube)){
            goalSolver(cube, shortestFirstLayerCorner(cube).get(1), readyfirstLayerCorner(cube));
            cube.print();
            System.out.println("-------************************************************************");
            System.out.println(readyfirstLayerCorner(cube));
        }

        while (!goals.secondLayer(cube)){
            goalSolver(cube, shortestSecondLayerEdge(cube).get(1), readySecondLayerEdge(cube));
            cube.print();
            System.out.println("-------************************************************************");
            System.out.println(readySecondLayerEdge(cube));
        }


    }

    public void goalSolver(Cube cube, String goal) {

        List<String> shortestSolutionsList;
        Rotations rotation = new Rotations();
        DepthFirstSearch dfs;
        System.out.println("-------1");

        dfs = new DepthFirstSearch("", cube, goal);
        dfs.search();

        System.out.println("Legrovidebb megoldasok, " + goal + dfs.shortestSolutions());

        shortestSolutionsList = dfs.shortestSolutions();
        String firstLayer = shortestSolutionsList.get(0);

        rotation.movesTranslate(firstLayer, cube);
        cube.print();

        System.out.println("-------");
    }
    public void goalSolver(Cube cube, String goal, List solvedGoals) {

        List<String> shortestSolutionsList = new ArrayList<>();
        Rotations rotation = new Rotations();
        DepthFirstSearch dfs;
        System.out.println("-------");

        /*dfs = new DepthFirstSearch("", cube, goal, solvedGoals);
        dfs.search();

        System.out.println("Legrovidebb megoldasok, " + goal + dfs.shortestSolutions());

        shortestSolutionsList = dfs.shortestSolutions();
        String firstLayer = shortestSolutionsList.get(0);*/

        rotation.movesTranslate(goal, cube);
        cube.print();

        System.out.println("-------");
    }

    public int goalTester(Cube cube, String goal) {

        List<String> shortestSolutionsList = new ArrayList<>();
        Rotations rotation = new Rotations();
        DepthFirstSearch dfs;
        int shortestSol = 0;
        System.out.println("-------");

        dfs = new DepthFirstSearch("", cube, goal);
        dfs.search();

        System.out.println("Legrovidebb megoldasok, " + goal + dfs.shortestSolutions());

        if (!dfs.shortestSolutions().isEmpty()) {
            shortestSol = dfs.shortestSolutions().get(0).length();
        }
        System.out.println("-------");
        return shortestSol;


    }

    //megnezi melyik blokk van mar kesz.
    public List<String> readyF2l(Cube cube) {
        Goals goal = new Goals();
        List<String> solvedGoals = new ArrayList();
        String[] goals = {"f2l1", "f2l2", "f2l3", "f2l4"};
        for (String temp : goals) {
            //System.out.println(f2lSelecter(temp, cube));
            if (!f2lSelecter(temp, cube).isEmpty())
                solvedGoals.add(f2lSelecter(temp, cube).get(0).toString());

        }

        //System.out.println("solvedgoals--" + solvedGoals);
    return solvedGoals;
    }

    public List<String> readyfirstLayerCorner(Cube cube) {
        Goals goal = new Goals();
        List<String> solvedGoals = new ArrayList();
        String[] goals = {"firstLayerCorner1", "firstLayerCorner2", "firstLayerCorner3", "firstLayerCorner4"};
        for (String temp : goals) {
            //System.out.println(f2lSelecter(temp, cube));
            if (!firstLayerCornerSelecter(temp, cube).isEmpty())
                solvedGoals.add(firstLayerCornerSelecter(temp, cube).get(0).toString());

        }

        //System.out.println("solvedgoals--" + solvedGoals);
        return solvedGoals;
    }

    public List<String> readySecondLayerEdge(Cube cube) {
        Goals goal = new Goals();
        List<String> solvedGoals = new ArrayList();
        String[] goals = {"secondLayerEdge1", "secondLayerEdge2", "secondLayerEdge3", "secondLayerEdge4"};
        for (String temp : goals) {
            //System.out.println(f2lSelecter(temp, cube));
            if (!secondLayerEdgeSelecter(temp, cube).isEmpty())
                solvedGoals.add(secondLayerEdgeSelecter(temp, cube).get(0).toString());

        }

        //System.out.println("solvedgoals--" + solvedGoals);
        return solvedGoals;
    }


    public List<String> shortestF2l(Cube cube) {

        List<String> shortestSolutionsList = new ArrayList<>();
        Rotations rotation = new Rotations();
        DepthFirstSearch dfs;
        System.out.println("-------");
        String shortestGoal = null;
        Cube tempCube;
        Cube staticCube = new Cube(cube);
        tempCube = staticCube;
        Goals goal = new Goals();
        List<String> readyList = new ArrayList();
        List<String> goalAndSolutionList = new ArrayList();
        String[] goals = {"f2l1GoalUpdate", "f2l2GoalUpdate", "f2l3GoalUpdate", "f2l4GoalUpdate"};

        for (String temp : goals) {
            dfs = new DepthFirstSearch("", tempCube, temp, readyF2l(cube));
            dfs.search();
            if (!dfs.shortestSolutions().isEmpty()) {
                if (dfs.shortestSolutions().get(0) != "") {
                    if (readyList.isEmpty()) {
                        readyList.add(dfs.shortestSolutions().get(0));
                        shortestGoal = temp;
                    }
                    //System.out.println("1   " + readyList + "   " + readyList.isEmpty());
                    //System.out.println("1-   " + dfs.shortestSolutions());
                    if (!readyList.isEmpty() && !dfs.shortestSolutions().isEmpty() &&
                            readyList.get(0).length() > dfs.shortestSolutions().get(0).length()) {
                        //System.out.println("2   " + readyList);
                        //System.out.println("3   " + dfs.shortestSolutions());
                        readyList.clear();
                        readyList.add(dfs.shortestSolutions().get(0));
                        shortestGoal = temp;
                    }
                }
            }
        }
        System.out.println("ez a lista" + readyList);
        System.out.println(shortestGoal);
        goalAndSolutionList.add(shortestGoal);
        goalAndSolutionList.add(readyList.get(0));
        //tempCube.print();

        //System.out.println("Legrovidebb megoldasok, " +  + dfs.shortestSolutions());

        // shortestSolutionsList = dfs.shortestSolutions();
        //String firstLayer = shortestSolutionsList.get(0);

        return goalAndSolutionList;
    }

    public List<String> shortestFirstLayerCorner(Cube cube) {

        List<String> shortestSolutionsList = new ArrayList<>();
        Rotations rotation = new Rotations();
        DepthFirstSearch dfs;
        System.out.println("-------");
        String shortestGoal = null;
        Cube tempCube;
        Cube staticCube = new Cube(cube);
        tempCube = staticCube;
        Goals goal = new Goals();
        List<String> readyList = new ArrayList();
        List<String> goalAndSolutionList = new ArrayList();
        String[] goals = {"firstLayerCorner1GoalUpdate",
                        "firstLayerCorner2GoalUpdate",
                        "firstLayerCorner3GoalUpdate",
                        "firstLayerCorner4GoalUpdate"};

        for (String temp : goals) {
            dfs = new DepthFirstSearch("", tempCube, temp, readyfirstLayerCorner(cube));
            dfs.search();
            if (!dfs.shortestSolutions().isEmpty()) {
                if (dfs.shortestSolutions().get(0) != "") {
                    if (readyList.isEmpty()) {
                        readyList.add(dfs.shortestSolutions().get(0));
                        shortestGoal = temp;
                    }
                    //System.out.println("1   " + readyList + "   " + readyList.isEmpty());
                    //System.out.println("1-   " + dfs.shortestSolutions());
                    if (!readyList.isEmpty() && !dfs.shortestSolutions().isEmpty() &&
                            readyList.get(0).length() > dfs.shortestSolutions().get(0).length()) {
                        //System.out.println("2   " + readyList);
                        //System.out.println("3   " + dfs.shortestSolutions());
                        readyList.clear();
                        readyList.add(dfs.shortestSolutions().get(0));
                        shortestGoal = temp;
                    }
                }
            }
        }
        System.out.println("ez a lista" + readyList);
        System.out.println(shortestGoal);
        goalAndSolutionList.add(shortestGoal);
        goalAndSolutionList.add(readyList.get(0));
        //tempCube.print();

        //System.out.println("Legrovidebb megoldasok, " +  + dfs.shortestSolutions());

        // shortestSolutionsList = dfs.shortestSolutions();
        //String firstLayer = shortestSolutionsList.get(0);

        return goalAndSolutionList;
    }

    public List<String> shortestSecondLayerEdge(Cube cube) {

        List<String> shortestSolutionsList = new ArrayList<>();
        Rotations rotation = new Rotations();
        DepthFirstSearch dfs;
        System.out.println("-------");
        String shortestGoal = null;
        Cube tempCube;
        Cube staticCube = new Cube(cube);
        tempCube = staticCube;
        Goals goal = new Goals();
        List<String> readyList = new ArrayList();
        List<String> goalAndSolutionList = new ArrayList();
        String[] goals = {"secondLayerEdge1GoalUpdate",
                "secondLayerEdge2GoalUpdate",
                "secondLayerEdge3GoalUpdate",
                "secondLayerEdge4GoalUpdate"};

        for (String temp : goals) {
            dfs = new DepthFirstSearch("", tempCube, temp, readySecondLayerEdge(cube));
            dfs.search();
            if (!dfs.shortestSolutions().isEmpty()) {
                if (dfs.shortestSolutions().get(0) != "") {
                    if (readyList.isEmpty()) {
                        readyList.add(dfs.shortestSolutions().get(0));
                        shortestGoal = temp;
                    }
                    //System.out.println("1   " + readyList + "   " + readyList.isEmpty());
                    //System.out.println("1-   " + dfs.shortestSolutions());
                    if (!readyList.isEmpty() && !dfs.shortestSolutions().isEmpty() &&
                            readyList.get(0).length() > dfs.shortestSolutions().get(0).length()) {
                        //System.out.println("2   " + readyList);
                        //System.out.println("3   " + dfs.shortestSolutions());
                        readyList.clear();
                        readyList.add(dfs.shortestSolutions().get(0));
                        shortestGoal = temp;
                    }
                }
            }
        }
        System.out.println("ez a lista" + readyList);
        System.out.println(shortestGoal);
        goalAndSolutionList.add(shortestGoal);
        goalAndSolutionList.add(readyList.get(0));
        //tempCube.print();

        //System.out.println("Legrovidebb megoldasok, " +  + dfs.shortestSolutions());

        // shortestSolutionsList = dfs.shortestSolutions();
        //String firstLayer = shortestSolutionsList.get(0);

        return goalAndSolutionList;
    }

    public List f2lSelecter(String goal, Cube cube) {
        Goals goal1 = new Goals();
        boolean isReady;
        String readyF2l = "nincs";
        List readyList = new ArrayList();
        switch (goal) {
            case "f2l1":
                isReady = goal1.f2l1(cube);
                if (isReady)
                    readyList.add("f2l1");
                break;
            case "f2l2":
                isReady = goal1.f2l2(cube);
                if (isReady)
                    readyList.add("f2l2");
                break;
            case "f2l3":
                isReady = goal1.f2l3(cube);
                if (isReady)
                    readyList.add("f2l3");
                break;
            case "f2l4":
                isReady = goal1.f2l4(cube);
                if (isReady)
                    readyList.add("f2l4");
                break;
            default:
                isReady = false;
                readyF2l = "nincs";
        }
        return readyList;

    }

    public List firstLayerCornerSelecter(String goal, Cube cube) {
        Goals goal1 = new Goals();
        boolean isReady;
        String readyirstLayerCorner = "nincs";
        List readyList = new ArrayList();
        switch (goal) {
            case "firstLayerCorner1":
                isReady = goal1.firstLayerCorner1(cube);
                if (isReady)
                    readyList.add("firstLayerCorner1");
                break;
            case "firstLayerCorner2":
                isReady = goal1.firstLayerCorner2(cube);
                if (isReady)
                    readyList.add("firstLayerCorner2");
                break;
            case "firstLayerCorner3":
                isReady = goal1.firstLayerCorner3(cube);
                if (isReady)
                    readyList.add("firstLayerCorner3");
                break;
            case "firstLayerCorner4":
                isReady = goal1.firstLayerCorner4(cube);
                if (isReady)
                    readyList.add("firstLayerCorner4");
                break;
            default:
                isReady = false;
                readyirstLayerCorner = "nincs";
        }
        return readyList;

    }

    public List secondLayerEdgeSelecter(String goal, Cube cube) {
        Goals goal1 = new Goals();
        boolean isReady;
        String readyirstLayerCorner = "nincs";
        List readyList = new ArrayList();
        switch (goal) {
            case "secondLayerEdge1":
                isReady = goal1.secondLayerEdge1(cube);
                if (isReady)
                    readyList.add("secondLayerEdge1");
                break;
            case "secondLayerEdge2":
                isReady = goal1.secondLayerEdge2(cube);
                if (isReady)
                    readyList.add("secondLayerEdge2");
                break;
            case "secondLayerEdge3":
                isReady = goal1.secondLayerEdge3(cube);
                if (isReady)
                    readyList.add("secondLayerEdge3");
                break;
            case "secondLayerEdge4":
                isReady = goal1.secondLayerEdge4(cube);
                if (isReady)
                    readyList.add("secondLayerEdge4");
                break;
            default:
                isReady = false;
                readyirstLayerCorner = "nincs";
        }
        return readyList;

    }


}
