public class Jeu {
    private Banque banque;
    private boolean ouvert;

    Jeu(Banque banque) {
        this.banque = banque;
        this.ouvert = banque.est_solvable();;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ouvert) {
            throw new JeuFermeException("Le jeu est fermé.");
        }

        int mise = joueur.mise();
        try {
            joueur.debiter(mise);
            int resultat = de1.lancer() + de2.lancer();
            if (resultat == 7) {
                banque.crediter(2 * mise);
            }
        } catch (DebitImpossibleException e) {
            // Le joueur / la banque  est insolvable
            ouvert = false;
            throw new JeuFermeException("\n\n*******-----insolvable-----*******\n\n");
        }
    }

    public void fermer() {
        ouvert = false;
    }

    public boolean estOuvert() {
        return banque.est_solvable();
    }
}
