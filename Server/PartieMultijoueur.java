package Server;

class PartieMultijoueur implements Runnable {
    private ClientHandler joueur1;
    private ClientHandler joueur2;

    public PartieMultijoueur(ClientHandler joueur1, ClientHandler joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    @Override
    public void run() {
        // Impl�mentez la logique de jeu multijoueur ici
        // Vous devez g�rer les �changes entre les deux joueurs, leurs tirs, etc.
    }
}