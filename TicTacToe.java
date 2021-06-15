package core;

public class TicTacToe {

    public static void main(String[] args) {


        Controller c = new Controller();
        View v = new View();
        Model m = new Model();


        m.registerView(v);
        c.setModel(m);
        v.setActionListener(c);
    }
}
