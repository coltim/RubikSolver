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
        cube.print();

        Scramble scramble = new Scramble(25, cube);
        scramble.getRandomMoves();
        cube.print();

        String randomScrambleMoves = scramble.getRandomMoves();
        //rotation.movesTranslate(randomScrambleMoves, cube);

        /*dfs = new DepthFirstSearch(randomScrambleMoves, cube, "whiteCross");
        dfs.search();

        System.out.println("Legrovidebb megoldasok, kereszt: " + dfs.shortestSolutions());


        shortestSolutionsList = dfs.shortestSolutions();
        String whiteCrossShortestSolution = shortestSolutionsList.get(0);

        rotation.movesTranslate(whiteCrossShortestSolution, cube);

        cube.print();
        System.out.println("-------");
        //goalSolver("whiteCross");

        dfs = new DepthFirstSearch("", cube, "firstLayerCorner1");
        dfs.search();

        System.out.println("Legrovidebb megoldasok, elso sarok: " + dfs.shortestSolutions());

        shortestSolutionsList = dfs.shortestSolutions();
        String corner1 = shortestSolutionsList.get(0);

        rotation.movesTranslate(corner1, cube);

        System.out.println(cube.getElement(36) + " " +
                            cube.getElement(0) + " " +
                            cube.getElement(29));
        cube.print();

        System.out.println("-------");
        goalSolver(cube, "firstLayerCorner2");
        System.out.println("-------");

        dfs = new DepthFirstSearch("", cube, "firstLayerCorner3");
        dfs.search();

        System.out.println("Legrovidebb megoldasok, harmadik sarok: " + dfs.shortestSolutions());

        shortestSolutionsList = dfs.shortestSolutions();
        String corner3 = shortestSolutionsList.get(0);

        rotation.movesTranslate(corner3, cube);

        System.out.println(cube.getElement(44) + " " +
                cube.getElement(11) + " " +
                cube.getElement(18));
        cube.print();

        System.out.println("-------");
        System.out.println("-------");

        dfs = new DepthFirstSearch("", cube, "firstLayerCorner4");
        dfs.search();

        System.out.println("Legrovidebb megoldasok, negyedik sarok: " + dfs.shortestSolutions());

        shortestSolutionsList = dfs.shortestSolutions();
        String corner4 = shortestSolutionsList.get(0);

        rotation.movesTranslate(corner4, cube);

        System.out.println(cube.getElement(38) + " " +
                cube.getElement(20) + " " +
                cube.getElement(27));
        cube.print();

        System.out.println("-------");

        goalSolver(cube, "firstLayer");





        /*dfs = new DepthFirstSearch(randomScrambleMoves, cube, "fullCube");
        dfs.search();

        System.out.println("Legrovidebb megoldasok: " + dfs.shortestSolutions());
        System.out.println("-------");*/

        goalSolver(cube, "whiteCross");
       /* goalSolver(cube, "firstLayerCorner1");
        goalSolver(cube, "firstLayerCorner2");
        goalSolver(cube, "firstLayerCorner3");
        goalSolver(cube, "firstLayerCorner4");
        goalSolver(cube, "secondLayerEdge1");
        goalSolver(cube, "secondLayerEdge2");
        goalSolver(cube, "secondLayerEdge3");
        goalSolver(cube, "secondLayerEdge4");*/

        //shortestF2l(cube);
        readyF2l(cube);
        goalSolver(cube, shortestF2l(cube).get(1), readyF2l(cube));
        cube.print();
        System.out.println("masodik************************************************************");
        System.out.println("masodik************************************************************");
        System.out.println("masodik************************************************************");
        System.out.println(readyF2l(cube));
        goalSolver(cube, shortestF2l(cube).get(1), readyF2l(cube));
        cube.print();
        System.out.println("harom************************************************************");
        System.out.println("harom************************************************************");
        System.out.println("harom************************************************************");
        System.out.println(readyF2l(cube));
        goalSolver(cube, shortestF2l(cube).get(1), readyF2l(cube));
        cube.print();
        System.out.println("negy************************************************************");
        System.out.println("negy************************************************************");
        System.out.println("negy************************************************************");
        System.out.println(readyF2l(cube));
        goalSolver(cube, shortestF2l(cube).get(1), readyF2l(cube));
        cube.print();

        //goalSolver(cube, shortestF2l(cube));
        //goalSolver(cube, shortestF2l(cube));
        //goalSolver(cube, shortestF2l(cube));


        /*System.out.println("legrovidebb f2l1//////////////");
        cube.print();
        //String temp = shortestSolutionsList.get(0);
        rotation.movesTranslate(shortestF2l(cube), cube);
        cube.print();
        System.out.println("legrovidebb f2l 1vege////////////");
        readyF2l(cube);System.out.println("legrovidebb f2l2//////////////");
        cube.print();
        //String temp = shortestSolutionsList.get(0);
        rotation.movesTranslate(shortestF2l(cube), cube);
        cube.print();
        System.out.println("legrovidebb f2l 2vege////////////");
        readyF2l(cube);System.out.println("legrovidebb f2l3//////////////");
        cube.print();
        //String temp = shortestSolutionsList.get(0);
        rotation.movesTranslate(shortestF2l(cube), cube);
        cube.print();
        System.out.println("legrovidebb f2l 3vege////////////");
        readyF2l(cube);System.out.println("legrovidebb f2l4//////////////");
        cube.print();
        //String temp = shortestSolutionsList.get(0);
        rotation.movesTranslate(shortestF2l(cube), cube);
        cube.print();
        System.out.println("legrovidebb f2l 4vege////////////");
        readyF2l(cube);*/
//        if (goalTester(cube, "f2l1") > 0)
        //goalTester(cube, "f2l1");
//        shortestF2l(cube);
//        if (goalTester(cube, "f2l2") > 0)
        //goalTester(cube, "f2l2");
//        shortestF2l(cube);
//        if (goalTester(cube, "f2l3") > 0)
        //goalTester(cube, "f2l3");
//        shortestF2l(cube);
//        if (goalTester(cube, "f2l4") > 0)
        //goalTester(cube, "f2l4");
//        shortestF2l(cube);


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


}
