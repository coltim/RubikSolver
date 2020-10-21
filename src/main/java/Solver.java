public class Solver {

    public Solver() {
    }

    public void solver(){
        Cube cube = new Cube();
        cube.print();

        Scramble scramble = new Scramble(15, cube);
        scramble.getRandomMoves();
        cube.print();
    }


}
