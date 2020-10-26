import java.util.ArrayList;
import java.util.List;

public class Solver {

    public Solver() {
    }

    public void solver(){
        Cube cube = new Cube();
        List<String> shortestSolutionsList = new ArrayList<>();
        Rotations rotation = new Rotations();
        DepthFirstSearch dfs;
        cube.print();

        Scramble scramble = new Scramble(15, cube);
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
        goalSolver(cube, "firstLayerCorner1");
        goalSolver(cube, "firstLayerCorner2");
        goalSolver(cube, "firstLayerCorner3");
        goalSolver(cube, "firstLayerCorner4");
        goalSolver(cube, "secondLayerEdge1");
        goalSolver(cube, "secondLayerEdge2");
        goalSolver(cube, "secondLayerEdge3");
        goalSolver(cube, "secondLayerEdge4");
    }

    public void goalSolver(Cube cube, String goal) {

        List<String> shortestSolutionsList = new ArrayList<>();
        Rotations rotation = new Rotations();
        DepthFirstSearch dfs;
        System.out.println("-------");

        dfs = new DepthFirstSearch("", cube, goal);
        dfs.search();

        System.out.println("Legrovidebb megoldasok, " + goal + dfs.shortestSolutions());

        shortestSolutionsList = dfs.shortestSolutions();
        String firstLayer = shortestSolutionsList.get(0);

        rotation.movesTranslate(firstLayer, cube);
        cube.print();

        System.out.println("-------");
    }

}
