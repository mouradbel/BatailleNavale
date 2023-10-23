package Server;

class PartieSolo implements Runnable {
    private ClientHandler joueur;

    public PartieSolo(ClientHandler joueur) {
        this.joueur = joueur;
    }

    @Override
    public void run() {
        // Implémentez la logique de jeu en mode solo ici
        // Vous devez gérer la partie du joueur contre l'IA (le serveur).
    }
}