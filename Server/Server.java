package Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class Server {
    private static ArrayList<ClientHandler> clientsEnAttente = new ArrayList<>();

    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Serveur Bataille Navale démarré. En attente de joueurs...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion client.");

                ClientHandler handler = new ClientHandler(clientSocket);
                Thread handlerThread = new Thread(handler);
                handlerThread.start();

                if (handler.getGameMode().equals("2")) {
                    clientsEnAttente.add(handler);

                    if (clientsEnAttente.size() >= 2) {
                        ClientHandler joueur1 = clientsEnAttente.remove(0);
                        ClientHandler joueur2 = clientsEnAttente.remove(0);

                        PartieMultijoueur nouvellePartie = new PartieMultijoueur(joueur1, joueur2);
                        Thread partieThread = new Thread(nouvellePartie);
                        partieThread.start();
                    }
                } else if (handler.getGameMode().equals("1")) {
                    PartieSolo nouvellePartie = new PartieSolo(handler);
                    Thread partieThread = new Thread(nouvellePartie);
                    partieThread.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}