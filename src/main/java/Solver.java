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

        Scramble scramble = new Scramble(4, cube);
        scramble.getRandomMoves();
        cube.print();

        String randomScrambleMoves = scramble.getRandomMoves();
        dfs = new DepthFirstSearch(randomScrambleMoves, cube, "fullCube");
        dfs.search();

        System.out.println("Legrovidebb megoldasok, kereszt: " + dfs.shortestSolutions());


        /*shortestSolutionsList = dfs.shortestSolutions();
        String whiteCrossShortestSolution = shortestSolutionsList.get(0);

        rotation.movesTranslate(whiteCrossShortestSolution, cube);

        cube.print();
        System.out.println("-------");

        dfs = new DepthFirstSearch(randomSrambleMoves, cube, "firstLayerCorner1");
        dfs.search();

        System.out.println("Legrovidebb megoldasok, elso sarok: " + dfs.shortestSolutions());

        shortestSolutionsList = dfs.shortestSolutions();
        String corer = shortestSolutionsList.get(0);

        rotation.movesTranslate(corer, cube);

        System.out.println(cube.getElement(36) + " " +
                            cube.getElement(0) + " " +
                            cube.getElement(29));
        cube.print();

        System.out.println("-------");



        dfs = new DepthFirstSearch(randomSrambleMoves, cube, "fullCube");
        dfs.search();

        System.out.println("Legrovidebb megoldasok: " + dfs.shortestSolutions());
        System.out.println("-------");*/
    }


}
