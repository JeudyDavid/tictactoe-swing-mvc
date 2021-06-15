package core;
public class Model {
    private View v;
    private int joueurId;
    private int compteur;
    private char[][] caseJeu;
    private String text;


    public Model() {
        this.caseJeu = new char[3][3];
        this.compteur = 9;
        this.joueurId = 1;
    }


    public void registerView(View v) {
        this.v = v;
    }


    public int getjoueurId() {
        return joueurId;
    }

    public void setjoueurId(int joueurId) {
        this.joueurId = joueurId;
    }

    public int getcompteur() {
        return compteur;
    }

    public void setcompteur(int compteur) {
        this.compteur = compteur;
    }

    public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }


    public void PlayMove(int x, int y) {

        if(getcompteur() > 0){
            if(joueurId%2 != 0)
                caseJeu[x][y] = 'X';
            else
                caseJeu[x][y] = 'O';


            setcompteur(--compteur);

            if(checkGagnant(x, y)) {
                settext("le joueur " + joueurId + " est le gagnant!");
                v.checkGagnant(x, y, caseJeu[x][y], gettext());
            }
            else if(getcompteur()==0) {
                settext("il n'y a pas de gagnant dans le jeu le jeu est nul");
                v.checkGagnant(x, y, caseJeu[x][y], gettext());
            }
            else {
                if(joueurId%2 != 0) {

                    setjoueurId(2);
                    settext("O turn ");
                }
                else {
                    setjoueurId(1);
                    settext("X  turn ");

                }

                v.update(x, y, caseJeu[x][y], gettext());
            }

        }

    }


    public boolean checkGagnant(int x, int y) {
        int cligne = 0;
        int Colonne = 0;
        int compteur1 = 0;
        int compteur2 = 0;
        char pions;
        if(getjoueurId() %2 !=0)
            pions = 'X';
        else
            pions = 'O';

        for(int i=0; i<caseJeu.length;i++) {
            if(caseJeu[x][i] == pions)
                cligne++;
            if(caseJeu[i][y] == pions)
                Colonne++;
            if(caseJeu[i][i] == pions)
                compteur2++;
            if(caseJeu[caseJeu.length-1-i][i] == pions)
                compteur1++;
        }

        if(Colonne==caseJeu.length || cligne==caseJeu.length
                || compteur1 == caseJeu.length || compteur2 == caseJeu.length)
            return true;

        return false;
    }

    public void clear() {
        compteur = 9;
        setjoueurId(1);
        settext("");
        for(int i=0; i<caseJeu.length;i++) {
            for(int j=0; j<caseJeu.length;j++) {
                caseJeu[i][j] = '\0';
            }
        }
        v.resetGrille_du_jeu();

    }

}
