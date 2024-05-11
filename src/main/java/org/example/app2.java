package org.example;


public class app2 {

    public static class UserService {
        int id;
        final UtilisateurApi utilisateurApi;
        UserService(UtilisateurApi utilisateurApi) {
            this.utilisateurApi = utilisateurApi;
        }
        public void creerUtilisateur(Utilisateur utilisateur) throws
                ServiceException {
            utilisateurApi.creerUtilisateur(utilisateur);
            this.id = utilisateur.getId();
        }

        public int returnId() {

            return utilisateurApi.returnId();
        }

    }

////////////////////////////////////////////////////////////////////////////////////////

    public interface UtilisateurApi {
        void creerUtilisateur(Utilisateur utilisateur) throws ServiceException;
        int returnId();
    }

///////////////////////////////////////////////////////////////////////////////////////////

    public static class ServiceException extends Exception {
        // Constructeur prenant un message d'erreur en paramètre
        public ServiceException(String message) {
            // Appelle le constructeur de la superclasse (Exception) avec le message
            super(message);
        }
    }



}