import java.util.ArrayList;
import java.util.List;

public class Solver {

    public Solver() {
    }

    public void solver(int scrambleNumber, String method) {
        Cube cube = new Cube();
        cube.print();
        Scramble scramble = new Scramble(scrambleNumber, cube);
        scramble.getRandomMoves();
        cube.print();

        switch(method) {
            case "LayerByLayer":
                layerByLayer(cube);
                break;
            case "First2Layer":
                first2Layer(cube);
                break;
        }

    }

    public void layerByLayer(Cube cube){
        Goals goals = new Goals();
        System.out.println("-------White Cross");
        goalSolver(cube, "whiteCross");
        cube.print();
        while (!goals.firstLayer(cube)){
            System.out.println("-------First Layer Corner");
            goalSolver(cube, shortestFirstLayerCorner(cube).get(1), readyfirstLayerCorner(cube));
            cube.print();
        }

        while (!goals.secondLayer(cube)){
            System.out.println("-------Second Layer Edge");
            goalSolver(cube, shortestSecondLayerEdge(cube).get(1), readySecondLayerEdge(cube));
            cube.print();
        }
    }

    public void first2Layer(Cube cube){
        Goals goals = new Goals();
        System.out.println("-------White Cross");
        goalSolver(cube, "whiteCross");
        cube.print();
        while (!goals.secondLayer(cube)){
            System.out.println("-------F2L");
            goalSolver(cube, shortestF2l(cube).get(1), readyF2l(cube));
            cube.print();
        }
    }

    public void goalSolver(Cube cube, String goal) {

        Rotations rotation = new Rotations();
        IterativeBreadthFirstSearch ibfs;

        ibfs = new IterativeBreadthFirstSearch("", cube, goal);
        ibfs.search();

        if (ibfs.getSolution() != null){
            rotation.movesTranslate(ibfs.getSolution(), cube);
        } else {
            System.out.println("Ebben a mélységben nincs megoldás");
            System.exit(0);
        }

        System.out.println("-------");
    }
    public void goalSolver(Cube cube, String goal, List solvedGoals) {

        Rotations rotation = new Rotations();

        rotation.movesTranslate(goal, cube);

        System.out.println("-------");
    }

    //megnezi melyik blokk van mar kesz.
    public List<String> readyF2l(Cube cube) {
        List<String> solvedGoals = new ArrayList();
        String[] goals = {"f2l1", "f2l2", "f2l3", "f2l4"};
        for (String temp : goals) {
            if (!f2lSelecter(temp, cube).isEmpty())
                solvedGoals.add(f2lSelecter(temp, cube).get(0).toString());
        }
        return solvedGoals;
    }

    public List<String> readyfirstLayerCorner(Cube cube) {
        List<String> solvedGoals = new ArrayList();
        String[] goals = {"firstLayerCorner1", "firstLayerCorner2", "firstLayerCorner3", "firstLayerCorner4"};
        for (String temp : goals) {
            if (!firstLayerCornerSelecter(temp, cube).isEmpty())
                solvedGoals.add(firstLayerCornerSelecter(temp, cube).get(0).toString());
        }
        return solvedGoals;
    }

    public List<String> readySecondLayerEdge(Cube cube) {
        List<String> solvedGoals = new ArrayList();
        String[] goals = {"secondLayerEdge1", "secondLayerEdge2", "secondLayerEdge3", "secondLayerEdge4"};
        for (String temp : goals) {
            if (!secondLayerEdgeSelecter(temp, cube).isEmpty())
                solvedGoals.add(secondLayerEdgeSelecter(temp, cube).get(0).toString());

        }
        return solvedGoals;
    }


    public List<String> shortestF2l(Cube cube) {

        IterativeBreadthFirstSearch ibfs;
        System.out.println("-------");
        String shortestGoal = null;
        Cube tempCube;
        Cube staticCube = new Cube(cube);
        tempCube = staticCube;
        int index = 1;
        String solution;
        List<String> readyList = new ArrayList();
        List<String> goalAndSolutionList = new ArrayList();
        String[] goals = {"f2l1GoalUpdate", "f2l2GoalUpdate", "f2l3GoalUpdate", "f2l4GoalUpdate"};

        for (String temp : goals) {
            ibfs = new IterativeBreadthFirstSearch("", tempCube, temp, readyF2l(cube));
            ibfs.search();
            if (ibfs.getSolution() == null){
                solution = "Ebben a mélységben nincs megoldás";
            }else {
                solution = ibfs.getSolution() != "" ? ibfs.getSolution() : "Kész";
            }

            System.out.println(index + ". F2L legrövidebb megoldás: " + solution);

            if (!ibfs.shortestSolutions().isEmpty()) {
                if (ibfs.shortestSolutions().get(0) != "") {
                    if (readyList.isEmpty()) {
                        readyList.add(ibfs.shortestSolutions().get(0));
                        shortestGoal = temp;
                    }
                    if (!readyList.isEmpty() && !ibfs.shortestSolutions().isEmpty() &&
                            readyList.get(0).length() > ibfs.shortestSolutions().get(0).length()) {
                        readyList.clear();
                        readyList.add(ibfs.shortestSolutions().get(0));
                        shortestGoal = temp;
                    }
                }
            }
            index++;
        }
        goalAndSolutionList.add(shortestGoal);
        if (!readyList.isEmpty()){
            System.out.println("Használt algoritmus: " + readyList.get(0));
            goalAndSolutionList.add(readyList.get(0));
        } else {
            System.exit(0);
        }

        return goalAndSolutionList;
    }

    public List<String> shortestFirstLayerCorner(Cube cube) {

        IterativeBreadthFirstSearch ibfs;
        System.out.println("-------");
        String shortestGoal = null;
        Cube tempCube;
        Cube staticCube = new Cube(cube);
        tempCube = staticCube;
        int index = 1;
        String solution;
        List<String> readyList = new ArrayList();
        List<String> goalAndSolutionList = new ArrayList();
        String[] goals = {"firstLayerCorner1GoalUpdate",
                "firstLayerCorner2GoalUpdate",
                "firstLayerCorner3GoalUpdate",
                "firstLayerCorner4GoalUpdate"};

        for (String temp : goals) {
            ibfs = new IterativeBreadthFirstSearch("", tempCube, temp, readyfirstLayerCorner(cube));
            ibfs.search();
            if (ibfs.getSolution() == null){
                solution = "Ebben a mélységben nincs megoldás";
            }else {
                solution = ibfs.getSolution() != "" ? ibfs.getSolution() : "Kész";
            }
            System.out.println(index + ". sarok legrövidebb megoldás: " + solution);

            if (ibfs.getSolution() != null) {
                if (ibfs.getSolution()!= "") {
                    if (readyList.isEmpty()) {
                        readyList.add(ibfs.getSolution());
                        shortestGoal = temp;
                    }
                    if (!readyList.isEmpty() && ibfs.getSolution() != null &&
                            readyList.get(0).length() > ibfs.getSolution().length()) {
                        readyList.clear();
                        readyList.add(ibfs.getSolution());
                        shortestGoal = temp;
                    }
                }
            }
            index++;
        }

        goalAndSolutionList.add(shortestGoal);
        if (!readyList.isEmpty()){
            System.out.println("Használt algoritmus: " + readyList.get(0));
            goalAndSolutionList.add(readyList.get(0));
        } else {
            System.exit(0);
        }

        return goalAndSolutionList;
    }

    public List<String> shortestSecondLayerEdge(Cube cube) {

        IterativeBreadthFirstSearch ibfs;
        System.out.println("-------");
        String shortestGoal = null;
        Cube tempCube;
        Cube staticCube = new Cube(cube);
        tempCube = staticCube;
        int index = 1;
        String solution;
        List<String> readyList = new ArrayList();
        List<String> goalAndSolutionList = new ArrayList();
        String[] goals = {"secondLayerEdge1GoalUpdate",
                "secondLayerEdge2GoalUpdate",
                "secondLayerEdge3GoalUpdate",
                "secondLayerEdge4GoalUpdate"};

        for (String temp : goals) {
            ibfs = new IterativeBreadthFirstSearch("", tempCube, temp, readySecondLayerEdge(cube));
            ibfs.search();
            if (ibfs.getSolution() == null){
                solution = "Ebben a mélységben nincs megoldás";
            }else {
                solution = ibfs.getSolution() != "" ? ibfs.getSolution() : "Kész";
            }
            System.out.println(index + ". él legrövidebb megoldás: " + solution);

            if (!ibfs.shortestSolutions().isEmpty()) {
                if (ibfs.shortestSolutions().get(0) != "") {
                    if (readyList.isEmpty()) {
                        readyList.add(ibfs.shortestSolutions().get(0));
                        shortestGoal = temp;
                    }
                    if (!readyList.isEmpty() && !ibfs.shortestSolutions().isEmpty() &&
                            readyList.get(0).length() > ibfs.shortestSolutions().get(0).length()) {
                        readyList.clear();
                        readyList.add(ibfs.shortestSolutions().get(0));
                        shortestGoal = temp;
                    }
                }
            }
            index++;
        }
        goalAndSolutionList.add(shortestGoal);
        if (!readyList.isEmpty()){
            System.out.println("Használt algoritmus: " + readyList.get(0));
            goalAndSolutionList.add(readyList.get(0));
        } else {
            System.exit(0);
        }

        return goalAndSolutionList;
    }

    public List f2lSelecter(String goal, Cube cube) {
        Goals goal1 = new Goals();
        List readyList = new ArrayList();
        switch (goal) {
            case "f2l1":
                if (goal1.f2l1(cube))
                    readyList.add("f2l1");
                break;
            case "f2l2":
                if (goal1.f2l2(cube))
                    readyList.add("f2l2");
                break;
            case "f2l3":
                if (goal1.f2l3(cube))
                    readyList.add("f2l3");
                break;
            case "f2l4":
                if (goal1.f2l4(cube))
                    readyList.add("f2l4");
                break;
        }
        return readyList;

    }

    public List firstLayerCornerSelecter(String goal, Cube cube) {
        Goals goal1 = new Goals();
        List readyList = new ArrayList();
        switch (goal) {
            case "firstLayerCorner1":
                if (goal1.firstLayerCorner1(cube))
                    readyList.add("firstLayerCorner1");
                break;
            case "firstLayerCorner2":
                if (goal1.firstLayerCorner2(cube))
                    readyList.add("firstLayerCorner2");
                break;
            case "firstLayerCorner3":
                if (goal1.firstLayerCorner3(cube))
                    readyList.add("firstLayerCorner3");
                break;
            case "firstLayerCorner4":
                if (goal1.firstLayerCorner4(cube))
                    readyList.add("firstLayerCorner4");
                break;
        }
        return readyList;

    }

    public List secondLayerEdgeSelecter(String goal, Cube cube) {
        Goals goal1 = new Goals();
        List readyList = new ArrayList();
        switch (goal) {
            case "secondLayerEdge1":
                if (goal1.secondLayerEdge1(cube))
                    readyList.add("secondLayerEdge1");
                break;
            case "secondLayerEdge2":
                if (goal1.secondLayerEdge2(cube))
                    readyList.add("secondLayerEdge2");
                break;
            case "secondLayerEdge3":
                if (goal1.secondLayerEdge3(cube))
                    readyList.add("secondLayerEdge3");
                break;
            case "secondLayerEdge4":
                if (goal1.secondLayerEdge4(cube))
                    readyList.add("secondLayerEdge4");
                break;
        }
        return readyList;

    }
}
