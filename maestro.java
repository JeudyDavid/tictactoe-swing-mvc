package core;


import java.awt.event.*;
import java.util.*;

class maestro implements ActionListener {
    private Controller c;
    private View v;

    public maestro(Controller c, View v) {
        this.c = c;
        this.v = v;
    }

    public void actionPerformed(ActionEvent e) {
        if(v.TestClear(e))
            c.setRequest();
        else {
            ArrayList<Integer> position = v.getPosition(e);
            c.setRequest(position);
        }
    }

}
