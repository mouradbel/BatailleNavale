package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private String playerName;
    private String gameMode;

    public ClientHandler(Socket socket) {
        clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Serveur : Entrez votre nom");
            playerName = in.readLine();
            out.println("Serveur : Choisissez un mode (1 : solo / 2 : multijoueur)");
            gameMode = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getGameMode() {
        return gameMode;
    }

    // Autres getters et méthodes pour la communication avec le client
}