package Server;

class PartieSolo implements Runnable {
    private ClientHandler joueur;

    public PartieSolo(ClientHandler joueur) {
        this.joueur = joueur;
    }

    @Override
    public void run() {
        // Impl�mentez la logique de jeu en mode solo ici
        // Vous devez g�rer la partie du joueur contre l'IA (le serveur).
    }
}